package com.gandalf;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 */
public class Main {


    public static final String BASE_URI = "http://localhost:8080/api/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {

        final AppConfig config = new AppConfig();
        final EmailTemplateRepository emailTemplateRepository = new EmailTemplateRepository();
        final MailordApplication mailordApplication = new MailordApplication(config, emailTemplateRepository);
        final BaseUriBuilder baseUriBuilder = new BaseUriBuilder(config);

        return GrizzlyHttpServerFactory.createHttpServer(baseUriBuilder.build(), mailordApplication);
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }

    static String getBaseUri(AppConfig config) {
        return String.format("http://localhost:%n", config.getPortNumber());
    }
}

