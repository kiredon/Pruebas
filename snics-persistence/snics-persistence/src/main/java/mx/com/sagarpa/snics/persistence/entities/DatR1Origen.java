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
 * DatR1Origen generated by hbm2java
 */
@Entity
@Table(name="Dat_R1_Origen"
    ,catalog="sisem"
)
public class DatR1Origen  implements java.io.Serializable {


     private Integer idR1Origen;
     private CatEstado catEstado;
     private DatR1Cabecera datR1Cabecera;
     private CatOrigen catOrigen;
     private CatCategoria catCategoria;
     private CatUnidadSnics catUnidadSnics;
     private String serie;
     private Integer folioInicio;
     private Integer folioFin;
     private Integer foliosSeleccionados;
     private Integer numeroMovilizacion;
     private Date fechaEmision;

    public DatR1Origen() {
    }

	
    public DatR1Origen(DatR1Cabecera datR1Cabecera, CatOrigen catOrigen, String serie) {
        this.datR1Cabecera = datR1Cabecera;
        this.catOrigen = catOrigen;
        this.serie = serie;
    }
    public DatR1Origen(CatEstado catEstado, DatR1Cabecera datR1Cabecera, CatOrigen catOrigen, CatCategoria catCategoria, CatUnidadSnics catUnidadSnics, String serie, Integer folioInicio, Integer folioFin, Integer foliosSeleccionados, Integer numeroMovilizacion, Date fechaEmision) {
       this.catEstado = catEstado;
       this.datR1Cabecera = datR1Cabecera;
       this.catOrigen = catOrigen;
       this.catCategoria = catCategoria;
       this.catUnidadSnics = catUnidadSnics;
       this.serie = serie;
       this.folioInicio = folioInicio;
       this.folioFin = folioFin;
       this.foliosSeleccionados = foliosSeleccionados;
       this.numeroMovilizacion = numeroMovilizacion;
       this.fechaEmision = fechaEmision;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_R1_Origen", unique=true, nullable=false)
    public Integer getIdR1Origen() {
        return this.idR1Origen;
    }
    
    public void setIdR1Origen(Integer idR1Origen) {
        this.idR1Origen = idR1Origen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Estado")
    public CatEstado getCatEstado() {
        return this.catEstado;
    }
    
    public void setCatEstado(CatEstado catEstado) {
        this.catEstado = catEstado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R1_Cabecera", nullable=false)
    public DatR1Cabecera getDatR1Cabecera() {
        return this.datR1Cabecera;
    }
    
    public void setDatR1Cabecera(DatR1Cabecera datR1Cabecera) {
        this.datR1Cabecera = datR1Cabecera;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Origen", nullable=false)
    public CatOrigen getCatOrigen() {
        return this.catOrigen;
    }
    
    public void setCatOrigen(CatOrigen catOrigen) {
        this.catOrigen = catOrigen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Categoria")
    public CatCategoria getCatCategoria() {
        return this.catCategoria;
    }
    
    public void setCatCategoria(CatCategoria catCategoria) {
        this.catCategoria = catCategoria;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Snics")
    public CatUnidadSnics getCatUnidadSnics() {
        return this.catUnidadSnics;
    }
    
    public void setCatUnidadSnics(CatUnidadSnics catUnidadSnics) {
        this.catUnidadSnics = catUnidadSnics;
    }

    
    @Column(name="Serie", nullable=false, length=45)
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }

    
    @Column(name="Folio_Inicio")
    public Integer getFolioInicio() {
        return this.folioInicio;
    }
    
    public void setFolioInicio(Integer folioInicio) {
        this.folioInicio = folioInicio;
    }

    
    @Column(name="Folio_Fin")
    public Integer getFolioFin() {
        return this.folioFin;
    }
    
    public void setFolioFin(Integer folioFin) {
        this.folioFin = folioFin;
    }

    
    @Column(name="Folios_Seleccionados")
    public Integer getFoliosSeleccionados() {
        return this.foliosSeleccionados;
    }
    
    public void setFoliosSeleccionados(Integer foliosSeleccionados) {
        this.foliosSeleccionados = foliosSeleccionados;
    }

    
    @Column(name="Numero_Movilizacion")
    public Integer getNumeroMovilizacion() {
        return this.numeroMovilizacion;
    }
    
    public void setNumeroMovilizacion(Integer numeroMovilizacion) {
        this.numeroMovilizacion = numeroMovilizacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Emision", length=19)
    public Date getFechaEmision() {
        return this.fechaEmision;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }




}


