package com.eduforall.model.criteria;

public class CoursCriteria {
    private String subject;
    private String level;
    private int duration;
    private String specialite;
    private String professeur;
    private String ecole;

    public CoursCriteria(String subject, String level, int duration, String specialite, String professeur, String ecole) {
        this.subject = subject;
        this.level = level;
        this.duration = duration;
        this.specialite = specialite;
        this.professeur = professeur;
        this.ecole = ecole;
    }

    public CoursCriteria() {
    }

    public String getSubject() {
        return subject;
    }

    public String getLevel() {
        return level;
    }

    public int getDuration() {
        return duration;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getProfesseur() {
        return professeur;
    }

    public String getEcole() {
        return ecole;
    }
}
