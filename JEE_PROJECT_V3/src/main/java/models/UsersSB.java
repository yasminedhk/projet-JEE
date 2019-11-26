/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dahak
 */
@Stateless
public class UsersSB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     @PersistenceContext
    EntityManager myEntityManager;
    
    ArrayList<Users> listUsers;
     Users returnUser;
    
    
     public ArrayList<Users> getUsers(){
        listUsers = new ArrayList<>();
        Query myQuery = myEntityManager.createNamedQuery("Users.findAll");
        listUsers.addAll(myQuery.getResultList());
        return listUsers;
    }
     
     public Users checkConnexion(Users input)
   {
      
       listUsers=getUsers();
       returnUser= null;
     
       
       for(int i=0 ; i<listUsers.size();i++)
       {
           if(listUsers.get(i).getLogin().equals(input.getLogin()) && listUsers.get(i).getPwd().equals(input.getPwd()))
               
           {  input.setAdmin(listUsers.get(i).getAdmin());
              returnUser = listUsers.get(i);
           }
           
       }
      return returnUser;     
   }
    
}
