package com.habitrpg.client;

import com.habitrpg.client.resource.Task;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.codehaus.jackson.map.type.CollectionType.construct;

public class RestClient {

    private final Client client;
    private final Fetcher fetcher;
    private final Map<String, String> headers;

    private Logger LOG = LoggerFactory.getLogger(RestClient.class);

    public RestClient(Map<String, String> headers) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getClasses().add(JacksonJsonProvider.class);
        this.client = Client.create(clientConfig);
        this.fetcher = new Fetcher(headers);
        this.headers = headers;
    }

    public <T> T get(String url, Class<T> clazz) throws ResourceNotFoundException {
        debugGet(url);
        try {
            return new ObjectMapper().readValue(fetcher.fetch(url), clazz);
        } catch (Throwable t) {
            throw new ResourceNotFoundException("Can't get resource of type " + clazz.getName() + " at '" + url + "'", t);
        }
    }

    public <T> T getCollection(String url, Class<T> collectionClass, Class<?> objectClass) throws ResourceNotFoundException {
        debugGet(url);
        try {
            JavaType javaType = construct(collectionClass, SimpleType.construct(objectClass));
            return new ObjectMapper().readValue(fetcher.fetch(url), javaType);
        } catch (Throwable t) {
            throw new ResourceNotFoundException("Can't get resource of type " + collectionClass.getSimpleName() + "<" + objectClass.getSimpleName() + ">" + " at '" + url + "'", t);
        }
    }

    public void delete(String url) {
        debugDelete(url);
        resource(url).delete();
    }

    public <T> T post(Task task, String url, Class<T> clazz) {
        debugPost(url, task);
        return resource(url).post(ClientResponse.class, task).getEntity(clazz);
    }

    public <T> T post(String url, Class<T> clazz) {
        debugPost(url);
        return resource(url).post(ClientResponse.class).getEntity(clazz);
    }

    public <T> T put(Task task, String url, Class<T> clazz) {
        debugPut(url);
        return resource(url).put(ClientResponse.class, task).getEntity(clazz);
    }

    private WebResource.Builder resource(String url) {
        WebResource.Builder builder = client.resource(url).accept(APPLICATION_JSON);
        for (Map.Entry<String, String> header : headers.entrySet()) {
            builder = builder.header(header.getKey(), header.getValue());
        }
        return builder;
    }

    private void debugGet(String url) {
        LOG.debug(new CurlCommand().get().withUrl(url).withHeaders(headers).build().toString());
    }

    private void debugPut(String url) {
        LOG.debug(new CurlCommand().put().withUrl(url).withHeaders(headers).build().toString());
    }

    private void debugDelete(String url) {
        LOG.debug(new CurlCommand().delete().withUrl(url).withHeaders(headers).build().toString());
    }

    private void debugPost(String url, Object object) {
        try {
            LOG.debug(new CurlCommand().post().withBody(body(object)).withUrl(url).withHeaders(headers).build().toString());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void debugPost(String url) {
        LOG.debug(new CurlCommand().post().withUrl(url).withHeaders(headers).build().toString());
    }

    private String body(Object object) throws IOException {
        return new ObjectMapper().writeValueAsString(object);
    }

}
