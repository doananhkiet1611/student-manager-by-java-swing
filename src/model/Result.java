package model;

import java.io.Serializable;

public class Result implements Serializable {
    private Subject subject;
    private float score;

    public Result() {
        
    }

    public Result(Subject subject, float score) {
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
