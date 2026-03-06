package org.example.commentSectionWithSql.repository;

import org.example.commentSectionWithSql.entities.Comment;
import org.example.commentSectionWithSql.db.DBConnection;

import java.sql.*;
import java.util.*;

public class CommentRepository {

    public Comment findById(int id) throws Exception {

        String sql = "SELECT * FROM comments WHERE id = ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            Integer parentId = rs.getObject("parent_id") == null
                    ? null
                    : rs.getInt("parent_id");

            Comment comment = new Comment(
                    rs.getInt("id"),
                    rs.getInt("post_id"),
                    parentId,
                    rs.getString("text")
            );

            return comment;
        }

        return null;
    }
    public void addComment(int postId, Integer parentId, String text) throws Exception {

        String sql = "INSERT INTO comments(post_id,parent_id,text) VALUES (?,?,?)";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, postId);

        if(parentId == null)
            ps.setNull(2, Types.INTEGER);
        else
            ps.setInt(2, parentId);

        ps.setString(3, text);

        ps.executeUpdate();
    }

    public List<Comment> getComments(int postId) throws Exception {

        String sql = "SELECT * FROM comments WHERE post_id = ? ORDER BY created_at";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, postId);

        ResultSet rs = ps.executeQuery();

        List<Comment> comments = new ArrayList<>();

        while(rs.next()) {

            Integer parentId = rs.getObject("parent_id") == null ?
                    null : rs.getInt("parent_id");

            Comment c = new Comment(
                    rs.getInt("id"),
                    rs.getInt("post_id"),
                    parentId,
                    rs.getString("text")
            );

            comments.add(c);
        }

        return comments;
    }

    public void deleteComment(int id) throws Exception {

        String sql = "DELETE FROM comments WHERE id = ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,id);

        ps.executeUpdate();
    }
}

//Important:
//
//Because we used
//
//ON DELETE CASCADE
//
//Deleting a parent comment automatically deletes all children.