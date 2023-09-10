package com.model;


import java.io.Serializable;

public class etudient implements Serializable {
    private Integer id;
    private String nom;
    private String prenom;
    private String dateNaiss;
    private String sexe;
    private int numBac;
    private String dateInsc;
//    public etudient(int id, String nom, String prenom, String datenaiss, String sexe, int numbac, String dateinsc) {
//    }

    public etudient(Integer id , String nom, String prenom, String dateNaiss, String sexe, Integer numBac, String dateInsc) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.numBac = numBac;
        this.dateInsc = dateInsc;
    }
    public etudient(String nom, String prenom, String dateNaiss, String sexe, int numBac, String dateInsc) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.numBac = numBac;
        this.dateInsc = dateInsc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getNumBac() {
        return this.numBac;
    }

    public void setNumBac(int numBac) {
        this.numBac = numBac;
    }

    public String getDateInsc() {
        return dateInsc;
    }

    public void setDateInsc(String dateInsc) {
        this.dateInsc = dateInsc;
    }
}
