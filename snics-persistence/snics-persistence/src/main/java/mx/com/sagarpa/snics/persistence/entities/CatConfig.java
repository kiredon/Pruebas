package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CatConfig generated by hbm2java
 */
@Entity
@Table(name="Cat_Config"
    ,catalog="sisem"
)
public class CatConfig  implements java.io.Serializable {


     private int idConfig;
     private String nombreConfig;
     private String config;

    public CatConfig() {
    }

    public CatConfig(int idConfig, String nombreConfig, String config) {
       this.idConfig = idConfig;
       this.nombreConfig = nombreConfig;
       this.config = config;
    }
   
     @Id 

    
    @Column(name="Id_Config", unique=true, nullable=false)
    public int getIdConfig() {
        return this.idConfig;
    }
    
    public void setIdConfig(int idConfig) {
        this.idConfig = idConfig;
    }

    
    @Column(name="Nombre_Config", nullable=false, length=50)
    public String getNombreConfig() {
        return this.nombreConfig;
    }
    
    public void setNombreConfig(String nombreConfig) {
        this.nombreConfig = nombreConfig;
    }

    
    @Column(name="Config", nullable=false, length=500)
    public String getConfig() {
        return this.config;
    }
    
    public void setConfig(String config) {
        this.config = config;
    }




}


