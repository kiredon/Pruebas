package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DatR5Cabecera generated by hbm2java
 */
@Entity
@Table(name="Dat_R5_Cabecera"
    ,catalog="sisem"
)
public class DatR5Cabecera  implements java.io.Serializable {


     private int idR5Cabecera;
     private DatR5MateriaPrima datR5MateriaPrima;
     private DatOrganismo datOrganismoByIdOrganismoProductor;
     private DatR5Transporte datR5Transporte;
     private DatR5Ciclo datR5Ciclo;
     private DatOrganismo datOrganismoByIdOrganismo;
     private DatUsuario datUsuario;
     private DatR5Detalle datR5Detalle;
     private DatR5Estiba datR5Estiba;
     private DatR5Particulares datR5Particulares;
     private CatMunicipio catMunicipio;
     private DatDomicilioFiscal datDomicilioFiscal;
     private DatR5Origen datR5Origen;
     private CatUnidadSnics catUnidadSnics;
     private String boletaIdentificacion;
     private Date fechaCreacion;
     private Date fechaEdicion;
     private Boolean status;
     private Boolean statusCerrada;
     private Set<DatLaboratorioCabecera> datLaboratorioCabeceras = new HashSet<DatLaboratorioCabecera>(0);

    public DatR5Cabecera() {
    }

	
    public DatR5Cabecera(int idR5Cabecera, DatR5MateriaPrima datR5MateriaPrima, DatOrganismo datOrganismoByIdOrganismoProductor, DatR5Transporte datR5Transporte, DatR5Ciclo datR5Ciclo, DatOrganismo datOrganismoByIdOrganismo, DatUsuario datUsuario, DatR5Detalle datR5Detalle, DatR5Estiba datR5Estiba, DatR5Particulares datR5Particulares, CatMunicipio catMunicipio, DatDomicilioFiscal datDomicilioFiscal, DatR5Origen datR5Origen, CatUnidadSnics catUnidadSnics) {
        this.idR5Cabecera = idR5Cabecera;
        this.datR5MateriaPrima = datR5MateriaPrima;
        this.datOrganismoByIdOrganismoProductor = datOrganismoByIdOrganismoProductor;
        this.datR5Transporte = datR5Transporte;
        this.datR5Ciclo = datR5Ciclo;
        this.datOrganismoByIdOrganismo = datOrganismoByIdOrganismo;
        this.datUsuario = datUsuario;
        this.datR5Detalle = datR5Detalle;
        this.datR5Estiba = datR5Estiba;
        this.datR5Particulares = datR5Particulares;
        this.catMunicipio = catMunicipio;
        this.datDomicilioFiscal = datDomicilioFiscal;
        this.datR5Origen = datR5Origen;
        this.catUnidadSnics = catUnidadSnics;
    }
    public DatR5Cabecera(int idR5Cabecera, DatR5MateriaPrima datR5MateriaPrima, DatOrganismo datOrganismoByIdOrganismoProductor, DatR5Transporte datR5Transporte, DatR5Ciclo datR5Ciclo, DatOrganismo datOrganismoByIdOrganismo, DatUsuario datUsuario, DatR5Detalle datR5Detalle, DatR5Estiba datR5Estiba, DatR5Particulares datR5Particulares, CatMunicipio catMunicipio, DatDomicilioFiscal datDomicilioFiscal, DatR5Origen datR5Origen, CatUnidadSnics catUnidadSnics, String boletaIdentificacion, Date fechaCreacion, Date fechaEdicion, Boolean status, Boolean statusCerrada, Set<DatLaboratorioCabecera> datLaboratorioCabeceras) {
       this.idR5Cabecera = idR5Cabecera;
       this.datR5MateriaPrima = datR5MateriaPrima;
       this.datOrganismoByIdOrganismoProductor = datOrganismoByIdOrganismoProductor;
       this.datR5Transporte = datR5Transporte;
       this.datR5Ciclo = datR5Ciclo;
       this.datOrganismoByIdOrganismo = datOrganismoByIdOrganismo;
       this.datUsuario = datUsuario;
       this.datR5Detalle = datR5Detalle;
       this.datR5Estiba = datR5Estiba;
       this.datR5Particulares = datR5Particulares;
       this.catMunicipio = catMunicipio;
       this.datDomicilioFiscal = datDomicilioFiscal;
       this.datR5Origen = datR5Origen;
       this.catUnidadSnics = catUnidadSnics;
       this.boletaIdentificacion = boletaIdentificacion;
       this.fechaCreacion = fechaCreacion;
       this.fechaEdicion = fechaEdicion;
       this.status = status;
       this.statusCerrada = statusCerrada;
       this.datLaboratorioCabeceras = datLaboratorioCabeceras;
    }
   
     @Id 

    
    @Column(name="Id_R5_Cabecera", unique=true, nullable=false)
    public int getIdR5Cabecera() {
        return this.idR5Cabecera;
    }
    
    public void setIdR5Cabecera(int idR5Cabecera) {
        this.idR5Cabecera = idR5Cabecera;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R5_Materia_Prima", nullable=false)
    public DatR5MateriaPrima getDatR5MateriaPrima() {
        return this.datR5MateriaPrima;
    }
    
    public void setDatR5MateriaPrima(DatR5MateriaPrima datR5MateriaPrima) {
        this.datR5MateriaPrima = datR5MateriaPrima;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Organismo_Productor", nullable=false)
    public DatOrganismo getDatOrganismoByIdOrganismoProductor() {
        return this.datOrganismoByIdOrganismoProductor;
    }
    
    public void setDatOrganismoByIdOrganismoProductor(DatOrganismo datOrganismoByIdOrganismoProductor) {
        this.datOrganismoByIdOrganismoProductor = datOrganismoByIdOrganismoProductor;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R5_Transporte", nullable=false)
    public DatR5Transporte getDatR5Transporte() {
        return this.datR5Transporte;
    }
    
    public void setDatR5Transporte(DatR5Transporte datR5Transporte) {
        this.datR5Transporte = datR5Transporte;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R5_Ciclo", nullable=false)
    public DatR5Ciclo getDatR5Ciclo() {
        return this.datR5Ciclo;
    }
    
    public void setDatR5Ciclo(DatR5Ciclo datR5Ciclo) {
        this.datR5Ciclo = datR5Ciclo;
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
    @JoinColumn(name="Id_Usuario_Edicion", nullable=false)
    public DatUsuario getDatUsuario() {
        return this.datUsuario;
    }
    
    public void setDatUsuario(DatUsuario datUsuario) {
        this.datUsuario = datUsuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R5_Detalle", nullable=false)
    public DatR5Detalle getDatR5Detalle() {
        return this.datR5Detalle;
    }
    
    public void setDatR5Detalle(DatR5Detalle datR5Detalle) {
        this.datR5Detalle = datR5Detalle;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R5_Estiba", nullable=false)
    public DatR5Estiba getDatR5Estiba() {
        return this.datR5Estiba;
    }
    
    public void setDatR5Estiba(DatR5Estiba datR5Estiba) {
        this.datR5Estiba = datR5Estiba;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R5_Particulares", nullable=false)
    public DatR5Particulares getDatR5Particulares() {
        return this.datR5Particulares;
    }
    
    public void setDatR5Particulares(DatR5Particulares datR5Particulares) {
        this.datR5Particulares = datR5Particulares;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Municipio_Semilla", nullable=false)
    public CatMunicipio getCatMunicipio() {
        return this.catMunicipio;
    }
    
    public void setCatMunicipio(CatMunicipio catMunicipio) {
        this.catMunicipio = catMunicipio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Domicilio_Fiscal_Organismo", nullable=false)
    public DatDomicilioFiscal getDatDomicilioFiscal() {
        return this.datDomicilioFiscal;
    }
    
    public void setDatDomicilioFiscal(DatDomicilioFiscal datDomicilioFiscal) {
        this.datDomicilioFiscal = datDomicilioFiscal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_R5_Origen", nullable=false)
    public DatR5Origen getDatR5Origen() {
        return this.datR5Origen;
    }
    
    public void setDatR5Origen(DatR5Origen datR5Origen) {
        this.datR5Origen = datR5Origen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Snics", nullable=false)
    public CatUnidadSnics getCatUnidadSnics() {
        return this.catUnidadSnics;
    }
    
    public void setCatUnidadSnics(CatUnidadSnics catUnidadSnics) {
        this.catUnidadSnics = catUnidadSnics;
    }

    
    @Column(name="Boleta_Identificacion", length=45)
    public String getBoletaIdentificacion() {
        return this.boletaIdentificacion;
    }
    
    public void setBoletaIdentificacion(String boletaIdentificacion) {
        this.boletaIdentificacion = boletaIdentificacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Creacion", length=19)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha_Edicion", length=19)
    public Date getFechaEdicion() {
        return this.fechaEdicion;
    }
    
    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    
    @Column(name="Status")
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    @Column(name="Status_Cerrada")
    public Boolean getStatusCerrada() {
        return this.statusCerrada;
    }
    
    public void setStatusCerrada(Boolean statusCerrada) {
        this.statusCerrada = statusCerrada;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="datR5Cabecera")
    public Set<DatLaboratorioCabecera> getDatLaboratorioCabeceras() {
        return this.datLaboratorioCabeceras;
    }
    
    public void setDatLaboratorioCabeceras(Set<DatLaboratorioCabecera> datLaboratorioCabeceras) {
        this.datLaboratorioCabeceras = datLaboratorioCabeceras;
    }




}


