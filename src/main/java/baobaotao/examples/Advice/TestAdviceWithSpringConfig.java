package baobaotao.examples.Advice;

import baobaotao.examples.Advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//使用spring配置文件完成对方法的前置增强
public class TestAdviceWithSpringConfig
{
    public static void main(String[] args)
    {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice-config.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice-config-before-and-after.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        waiter.serveTo("Tom");
    }
}
