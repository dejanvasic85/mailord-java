package com.gandalf;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;


public class EmailTemplateRepository {

    private Map<String, EmailTemplate> templates;


    EmailTemplateRepository() {
        this.templates = new HashMap<>();

        EmailTemplate t1 = new EmailTemplate();
        t1.setId("123");
        t1.setTitle("test-template");
        t1.setSubject("Hello");
        t1.setBody("Welcome to the dark side of");
        t1.setAccountId("account-123");

        templates.put(t1.getId(), t1);

        EmailTemplate t2 = new EmailTemplate();
        t2.setId("456");
        t2.setTitle("test-template2");
        t2.setSubject("Whoa");
        t2.setBody("Whoa");
        t2.setAccountId("account-123");


        templates.put(t2.getId(), t2);
    }

    Collection<EmailTemplate> getEmailTemplates(){
        return this.templates.values();
    }
}