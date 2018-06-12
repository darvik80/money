package xyz.crearts.money.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/**
 * @author Ivan Kishchenko (email: ivan.kishchenko@lazada.com)
 */
@Service
public class MailReporter {
    //final private SmtpConnectionFactory factory;
    final private TemplateEngine templateEngine;
    final private JavaMailSender mailSender;

    public MailReporter(@Qualifier("emailTemplateEngine") TemplateEngine templateEngine, @Qualifier("emailSender") JavaMailSender mailSender) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }


    /*
    @PostConstruct
    public void postConstruct() throws Exception{
        //Create the configuration
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(2);

        //Declare the factory and the connection pool, usually at the application startup
        SmtpConnectionPool smtpConnectionPool = new SmtpConnectionPool(factory, config);
        for (int i = 0; i < 10; i++) {

            //borrow an object in a try-with-resource statement or call `close` by yourself
            try (ClosableSmtpConnection transport = smtpConnectionPool.borrowObject()) {
                MimeMessage mimeMessage = new MimeMessage(transport.getSession());
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
                mimeMessageHelper.addTo("darvik80@gmail.com");
                mimeMessageHelper.setFrom("noreply@support.lazada.sg");
                mimeMessageHelper.setSubject("Hi! " + UUID.randomUUID().toString());
                mimeMessageHelper.setText("Hello World!" + UUID.randomUUID().toString(), false);
                transport.sendMessage(mimeMessage);
            }

        }
        //Close the pool, usually when the application shutdown
        smtpConnectionPool.close();
    }
    */

    @PostConstruct
    public void postConstruct() throws Exception{
        //this.sendReport("html/report.daily", null);
    }

    public void sendReport(String template, Map<String, Object> params) throws MessagingException {

        String body = this.render(template, params);

        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
        mimeMessageHelper.addTo("darvik80@gmail.com");
        mimeMessageHelper.setFrom("noreply@support.lazada.sg");
        mimeMessageHelper.setSubject("Hi! " + UUID.randomUUID().toString());
        mimeMessageHelper.setText(body);
        this.mailSender.send(mimeMessage);
    }

    public String render(String template, Map<String, Object> params) {
        final Context ctx = new Context(Locale.ENGLISH);
        if (!CollectionUtils.isEmpty(params)) {
            params.forEach(ctx::setVariable);
        }

        return templateEngine.process(template, ctx);
    }
}
