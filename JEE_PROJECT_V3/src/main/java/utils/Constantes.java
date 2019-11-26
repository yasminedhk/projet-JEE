/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author dahak
 */
public class Constantes {

    public static final String URL = "jdbc:derby://localhost:1527/JEEPRJ";
    public static final String USER_BDD = "jee";
    public static final String MDP_BDD = "jee";
    public static final String ACCUEIL = "WEB-INF/login.jsp";
    public static final String BIENVENUE = "WEB-INF/bienvenue.jsp";
    public static final String CREATE = "WEB-INF/createform.jsp";
    public static final String DETAILS = "WEB-INF/details.jsp";

    public static final String REQ_ALL_USERS = "SELECT * from UTILISATEUR";
    public static final String REQ_ALL_EMPLOYEES = "SELECT * from EMPLOYES";
    public static final String REQ_SUPP_EMPL = "DELETE FROM EMPLOYES WHERE ID = ";
    public static final String REQ_AJOUTER_EMPL = "INSERT INTO EMPLOYES (NOM , PRENOM , TELDOM , TELPORT , TELPRO, ADRESSE, CODEPOSTAL , VILLE , EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_EMPLOYE_BY_ID = "SELECT * FROM EMPLOYES WHERE ID = ?";
    public static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE EMPLOYES SET NOM = ?, PRENOM = ?, TELDOM = ?, TELPORT = ?, TELPRO = ?, ADRESSE = ?, CODEPOSTAL = ?, VILLE = ?, EMAIL = ? WHERE ID = ?";

    public static final String FIELDEMPTY_ERROR_MESSAGE = "Vous Devez renseigner les deux champs";
    public static final String FIELD_ERROR_LOG = "Echec! Mot de passe ou Login incorrect";
    public static final String SUPR_MSG = "Employé Supprimé!";
    public static final String SUPR_MSG_ERR = "Veuillez selectionner un employé!";

}
