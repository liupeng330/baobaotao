package baobaotao.domain;

import java.io.Serializable;

public class Post implements Serializable
{
    private int postId;
    private int userId;
    private String postText;
    private byte[] postAttach;

    public int getPostId()
    {
        return postId;
    }

    public void setPostId(int postId)
    {
        this.postId = postId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getPostText()
    {
        return postText;
    }

    public void setPostText(String postText)
    {
        this.postText = postText;
    }

    public byte[] getPostAttach()
    {
        return postAttach;
    }

    public void setPostAttach(byte[] postAttach)
    {
        this.postAttach = postAttach;
    }
}
