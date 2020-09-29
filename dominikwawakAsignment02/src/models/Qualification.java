package models;

public class Qualification {
    private int year;
    private String qualification;
    private String college;
    private String degree;

    public Qualification(int year, String qualification, String college, String degree) {
        this.year = year;
        this.qualification = qualification;
        this.college = college;
        this.degree = degree;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


}