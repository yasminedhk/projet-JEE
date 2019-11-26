/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsi.m1.models;

/**
 *
 * @author dahak
 */
public class Employees {

    int id;
    String nom;
    String pnom;
    String teldom;
    String telport;
    String telpro;
    String adresse;
    String codep;
    String ville;
    String email;

    public Employees() {
    }

    public Employees(int id, String nom, String pnom, String teldom, String telport, String telpro, String adresse, String codep, String ville, String email) {
        this.id = id;
        this.nom = nom;
        this.pnom = pnom;
        this.teldom = teldom;
        this.telport = telport;
        this.telpro = telpro;
        this.adresse = adresse;
        this.codep = codep;
        this.ville = ville;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPnom() {
        return pnom;
    }

    public String getTeldom() {
        return teldom;
    }

    public String getTelport() {
        return telport;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodep() {
        return codep;
    }

    public String getVille() {
        return ville;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPnom(String pnom) {
        this.pnom = pnom;
    }

    public void setTeldom(String teldom) {
        this.teldom = teldom;
    }

    public void setTelport(String telport) {
        this.telport = telport;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodep(String codep) {
        this.codep = codep;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelpro() {
        return telpro;
    }

    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

}
