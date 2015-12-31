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
 * CatFechaCiclo generated by hbm2java
 */
@Entity
@Table(name="Cat_Fecha_Ciclo"
    ,catalog="sisem"
)
public class CatFechaCiclo  implements java.io.Serializable {


     private Integer idFechaCiclo;
     private String nombreFechaCiclo;
     private boolean status;
     private Set<DatR5Ciclo> datR5Ciclos = new HashSet<DatR5Ciclo>(0);
     private Set<DatR7Inspeccion> datR7Inspeccions = new HashSet<DatR7Inspeccion>(0);
     private Set<DatR1Cabecera> datR1CabecerasForIdFechaClicloAgricolaOrigen = new HashSet<DatR1Cabecera>(0);
     private Set<DatR1Cabecera> datR1CabecerasForIdFechaClicloAgricolaProduccion = new HashSet<DatR1Cabecera>(0);

    public CatFechaCiclo() {
    }

	
    public CatFechaCiclo(String nombreFechaCiclo, boolean status) {
        this.nombreFechaCiclo = nombreFechaCiclo;
        this.status = status;
    }
    public CatFechaCiclo(String nombreFechaCiclo, boolean status, Set<DatR5Ciclo> datR5Ciclos, Set<DatR7Inspeccion> datR7Inspeccions, Set<DatR1Cabecera> datR1CabecerasForIdFechaClicloAgricolaOrigen, Set<DatR1Cabecera> datR1CabecerasForIdFechaClicloAgricolaProduccion) {
       this.nombreFechaCiclo = nombreFechaCiclo;
       this.status = status;
       this.datR5Ciclos = datR5Ciclos;
       this.datR7Inspeccions = datR7Inspeccions;
       this.datR1CabecerasForIdFechaClicloAgricolaOrigen = datR1CabecerasForIdFechaClicloAgricolaOrigen;
       this.datR1CabecerasForIdFechaClicloAgricolaProduccion = datR1CabecerasForIdFechaClicloAgricolaProduccion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Fecha_Ciclo", unique=true, nullable=false)
    public Integer getIdFechaCiclo() {
        return this.idFechaCiclo;
    }
    
    public void setIdFechaCiclo(Integer idFechaCiclo) {
        this.idFechaCiclo = idFechaCiclo;
    }

    
    @Column(name="Nombre_Fecha_Ciclo", nullable=false, length=45)
    public String getNombreFechaCiclo() {
        return this.nombreFechaCiclo;
    }
    
    public void setNombreFechaCiclo(String nombreFechaCiclo) {
        this.nombreFechaCiclo = nombreFechaCiclo;
    }

    
    @Column(name="Status", nullable=false)
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catFechaCiclo")
    public Set<DatR5Ciclo> getDatR5Ciclos() {
        return this.datR5Ciclos;
    }
    
    public void setDatR5Ciclos(Set<DatR5Ciclo> datR5Ciclos) {
        this.datR5Ciclos = datR5Ciclos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catFechaCiclo")
    public Set<DatR7Inspeccion> getDatR7Inspeccions() {
        return this.datR7Inspeccions;
    }
    
    public void setDatR7Inspeccions(Set<DatR7Inspeccion> datR7Inspeccions) {
        this.datR7Inspeccions = datR7Inspeccions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catFechaCicloByIdFechaClicloAgricolaOrigen")
    public Set<DatR1Cabecera> getDatR1CabecerasForIdFechaClicloAgricolaOrigen() {
        return this.datR1CabecerasForIdFechaClicloAgricolaOrigen;
    }
    
    public void setDatR1CabecerasForIdFechaClicloAgricolaOrigen(Set<DatR1Cabecera> datR1CabecerasForIdFechaClicloAgricolaOrigen) {
        this.datR1CabecerasForIdFechaClicloAgricolaOrigen = datR1CabecerasForIdFechaClicloAgricolaOrigen;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catFechaCicloByIdFechaClicloAgricolaProduccion")
    public Set<DatR1Cabecera> getDatR1CabecerasForIdFechaClicloAgricolaProduccion() {
        return this.datR1CabecerasForIdFechaClicloAgricolaProduccion;
    }
    
    public void setDatR1CabecerasForIdFechaClicloAgricolaProduccion(Set<DatR1Cabecera> datR1CabecerasForIdFechaClicloAgricolaProduccion) {
        this.datR1CabecerasForIdFechaClicloAgricolaProduccion = datR1CabecerasForIdFechaClicloAgricolaProduccion;
    }




}


