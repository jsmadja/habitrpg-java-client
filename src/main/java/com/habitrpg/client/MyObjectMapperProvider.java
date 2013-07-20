package com.habitrpg.client;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import static org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES;

@Provider
public class MyObjectMapperProvider extends JacksonJsonProvider implements ContextResolver<ObjectMapper> {

    private final Configuration configuration;

    public MyObjectMapperProvider(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        ObjectMapper result = new ObjectMapper();
        result.configure(FAIL_ON_UNKNOWN_PROPERTIES, configuration.shouldFailOnUnknownProperties());
        return result;
    }
}
