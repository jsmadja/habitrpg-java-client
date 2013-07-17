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

    public <T> T get(String strUrl, Class<T> clazz) throws ResourceNotFoundException {
        LOG.debug("GET " + strUrl);
        try {
            return new ObjectMapper().readValue(fetcher.fetch(strUrl), clazz);
        } catch (Throwable t) {
            throw new ResourceNotFoundException("Can't get resource of type " + clazz.getName() + " at '" + strUrl + "'", t);
        }
    }

    public <T> T getCollection(String strUrl, Class<T> collectionClass, Class<?> objectClass) throws ResourceNotFoundException {
        LOG.debug("GET " + strUrl);
        try {
            JavaType javaType = construct(collectionClass, SimpleType.construct(objectClass));
            return new ObjectMapper().readValue(fetcher.fetch(strUrl), javaType);
        } catch (Throwable t) {
            throw new ResourceNotFoundException("Can't get resource of type " + collectionClass.getSimpleName() + "<" + objectClass.getSimpleName() + ">" + " at '" + strUrl + "'", t);
        }
    }

    public void delete(String url) {
        LOG.debug("DELETE " + url);
        resource(url).delete();
    }

    public <T> T post(Task task, String url, Class<T> clazz) {
        LOG.debug("POST " + url);
        return resource(url).post(ClientResponse.class, task).getEntity(clazz);
    }

    public <T> T post(String url, Class<T> clazz) {
        LOG.debug("POST " + url);
        return resource(url).post(ClientResponse.class).getEntity(clazz);
    }

    public <T> T put(Task task, String url, Class<T> clazz) {
        LOG.debug("PUT " + url);
        return resource(url).put(ClientResponse.class, task).getEntity(clazz);
    }

    private WebResource.Builder resource(String url) {
        WebResource.Builder builder = client.resource(url).accept(APPLICATION_JSON);
        for (Map.Entry<String, String> header : headers.entrySet()) {
            builder = builder.header(header.getKey(), header.getValue());
        }
        return builder;
    }

}
