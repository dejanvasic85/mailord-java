package com.gandalf;

import javax.inject.Inject;
import java.util.Collection;

public class EmailService {

    private final EmailTemplateRepository emailTemplateRepository;

    @Inject
    public EmailService(EmailTemplateRepository emailTemplateRepository) {
        this.emailTemplateRepository = emailTemplateRepository;
    }

    public Collection<EmailTemplate> getTemplates() {
        return this.emailTemplateRepository.getEmailTemplates();
    }
}
