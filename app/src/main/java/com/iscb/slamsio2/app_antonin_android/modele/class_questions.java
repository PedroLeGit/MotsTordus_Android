package com.iscb.slamsio2.app_antonin_android.modele;

public class class_questions {
    //  Propriété
    private int id_question;
    private String libelle_question;
    private String choix1_question;
    private String choix2_question;
    private String choix3_question;
    private int solution_question;

    //  Construction
    public class_questions(int unId, String unLibelle, String choix1, String choix2, String choix3, int bonne_rep){
        id_question = unId;
        libelle_question = unLibelle;
        choix1_question = choix1;
        choix2_question = choix2;
        choix3_question = choix3;
        solution_question = bonne_rep;
    }
    //  Accesseurs
    //      Getter

    public int getId_question() {
        return id_question;
    }

    public String getLibelle_question() {
        return libelle_question;
    }

    public String getChoix1_question() {
        return choix1_question;
    }

    public String getChoix2_question() {
        return choix2_question;
    }

    public String getChoix3_question() {
        return choix3_question;
    }

    public int getSolution_question() {
        return solution_question;
    }

    //      Setter

    public void setLibelle_question(String libelle_question) {
        this.libelle_question = libelle_question;
    }

    public void setChoix1_question(String choix1_question) {
        this.choix1_question = choix1_question;
    }

    public void setChoix2_question(String choix2_question) {
        this.choix2_question = choix2_question;
    }

    public void setChoix3_question(String choix3_question) {
        this.choix3_question = choix3_question;
    }

    public void setSolution_question(int solution_question) {
        this.solution_question = solution_question;
    }
}
