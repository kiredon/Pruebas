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
 * DatR1Inspeccion generated by hbm2java
 */
@Entity
@Table(name="Dat_R1_Inspeccion"
    ,catalog="sisem"
)
public class DatR1Inspeccion  implements java.io.Serializable {


     private Integer idR1Inspeccion;
     private CatTipoPlanta catTipoPlanta;
     private CatCondicionCultivo catCondicionCultivo;
     private CatEtapaCultivo catEtapaCultivo;
     private CatResultadoInspeccion catResultadoInspeccion;
     private DatR1Cabecera datR1Cabecera;
     private DatUsuario datUsuario;
     private CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSuperficie;
     private CatUnidadMedida catUnidadMedidaByIdUnidadMedidaMateriaPrima;
     private Date fechaInspeccion;
     private String cantidadSuperficieInspeccionada;
     private Integer superficieRestante;
     private Integer plantasHectarea;
     private String recomendacionesR2;
     private Boolean statusCerrada;
     private Boolean tipoInspeccionCampo;
     private Integer cantMateriaPrima;
     private Integer numeroInspeccion;
     private Set<DatR3Cabecera> datR3Cabeceras = new HashSet<DatR3Cabecera>(0);
     private Set<DatR5Origen> datR5Origens = new HashSet<DatR5Origen>(0);
     private Set<DatR4Cabecera> datR4Cabeceras = new HashSet<DatR4Cabecera>(0);

    public DatR1Inspeccion() {
    }

	
    public DatR1Inspeccion(CatTipoPlanta catTipoPlanta, CatCondicionCultivo catCondicionCultivo, CatEtapaCultivo catEtapaCultivo, CatResultadoInspeccion catResultadoInspeccion, DatR1Cabecera datR1Cabecera, DatUsuario datUsuario, CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSuperficie, CatUnidadMedida catUnidadMedidaByIdUnidadMedidaMateriaPrima) {
        this.catTipoPlanta = catTipoPlanta;
        this.catCondicionCultivo = catCondicionCultivo;
        this.catEtapaCultivo = catEtapaCultivo;
        this.catResultadoInspeccion = catResultadoInspeccion;
        this.datR1Cabecera = datR1Cabecera;
        this.datUsuario = datUsuario;
        this.catUnidadMedidaByIdUnidadMedidaSuperficie = catUnidadMedidaByIdUnidadMedidaSuperficie;
        this.catUnidadMedidaByIdUnidadMedidaMateriaPrima = catUnidadMedidaByIdUnidadMedidaMateriaPrima;
    }
    public DatR1Inspeccion(CatTipoPlanta catTipoPlanta, CatCondicionCultivo catCondicionCultivo, CatEtapaCultivo catEtapaCultivo, CatResultadoInspeccion catResultadoInspeccion, DatR1Cabecera datR1Cabecera, DatUsuario datUsuario, CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSuperficie, CatUnidadMedida catUnidadMedidaByIdUnidadMedidaMateriaPrima, Date fechaInspeccion, String cantidadSuperficieInspeccionada, Integer superficieRestante, Integer plantasHectarea, String recomendacionesR2, Boolean statusCerrada, Boolean tipoInspeccionCampo, Integer cantMateriaPrima, Integer numeroInspeccion, Set<DatR3Cabecera> datR3Cabeceras, Set<DatR5Origen> datR5Origens, Set<DatR4Cabecera> datR4Cabeceras) {
       this.catTipoPlanta = catTipoPlanta;
       this.catCondicionCultivo = catCondicionCultivo;
       this.catEtapaCultivo = catEtapaCultivo;
       this.catResultadoInspeccion = catResultadoInspeccion;
       this.datR1Cabecera = datR1Cabecera;
       this.datUsuario = datUsuario;
       this.catUnidadMedidaByIdUnidadMedidaSuperficie = catUnidadMedidaByIdUnidadMedidaSuperficie;
       this.catUnidadMedidaByIdUnidadMedidaMateriaPrima = catUnidadMedidaByIdUnidadMedidaMateriaPrima;
       this.fechaInspeccion = fechaInspeccion;
       this.cantidadSuperficieInspeccionada = cantidadSuperficieInspeccionada;
       this.superficieRestante = superficieRestante;
       this.plantasHectarea = plantasHectarea;
       this.recomendacionesR2 = recomendacionesR2;
       this.statusCerrada = statusCerrada;
       this.tipoInspeccionCampo = tipoInspeccionCampo;
       this.cantMateriaPrima = cantMateriaPrima;
       this.numeroInspeccion = numeroInspeccion;
       this.datR3Cabeceras = datR3Cabeceras;
       this.datR5Origens = datR5Origens;
       this.datR4Cabeceras = datR4Cabeceras;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_R1_Inspeccion", unique=true, nullable=false)
    public Integer getIdR1Inspeccion() {
        return this.idR1Inspeccion;
    }
    
    public void setIdR1Inspeccion(Integer idR1Inspeccion) {
        this.idR1Inspeccion = idR1Inspeccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Tipo_Planta", nullable=false)
    public CatTipoPlanta getCatTipoPlanta() {
        return this.catTipoPlanta;
    }
    
    public void setCatTipoPlanta(CatTipoPlanta catTipoPlanta) {
        this.catTipoPlanta = catTipoPlanta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Condicion_Cultivo", nullable=false)
    public CatCondicionCultivo getCatCondicionCultivo() {
        return this.catCondicionCultivo;
    }
    
    public void setCatCondicionCultivo(CatCondicionCultivo catCondicionCultivo) {
        this.catCondicionCultivo = catCondicionCultivo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Etapa_Cultivo", nullable=false)
    public CatEtapaCultivo getCatEtapaCultivo() {
        return this.catEtapaCultivo;
    }
    
    public void setCatEtapaCultivo(CatEtapaCultivo catEtapaCultivo) {
        this.catEtapaCultivo = catEtapaCultivo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Resultado_Inspeccion", nullable=false)
    public CatResultadoInspeccion getCatResultadoInspeccion() {
        return this.catResultadoInspeccion;
    }
    
    public void setCatResultadoInspeccion(CatResultadoInspeccion catResultadoInspeccion) {
        this.catResultadoInspeccion = catResultadoInspeccion;
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
    @JoinColumn(name="Id_Usuario_Inspector", nullable=false)
    public DatUsuario getDatUsuario() {
        return this.datUsuario;
    }
    
    public void setDatUsuario(DatUsuario datUsuario) {
        this.datUsuario = datUsuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Medida_Superficie", nullable=false)
    public CatUnidadMedida getCatUnidadMedidaByIdUnidadMedidaSuperficie() {
        return this.catUnidadMedidaByIdUnidadMedidaSuperficie;
    }
    
    public void setCatUnidadMedidaByIdUnidadMedidaSuperficie(CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSuperficie) {
        this.catUnidadMedidaByIdUnidadMedidaSuperficie = catUnidadMedidaByIdUnidadMedidaSuperficie;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Medida_Materia_Prima", nullable=false)
    public CatUnidadMedida getCatUnidadMedidaByIdUnidadMedidaMateriaPrima() {
        return this.catUnidadMedidaByIdUnidadMedidaMateriaPrima;
    }
    
    public void setCatUnidadMedidaByIdUnidadMedidaMateriaPrima(CatUnidadMedida catUnidadMedidaByIdUnidadMedidaMateriaPrima) {
        this.catUnidadMedidaByIdUnidadMedidaMateriaPrima = catUnidadMedidaByIdUnidadMedidaMateriaPrima;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Inspeccion", length=19)
    public Date getFechaInspeccion() {
        return this.fechaInspeccion;
    }
    
    public void setFechaInspeccion(Date fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
    }

    
    @Column(name="Cantidad_Superficie_Inspeccionada", length=45)
    public String getCantidadSuperficieInspeccionada() {
        return this.cantidadSuperficieInspeccionada;
    }
    
    public void setCantidadSuperficieInspeccionada(String cantidadSuperficieInspeccionada) {
        this.cantidadSuperficieInspeccionada = cantidadSuperficieInspeccionada;
    }

    
    @Column(name="Superficie_Restante")
    public Integer getSuperficieRestante() {
        return this.superficieRestante;
    }
    
    public void setSuperficieRestante(Integer superficieRestante) {
        this.superficieRestante = superficieRestante;
    }

    
    @Column(name="Plantas_Hectarea")
    public Integer getPlantasHectarea() {
        return this.plantasHectarea;
    }
    
    public void setPlantasHectarea(Integer plantasHectarea) {
        this.plantasHectarea = plantasHectarea;
    }

    
    @Column(name="Recomendaciones_R2", length=350)
    public String getRecomendacionesR2() {
        return this.recomendacionesR2;
    }
    
    public void setRecomendacionesR2(String recomendacionesR2) {
        this.recomendacionesR2 = recomendacionesR2;
    }

    
    @Column(name="Status_Cerrada")
    public Boolean getStatusCerrada() {
        return this.statusCerrada;
    }
    
    public void setStatusCerrada(Boolean statusCerrada) {
        this.statusCerrada = statusCerrada;
    }

    
    @Column(name="Tipo_Inspeccion_Campo")
    public Boolean getTipoInspeccionCampo() {
        return this.tipoInspeccionCampo;
    }
    
    public void setTipoInspeccionCampo(Boolean tipoInspeccionCampo) {
        this.tipoInspeccionCampo = tipoInspeccionCampo;
    }

    
    @Column(name="Cant_Materia_Prima")
    public Integer getCantMateriaPrima() {
        return this.cantMateriaPrima;
    }
    
    public void setCantMateriaPrima(Integer cantMateriaPrima) {
        this.cantMateriaPrima = cantMateriaPrima;
    }

    
    @Column(name="Numero_Inspeccion")
    public Integer getNumeroInspeccion() {
        return this.numeroInspeccion;
    }
    
    public void setNumeroInspeccion(Integer numeroInspeccion) {
        this.numeroInspeccion = numeroInspeccion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datR1Inspeccion")
    public Set<DatR3Cabecera> getDatR3Cabeceras() {
        return this.datR3Cabeceras;
    }
    
    public void setDatR3Cabeceras(Set<DatR3Cabecera> datR3Cabeceras) {
        this.datR3Cabeceras = datR3Cabeceras;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datR1Inspeccion")
    public Set<DatR5Origen> getDatR5Origens() {
        return this.datR5Origens;
    }
    
    public void setDatR5Origens(Set<DatR5Origen> datR5Origens) {
        this.datR5Origens = datR5Origens;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datR1Inspeccion")
    public Set<DatR4Cabecera> getDatR4Cabeceras() {
        return this.datR4Cabeceras;
    }
    
    public void setDatR4Cabeceras(Set<DatR4Cabecera> datR4Cabeceras) {
        this.datR4Cabeceras = datR4Cabeceras;
    }




}


