package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


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

/**
 * CatCategoriaProduccion generated by hbm2java
 */
@Entity
@Table(name="Cat_Categoria_Produccion"
    ,catalog="sisem"
)
public class CatCategoriaProduccion  implements java.io.Serializable {


     private Integer idCategoriaProduccion;
     private CatCategoria catCategoriaByIdCategoriaProducir;
     private CatCategoria catCategoriaByIdCategoriaSembrar;
     private String relacion;
     private String requisito;
     private Set<DatR1Cabecera> datR1Cabeceras = new HashSet<DatR1Cabecera>(0);
     private Set<DatR1Categoria> datR1Categorias = new HashSet<DatR1Categoria>(0);

    public CatCategoriaProduccion() {
    }

	
    public CatCategoriaProduccion(CatCategoria catCategoriaByIdCategoriaProducir, CatCategoria catCategoriaByIdCategoriaSembrar) {
        this.catCategoriaByIdCategoriaProducir = catCategoriaByIdCategoriaProducir;
        this.catCategoriaByIdCategoriaSembrar = catCategoriaByIdCategoriaSembrar;
    }
    public CatCategoriaProduccion(CatCategoria catCategoriaByIdCategoriaProducir, CatCategoria catCategoriaByIdCategoriaSembrar, String relacion, String requisito, Set<DatR1Cabecera> datR1Cabeceras, Set<DatR1Categoria> datR1Categorias) {
       this.catCategoriaByIdCategoriaProducir = catCategoriaByIdCategoriaProducir;
       this.catCategoriaByIdCategoriaSembrar = catCategoriaByIdCategoriaSembrar;
       this.relacion = relacion;
       this.requisito = requisito;
       this.datR1Cabeceras = datR1Cabeceras;
       this.datR1Categorias = datR1Categorias;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Categoria_Produccion", unique=true, nullable=false)
    public Integer getIdCategoriaProduccion() {
        return this.idCategoriaProduccion;
    }
    
    public void setIdCategoriaProduccion(Integer idCategoriaProduccion) {
        this.idCategoriaProduccion = idCategoriaProduccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Categoria_Producir", nullable=false)
    public CatCategoria getCatCategoriaByIdCategoriaProducir() {
        return this.catCategoriaByIdCategoriaProducir;
    }
    
    public void setCatCategoriaByIdCategoriaProducir(CatCategoria catCategoriaByIdCategoriaProducir) {
        this.catCategoriaByIdCategoriaProducir = catCategoriaByIdCategoriaProducir;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Categoria_Sembrar", nullable=false)
    public CatCategoria getCatCategoriaByIdCategoriaSembrar() {
        return this.catCategoriaByIdCategoriaSembrar;
    }
    
    public void setCatCategoriaByIdCategoriaSembrar(CatCategoria catCategoriaByIdCategoriaSembrar) {
        this.catCategoriaByIdCategoriaSembrar = catCategoriaByIdCategoriaSembrar;
    }

    
    @Column(name="Relacion", length=45)
    public String getRelacion() {
        return this.relacion;
    }
    
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    
    @Column(name="Requisito", length=45)
    public String getRequisito() {
        return this.requisito;
    }
    
    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoriaProduccion")
    public Set<DatR1Cabecera> getDatR1Cabeceras() {
        return this.datR1Cabeceras;
    }
    
    public void setDatR1Cabeceras(Set<DatR1Cabecera> datR1Cabeceras) {
        this.datR1Cabeceras = datR1Cabeceras;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catCategoriaProduccion")
    public Set<DatR1Categoria> getDatR1Categorias() {
        return this.datR1Categorias;
    }
    
    public void setDatR1Categorias(Set<DatR1Categoria> datR1Categorias) {
        this.datR1Categorias = datR1Categorias;
    }




}


