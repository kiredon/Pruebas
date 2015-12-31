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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CatStatusMovimientoEtiqueta generated by hbm2java
 */
@Entity
@Table(name="Cat_Status_Movimiento_Etiqueta"
    ,catalog="sisem"
)
public class CatStatusMovimientoEtiqueta  implements java.io.Serializable {


     private Integer idStatusMovimientoEtiqueta;
     private String nombreStatus;
     private Boolean status;
     private Set<DatMovimientoEtiquetas> datMovimientoEtiquetases = new HashSet<DatMovimientoEtiquetas>(0);
     private Set<LinkMovimientoEtiquetasSnics> linkMovimientoEtiquetasSnicses = new HashSet<LinkMovimientoEtiquetasSnics>(0);

    public CatStatusMovimientoEtiqueta() {
    }

    public CatStatusMovimientoEtiqueta(String nombreStatus, Boolean status, Set<DatMovimientoEtiquetas> datMovimientoEtiquetases, Set<LinkMovimientoEtiquetasSnics> linkMovimientoEtiquetasSnicses) {
       this.nombreStatus = nombreStatus;
       this.status = status;
       this.datMovimientoEtiquetases = datMovimientoEtiquetases;
       this.linkMovimientoEtiquetasSnicses = linkMovimientoEtiquetasSnicses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Status_Movimiento_Etiqueta", unique=true, nullable=false)
    public Integer getIdStatusMovimientoEtiqueta() {
        return this.idStatusMovimientoEtiqueta;
    }
    
    public void setIdStatusMovimientoEtiqueta(Integer idStatusMovimientoEtiqueta) {
        this.idStatusMovimientoEtiqueta = idStatusMovimientoEtiqueta;
    }

    
    @Column(name="Nombre_Status", length=45)
    public String getNombreStatus() {
        return this.nombreStatus;
    }
    
    public void setNombreStatus(String nombreStatus) {
        this.nombreStatus = nombreStatus;
    }

    
    @Column(name="Status")
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catStatusMovimientoEtiqueta")
    public Set<DatMovimientoEtiquetas> getDatMovimientoEtiquetases() {
        return this.datMovimientoEtiquetases;
    }
    
    public void setDatMovimientoEtiquetases(Set<DatMovimientoEtiquetas> datMovimientoEtiquetases) {
        this.datMovimientoEtiquetases = datMovimientoEtiquetases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catStatusMovimientoEtiqueta")
    public Set<LinkMovimientoEtiquetasSnics> getLinkMovimientoEtiquetasSnicses() {
        return this.linkMovimientoEtiquetasSnicses;
    }
    
    public void setLinkMovimientoEtiquetasSnicses(Set<LinkMovimientoEtiquetasSnics> linkMovimientoEtiquetasSnicses) {
        this.linkMovimientoEtiquetasSnicses = linkMovimientoEtiquetasSnicses;
    }




}


