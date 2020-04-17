package com.example.project;

public class Database {
    private String subject;
    private String add;
    private String notadd;
    private long id;

    public Database(Long id, String subject, String add, String notadd) {
        this.id = id;
        this.subject = subject;
        this.add = add;
        this.notadd = notadd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSent() {
        return add;
    }

    public void setSent(String add) {
        this.add = add;
    }

    public String getReceived() {
        return notadd;
    }

    public void setReceived(String notadd) {
        this.notadd = notadd;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
