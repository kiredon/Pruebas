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
 * CatSustrato generated by hbm2java
 */
@Entity
@Table(name="Cat_Sustrato"
    ,catalog="sisem"
)
public class CatSustrato  implements java.io.Serializable {


     private Integer idSustrato;
     private DatUsuario datUsuarioByIdUsuarioCreacion;
     private DatUsuario datUsuarioByIdUsuarioEdicion;
     private String nombreSustrato;
     private boolean status;
     private Date fechaCreacion;
     private Date fechaEdicion;
     private Set<DatLaboratorioGerminacion> datLaboratorioGerminacions = new HashSet<DatLaboratorioGerminacion>(0);

    public CatSustrato() {
    }

	
    public CatSustrato(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreSustrato, boolean status, Date fechaCreacion, Date fechaEdicion) {
        this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
        this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
        this.nombreSustrato = nombreSustrato;
        this.status = status;
        this.fechaCreacion = fechaCreacion;
        this.fechaEdicion = fechaEdicion;
    }
    public CatSustrato(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreSustrato, boolean status, Date fechaCreacion, Date fechaEdicion, Set<DatLaboratorioGerminacion> datLaboratorioGerminacions) {
       this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
       this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
       this.nombreSustrato = nombreSustrato;
       this.status = status;
       this.fechaCreacion = fechaCreacion;
       this.fechaEdicion = fechaEdicion;
       this.datLaboratorioGerminacions = datLaboratorioGerminacions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Sustrato", unique=true, nullable=false)
    public Integer getIdSustrato() {
        return this.idSustrato;
    }
    
    public void setIdSustrato(Integer idSustrato) {
        this.idSustrato = idSustrato;
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

    
    @Column(name="Nombre_Sustrato", nullable=false, length=45)
    public String getNombreSustrato() {
        return this.nombreSustrato;
    }
    
    public void setNombreSustrato(String nombreSustrato) {
        this.nombreSustrato = nombreSustrato;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="catSustrato")
    public Set<DatLaboratorioGerminacion> getDatLaboratorioGerminacions() {
        return this.datLaboratorioGerminacions;
    }
    
    public void setDatLaboratorioGerminacions(Set<DatLaboratorioGerminacion> datLaboratorioGerminacions) {
        this.datLaboratorioGerminacions = datLaboratorioGerminacions;
    }




}


