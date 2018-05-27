package xyz.crearts.money.entity;

import net.sf.beanrunner.BeanRunner;
import org.junit.Assert;
import org.junit.Test;
import xyz.crearts.money.model.Config;

public class BeanTest {
    private BeanRunner beanRunner = new BeanRunner();

    @Test
    public void testCurrencyBean() throws Exception {
        Currency bean = new Currency();
        beanRunner.testBean(bean);
    }

    @Test
    public void testImageBean() throws Exception {
        Image bean = new Image();
        beanRunner.testBean(bean);
    }

    @Test
    public void testCachFlowBean() throws Exception {
        CashFlow bean = new CashFlow();
        beanRunner.testBean(bean);
    }

    @Test
    public void testCashFlowPieChartBean() throws Exception {
        CashFlowPieChart bean = new CashFlowPieChart(1L, "test", 10d);

        Assert.assertEquals(1L, bean.getCategoryId());
        Assert.assertEquals("test", bean.getName());
        Assert.assertEquals(10d, bean.getAmount(), 0);

        bean = new CashFlowPieChart();

        Assert.assertEquals(0L, bean.getCategoryId());
        Assert.assertNull(bean.getName());
        Assert.assertEquals(0d, bean.getAmount(), 0);
    }

    @Test
    public void testCategoryBean() throws Exception {
        Category bean = new Category();
        beanRunner.testBean(bean);
    }

}
