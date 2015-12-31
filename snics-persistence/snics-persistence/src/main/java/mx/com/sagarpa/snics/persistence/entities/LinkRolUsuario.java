package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LinkRolUsuario generated by hbm2java
 */
@Entity
@Table(name="Link_Rol_Usuario"
    ,catalog="sisem"
)
public class LinkRolUsuario  implements java.io.Serializable {


     private Integer idRolUsuario;
     private CatRol catRol;
     private DatUsuario datUsuario;
     private Set<CatUnidadSnics> catUnidadSnicses = new HashSet<CatUnidadSnics>(0);

    public LinkRolUsuario() {
    }

	
    public LinkRolUsuario(CatRol catRol, DatUsuario datUsuario) {
        this.catRol = catRol;
        this.datUsuario = datUsuario;
    }
    public LinkRolUsuario(CatRol catRol, DatUsuario datUsuario, Set<CatUnidadSnics> catUnidadSnicses) {
       this.catRol = catRol;
       this.datUsuario = datUsuario;
       this.catUnidadSnicses = catUnidadSnicses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Rol_Usuario", unique=true, nullable=false)
    public Integer getIdRolUsuario() {
        return this.idRolUsuario;
    }
    
    public void setIdRolUsuario(Integer idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Rol", nullable=false)
    public CatRol getCatRol() {
        return this.catRol;
    }
    
    public void setCatRol(CatRol catRol) {
        this.catRol = catRol;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Usuario", nullable=false)
    public DatUsuario getDatUsuario() {
        return this.datUsuario;
    }
    
    public void setDatUsuario(DatUsuario datUsuario) {
        this.datUsuario = datUsuario;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Link_Rol_Usuario_Unidad_Snics", catalog="sisem", joinColumns = { 
        @JoinColumn(name="Id_Rol_Usuario", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Id_Unidad_Snics", nullable=false, updatable=false) })
    public Set<CatUnidadSnics> getCatUnidadSnicses() {
        return this.catUnidadSnicses;
    }
    
    public void setCatUnidadSnicses(Set<CatUnidadSnics> catUnidadSnicses) {
        this.catUnidadSnicses = catUnidadSnicses;
    }




}


