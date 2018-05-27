package xyz.crearts.money.model;

import net.sf.beanrunner.BeanRunner;
import org.junit.Test;

public class BeanTest {
    private BeanRunner beanRunner = new BeanRunner();

    @Test
    public void testConfigBean() throws Exception {
        Config bean = new Config();
        beanRunner.testBean(bean);
    }
}
