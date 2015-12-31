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
 * CatTipoDomicilio generated by hbm2java
 */
@Entity
@Table(name="Cat_Tipo_Domicilio"
    ,catalog="sisem"
)
public class CatTipoDomicilio  implements java.io.Serializable {


     private Integer idTipoDomicilio;
     private DatUsuario datUsuarioByIdUsuarioCreacion;
     private DatUsuario datUsuarioByIdUsuarioEdicion;
     private String nombreTipoDomicilio;
     private boolean status;
     private Date fechaCreacion;
     private Date fechaEdicion;
     private Set<DatDomicilioFiscal> datDomicilioFiscals = new HashSet<DatDomicilioFiscal>(0);

    public CatTipoDomicilio() {
    }

	
    public CatTipoDomicilio(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreTipoDomicilio, boolean status, Date fechaCreacion, Date fechaEdicion) {
        this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
        this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
        this.nombreTipoDomicilio = nombreTipoDomicilio;
        this.status = status;
        this.fechaCreacion = fechaCreacion;
        this.fechaEdicion = fechaEdicion;
    }
    public CatTipoDomicilio(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreTipoDomicilio, boolean status, Date fechaCreacion, Date fechaEdicion, Set<DatDomicilioFiscal> datDomicilioFiscals) {
       this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
       this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
       this.nombreTipoDomicilio = nombreTipoDomicilio;
       this.status = status;
       this.fechaCreacion = fechaCreacion;
       this.fechaEdicion = fechaEdicion;
       this.datDomicilioFiscals = datDomicilioFiscals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Tipo_Domicilio", unique=true, nullable=false)
    public Integer getIdTipoDomicilio() {
        return this.idTipoDomicilio;
    }
    
    public void setIdTipoDomicilio(Integer idTipoDomicilio) {
        this.idTipoDomicilio = idTipoDomicilio;
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

    
    @Column(name="Nombre_Tipo_Domicilio", nullable=false, length=45)
    public String getNombreTipoDomicilio() {
        return this.nombreTipoDomicilio;
    }
    
    public void setNombreTipoDomicilio(String nombreTipoDomicilio) {
        this.nombreTipoDomicilio = nombreTipoDomicilio;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="catTipoDomicilio")
    public Set<DatDomicilioFiscal> getDatDomicilioFiscals() {
        return this.datDomicilioFiscals;
    }
    
    public void setDatDomicilioFiscals(Set<DatDomicilioFiscal> datDomicilioFiscals) {
        this.datDomicilioFiscals = datDomicilioFiscals;
    }




}


