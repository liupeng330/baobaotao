package baobaotao;

import baobaotao.dao.PostDao;
import baobaotao.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
@TransactionConfiguration
@Transactional
public class TestPostDao
{
    @Autowired
    private PostDao postDao;

    @Test
    @Rollback(false)
    public void testAddPost() throws Throwable
    {
        Post post = new Post();
        post.setUserId(3);

        ClassPathResource res = new ClassPathResource("temp.jpg");
        byte[] mockimg = FileCopyUtils.copyToByteArray(res.getFile());
        post.setPostAttach(mockimg);
        post.setPostText("测试内容");

        this.postDao.addPost(post);
    }
}
