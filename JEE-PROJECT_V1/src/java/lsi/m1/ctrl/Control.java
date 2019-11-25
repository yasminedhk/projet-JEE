/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsi.m1.ctrl;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lsi.m1.models.BD;
import lsi.m1.models.Employees;
import lsi.m1.models.Users;

import static lsi.m1.utils.Constantes.*;

/**
 *
 * @author dahak
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {
     BD actionsBD;

     private Users input;
     HttpSession session;
     Employees empl ;
      

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

   
        actionsBD = new BD();          
        
             
        if ( request.getParameter("action")== null) {
            //If user is connected
           /* if (selectedUser != null) {
                request.setAttribute("employeesList", dBAction.getEmployees());
                request.setAttribute("deleteSucceed", "-1");
                request.getRequestDispatcher(WELCOMEPAGE_JSP).forward(request, response);
            } else {*/
                request.getRequestDispatcher(ACCUEIL).forward(request, response);
            //}
        } 
          
        switch(request.getParameter("action"))
        {
            case "connexion":
                
                 if(request.getParameter("pass").equals("") || request.getParameter("pseudo").equals("")){
                    request.setAttribute("errKey", "<p class=\"text-danger\"> Vous devez renseigner les deux champs</p>"); 
                    request.getRequestDispatcher(ACCUEIL).forward(request, response); 
                }
                 else{
                        input = new Users();
                        session = request.getSession();
                        input.setLogin(request.getParameter("pseudo"));
                        input.setpassword(request.getParameter("pass"));
                        //si les cases sont remplies
                        if(actionsBD.checkConnexion(input) == true)
                        {  
                            request.setAttribute("input", input.getLogin());
                               
                            //si c'est l'Admin
                            if(input.isIsAdmin() == true)
                                 
                                
                            {
                                
                                request.setAttribute("vide", actionsBD.getEmployees().isEmpty());
                                request.setAttribute("liste", actionsBD.getEmployees());
                                
                                request.setAttribute("isAdmin",input.isIsAdmin());
                                request.getRequestDispatcher(BIENVENUE).forward(request, response);                                                
                                
                                
                                     
                                
                       
                              
                            
                        
                                
                            }
                            else
                            {
                                 request.setAttribute("isAdmin",input.isIsAdmin());
                                 
                                
                                  request.setAttribute("liste", actionsBD.getEmployees());
                        
                                  request.getRequestDispatcher(BIENVENUE).forward(request, response);
                            }
                        }
                   
                
                        else
                        {
                            request.setAttribute("errKey", "<p class=\"text-danger\"> Erreur! Login ou mot de passe incorrect</p>"); 
                    request.getRequestDispatcher(ACCUEIL).forward(request, response); 
                        }
                       
                break;        
                        
                        
                        
                 }
            case "supprimer": //Géerer messages pas fait
               
                                     String id = request.getParameter("radiobtn");
                                     if (id != null) {
                                     actionsBD.DeleteEmp(id);
                                     request.setAttribute("MSG_SUPP",true);
                                     request.setAttribute("liste", actionsBD.getEmployees());
                                      request.setAttribute("vide", actionsBD.getEmployees().isEmpty());
                                       request.setAttribute("isAdmin",input.isIsAdmin());
                                     
                                     request.getRequestDispatcher(BIENVENUE).forward(request, response);
                                     } else {
                                        
                                       request.setAttribute("MSG_SUPP",false);
                                       request.setAttribute("liste", actionsBD.getEmployees());
                                      request.setAttribute("vide", actionsBD.getEmployees().isEmpty());
                                       request.setAttribute("isAdmin",input.isIsAdmin());
                                         
                                    //request.setAttribute("errSelectEmpl", ERR_SELECT_EMPL_SUPP);
                                    //request.setAttribute("listeEmplKey", actionsBD.getEmployes());
                                    //request.getRequestDispatcher(JSP_BIENVENUE).forward(request, response);
                                     }
                                     
                            
          
                
                 
           
                 
             break;    
            case "details" :
                String idi = request.getParameter("radiobtn");
                if (idi != null) {
             
                request.setAttribute("employee", actionsBD.getEmployeeByID(idi));
                request.getRequestDispatcher(DETAILS).forward(request, response);
            } else {
               /* request.setAttribute("errSelectEmpl", ERR_SELECT_EMPL);
                request.setAttribute("listeEmplKey", actionsBD.getEmployes());
                request.getRequestDispatcher(JSP_BIENVENUE).forward(request, response);*/
            }
                    
                 request.getRequestDispatcher(DETAILS).forward(request, response);
                
                
                
             break;
             
            case "ajouter":
             request.getRequestDispatcher(CREATE).forward(request, response);
            break;
            
            case "validerajout":
             empl = new Employees();
            empl.setNom(request.getParameter("nomForm"));
            empl.setPnom(request.getParameter("prenomForm"));
            empl.setTeldom(request.getParameter("telDomForm"));
            empl.setTelport(request.getParameter("telMobForm"));
             empl.setTelpro(request.getParameter("telProForm"));
            
            empl.setAdresse(request.getParameter("adresseForm"));
            empl.setCodep(request.getParameter("codePostalForm"));
            empl.setVille(request.getParameter("villeForm"));
            empl.setEmail(request.getParameter("emailForm"));
            actionsBD.ajouterEmpl(empl);
            request.setAttribute("liste", actionsBD.getEmployees());
            request.setAttribute("isAdmin",input.isIsAdmin());
            request.getRequestDispatcher(BIENVENUE).forward(request, response);
            
            break;
            case "Retourliste":
                
              request.setAttribute("isAdmin",input.isIsAdmin());
              request.setAttribute("liste", actionsBD.getEmployees());
                        
             request.getRequestDispatcher(BIENVENUE).forward(request, response);
            
            break;
            case "Modifier":
                
                 empl = new Employees();
            empl.setId(Integer.parseInt(request.getParameter("idForm")));
            empl.setNom(request.getParameter("nomForm"));
            empl.setPnom(request.getParameter("prenomForm"));
            empl.setTeldom(request.getParameter("telDomForm"));
            empl.setTelport(request.getParameter("telMobForm"));
             empl.setTelpro(request.getParameter("telProForm"));
            
            empl.setAdresse(request.getParameter("adresseForm"));
            empl.setCodep(request.getParameter("codePostalForm"));
            empl.setVille(request.getParameter("villeForm"));
            empl.setEmail(request.getParameter("emailForm"));
            
            actionsBD.modifierEmpl(empl);
            request.setAttribute("liste", actionsBD.getEmployees());
            request.setAttribute("isAdmin",input.isIsAdmin());
            request.getRequestDispatcher(BIENVENUE).forward(request, response);
            
            break;
            
             case "deconnecter":
            request.getRequestDispatcher(ACCUEIL).forward(request, response); 
            break;
                
        }
        
       
      
    }
    

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  
}