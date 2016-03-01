package baobaotao.examples.Advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticAdvisor
{
    public static void main(String[] args)
    {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advisor-static-config.xml");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advisor-regexp-config.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advisor-auto-proxy-regexp-config.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }
}
