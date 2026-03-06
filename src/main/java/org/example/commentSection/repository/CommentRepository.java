package org.example.commentSection.repository;

import org.example.commentSection.entities.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    private final List<Comment> comments = new ArrayList<>();
    public List<Comment> getComments(){
        return comments;
    }
    public void addComment(Comment comment){
        try{
            comments.add(comment);
            System.out.println("Comment added successfully");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void deleteComment(int commentId){
        int index = -1;
        for(int i=0;i<comments.size();i++){
            if(comments.get(i).getId() == commentId){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("Wrong comment id");
            return;
        }
        comments.remove(index);
        System.out.println("Comment removed successfully");
    }
    public void editComment(int commentId, String text){
        int index = -1;
        for(int i=0;i<comments.size();i++){
            if(comments.get(i).getId() == commentId){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("Wrong comment id");
            return;
        }
        comments.get(index).setText(text);
        System.out.println("Comment " + commentId + " edited successfully");
    }
}
