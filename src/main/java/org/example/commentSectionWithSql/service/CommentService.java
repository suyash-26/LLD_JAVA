package org.example.commentSectionWithSql.service;

import org.example.commentSectionWithSql.entities.Comment;
import org.example.commentSectionWithSql.repository.CommentRepository;

import java.util.*;

public class CommentService {

    CommentRepository repo = new CommentRepository();

    public void addComment(int postId, Integer parentId, String text) throws Exception {

        if(parentId != null) {

            Comment parent = repo.findById(parentId);

            if(parent == null)
                throw new RuntimeException("Parent comment not found");

            if(parent.getPostId() != postId)
                throw new RuntimeException("Parent belongs to different post");
        }

        repo.addComment(postId, parentId, text);
    }

    public List<Comment> getCommentTree(int postId) throws Exception {

        List<Comment> all = repo.getComments(postId);

        Map<Integer,Comment> map = new HashMap<>();

        List<Comment> roots = new ArrayList<>();

        for(Comment c : all)
            map.put(c.getId(),c);

        for(Comment c : all){

            if(c.getParentId() == null)
                roots.add(c);

            else{
                Comment parent = map.get(c.getParentId());
                parent.addReply(c);
            }
        }

        return roots;
    }
}
