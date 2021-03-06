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
 * CatCategoria generated by hbm2java
 */
@Entity
@Table(name="Cat_Categoria"
    ,catalog="sisem"
)
public class CatCategoria  implements java.io.Serializable {


     private Integer idCategoria;
     private DatUsuario datUsuarioByIdUsuarioCreacion;
     private DatUsuario datUsuarioByIdUsuarioEdicion;
     private String nombreCategoria;
     private boolean status;
     private Date fechaCreacion;
     private Date fechaEdicion;
     private Set<CatCategoriaProduccion> catCategoriaProduccionsForIdCategoriaProducir = new HashSet<CatCategoriaProduccion>(0);
     private Set<DatR7Inspeccion> datR7Inspeccions = new HashSet<DatR7Inspeccion>(0);
     private Set<CatCategoriaProduccion> catCategoriaProduccionsForIdCategoriaSembrar = new HashSet<CatCategoriaProduccion>(0);
     private Set<DatR4Cabecera> datR4Cabeceras = new HashSet<DatR4Cabecera>(0);
     private Set<LinkOrganismoCultivo> linkOrganismoCultivos = new HashSet<LinkOrganismoCultivo>(0);
     private Set<DatR5Detalle> datR5Detalles = new HashSet<DatR5Detalle>(0);
     private Set<DatExistenciasEtiquetas> datExistenciasEtiquetases = new HashSet<DatExistenciasEtiquetas>(0);
     private Set<DatR1Origen> datR1Origens = new HashSet<DatR1Origen>(0);
     private Set<DatMovimientoEtiquetas> datMovimientoEtiquetases = new HashSet<DatMovimientoEtiquetas>(0);

    public CatCategoria() {
    }

	
    public CatCategoria(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreCategoria, boolean status, Date fechaCreacion, Date fechaEdicion) {
        this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
        this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
        this.nombreCategoria = nombreCategoria;
        this.status = status;
        this.fechaCreacion = fechaCreacion;
        this.fechaEdicion = fechaEdicion;
    }
    public CatCategoria(DatUsuario datUsuarioByIdUsuarioCreacion, DatUsuario datUsuarioByIdUsuarioEdicion, String nombreCategoria, boolean status, Date fechaCreacion, Date fechaEdicion, Set<CatCategoriaProduccion> catCategoriaProduccionsForIdCategoriaProducir, Set<DatR7Inspeccion> datR7Inspeccions, Set<CatCategoriaProduccion> catCategoriaProduccionsForIdCategoriaSembrar, Set<DatR4Cabecera> datR4Cabeceras, Set<LinkOrganismoCultivo> linkOrganismoCultivos, Set<DatR5Detalle> datR5Detalles, Set<DatExistenciasEtiquetas> datExistenciasEtiquetases, Set<DatR1Origen> datR1Origens, Set<DatMovimientoEtiquetas> datMovimientoEtiquetases) {
       this.datUsuarioByIdUsuarioCreacion = datUsuarioByIdUsuarioCreacion;
       this.datUsuarioByIdUsuarioEdicion = datUsuarioByIdUsuarioEdicion;
       this.nombreCategoria = nombreCategoria;
       this.status = status;
       this.fechaCreacion = fechaCreacion;
       this.fechaEdicion = fechaEdicion;
       this.catCategoriaProduccionsForIdCategoriaProducir = catCategoriaProduccionsForIdCategoriaProducir;
       this.datR7Inspeccions = datR7Inspeccions;
       this.catCategoriaProduccionsForIdCategoriaSembrar = catCategoriaProduccionsForIdCategoriaSembrar;
       this.datR4Cabeceras = datR4Cabeceras;
       this.linkOrganismoCultivos = linkOrganismoCultivos;
       this.datR5Detalles = datR5Detalles;
       this.datExistenciasEtiquetases = datExistenciasEtiquetases;
       this.datR1Origens = datR1Origens;
       this.datMovimientoEtiquetases = datMovimientoEtiquetases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Categoria", unique=true, nullable=false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    
    @Column(name="Nombre_Categoria", nullable=false, length=45)
    public String getNombreCategoria() {
        return this.nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoriaByIdCategoriaProducir")
    public Set<CatCategoriaProduccion> getCatCategoriaProduccionsForIdCategoriaProducir() {
        return this.catCategoriaProduccionsForIdCategoriaProducir;
    }
    
    public void setCatCategoriaProduccionsForIdCategoriaProducir(Set<CatCategoriaProduccion> catCategoriaProduccionsForIdCategoriaProducir) {
        this.catCategoriaProduccionsForIdCategoriaProducir = catCategoriaProduccionsForIdCategoriaProducir;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoria")
    public Set<DatR7Inspeccion> getDatR7Inspeccions() {
        return this.datR7Inspeccions;
    }
    
    public void setDatR7Inspeccions(Set<DatR7Inspeccion> datR7Inspeccions) {
        this.datR7Inspeccions = datR7Inspeccions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoriaByIdCategoriaSembrar")
    public Set<CatCategoriaProduccion> getCatCategoriaProduccionsForIdCategoriaSembrar() {
        return this.catCategoriaProduccionsForIdCategoriaSembrar;
    }
    
    public void setCatCategoriaProduccionsForIdCategoriaSembrar(Set<CatCategoriaProduccion> catCategoriaProduccionsForIdCategoriaSembrar) {
        this.catCategoriaProduccionsForIdCategoriaSembrar = catCategoriaProduccionsForIdCategoriaSembrar;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoria")
    public Set<DatR4Cabecera> getDatR4Cabeceras() {
        return this.datR4Cabeceras;
    }
    
    public void setDatR4Cabeceras(Set<DatR4Cabecera> datR4Cabeceras) {
        this.datR4Cabeceras = datR4Cabeceras;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoria")
    public Set<LinkOrganismoCultivo> getLinkOrganismoCultivos() {
        return this.linkOrganismoCultivos;
    }
    
    public void setLinkOrganismoCultivos(Set<LinkOrganismoCultivo> linkOrganismoCultivos) {
        this.linkOrganismoCultivos = linkOrganismoCultivos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoria")
    public Set<DatR5Detalle> getDatR5Detalles() {
        return this.datR5Detalles;
    }
    
    public void setDatR5Detalles(Set<DatR5Detalle> datR5Detalles) {
        this.datR5Detalles = datR5Detalles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoria")
    public Set<DatExistenciasEtiquetas> getDatExistenciasEtiquetases() {
        return this.datExistenciasEtiquetases;
    }
    
    public void setDatExistenciasEtiquetases(Set<DatExistenciasEtiquetas> datExistenciasEtiquetases) {
        this.datExistenciasEtiquetases = datExistenciasEtiquetases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoria")
    public Set<DatR1Origen> getDatR1Origens() {
        return this.datR1Origens;
    }
    
    public void setDatR1Origens(Set<DatR1Origen> datR1Origens) {
        this.datR1Origens = datR1Origens;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoria")
    public Set<DatMovimientoEtiquetas> getDatMovimientoEtiquetases() {
        return this.datMovimientoEtiquetases;
    }
    
    public void setDatMovimientoEtiquetases(Set<DatMovimientoEtiquetas> datMovimientoEtiquetases) {
        this.datMovimientoEtiquetases = datMovimientoEtiquetases;
    }




}


