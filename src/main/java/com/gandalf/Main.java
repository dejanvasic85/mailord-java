package com.gandalf;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 */
public class Main {


    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {

        final AppConfig config = new AppConfig();
        final EmailTemplateRepository emailTemplateRepository = new EmailTemplateRepository();
        final MailordApplication mailordApplication = new MailordApplication(config, emailTemplateRepository);
        final URI address = new BaseUriBuilder(config).build();


        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(address, mailordApplication);

        System.out.println(String.format("Jersey app started with WADL available at %sapplication.wadl\nHit enter to stop it...", address.toString()));

        return server;
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        System.in.read();
        server.stop();
    }
}

