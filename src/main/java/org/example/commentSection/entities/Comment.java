package org.example.commentSection.entities;

import java.util.List;

public class Comment {
    private String text;
    private int id;
    private int ticket_id;
    private int parentId;

    public Comment(){
        this.id = (int)(Math.random()*100);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", id=" + id +
                ", ticket_id=" + ticket_id +
                ", parentId=" + parentId +
                '}';
    }
}
