package baobaotao.examples.proxy;

public class ForumServiceImpl implements ForumService
{
    @Override
    public void removeTopic(int topicId)
    {
        // 注释掉业务逻辑代码中加入的性能监控
//        PerformanceMonitor.begin("baobaotao.examples.proxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录： " + topicId);

        try
        {
            Thread.currentThread().sleep(20);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

//        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId)
    {
        // 注释掉业务逻辑代码中加入的性能监控
//        PerformanceMonitor.begin("baobaotao.examples.proxy.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录： " + forumId);
        try
        {
            Thread.currentThread().sleep(40);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

//        PerformanceMonitor.end();
    }
}
