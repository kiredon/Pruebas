package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CatTipoPlanta generated by hbm2java
 */
@Entity
@Table(name="Cat_Tipo_Planta"
    ,catalog="sisem"
)
public class CatTipoPlanta  implements java.io.Serializable {


     private Integer idTipoPlanta;
     private DatUsuario datUsuarioByIdUsuarioCreacion;
     private DatUsuario datUsuarioByIdUsuarioEdicion;
     private String nombreTipoPlanta;
     private boolean status;
     private Date fechaCreacion;
     private Date fechaEdicion;
     private Set<DatR1Inspeccion> datR1Inspeccions = new HashSet<DatR1Inspeccion>(0);

    public CatTipoPlanta() {
    }

	
    public CatTipoPlanta(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreTipoPlanta, boolean status, Date fechaCreacion, Date fechaEdicion) {
        this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
        this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
        this.nombreTipoPlanta = nombreTipoPlanta;
        this.status = status;
        this.fechaCreacion = fechaCreacion;
        this.fechaEdicion = fechaEdicion;
    }
    public CatTipoPlanta(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreTipoPlanta, boolean status, Date fechaCreacion, Date fechaEdicion, Set<DatR1Inspeccion> datR1Inspeccions) {
       this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
       this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
       this.nombreTipoPlanta = nombreTipoPlanta;
       this.status = status;
       this.fechaCreacion = fechaCreacion;
       this.fechaEdicion = fechaEdicion;
       this.datR1Inspeccions = datR1Inspeccions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Tipo_Planta", unique=true, nullable=false)
    public Integer getIdTipoPlanta() {
        return this.idTipoPlanta;
    }
    
    public void setIdTipoPlanta(Integer idTipoPlanta) {
        this.idTipoPlanta = idTipoPlanta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Usuario_Creacion", nullable=false)
    public DatUsuario getDatUsuarioByIdUsuarioCreacion() {
        return this.datUsuarioByIdUsuarioCreacion;
    }
    
    public void setDatUsuarioByIdUsuarioCreacion(DatUsuario datUsuarioByIdUsuarioCreacion) {
        this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Usuario_Edicion", nullable=false)
    public DatUsuario getDatUsuarioByIdUsuarioEdicion() {
        return this.datUsuarioByIdUsuarioEdicion;
    }
    
    public void setDatUsuarioByIdUsuarioEdicion(DatUsuario datUsuarioByIdUsuarioEdicion) {
        this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
    }

    
    @Column(name="Nombre_Tipo_Planta", nullable=false, length=45)
    public String getNombreTipoPlanta() {
        return this.nombreTipoPlanta;
    }
    
    public void setNombreTipoPlanta(String nombreTipoPlanta) {
        this.nombreTipoPlanta = nombreTipoPlanta;
    }

    
    @Column(name="Status", nullable=false)
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Creacion", nullable=false, length=19)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Edicion", nullable=false, length=19)
    public Date getFechaEdicion() {
        return this.fechaEdicion;
    }
    
    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catTipoPlanta")
    public Set<DatR1Inspeccion> getDatR1Inspeccions() {
        return this.datR1Inspeccions;
    }
    
    public void setDatR1Inspeccions(Set<DatR1Inspeccion> datR1Inspeccions) {
        this.datR1Inspeccions = datR1Inspeccions;
    }




}


