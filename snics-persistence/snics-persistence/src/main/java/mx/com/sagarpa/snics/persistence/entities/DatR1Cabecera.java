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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DatR1Cabecera generated by hbm2java
 */
@Entity
@Table(name="Dat_R1_Cabecera"
    ,catalog="sisem"
)
public class DatR1Cabecera  implements java.io.Serializable {


     private Integer idR1Cabecera;
     private CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSemilla;
     private CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaOrigen;
     private CatEstado catEstado;
     private DatUsuario datUsuario;
     private DatOrganismo datOrganismoByIdProductor;
     private DatOrganismo datOrganismoByIdOrganismo;
     private CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaProduccion;
     private CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSuperficie;
     private CatModalidad catModalidad;
     private CatCicloAgricola catCicloAgricolaByIdCicloAgricolaProduccion;
     private CatCategoriaProduccion catCategoriaProduccion;
     private CatCicloAgricola catCicloAgricolaByIdCicloAgricolaOrigen;
     private CatUnidadSnics catUnidadSnics;
     private Date fechaSiembra;
     private Date fechaRecepcion;
     private int cantidadSemilla;
     private int cantidadSuperficie;
     private Integer numeroSolicitud;
     private Boolean status;
     private String coordenadas;
     private Date fechaCreacion;
     private DatR1Predio datR1Predio;
     private Set<DatR1Inspeccion> datR1Inspeccions = new HashSet<DatR1Inspeccion>(0);
     private Set<DatR1Categoria> datR1Categorias = new HashSet<DatR1Categoria>(0);
     private Set<DatR1Origen> datR1Origens = new HashSet<DatR1Origen>(0);

    public DatR1Cabecera() {
    }

	
    public DatR1Cabecera(CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSemilla, CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaOrigen, CatEstado catEstado, DatUsuario datUsuario, DatOrganismo datOrganismoByIdProductor, DatOrganismo datOrganismoByIdOrganismo, CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaProduccion, CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSuperficie, CatModalidad catModalidad, CatCicloAgricola catCicloAgricolaByIdCicloAgricolaProduccion, CatCategoriaProduccion catCategoriaProduccion, CatCicloAgricola catCicloAgricolaByIdCicloAgricolaOrigen, CatUnidadSnics catUnidadSnics, Date fechaSiembra, Date fechaRecepcion, int cantidadSemilla, int cantidadSuperficie) {
        this.catUnidadMedidaByIdUnidadMedidaSemilla = catUnidadMedidaByIdUnidadMedidaSemilla;
        this.catFechaCicloByIdFechaClicloAgricolaOrigen = catFechaCicloByIdFechaClicloAgricolaOrigen;
        this.catEstado = catEstado;
        this.datUsuario = datUsuario;
        this.datOrganismoByIdProductor = datOrganismoByIdProductor;
        this.datOrganismoByIdOrganismo = datOrganismoByIdOrganismo;
        this.catFechaCicloByIdFechaClicloAgricolaProduccion = catFechaCicloByIdFechaClicloAgricolaProduccion;
        this.catUnidadMedidaByIdUnidadMedidaSuperficie = catUnidadMedidaByIdUnidadMedidaSuperficie;
        this.catModalidad = catModalidad;
        this.catCicloAgricolaByIdCicloAgricolaProduccion = catCicloAgricolaByIdCicloAgricolaProduccion;
        this.catCategoriaProduccion = catCategoriaProduccion;
        this.catCicloAgricolaByIdCicloAgricolaOrigen = catCicloAgricolaByIdCicloAgricolaOrigen;
        this.catUnidadSnics = catUnidadSnics;
        this.fechaSiembra = fechaSiembra;
        this.fechaRecepcion = fechaRecepcion;
        this.cantidadSemilla = cantidadSemilla;
        this.cantidadSuperficie = cantidadSuperficie;
    }
    public DatR1Cabecera(CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSemilla, CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaOrigen, CatEstado catEstado, DatUsuario datUsuario, DatOrganismo datOrganismoByIdProductor, DatOrganismo datOrganismoByIdOrganismo, CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaProduccion, CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSuperficie, CatModalidad catModalidad, CatCicloAgricola catCicloAgricolaByIdCicloAgricolaProduccion, CatCategoriaProduccion catCategoriaProduccion, CatCicloAgricola catCicloAgricolaByIdCicloAgricolaOrigen, CatUnidadSnics catUnidadSnics, Date fechaSiembra, Date fechaRecepcion, int cantidadSemilla, int cantidadSuperficie, Integer numeroSolicitud, Boolean status, String coordenadas, Date fechaCreacion, DatR1Predio datR1Predio, Set<DatR1Inspeccion> datR1Inspeccions, Set<DatR1Categoria> datR1Categorias, Set<DatR1Origen> datR1Origens) {
       this.catUnidadMedidaByIdUnidadMedidaSemilla = catUnidadMedidaByIdUnidadMedidaSemilla;
       this.catFechaCicloByIdFechaClicloAgricolaOrigen = catFechaCicloByIdFechaClicloAgricolaOrigen;
       this.catEstado = catEstado;
       this.datUsuario = datUsuario;
       this.datOrganismoByIdProductor = datOrganismoByIdProductor;
       this.datOrganismoByIdOrganismo = datOrganismoByIdOrganismo;
       this.catFechaCicloByIdFechaClicloAgricolaProduccion = catFechaCicloByIdFechaClicloAgricolaProduccion;
       this.catUnidadMedidaByIdUnidadMedidaSuperficie = catUnidadMedidaByIdUnidadMedidaSuperficie;
       this.catModalidad = catModalidad;
       this.catCicloAgricolaByIdCicloAgricolaProduccion = catCicloAgricolaByIdCicloAgricolaProduccion;
       this.catCategoriaProduccion = catCategoriaProduccion;
       this.catCicloAgricolaByIdCicloAgricolaOrigen = catCicloAgricolaByIdCicloAgricolaOrigen;
       this.catUnidadSnics = catUnidadSnics;
       this.fechaSiembra = fechaSiembra;
       this.fechaRecepcion = fechaRecepcion;
       this.cantidadSemilla = cantidadSemilla;
       this.cantidadSuperficie = cantidadSuperficie;
       this.numeroSolicitud = numeroSolicitud;
       this.status = status;
       this.coordenadas = coordenadas;
       this.fechaCreacion = fechaCreacion;
       this.datR1Predio = datR1Predio;
       this.datR1Inspeccions = datR1Inspeccions;
       this.datR1Categorias = datR1Categorias;
       this.datR1Origens = datR1Origens;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_R1_Cabecera", unique=true, nullable=false)
    public Integer getIdR1Cabecera() {
        return this.idR1Cabecera;
    }
    
    public void setIdR1Cabecera(Integer idR1Cabecera) {
        this.idR1Cabecera = idR1Cabecera;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Medida_Semilla", nullable=false)
    public CatUnidadMedida getCatUnidadMedidaByIdUnidadMedidaSemilla() {
        return this.catUnidadMedidaByIdUnidadMedidaSemilla;
    }
    
    public void setCatUnidadMedidaByIdUnidadMedidaSemilla(CatUnidadMedida catUnidadMedidaByIdUnidadMedidaSemilla) {
        this.catUnidadMedidaByIdUnidadMedidaSemilla = catUnidadMedidaByIdUnidadMedidaSemilla;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Fecha_Cliclo_Agricola_Origen", nullable=false)
    public CatFechaCiclo getCatFechaCicloByIdFechaClicloAgricolaOrigen() {
        return this.catFechaCicloByIdFechaClicloAgricolaOrigen;
    }
    
    public void setCatFechaCicloByIdFechaClicloAgricolaOrigen(CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaOrigen) {
        this.catFechaCicloByIdFechaClicloAgricolaOrigen = catFechaCicloByIdFechaClicloAgricolaOrigen;
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
    @JoinColumn(name="Id_Usuario_Creacion", nullable=false)
    public DatUsuario getDatUsuario() {
        return this.datUsuario;
    }
    
    public void setDatUsuario(DatUsuario datUsuario) {
        this.datUsuario = datUsuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Productor", nullable=false)
    public DatOrganismo getDatOrganismoByIdProductor() {
        return this.datOrganismoByIdProductor;
    }
    
    public void setDatOrganismoByIdProductor(DatOrganismo datOrganismoByIdProductor) {
        this.datOrganismoByIdProductor = datOrganismoByIdProductor;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Organismo", nullable=false)
    public DatOrganismo getDatOrganismoByIdOrganismo() {
        return this.datOrganismoByIdOrganismo;
    }
    
    public void setDatOrganismoByIdOrganismo(DatOrganismo datOrganismoByIdOrganismo) {
        this.datOrganismoByIdOrganismo = datOrganismoByIdOrganismo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Fecha_Cliclo_Agricola_Produccion", nullable=false)
    public CatFechaCiclo getCatFechaCicloByIdFechaClicloAgricolaProduccion() {
        return this.catFechaCicloByIdFechaClicloAgricolaProduccion;
    }
    
    public void setCatFechaCicloByIdFechaClicloAgricolaProduccion(CatFechaCiclo catFechaCicloByIdFechaClicloAgricolaProduccion) {
        this.catFechaCicloByIdFechaClicloAgricolaProduccion = catFechaCicloByIdFechaClicloAgricolaProduccion;
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
    @JoinColumn(name="Id_Modalidad", nullable=false)
    public CatModalidad getCatModalidad() {
        return this.catModalidad;
    }
    
    public void setCatModalidad(CatModalidad catModalidad) {
        this.catModalidad = catModalidad;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Ciclo_Agricola_Produccion", nullable=false)
    public CatCicloAgricola getCatCicloAgricolaByIdCicloAgricolaProduccion() {
        return this.catCicloAgricolaByIdCicloAgricolaProduccion;
    }
    
    public void setCatCicloAgricolaByIdCicloAgricolaProduccion(CatCicloAgricola catCicloAgricolaByIdCicloAgricolaProduccion) {
        this.catCicloAgricolaByIdCicloAgricolaProduccion = catCicloAgricolaByIdCicloAgricolaProduccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Categoria_Produccion", nullable=false)
    public CatCategoriaProduccion getCatCategoriaProduccion() {
        return this.catCategoriaProduccion;
    }
    
    public void setCatCategoriaProduccion(CatCategoriaProduccion catCategoriaProduccion) {
        this.catCategoriaProduccion = catCategoriaProduccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Ciclo_Agricola_Origen", nullable=false)
    public CatCicloAgricola getCatCicloAgricolaByIdCicloAgricolaOrigen() {
        return this.catCicloAgricolaByIdCicloAgricolaOrigen;
    }
    
    public void setCatCicloAgricolaByIdCicloAgricolaOrigen(CatCicloAgricola catCicloAgricolaByIdCicloAgricolaOrigen) {
        this.catCicloAgricolaByIdCicloAgricolaOrigen = catCicloAgricolaByIdCicloAgricolaOrigen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Snics", nullable=false)
    public CatUnidadSnics getCatUnidadSnics() {
        return this.catUnidadSnics;
    }
    
    public void setCatUnidadSnics(CatUnidadSnics catUnidadSnics) {
        this.catUnidadSnics = catUnidadSnics;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Siembra", nullable=false, length=19)
    public Date getFechaSiembra() {
        return this.fechaSiembra;
    }
    
    public void setFechaSiembra(Date fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Recepcion", nullable=false, length=19)
    public Date getFechaRecepcion() {
        return this.fechaRecepcion;
    }
    
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    
    @Column(name="Cantidad_Semilla", nullable=false)
    public int getCantidadSemilla() {
        return this.cantidadSemilla;
    }
    
    public void setCantidadSemilla(int cantidadSemilla) {
        this.cantidadSemilla = cantidadSemilla;
    }

    
    @Column(name="Cantidad_Superficie", nullable=false)
    public int getCantidadSuperficie() {
        return this.cantidadSuperficie;
    }
    
    public void setCantidadSuperficie(int cantidadSuperficie) {
        this.cantidadSuperficie = cantidadSuperficie;
    }

    
    @Column(name="Numero_Solicitud")
    public Integer getNumeroSolicitud() {
        return this.numeroSolicitud;
    }
    
    public void setNumeroSolicitud(Integer numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    
    @Column(name="Status")
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    @Column(name="Coordenadas")
    public String getCoordenadas() {
        return this.coordenadas;
    }
    
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Creacion", length=19)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="datR1Cabecera")
    public DatR1Predio getDatR1Predio() {
        return this.datR1Predio;
    }
    
    public void setDatR1Predio(DatR1Predio datR1Predio) {
        this.datR1Predio = datR1Predio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datR1Cabecera")
    public Set<DatR1Inspeccion> getDatR1Inspeccions() {
        return this.datR1Inspeccions;
    }
    
    public void setDatR1Inspeccions(Set<DatR1Inspeccion> datR1Inspeccions) {
        this.datR1Inspeccions = datR1Inspeccions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datR1Cabecera")
    public Set<DatR1Categoria> getDatR1Categorias() {
        return this.datR1Categorias;
    }
    
    public void setDatR1Categorias(Set<DatR1Categoria> datR1Categorias) {
        this.datR1Categorias = datR1Categorias;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datR1Cabecera")
    public Set<DatR1Origen> getDatR1Origens() {
        return this.datR1Origens;
    }
    
    public void setDatR1Origens(Set<DatR1Origen> datR1Origens) {
        this.datR1Origens = datR1Origens;
    }




}


