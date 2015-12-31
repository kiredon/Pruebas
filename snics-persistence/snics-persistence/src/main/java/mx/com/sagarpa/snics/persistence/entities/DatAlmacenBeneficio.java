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
 * DatAlmacenBeneficio generated by hbm2java
 */
@Entity
@Table(name="Dat_Almacen_Beneficio"
    ,catalog="sisem"
)
public class DatAlmacenBeneficio  implements java.io.Serializable {


     private Integer idAlmacen;
     private CatUnidadMedida catUnidadMedida;
     private CatColonia catColonia;
     private CatEstado catEstado;
     private DatOrganismo datOrganismo;
     private CatMunicipio catMunicipio;
     private String calle;
     private String numero;
     private int claveLada;
     private int telefono;
     private String codigoPostal;
     private String correoElectronico;
     private int capacidad;
     private boolean beneficio;

    public DatAlmacenBeneficio() {
    }

    public DatAlmacenBeneficio(CatUnidadMedida catUnidadMedida, CatColonia catColonia, CatEstado catEstado, DatOrganismo datOrganismo, CatMunicipio catMunicipio, String calle, String numero, int claveLada, int telefono, String codigoPostal, String correoElectronico, int capacidad, boolean beneficio) {
       this.catUnidadMedida = catUnidadMedida;
       this.catColonia = catColonia;
       this.catEstado = catEstado;
       this.datOrganismo = datOrganismo;
       this.catMunicipio = catMunicipio;
       this.calle = calle;
       this.numero = numero;
       this.claveLada = claveLada;
       this.telefono = telefono;
       this.codigoPostal = codigoPostal;
       this.correoElectronico = correoElectronico;
       this.capacidad = capacidad;
       this.beneficio = beneficio;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Almacen", unique=true, nullable=false)
    public Integer getIdAlmacen() {
        return this.idAlmacen;
    }
    
    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Medida", nullable=false)
    public CatUnidadMedida getCatUnidadMedida() {
        return this.catUnidadMedida;
    }
    
    public void setCatUnidadMedida(CatUnidadMedida catUnidadMedida) {
        this.catUnidadMedida = catUnidadMedida;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Colonia", nullable=false)
    public CatColonia getCatColonia() {
        return this.catColonia;
    }
    
    public void setCatColonia(CatColonia catColonia) {
        this.catColonia = catColonia;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Estado", nullable=false)
    public CatEstado getCatEstado() {
        return this.catEstado;
    }
    
    public void setCatEstado(CatEstado catEstado) {
        this.catEstado = catEstado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Organismo", nullable=false)
    public DatOrganismo getDatOrganismo() {
        return this.datOrganismo;
    }
    
    public void setDatOrganismo(DatOrganismo datOrganismo) {
        this.datOrganismo = datOrganismo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Municipio", nullable=false)
    public CatMunicipio getCatMunicipio() {
        return this.catMunicipio;
    }
    
    public void setCatMunicipio(CatMunicipio catMunicipio) {
        this.catMunicipio = catMunicipio;
    }

    
    @Column(name="Calle", nullable=false, length=45)
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }

    
    @Column(name="Numero", nullable=false, length=45)
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
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

    
    @Column(name="Codigo_Postal", nullable=false, length=10)
    public String getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    
    @Column(name="Correo_Electronico", nullable=false, length=80)
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    @Column(name="Capacidad", nullable=false)
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    @Column(name="Beneficio", nullable=false)
    public boolean isBeneficio() {
        return this.beneficio;
    }
    
    public void setBeneficio(boolean beneficio) {
        this.beneficio = beneficio;
    }




}


