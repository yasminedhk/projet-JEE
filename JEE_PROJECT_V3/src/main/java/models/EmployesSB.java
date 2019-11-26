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
public class EmployesSB {
    
      @PersistenceContext
    EntityManager myEntityManager;
    
    ArrayList<Employes> liste;
    
    
      public ArrayList<Employes> getEmployes(){
        liste = new ArrayList<>();
        Query myQuery = myEntityManager.createNamedQuery("Employes.findAll");
        liste.addAll(myQuery.getResultList());
        return liste;
    }
      
        public Employes getEmployesByID(String id){
        
            Query myQuery = myEntityManager.createNamedQuery("Employes.findById");
            myQuery.setParameter("id", Integer.parseInt(id));
            return (Employes) myQuery.getSingleResult();
       
        
    }
      
        public void deleteEmployesByID(String id){
        Query myQuery = myEntityManager.createNamedQuery("Employes.deleteById");
        myQuery.setParameter("id", Integer.parseInt(id));
        myQuery.executeUpdate();
    }
        
        
         public void saveEmployee(Employes e){
        myEntityManager.persist(e);
    }
         
          public void updateEmployee(Employes e){
        myEntityManager.merge(e);
    }
          

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
