package baobaotao.dao;

import baobaotao.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by peng on 16-3-10.
 */
@Repository
public class PostDao
{
    private static final String sql = "INSERT INTO t_post(post_id, user_id, post_text, post_attach) VALUES(?,?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LobHandler lobHandler;

    public void addPost(final Post post)
    {
        jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler)
        {
            @Override
            protected void setValues(PreparedStatement preparedStatement, LobCreator lobCreator) throws SQLException, DataAccessException
            {
                preparedStatement.setInt(1, post.getPostId());
                preparedStatement.setInt(2, post.getUserId());
                lobCreator.setClobAsString(preparedStatement, 3, post.getPostText());
                lobCreator.setBlobAsBytes(preparedStatement, 4, post.getPostAttach());
            }
        });
    }
}
