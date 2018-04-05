package com.gandalf;

import java.net.URI;

class BaseUriBuilder {

    private AppConfig appConfig;

    BaseUriBuilder(AppConfig config) {
        appConfig = config;
    }

    URI build() {
        return URI.create(String.format("http://%s:%d", appConfig.getBaseUri(), appConfig.getPortNumber()));
    }
}
