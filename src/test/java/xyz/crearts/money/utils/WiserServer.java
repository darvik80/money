package xyz.crearts.money.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * wiser server mock
 *
 * @author leijuan
 */
@Service
@Profile("test")
public class WiserServer {
    private Wiser wiser;

    private MailProperties properties;

    public WiserServer(MailProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void start() {
        this.wiser = new Wiser();
        this.wiser.setHostname(properties.getHost());
        this.wiser.setPort(properties.getPort());
        this.wiser.start();
    }

    @PreDestroy
    public void stop() {
        this.wiser.stop();
    }

    public List<WiserMessage> getMessages() {
        return this.wiser.getMessages();
    }
}
