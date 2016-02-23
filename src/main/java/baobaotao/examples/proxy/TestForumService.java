package baobaotao.examples.proxy;

import java.lang.reflect.Proxy;

public class TestForumService
{
    public static void main(String[] args)
    {
//        ForumService forumService = new ForumServiceImpl();
//        forumService.removeForum(10);
//        forumService.removeTopic(2099);

        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        proxy.removeForum(10);
        proxy.removeTopic(2099);
    }
}
