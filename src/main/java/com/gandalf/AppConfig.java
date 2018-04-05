package com.gandalf;

import java.util.Optional;

class AppConfig {

    private String readEnvOrDefault(String key, String defaultValue) {
        return Optional.ofNullable(System.getenv(key)).orElse(defaultValue);
    }

    Integer getPortNumber() {
        return Integer.parseInt(readEnvOrDefault("PORT_NUMBER", "8080"));
    }

    String getBaseUri(){
        return readEnvOrDefault("BASE_ADDRESS", "localhost");
    }
}
