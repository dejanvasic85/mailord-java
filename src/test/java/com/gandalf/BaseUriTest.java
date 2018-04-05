package com.gandalf;


import org.junit.Test;

import java.net.URI;

import static junit.framework.Assert.assertEquals;

public class BaseUriTest {

    @Test
    public void getPortNumberTest_ReturnsEnvironmentVariable_OrDefault(){
        AppConfig config = new AppConfig();
        BaseUriBuilder builder = new BaseUriBuilder(config);

        URI address = builder.build();
        assertEquals("http://localhost:8080", address.toString());
    }
}
