package entity;

public class SubjectScore {
    private Subject subject;
    private double score;

    public SubjectScore(Subject subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SubjectScore{" +
                "subject=" + subject +
                ", score=" + score +
                '}';
    }
}
