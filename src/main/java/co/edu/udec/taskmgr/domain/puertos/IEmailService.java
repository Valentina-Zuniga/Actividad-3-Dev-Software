package co.edu.udec.taskmgr.domain.puertos;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface IEmailService {

    void sendEmail(String to, String subject, String body);
}
