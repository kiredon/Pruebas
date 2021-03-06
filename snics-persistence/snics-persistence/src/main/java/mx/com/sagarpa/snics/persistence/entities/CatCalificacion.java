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
 * CatCalificacion generated by hbm2java
 */
@Entity
@Table(name="Cat_Calificacion"
    ,catalog="sisem"
)
public class CatCalificacion  implements java.io.Serializable {


     private Integer idCalificacion;
     private String nombreCalificacion;
     private Set<DatLaboratorioCabecera> datLaboratorioCabeceras = new HashSet<DatLaboratorioCabecera>(0);

    public CatCalificacion() {
    }

	
    public CatCalificacion(String nombreCalificacion) {
        this.nombreCalificacion = nombreCalificacion;
    }
    public CatCalificacion(String nombreCalificacion, Set<DatLaboratorioCabecera> datLaboratorioCabeceras) {
       this.nombreCalificacion = nombreCalificacion;
       this.datLaboratorioCabeceras = datLaboratorioCabeceras;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Calificacion", unique=true, nullable=false)
    public Integer getIdCalificacion() {
        return this.idCalificacion;
    }
    
    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    
    @Column(name="Nombre_Calificacion", nullable=false, length=45)
    public String getNombreCalificacion() {
        return this.nombreCalificacion;
    }
    
    public void setNombreCalificacion(String nombreCalificacion) {
        this.nombreCalificacion = nombreCalificacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCalificacion")
    public Set<DatLaboratorioCabecera> getDatLaboratorioCabeceras() {
        return this.datLaboratorioCabeceras;
    }
    
    public void setDatLaboratorioCabeceras(Set<DatLaboratorioCabecera> datLaboratorioCabeceras) {
        this.datLaboratorioCabeceras = datLaboratorioCabeceras;
    }




}


