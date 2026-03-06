package org.example.commentSectionWithSql.entities;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    private int id;
    private int postId;
    private Integer parentId;
    private String text;

    private List<Comment> replies = new ArrayList<>();

    public Comment(int id, int postId, Integer parentId, String text) {
        this.id = id;
        this.postId = postId;
        this.parentId = parentId;
        this.text = text;
    }

    public int getId() { return id; }
    public int getPostId() { return postId; }
    public Integer getParentId() { return parentId; }
    public String getText() { return text; }

    public List<Comment> getReplies() { return replies; }

    public void addReply(Comment c){
        replies.add(c);
    }
}

//
//Notice:
//
//List<Comment> replies
//
//This is used only in memory to build the comment tree.