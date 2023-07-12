package com.example.CMSCrud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Outgoing")
public class Outgoing {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="reference")
    private String reference;
    @Column(name="subj")
    private String subject;
    @Column(name="pr")
    private String priority;
    @Column(name="descr")
    private String description;
    @Column(name="comment")
    private String comment;
    @Column(name="dt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date date;
    @Column(name="sender")
    private Integer sender;
    @Column(name="receiver")
    private Integer reciever;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getReciever() {
        return reciever;
    }

    public void setReciever(Integer reciever) {
        this.reciever = reciever;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outgoing outgoing = (Outgoing) o;
        return id.equals(outgoing.id) && reference.equals(outgoing.reference) && subject.equals(outgoing.subject) && priority.equals(outgoing.priority) && description.equals(outgoing.description) && comment.equals(outgoing.comment) && date.equals(outgoing.date) && sender.equals(outgoing.sender) && reciever.equals(outgoing.reciever);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, subject, priority, description, comment, date, sender, reciever);
    }

}
