package baobaotao.dao;

import baobaotao.domain.Post;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDao
{
    private static final String sql = "INSERT INTO t_post(post_id, user_id, post_text, post_attach) VALUES(?,?,?,?)";
    private static final String searchSql = "SELECT post_id, post_attach, post_text FROM t_post where user_id = ? and post_attach is not null";
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

    public List getPost(final int userId)
    {
        return this.jdbcTemplate.query(searchSql, new Object[]{userId},
                new RowMapper<Post>()
                {
                    @Override
                    public Post mapRow(ResultSet rs, int rowNum) throws SQLException
                    {
                        int postId = rs.getInt(1);

                        byte[] attach = lobHandler.getBlobAsBytes(rs, 2);
                        String text = lobHandler.getClobAsString(rs, 3);
                        Post post = new Post();
                        post.setPostId(postId);
                        post.setPostAttach(attach);
                        post.setPostText(text);
                        return post;
                    }
                });
    }
}
