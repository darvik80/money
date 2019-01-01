package xyz.crearts.money.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Collections;
import java.util.Properties;

/**
 * @author Ivan Kishchenko (email: ivan.kishchenko@lazada.com)
 */

@Configuration
@EnableConfigurationProperties(MailProperties.class)
public class MailReportConfig {
    private MailProperties properties;

    public MailReportConfig(MailProperties properties) {
        this.properties = properties;
    }

    @Bean
    public TemplateEngine emailTemplateEngine() {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // Resolver for HTML emails (except the editable one)
        templateEngine.addTemplateResolver(htmlTemplateResolver());

        // Message source, internationalization specific to emails
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("mail/MailMessages");
        templateEngine.setTemplateEngineMessageSource(messageSource);
        return templateEngine;
    }

    @Bean
    public JavaMailSender emailSender() {
        Properties sessionProperties = new Properties();
        //sessionProperties.setProperty("mail.debug", "true");
        sessionProperties.put("mail.smtp.starttls.enable", "true");


        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(sessionProperties);

        mailSender.setHost(properties.getHost());
        mailSender.setPort(properties.getPort());
        mailSender.setProtocol(properties.getProtocol());
        mailSender.setUsername(properties.getUsername());
        mailSender.setPassword(properties.getPassword());

        return mailSender;
    }

    private ITemplateResolver htmlTemplateResolver() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setOrder(1);
        templateResolver.setResolvablePatterns(Collections.singleton("html/*"));
        templateResolver.setPrefix("/mail/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("utf-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
}
