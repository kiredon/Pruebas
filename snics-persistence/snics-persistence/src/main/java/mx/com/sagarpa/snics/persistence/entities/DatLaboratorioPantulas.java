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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DatLaboratorioPantulas generated by hbm2java
 */
@Entity
@Table(name="Dat_Laboratorio_Pantulas"
    ,catalog="sisem"
)
public class DatLaboratorioPantulas  implements java.io.Serializable {


     private Integer idLaboratorioPantulas;
     private Integer normalA;
     private Integer normalB;
     private Integer normalC;
     private Integer normalD;
     private Integer normalPromedio;
     private Integer anormalCantidad;
     private Integer semillasDuras;
     private Integer semillasMuertas;
     private Integer semillasFrescas;
     private Set<DatLaboratorioCabecera> datLaboratorioCabeceras = new HashSet<DatLaboratorioCabecera>(0);

    public DatLaboratorioPantulas() {
    }

    public DatLaboratorioPantulas(Integer normalA, Integer normalB, Integer normalC, Integer normalD, Integer normalPromedio, Integer anormalCantidad, Integer semillasDuras, Integer semillasMuertas, Integer semillasFrescas, Set<DatLaboratorioCabecera> datLaboratorioCabeceras) {
       this.normalA = normalA;
       this.normalB = normalB;
       this.normalC = normalC;
       this.normalD = normalD;
       this.normalPromedio = normalPromedio;
       this.anormalCantidad = anormalCantidad;
       this.semillasDuras = semillasDuras;
       this.semillasMuertas = semillasMuertas;
       this.semillasFrescas = semillasFrescas;
       this.datLaboratorioCabeceras = datLaboratorioCabeceras;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Laboratorio_Pantulas", unique=true, nullable=false)
    public Integer getIdLaboratorioPantulas() {
        return this.idLaboratorioPantulas;
    }
    
    public void setIdLaboratorioPantulas(Integer idLaboratorioPantulas) {
        this.idLaboratorioPantulas = idLaboratorioPantulas;
    }

    
    @Column(name="Normal_A")
    public Integer getNormalA() {
        return this.normalA;
    }
    
    public void setNormalA(Integer normalA) {
        this.normalA = normalA;
    }

    
    @Column(name="Normal_B")
    public Integer getNormalB() {
        return this.normalB;
    }
    
    public void setNormalB(Integer normalB) {
        this.normalB = normalB;
    }

    
    @Column(name="Normal_C")
    public Integer getNormalC() {
        return this.normalC;
    }
    
    public void setNormalC(Integer normalC) {
        this.normalC = normalC;
    }

    
    @Column(name="Normal_D")
    public Integer getNormalD() {
        return this.normalD;
    }
    
    public void setNormalD(Integer normalD) {
        this.normalD = normalD;
    }

    
    @Column(name="Normal_Promedio")
    public Integer getNormalPromedio() {
        return this.normalPromedio;
    }
    
    public void setNormalPromedio(Integer normalPromedio) {
        this.normalPromedio = normalPromedio;
    }

    
    @Column(name="Anormal_Cantidad")
    public Integer getAnormalCantidad() {
        return this.anormalCantidad;
    }
    
    public void setAnormalCantidad(Integer anormalCantidad) {
        this.anormalCantidad = anormalCantidad;
    }

    
    @Column(name="Semillas_Duras")
    public Integer getSemillasDuras() {
        return this.semillasDuras;
    }
    
    public void setSemillasDuras(Integer semillasDuras) {
        this.semillasDuras = semillasDuras;
    }

    
    @Column(name="Semillas_Muertas")
    public Integer getSemillasMuertas() {
        return this.semillasMuertas;
    }
    
    public void setSemillasMuertas(Integer semillasMuertas) {
        this.semillasMuertas = semillasMuertas;
    }

    
    @Column(name="Semillas_Frescas")
    public Integer getSemillasFrescas() {
        return this.semillasFrescas;
    }
    
    public void setSemillasFrescas(Integer semillasFrescas) {
        this.semillasFrescas = semillasFrescas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datLaboratorioPantulas")
    public Set<DatLaboratorioCabecera> getDatLaboratorioCabeceras() {
        return this.datLaboratorioCabeceras;
    }
    
    public void setDatLaboratorioCabeceras(Set<DatLaboratorioCabecera> datLaboratorioCabeceras) {
        this.datLaboratorioCabeceras = datLaboratorioCabeceras;
    }




}


