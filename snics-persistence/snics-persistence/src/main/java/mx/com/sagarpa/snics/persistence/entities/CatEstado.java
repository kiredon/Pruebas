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
 * CatEstado generated by hbm2java
 */
@Entity
@Table(name="Cat_Estado"
    ,catalog="sisem"
)
public class CatEstado  implements java.io.Serializable {


     private Integer idEstado;
     private CatPais catPais;
     private int claveEstado;
     private String nombreEstado;
     private String status;
     private Set<CatMunicipio> catMunicipios = new HashSet<CatMunicipio>(0);
     private Set<DatR1Predio> datR1Predios = new HashSet<DatR1Predio>(0);
     private Set<CatUnidadSnics> catUnidadSnicses = new HashSet<CatUnidadSnics>(0);
     private Set<DatAlmacenBeneficio> datAlmacenBeneficios = new HashSet<DatAlmacenBeneficio>(0);
     private Set<DatR4Direccion> datR4Direccions = new HashSet<DatR4Direccion>(0);
     private Set<DatDomicilioFiscal> datDomicilioFiscals = new HashSet<DatDomicilioFiscal>(0);
     private Set<DatR7Inspeccion> datR7Inspeccions = new HashSet<DatR7Inspeccion>(0);
     private Set<DatR1Cabecera> datR1Cabeceras = new HashSet<DatR1Cabecera>(0);
     private Set<DatOrganismo> datOrganismos = new HashSet<DatOrganismo>(0);
     private Set<DatR1Origen> datR1Origens = new HashSet<DatR1Origen>(0);

    public CatEstado() {
    }

	
    public CatEstado(CatPais catPais, int claveEstado, String nombreEstado) {
        this.catPais = catPais;
        this.claveEstado = claveEstado;
        this.nombreEstado = nombreEstado;
    }
    public CatEstado(CatPais catPais, int claveEstado, String nombreEstado, String status, Set<CatMunicipio> catMunicipios, Set<DatR1Predio> datR1Predios, Set<CatUnidadSnics> catUnidadSnicses, Set<DatAlmacenBeneficio> datAlmacenBeneficios, Set<DatR4Direccion> datR4Direccions, Set<DatDomicilioFiscal> datDomicilioFiscals, Set<DatR7Inspeccion> datR7Inspeccions, Set<DatR1Cabecera> datR1Cabeceras, Set<DatOrganismo> datOrganismos, Set<DatR1Origen> datR1Origens) {
       this.catPais = catPais;
       this.claveEstado = claveEstado;
       this.nombreEstado = nombreEstado;
       this.status = status;
       this.catMunicipios = catMunicipios;
       this.datR1Predios = datR1Predios;
       this.catUnidadSnicses = catUnidadSnicses;
       this.datAlmacenBeneficios = datAlmacenBeneficios;
       this.datR4Direccions = datR4Direccions;
       this.datDomicilioFiscals = datDomicilioFiscals;
       this.datR7Inspeccions = datR7Inspeccions;
       this.datR1Cabeceras = datR1Cabeceras;
       this.datOrganismos = datOrganismos;
       this.datR1Origens = datR1Origens;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id_Estado", unique=true, nullable=false)
    public Integer getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Pais", nullable=false)
    public CatPais getCatPais() {
        return this.catPais;
    }
    
    public void setCatPais(CatPais catPais) {
        this.catPais = catPais;
    }

    
    @Column(name="Clave_Estado", nullable=false)
    public int getClaveEstado() {
        return this.claveEstado;
    }
    
    public void setClaveEstado(int claveEstado) {
        this.claveEstado = claveEstado;
    }

    
    @Column(name="Nombre_EStado", nullable=false, length=100)
    public String getNombreEstado() {
        return this.nombreEstado;
    }
    
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    
    @Column(name="Status", length=45)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<CatMunicipio> getCatMunicipios() {
        return this.catMunicipios;
    }
    
    public void setCatMunicipios(Set<CatMunicipio> catMunicipios) {
        this.catMunicipios = catMunicipios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatR1Predio> getDatR1Predios() {
        return this.datR1Predios;
    }
    
    public void setDatR1Predios(Set<DatR1Predio> datR1Predios) {
        this.datR1Predios = datR1Predios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<CatUnidadSnics> getCatUnidadSnicses() {
        return this.catUnidadSnicses;
    }
    
    public void setCatUnidadSnicses(Set<CatUnidadSnics> catUnidadSnicses) {
        this.catUnidadSnicses = catUnidadSnicses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatAlmacenBeneficio> getDatAlmacenBeneficios() {
        return this.datAlmacenBeneficios;
    }
    
    public void setDatAlmacenBeneficios(Set<DatAlmacenBeneficio> datAlmacenBeneficios) {
        this.datAlmacenBeneficios = datAlmacenBeneficios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatR4Direccion> getDatR4Direccions() {
        return this.datR4Direccions;
    }
    
    public void setDatR4Direccions(Set<DatR4Direccion> datR4Direccions) {
        this.datR4Direccions = datR4Direccions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatDomicilioFiscal> getDatDomicilioFiscals() {
        return this.datDomicilioFiscals;
    }
    
    public void setDatDomicilioFiscals(Set<DatDomicilioFiscal> datDomicilioFiscals) {
        this.datDomicilioFiscals = datDomicilioFiscals;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatR7Inspeccion> getDatR7Inspeccions() {
        return this.datR7Inspeccions;
    }
    
    public void setDatR7Inspeccions(Set<DatR7Inspeccion> datR7Inspeccions) {
        this.datR7Inspeccions = datR7Inspeccions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatR1Cabecera> getDatR1Cabeceras() {
        return this.datR1Cabeceras;
    }
    
    public void setDatR1Cabeceras(Set<DatR1Cabecera> datR1Cabeceras) {
        this.datR1Cabeceras = datR1Cabeceras;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatOrganismo> getDatOrganismos() {
        return this.datOrganismos;
    }
    
    public void setDatOrganismos(Set<DatOrganismo> datOrganismos) {
        this.datOrganismos = datOrganismos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catEstado")
    public Set<DatR1Origen> getDatR1Origens() {
        return this.datR1Origens;
    }
    
    public void setDatR1Origens(Set<DatR1Origen> datR1Origens) {
        this.datR1Origens = datR1Origens;
    }




}


