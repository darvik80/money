package xyz.crearts.money.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.WiserMessage;
import xyz.crearts.money.MoneyApplication;
import xyz.crearts.money.utils.WiserServer;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Ivan Kishchenko (email: ivan.kishchenko@lazada.com)
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoneyApplication.class)
@ActiveProfiles("test")
public class MailReporterTest {
    @Autowired
    private WiserServer smtp;

    @Autowired
    private MailReporter reporter;

    @Test
    public void renderTest() {
        String msg = reporter.render("html/test1", new HashMap<String, Object>() {{
            put("user", "darvik");
        }});

        assertTrue(msg.equals("<!DOCTYPE html><html lang=\"en\"><head><title>Test</title></head><body>Hello, darvik</body></html>\n"));

        msg = reporter.render("html/test2", null);

        assertTrue(msg.equals("<!DOCTYPE html><html lang=\"en\"><head><title>Test</title></head><body>Hello World</body></html>\n"));
    }

    @Test
    public void sendTest() throws MessagingException {
        reporter.sendReport("html/test2", null);

        List<WiserMessage> msgs = this.smtp.getMessages();
        assertEquals(1, msgs.size());
        assertEquals("darvik80@gmail.com", msgs.get(0).getEnvelopeReceiver());
        assertEquals("noreply@support.lazada.sg", msgs.get(0).getEnvelopeSender());
    }
}
