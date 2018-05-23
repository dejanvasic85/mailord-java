package com.gandalf;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Collection;


@Path("email-templates")
public class EmailTemplateResource {

    @Inject
    EmailTemplateRepository emailTemplateRepository;

    @Inject
    private EmailService emailService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EmailTemplate> getAllEmailTemplates(){
        return this.emailService.getTemplates();
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

           return template;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmailTemplate addEmailTemplate(EmailTemplate emailTemplate){
        return this.emailTemplateRepository.addEmailTemplate(emailTemplate);
    }
}