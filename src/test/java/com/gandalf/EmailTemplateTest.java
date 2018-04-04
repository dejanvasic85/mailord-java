package com.gandalf;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

public class EmailTemplateTest extends JerseyTest {

    protected Application configure(){
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        final EmailTemplateRepository emailTemplateRepository = new EmailTemplateRepository();
        return new MailordApplication(emailTemplateRepository);
    }

    final static String BASE_PATH = "email-templates";

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetEmailTemplateById() {
        EmailTemplate emailTemplate = target(BASE_PATH).path("123").request().get(EmailTemplate.class);
        assertEquals("123", emailTemplate.getId());
        assertEquals("test-template", emailTemplate.getTitle());
    }

    @Test
    public void testGetEmailTemplates(){
        Collection<EmailTemplate> templates = target(BASE_PATH).request().get(new GenericType<Collection<EmailTemplate>>(){});
        assertEquals(2, templates.size());
    }
}
