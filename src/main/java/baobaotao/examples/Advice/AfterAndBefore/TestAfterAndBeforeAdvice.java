package baobaotao.examples.Advice.AfterAndBefore;

import baobaotao.examples.Advice.Before.GreetingBeforeAdvice;
import baobaotao.examples.Advice.NavieWaiter;
import baobaotao.examples.Advice.Waiter;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAfterAndBeforeAdvice
{
    public static void main(String[] args)
    {
        Waiter target = new NavieWaiter();
        MethodInterceptor advice = new GreetingInterceptor();

        // Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        // 设置代理目标
        pf.setTarget(target);

        // 为代理目标添加advice
        pf.addAdvice(advice);

        // 生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}
