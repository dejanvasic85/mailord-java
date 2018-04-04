package com.gandalf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import java.util.Collection;


@Path("email-templates")
public class EmailTemplateResource {

    @Context
    EmailTemplateRepository emailTemplateRepository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EmailTemplate> getAllEmailTemplates(){
        return this.emailTemplateRepository.getEmailTemplates();
    }


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EmailTemplate getById(@PathParam("id") String id){


           EmailTemplate template = this.emailTemplateRepository.getEmailTemplates()
                   .stream()
                   .filter(l -> l.getId().equals(id))
                   .findFirst()
                   .orElse(EmailTemplate.Default());

           System.out.println("Found template " + template.getId());

           return template;
    }
}