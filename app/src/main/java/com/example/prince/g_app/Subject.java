package com.example.prince.g_app;

/**
 * Created by Prince on 01-04-2017.
 */

public class Subject {
    String subject,total;
    int image;


    public Subject(String subject, int image,String total) {
        this.subject = subject;
        this.image=image;
        this.total=total;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
