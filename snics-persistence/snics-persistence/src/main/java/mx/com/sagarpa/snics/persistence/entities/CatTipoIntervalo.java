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
 * CatTipoIntervalo generated by hbm2java
 */
@Entity
@Table(name="Cat_Tipo_Intervalo"
    ,catalog="sisem"
)
public class CatTipoIntervalo  implements java.io.Serializable {


     private Integer idTipoIntervalo;
     private String nombreTipoIntervalo;
     private Set<CatIntervalo> catIntervalos = new HashSet<CatIntervalo>(0);

    public CatTipoIntervalo() {
    }

    public CatTipoIntervalo(String nombreTipoIntervalo, Set<CatIntervalo> catIntervalos) {
       this.nombreTipoIntervalo = nombreTipoIntervalo;
       this.catIntervalos = catIntervalos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Tipo_Intervalo", unique=true, nullable=false)
    public Integer getIdTipoIntervalo() {
        return this.idTipoIntervalo;
    }
    
    public void setIdTipoIntervalo(Integer idTipoIntervalo) {
        this.idTipoIntervalo = idTipoIntervalo;
    }

    
    @Column(name="Nombre_Tipo_Intervalo", length=45)
    public String getNombreTipoIntervalo() {
        return this.nombreTipoIntervalo;
    }
    
    public void setNombreTipoIntervalo(String nombreTipoIntervalo) {
        this.nombreTipoIntervalo = nombreTipoIntervalo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catTipoIntervalo")
    public Set<CatIntervalo> getCatIntervalos() {
        return this.catIntervalos;
    }
    
    public void setCatIntervalos(Set<CatIntervalo> catIntervalos) {
        this.catIntervalos = catIntervalos;
    }




}


