/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dahak
 */
@Entity
@Table(name = "employes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employes.findAll", query = "SELECT e FROM Employes e")
    , @NamedQuery(name = "Employes.findById", query = "SELECT e FROM Employes e WHERE e.id = :id")
    , @NamedQuery(name = "Employes.findByNom", query = "SELECT e FROM Employes e WHERE e.nom = :nom")
    , @NamedQuery(name = "Employes.findByPrenom", query = "SELECT e FROM Employes e WHERE e.prenom = :prenom")
    , @NamedQuery(name = "Employes.findByTeldom", query = "SELECT e FROM Employes e WHERE e.teldom = :teldom")
    , @NamedQuery(name = "Employes.findByTelport", query = "SELECT e FROM Employes e WHERE e.telport = :telport")
    , @NamedQuery(name = "Employes.findByTelpro", query = "SELECT e FROM Employes e WHERE e.telpro = :telpro")
    , @NamedQuery(name = "Employes.findByAdresse", query = "SELECT e FROM Employes e WHERE e.adresse = :adresse")
    , @NamedQuery(name = "Employes.findByCodepostal", query = "SELECT e FROM Employes e WHERE e.codepostal = :codepostal")
    , @NamedQuery(name = "Employes.findByVille", query = "SELECT e FROM Employes e WHERE e.ville = :ville")
    , @NamedQuery(name = "Employes.findByEmail", query = "SELECT e FROM Employes e WHERE e.email = :email")
    ,@NamedQuery(name = "Employes.deleteById", query = "DELETE FROM Employes e WHERE e.id = :id")})
public class Employes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 25)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 25)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 10)
    @Column(name = "TELDOM")
    private String teldom;
    @Size(max = 10)
    @Column(name = "TELPORT")
    private String telport;
    @Size(max = 10)
    @Column(name = "TELPRO")
    private String telpro;
    @Size(max = 150)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 15)
    @Column(name = "CODEPOSTAL")
    private String codepostal;
    @Size(max = 25)
    @Column(name = "VILLE")
    private String ville;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "EMAIL")
    private String email;

    public Employes() {
    }

    public Employes(Integer id) {
        this.id = id;
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

    public String getTeldom() {
        return teldom;
    }

    public void setTeldom(String teldom) {
        this.teldom = teldom;
    }

    public String getTelport() {
        return telport;
    }

    public void setTelport(String telport) {
        this.telport = telport;
    }

    public String getTelpro() {
        return telpro;
    }

    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employes)) {
            return false;
        }
        Employes other = (Employes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Employes[ id=" + id + " ]";
    }
    
}
