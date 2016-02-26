package baobaotao.examples.Advice.Throw;

import baobaotao.examples.Advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestThrowAdvice
{
    public static void main(String[] args) throws Throwable
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice-config-throw.xml");
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        forumService.removeTopic(456);
        forumService.removeForum(123);
    }
}
