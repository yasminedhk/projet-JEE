/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsi.m1.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static lsi.m1.utils.Constantes.*;

/**
 *
 * @author dahak
 */
public class BD {

    Connection connexion;
    Statement stmt;
    ResultSet res;
    boolean test;
    ArrayList<Users> listeUsers;
    ArrayList<Employees> listeEmployees;
    PreparedStatement preparedStatement;

    public BD() {
        try {
            connexion = DriverManager.getConnection(URL, USER_BDD, MDP_BDD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    /**
     * 
     * @return 
     */
    public Statement getStatement() {
        try {
            stmt = connexion.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stmt;
    }
    
    /**
     * 
     * @param req
     * @return 
     */
    public ResultSet getResultSet(String req) {
        try {
            stmt = getStatement();

            res = stmt.executeQuery(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    /**
     * recupère l'employé à partir de son id dans la base
     * @param id string
     * @return un employé
     */
    public Employees getEmployeeByID(String id) {
        try {
            preparedStatement = connexion.prepareStatement(SELECT_EMPLOYE_BY_ID);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeQuery();
            res = preparedStatement.getResultSet();
            while (res.next()) {
                Employees e = new Employees();
                e.setId(res.getInt("ID"));
                e.setNom(res.getString("NOM"));
                e.setPnom(res.getString("PRENOM"));
                e.setTeldom(res.getString("TELDOM"));
                e.setTelport(res.getString("TELPORT"));
                e.setTelpro(res.getString("TELPRO"));
                e.setAdresse(res.getString("ADRESSE"));
                e.setCodep(res.getString("CODEPOSTAL"));
                e.setVille(res.getString("VILLE"));
                e.setEmail(res.getString("EMAIL"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * renvoi tous les users
     * @return une liste d'user
     */
    public ArrayList getUsers() {
        listeUsers = new ArrayList<>();
        try {
            res = getResultSet(REQ_ALL_USERS);

            while (res.next()) {
                Users userBean = new Users();
                userBean.setLogin(res.getString("LOGIN"));
                userBean.setpassword(res.getString("PASSWORD"));
                userBean.setIsAdmin(res.getBoolean("ADMIN"));

                listeUsers.add(userBean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeUsers;
    }
    
    /**
     * recupère tous les employés dans la base
     * @return 
     */
    public ArrayList getEmployees() {
        listeEmployees = new ArrayList<>();
        try {
            res = getResultSet(REQ_ALL_EMPLOYEES);

            while (res.next()) {
                Employees personne = new Employees();
                personne.setId(res.getInt("ID"));
                personne.setNom(res.getString("NOM"));
                personne.setPnom(res.getString("PRENOM"));
                personne.setTeldom(res.getString("TELDOM"));
                personne.setTelpro(res.getString("TELPRO"));
                personne.setTelport(res.getString("TELPORT"));
                personne.setAdresse(res.getString("ADRESSE"));
                personne.setCodep(res.getString("CODEPOSTAL"));
                personne.setVille(res.getString("VILLE"));
                personne.setEmail(res.getString("EMAIL"));

                listeEmployees.add(personne);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeEmployees;
    }
    
    /**
     * vérifie si le user est un admin
     * @param input
     * @return 
     */
    public boolean checkAdmin(Users input) {
        return input.isIsAdmin();

    }
    
    /**
     * mets à jour les infos de l'employé dans la bdd
     * @param empl 
     */
    public void modifierEmpl(Employees empl) {

        stmt = getStatement();

        try {

            stmt.executeUpdate("UPDATE EMPLOYES SET NOM = '"
                    + empl.getNom() + "',"
                    + "PRENOM = '" + empl.getPnom() + "',"
                    + "TELDOM = '" + empl.getTeldom() + "',"
                    + "TELPORT = '" + empl.getTelport() + "',"
                    + "TELPRO = '" + empl.getTelpro() + "',"
                    + "ADRESSE = '" + empl.getAdresse() + "',"
                    + "CODEPOSTAL = '" + empl.getCodep() + "',"
                    + "VILLE = '" + empl.getVille() + "',"
                    + "EMAIL = '" + empl.getEmail() + "'"
                    + "WHERE ID = " + empl.getId()
            );

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * vérifie si le couple login:mdp est correct
     * @param input
     * @return 
     */
    public boolean checkConnexion(Users input) {

        listeUsers = getUsers();
        for (Users i : listeUsers) {
            if (i.getLogin().equals(input.getLogin()) && i.getpassword().equals(input.getpassword())) {
                input.setIsAdmin(i.isIsAdmin());
                return true;
            }

        }
        return false;
    }
    
    /**
     * supprime l'employé de la base
     * @param id 
     */
    public void DeleteEmp(String id) {
        try {
            stmt = getStatement();
            stmt.executeUpdate(REQ_SUPP_EMPL + id);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * ajoute un employé en base
     * @param empl 
     */
    public void ajouterEmpl(Employees empl) {

        try {
            PreparedStatement pstmt = connexion.prepareStatement(REQ_AJOUTER_EMPL);
            pstmt.setString(1, empl.getNom());
            pstmt.setString(2, empl.getPnom());
            pstmt.setString(3, empl.getTeldom());
            pstmt.setString(4, empl.getTelport());
            pstmt.setString(5, empl.getTelpro());

            pstmt.setString(6, empl.getAdresse());
            pstmt.setString(7, empl.getCodep());
            pstmt.setString(8, empl.getVille());
            pstmt.setString(9, empl.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
