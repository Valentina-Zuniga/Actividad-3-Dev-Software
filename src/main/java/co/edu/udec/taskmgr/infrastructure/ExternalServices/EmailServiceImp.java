package co.edu.udec.taskmgr.infrastructure.ExternalServices;

import co.edu.udec.taskmgr.domain.puertos.IEmailService;



public class EmailServiceImp implements IEmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
