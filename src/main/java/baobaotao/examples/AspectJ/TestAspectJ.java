package baobaotao.examples.AspectJ;

import baobaotao.examples.Advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectJ
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aspectj-config.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("my test for aspectj");
        waiter.serveTo("my test for aspectj");
    }
}
