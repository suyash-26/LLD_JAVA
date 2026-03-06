package org.example;



import org.example.commentSectionWithSql.CommentManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CommentManager cm = new CommentManager();
        try{
            cm.start();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}