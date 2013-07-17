package com.habitrpg.client;

import com.habitrpg.client.resource.Answer;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class AnswerUnmarshallerTest {

    private String response = "{\"hp\":48,\"exp\":0,\"lvl\":1,\"gp\":0,\"delta\":-1}";

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_unmarshall_answer() throws IOException {
        Answer answer = mapper.readValue(response, Answer.class);
        assertThat(answer.getHp()).isEqualTo(48);
        assertThat(answer.getExp()).isEqualTo(0);
        assertThat(answer.getLvl()).isEqualTo(1);
        assertThat(answer.getGp()).isEqualTo(0);
    }

}
