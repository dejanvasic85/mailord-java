package com.gandalf;


import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class MailordApplication extends ResourceConfig {
    MailordApplication(final EmailTemplateRepository emailTemplateRepository) {
        packages("com.gandalf");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(emailTemplateRepository).to(EmailTemplateRepository.class);
            }
        });
    }
}