package com.gandalf;

import java.util.Map;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class EmailTemplateRepository {

    private Map<String, EmailTemplate> templates;


    EmailTemplateRepository() {
        this.templates = new ConcurrentHashMap<>();

        EmailTemplate t1 = new EmailTemplate();
        t1.setId(UUID.randomUUID().toString());
        t1.setTitle("test-template");
        t1.setSubject("Hello");
        t1.setBody("Welcome to the dark side of");
        t1.setAccountId("account-123");

        templates.put(t1.getId(), t1);

        EmailTemplate t2 = new EmailTemplate();
        t2.setId(UUID.randomUUID().toString());
        t2.setTitle("test-template2");
        t2.setSubject("Whoa");
        t2.setBody("Whoa");
        t2.setAccountId("account-123");


        templates.put(t2.getId(), t2);
    }

    Collection<EmailTemplate> getEmailTemplates(){
        return this.templates.values();
    }


    EmailTemplate addEmailTemplate(EmailTemplate emailTemplate){
        emailTemplate.setId(UUID.randomUUID().toString());
        this.templates.put(emailTemplate.getId(), emailTemplate);
        return emailTemplate;
    }
}