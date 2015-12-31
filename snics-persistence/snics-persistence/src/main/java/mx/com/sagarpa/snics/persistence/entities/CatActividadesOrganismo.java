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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CatActividadesOrganismo generated by hbm2java
 */
@Entity
@Table(name="Cat_Actividades_Organismo"
    ,catalog="sisem"
)
public class CatActividadesOrganismo  implements java.io.Serializable {


     private Integer idActividadesOrganismo;
     private DatUsuario datUsuarioByIdUsuarioCreacion;
     private DatUsuario datUsuarioByIdUsuarioEdicion;
     private String nombreActividadesOrganismo;
     private boolean status;
     private Date fechaCreacion;
     private Date fechaEdicion;
     private Set<DatOrganismo> datOrganismos = new HashSet<DatOrganismo>(0);

    public CatActividadesOrganismo() {
    }

	
    public CatActividadesOrganismo(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreActividadesOrganismo, boolean status, Date fechaCreacion, Date fechaEdicion) {
        this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
        this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
        this.nombreActividadesOrganismo = nombreActividadesOrganismo;
        this.status = status;
        this.fechaCreacion = fechaCreacion;
        this.fechaEdicion = fechaEdicion;
    }
    public CatActividadesOrganismo(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreActividadesOrganismo, boolean status, Date fechaCreacion, Date fechaEdicion, Set<DatOrganismo> datOrganismos) {
       this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
       this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
       this.nombreActividadesOrganismo = nombreActividadesOrganismo;
       this.status = status;
       this.fechaCreacion = fechaCreacion;
       this.fechaEdicion = fechaEdicion;
       this.datOrganismos = datOrganismos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Actividades_Organismo", unique=true, nullable=false)
    public Integer getIdActividadesOrganismo() {
        return this.idActividadesOrganismo;
    }
    
    public void setIdActividadesOrganismo(Integer idActividadesOrganismo) {
        this.idActividadesOrganismo = idActividadesOrganismo;
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

    
    @Column(name="Nombre_Actividades_Organismo", nullable=false, length=45)
    public String getNombreActividadesOrganismo() {
        return this.nombreActividadesOrganismo;
    }
    
    public void setNombreActividadesOrganismo(String nombreActividadesOrganismo) {
        this.nombreActividadesOrganismo = nombreActividadesOrganismo;
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

@ManyToMany(fetch=FetchType.LAZY, mappedBy="catActividadesOrganismos")
    public Set<DatOrganismo> getDatOrganismos() {
        return this.datOrganismos;
    }
    
    public void setDatOrganismos(Set<DatOrganismo> datOrganismos) {
        this.datOrganismos = datOrganismos;
    }




}

