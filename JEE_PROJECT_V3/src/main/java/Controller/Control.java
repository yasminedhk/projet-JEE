/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Constantes.*;

import models.Employes;
import models.EmployesSB;

import models.Users;
import models.UsersSB;

/**
 *
 * @author dahak
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})

public class Control extends HttpServlet {

    HttpSession session;
    String dBURL;
    String dBUser;
    String dBPassword;

    @EJB
    private EmployesSB employeSB;

    @EJB
    private UsersSB userSB;

    Users input;
    Employes selectedEmployee;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action") == null) {

            request.getRequestDispatcher(ACCUEIL).forward(request, response);

        }
        switch (request.getParameter("action")) {
            case "connexion":

                if (request.getParameter("pass").equals("") || request.getParameter("pseudo").equals("")) {
                    request.setAttribute("fieldIsEmpty", FIELDEMPTY_ERROR_MESSAGE);
                    request.getRequestDispatcher(ACCUEIL).forward(request, response);
                } else {
                    input = new Users();
                    input.setLogin(request.getParameter("pseudo"));
                    input.setPwd(request.getParameter("pass"));

                    session = request.getSession();

                    if (userSB.checkConnexion(input) != null) {
                        request.setAttribute("input", request.getParameter("pseudo"));
                        request.setAttribute("vide", employeSB.getEmployes().isEmpty());
                        request.setAttribute("liste", employeSB.getEmployes());

                        request.setAttribute("isAdmin", input.getAdmin());

                        request.getRequestDispatcher(BIENVENUE).forward(request, response);
                    } else {
                        request.setAttribute("wrongLoginPassword", FIELD_ERROR_LOG);
                        request.getRequestDispatcher(ACCUEIL).forward(request, response);
                    }
                }
                break;
            case "ajouter":
                request.getRequestDispatcher(CREATE).forward(request, response);
                break;

            case "details":
                String idi = request.getParameter("radiobtn");
                if (idi != null) {
                    request.setAttribute("employee", employeSB.getEmployesByID(idi));
                    request.getRequestDispatcher(DETAILS).forward(request, response);

                } else {
                    request.setAttribute("SUPR_MSG_ERR", SUPR_MSG_ERR);
                    request.setAttribute("input", request.getParameter("pseudo"));
                    request.setAttribute("vide", employeSB.getEmployes().isEmpty());
                    request.setAttribute("liste", employeSB.getEmployes());
                    request.setAttribute("isAdmin", input.getAdmin());
                    request.getRequestDispatcher(BIENVENUE).forward(request, response);
                }

                break;

            case "deconnecter":
                request.getRequestDispatcher(ACCUEIL).forward(request, response);
                break;

            case "Retourliste":

                request.setAttribute("input", input.getLogin());
                request.setAttribute("vide", employeSB.getEmployes().isEmpty());
                request.setAttribute("liste", employeSB.getEmployes());
                request.setAttribute("isAdmin", input.getAdmin());
                request.getRequestDispatcher(BIENVENUE).forward(request, response);
                break;

            case "supprimer":
                String id = request.getParameter("radiobtn");
                if (id != null) {
                    employeSB.deleteEmployesByID(id);
                    request.setAttribute("SUPR_MSG", SUPR_MSG);
                    request.setAttribute("input", input.getLogin());
                    request.setAttribute("vide", employeSB.getEmployes().isEmpty());
                    request.setAttribute("liste", employeSB.getEmployes());
                    request.setAttribute("isAdmin", input.getAdmin());
                    request.getRequestDispatcher(BIENVENUE).forward(request, response);

                } else {
                    request.setAttribute("SUPR_MSG_ERR", SUPR_MSG_ERR);
                    request.setAttribute("input", input.getLogin());
                    request.setAttribute("vide", employeSB.getEmployes().isEmpty());
                    request.setAttribute("liste", employeSB.getEmployes());
                    request.setAttribute("isAdmin", input.getAdmin());
                    request.getRequestDispatcher(BIENVENUE).forward(request, response);

                }

                break;

            case "Modifier":

                Employes empl = new Employes();
                empl.setNom(request.getParameter("nomForm"));
                empl.setPrenom(request.getParameter("prenomForm"));
                empl.setTeldom(request.getParameter("telDomForm"));
                empl.setTelport(request.getParameter("telMobForm"));
                empl.setTelpro(request.getParameter("telProForm"));
                empl.setVille(request.getParameter("villeForm"));
                empl.setCodepostal(request.getParameter("codePostalForm"));
                empl.setAdresse(request.getParameter("adresseForm"));
                empl.setEmail(request.getParameter("emailForm"));
                employeSB.updateEmployee(empl);
                request.setAttribute("input", input.getLogin());
                request.setAttribute("vide", employeSB.getEmployes().isEmpty());
                request.setAttribute("liste", employeSB.getEmployes());
                request.setAttribute("isAdmin", input.getAdmin());
                request.getRequestDispatcher(BIENVENUE).forward(request, response);

                break;

            case "validerajout":

                Employes emp = new Employes();
                emp.setNom(request.getParameter("nomForm"));
                emp.setPrenom(request.getParameter("prenomForm"));
                emp.setTeldom(request.getParameter("telDomForm"));
                emp.setTelport(request.getParameter("telMobForm"));
                emp.setTelpro(request.getParameter("telProForm"));
                emp.setVille(request.getParameter("villeForm"));
                emp.setCodepostal(request.getParameter("codePostalForm"));
                emp.setAdresse(request.getParameter("adresseForm"));
                emp.setEmail(request.getParameter("emailForm"));
                employeSB.saveEmployee(emp);
                request.setAttribute("input", input.getLogin());
                request.setAttribute("vide", employeSB.getEmployes().isEmpty());
                request.setAttribute("liste", employeSB.getEmployes());
                request.setAttribute("isAdmin", input.getAdmin());
                request.getRequestDispatcher(BIENVENUE).forward(request, response);

                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
