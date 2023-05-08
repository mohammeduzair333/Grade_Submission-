package com.ltp.gradesubmission;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Grade {
   @NotBlank(message = "Name cannot be blank")
   private String student;
   @NotBlank(message = "Subject cannot be blank")
   private String subject;
   private String score;

   private String id;

//    public Grade(String student, String subject, String score) {
//        this.student = student;
//        this.subject = subject;
//        this.score = score;
//    }

    public  Grade(){
     this.id=UUID.randomUUID().toString();
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
