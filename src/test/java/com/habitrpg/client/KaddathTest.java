package com.habitrpg.client;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class KaddathTest {

    @Test
    public void test() throws MalformedURLException, ResourceNotFoundException {
        HabitRpgClient habitRpgClient = new HabitRpgClient(new AuthenticationInformations("b3848424-9ac3-438d-8172-095a3c5dda04", "620b934b-f082-4b54-908f-639be696d7ab"));
        habitRpgClient.getUser();
        habitRpgClient.getTasks();
    }

}
