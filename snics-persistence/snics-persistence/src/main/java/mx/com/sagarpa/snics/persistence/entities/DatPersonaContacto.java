package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DatPersonaContacto generated by hbm2java
 */
@Entity
@Table(name="Dat_Persona_Contacto"
    ,catalog="sisem"
)
public class DatPersonaContacto  implements java.io.Serializable {


     private Integer idPersonaContacto;
     private DatOrganismo datOrganismo;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private int claveLada;
     private int telefono;
     private String correoElectronico;

    public DatPersonaContacto() {
    }

	
    public DatPersonaContacto(DatOrganismo datOrganismo, String nombre, String apellidoPaterno, String apellidoMaterno, int claveLada, int telefono) {
        this.datOrganismo = datOrganismo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.claveLada = claveLada;
        this.telefono = telefono;
    }
    public DatPersonaContacto(DatOrganismo datOrganismo, String nombre, String apellidoPaterno, String apellidoMaterno, int claveLada, int telefono, String correoElectronico) {
       this.datOrganismo = datOrganismo;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.claveLada = claveLada;
       this.telefono = telefono;
       this.correoElectronico = correoElectronico;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Persona_Contacto", unique=true, nullable=false)
    public Integer getIdPersonaContacto() {
        return this.idPersonaContacto;
    }
    
    public void setIdPersonaContacto(Integer idPersonaContacto) {
        this.idPersonaContacto = idPersonaContacto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Organismo", nullable=false)
    public DatOrganismo getDatOrganismo() {
        return this.datOrganismo;
    }
    
    public void setDatOrganismo(DatOrganismo datOrganismo) {
        this.datOrganismo = datOrganismo;
    }

    
    @Column(name="Nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="Apellido Paterno", nullable=false, length=45)
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    
    @Column(name="Apellido Materno", nullable=false, length=45)
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    
    @Column(name="Clave_Lada", nullable=false)
    public int getClaveLada() {
        return this.claveLada;
    }
    
    public void setClaveLada(int claveLada) {
        this.claveLada = claveLada;
    }

    
    @Column(name="Telefono", nullable=false)
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="Correo_Electronico", length=45)
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }




}

