package baobaotao.examples.Advice.Throw;

import java.sql.SQLException;

public class ForumServiceImpl implements ForumService
{
    @Override
    public void removeTopic(int topicId)
    {
//        throw new RuntimeException("运行异常抛出！！");
        System.out.println("removeTopic method!!");
    }

    @Override
    public void removeForum(int forumId) throws Exception
    {
        throw new SQLException("数据库异常抛出！！");
    }
}
