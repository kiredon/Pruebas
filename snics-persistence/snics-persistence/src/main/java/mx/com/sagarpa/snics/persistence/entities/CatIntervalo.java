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
 * CatIntervalo generated by hbm2java
 */
@Entity
@Table(name="Cat_Intervalo"
    ,catalog="sisem"
)
public class CatIntervalo  implements java.io.Serializable {


     private Integer idIntervalo;
     private CatTipoIntervalo catTipoIntervalo;
     private Integer nombreIntervalo;
     private String catIntervalocol;
     private Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForIdIntervalo08 = new HashSet<DatLaboratorioGerminacion>(0);
     private Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForIdIntervalo16 = new HashSet<DatLaboratorioGerminacion>(0);
     private Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForCatIntervaloConstante = new HashSet<DatLaboratorioGerminacion>(0);

    public CatIntervalo() {
    }

	
    public CatIntervalo(CatTipoIntervalo catTipoIntervalo) {
        this.catTipoIntervalo = catTipoIntervalo;
    }
    public CatIntervalo(CatTipoIntervalo catTipoIntervalo, Integer nombreIntervalo, String catIntervalocol, Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForIdIntervalo08, Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForIdIntervalo16, Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForCatIntervaloConstante) {
       this.catTipoIntervalo = catTipoIntervalo;
       this.nombreIntervalo = nombreIntervalo;
       this.catIntervalocol = catIntervalocol;
       this.datLaboratorioGerminacionsForIdIntervalo08 = datLaboratorioGerminacionsForIdIntervalo08;
       this.datLaboratorioGerminacionsForIdIntervalo16 = datLaboratorioGerminacionsForIdIntervalo16;
       this.datLaboratorioGerminacionsForCatIntervaloConstante = datLaboratorioGerminacionsForCatIntervaloConstante;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Intervalo", unique=true, nullable=false)
    public Integer getIdIntervalo() {
        return this.idIntervalo;
    }
    
    public void setIdIntervalo(Integer idIntervalo) {
        this.idIntervalo = idIntervalo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Tipo_Intervalo", nullable=false)
    public CatTipoIntervalo getCatTipoIntervalo() {
        return this.catTipoIntervalo;
    }
    
    public void setCatTipoIntervalo(CatTipoIntervalo catTipoIntervalo) {
        this.catTipoIntervalo = catTipoIntervalo;
    }

    
    @Column(name="Nombre_Intervalo")
    public Integer getNombreIntervalo() {
        return this.nombreIntervalo;
    }
    
    public void setNombreIntervalo(Integer nombreIntervalo) {
        this.nombreIntervalo = nombreIntervalo;
    }

    
    @Column(name="Cat_Intervalocol", length=45)
    public String getCatIntervalocol() {
        return this.catIntervalocol;
    }
    
    public void setCatIntervalocol(String catIntervalocol) {
        this.catIntervalocol = catIntervalocol;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catIntervaloByIdIntervalo08")
    public Set<DatLaboratorioGerminacion> getDatLaboratorioGerminacionsForIdIntervalo08() {
        return this.datLaboratorioGerminacionsForIdIntervalo08;
    }
    
    public void setDatLaboratorioGerminacionsForIdIntervalo08(Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForIdIntervalo08) {
        this.datLaboratorioGerminacionsForIdIntervalo08 = datLaboratorioGerminacionsForIdIntervalo08;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catIntervaloByIdIntervalo16")
    public Set<DatLaboratorioGerminacion> getDatLaboratorioGerminacionsForIdIntervalo16() {
        return this.datLaboratorioGerminacionsForIdIntervalo16;
    }
    
    public void setDatLaboratorioGerminacionsForIdIntervalo16(Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForIdIntervalo16) {
        this.datLaboratorioGerminacionsForIdIntervalo16 = datLaboratorioGerminacionsForIdIntervalo16;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catIntervaloByCatIntervaloConstante")
    public Set<DatLaboratorioGerminacion> getDatLaboratorioGerminacionsForCatIntervaloConstante() {
        return this.datLaboratorioGerminacionsForCatIntervaloConstante;
    }
    
    public void setDatLaboratorioGerminacionsForCatIntervaloConstante(Set<DatLaboratorioGerminacion> datLaboratorioGerminacionsForCatIntervaloConstante) {
        this.datLaboratorioGerminacionsForCatIntervaloConstante = datLaboratorioGerminacionsForCatIntervaloConstante;
    }




}


