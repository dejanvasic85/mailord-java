package com.gandalf;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmailTemplateTest extends JerseyTest {

    protected Application configure(){
        //enable(TestProperties.LOG_TRAFFIC);
        //enable(TestProperties.DUMP_ENTITY);

        final EmailTemplateRepository emailTemplateRepository = new EmailTemplateRepository();
        final AppConfig config = new AppConfig();
        return new MailordApplication(config, emailTemplateRepository);
    }

    final static String BASE_PATH = "email-templates";

    private EmailTemplate template_1;
    private EmailTemplate template_2;

    private Response addTemplate(String accountId, String title, String body, String subject){
        EmailTemplate template = new EmailTemplate();
        template.setAccountId(accountId);
        template.setTitle(title);
        template.setBody(body);
        template.setSubject(subject);
        Entity<EmailTemplate> emailTemplateEntity = Entity.entity(template, MediaType.APPLICATION_JSON_TYPE);

        return (target(BASE_PATH).request().post(emailTemplateEntity));
    }


    @Before
    public void setupTemplates(){
        template_1 = addTemplate("account-123", "title-123", "body-123", "subject-123").readEntity(EmailTemplate.class);
        template_2 = addTemplate("account-456", "title-456", "body-456", "subject-456").readEntity(EmailTemplate.class);
    }

    @Test
    public void testAddEmailTemplate(){
        Response response = addTemplate("adding-test", "adding-test-title", "adding-test-body", "adding-test-subject");

        assertEquals(200, response.getStatus());

        // Convert from JSON
        EmailTemplate templateResponse = response.readEntity(EmailTemplate.class);
        assertNotNull(templateResponse.getId());
    }

    @Test
    public void testGetEmailTemplateById() {
        EmailTemplate emailResponseTemplate = target(BASE_PATH).path(template_1.getId()).request().get(EmailTemplate.class);
        assertEquals(template_1.getId(), emailResponseTemplate.getId());
        assertEquals(template_1.getTitle(), emailResponseTemplate.getTitle());
    }

    @Test
    public void testGetEmailTemplates(){
        Collection<EmailTemplate> templates = target(BASE_PATH).request().get(new GenericType<Collection<EmailTemplate>>(){});
        assertEquals(4, templates.size());
    }
}
