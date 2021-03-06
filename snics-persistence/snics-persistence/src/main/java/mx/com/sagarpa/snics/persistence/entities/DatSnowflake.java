package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DatSnowflake generated by hbm2java
 */
@Entity
@Table(name="Dat_Snowflake"
    ,catalog="sisem"
)
public class DatSnowflake  implements java.io.Serializable {


     private Integer idSnowflake;
     private DatUsuario datUsuario;
     private String snowflake;
     private Date fechaCreacion;
     private Date fechaCaducidad;
     private String origen;
     private String userAgent;

    public DatSnowflake() {
    }

    public DatSnowflake(DatUsuario datUsuario, String snowflake, Date fechaCreacion, Date fechaCaducidad, String origen, String userAgent) {
       this.datUsuario = datUsuario;
       this.snowflake = snowflake;
       this.fechaCreacion = fechaCreacion;
       this.fechaCaducidad = fechaCaducidad;
       this.origen = origen;
       this.userAgent = userAgent;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Snowflake", unique=true, nullable=false)
    public Integer getIdSnowflake() {
        return this.idSnowflake;
    }
    
    public void setIdSnowflake(Integer idSnowflake) {
        this.idSnowflake = idSnowflake;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Usuario", nullable=false)
    public DatUsuario getDatUsuario() {
        return this.datUsuario;
    }
    
    public void setDatUsuario(DatUsuario datUsuario) {
        this.datUsuario = datUsuario;
    }

    
    @Column(name="Snowflake", nullable=false, length=500)
    public String getSnowflake() {
        return this.snowflake;
    }
    
    public void setSnowflake(String snowflake) {
        this.snowflake = snowflake;
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
    @Column(name="Fecha_Caducidad", nullable=false, length=19)
    public Date getFechaCaducidad() {
        return this.fechaCaducidad;
    }
    
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    
    @Column(name="Origen", nullable=false, length=20)
    public String getOrigen() {
        return this.origen;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    
    @Column(name="User_Agent", nullable=false, length=200)
    public String getUserAgent() {
        return this.userAgent;
    }
    
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }




}


