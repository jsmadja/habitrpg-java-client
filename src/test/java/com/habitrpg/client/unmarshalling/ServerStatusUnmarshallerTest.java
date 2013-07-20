package com.habitrpg.client.unmarshalling;

import com.habitrpg.client.resource.Server;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class ServerStatusUnmarshallerTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_unmarshall_server_status_up() throws IOException {
        Server server = mapper.readValue("{\"status\":\"up\"}", Server.class);
        assertThat(server.getStatus()).isEqualTo(Server.Status.up);
    }

    @Test
    public void should_unmarshall_server_status_down() throws IOException {
        Server server = mapper.readValue("{\"status\":\"down\"}", Server.class);
        assertThat(server.getStatus()).isEqualTo(Server.Status.down);
    }

}
