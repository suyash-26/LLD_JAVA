package org.example.commentSection;

import org.example.commentSection.entities.Comment;
import org.example.commentSection.repository.CommentRepository;

import java.util.List;
import java.util.Scanner;

public class CommentManager {
    private boolean exit = false;
    CommentRepository cr = new CommentRepository();
    public void init(){
        while(!exit){
            System.out.println("Press 1 to comment");
            System.out.println("Press 2 to get all comments");
            System.out.println("Press 0 to exit");
            Scanner sc = new Scanner(System.in);
            int status = sc.nextInt();
            if(status == 1){
                System.out.println("Enter post id");
                int ticketId = sc.nextInt();
                System.out.println("Enter parent comment id and 0 for no parent id");
                int parentId = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter text");
                String text = sc.nextLine();
                Comment c = new Comment();
                c.setText(text);
                c.setTicket_id(ticketId);
                c.setParentId(parentId);
                cr.addComment(c);
            }else if(status == 2){
                List<Comment> commentList = cr.getComments();
                commentList.forEach(comment -> System.out.println(comment));
            }else{
                exit = true;
            }
        }
    }
}
