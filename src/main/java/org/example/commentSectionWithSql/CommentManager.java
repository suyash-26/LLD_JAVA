package org.example.commentSectionWithSql;

import org.example.commentSectionWithSql.service.CommentService;
import org.example.commentSectionWithSql.entities.Comment;

import java.util.*;

public class CommentManager {

    CommentService service = new CommentService();
    Scanner sc = new Scanner(System.in);

    public void start() throws Exception {

        while(true){

            System.out.println("1 Add Comment");
            System.out.println("2 Show Comments");
            System.out.println("0 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){

                System.out.println("Post id");
                int postId = sc.nextInt();

                System.out.println("Parent id (0 for root)");
                int parent = sc.nextInt();
                sc.nextLine();

                System.out.println("Text");
                String text = sc.nextLine();

                Integer parentId = parent == 0 ? null : parent;

                service.addComment(postId,parentId,text);
            }

            else if(choice == 2){

                System.out.println("Post id");
                int postId = sc.nextInt();

                List<Comment> tree = service.getCommentTree(postId);

                print(tree,0);
            }

            else break;
        }
    }

    private void print(List<Comment> comments,int depth){

        for(Comment c : comments){

            for(int i=0;i<depth;i++)
                System.out.print("   ");

            System.out.println(c.getText());

            print(c.getReplies(),depth+1);
        }
    }
}
