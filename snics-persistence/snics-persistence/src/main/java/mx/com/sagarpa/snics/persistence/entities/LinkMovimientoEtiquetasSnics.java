package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LinkMovimientoEtiquetasSnics generated by hbm2java
 */
@Entity
@Table(name="Link_Movimiento_Etiquetas_Snics"
    ,catalog="sisem"
)
public class LinkMovimientoEtiquetasSnics  implements java.io.Serializable {


     private LinkMovimientoEtiquetasSnicsId id;
     private CatUnidadSnics catUnidadSnics;
     private CatStatusMovimientoEtiqueta catStatusMovimientoEtiqueta;
     private DatMovimientoEtiquetas datMovimientoEtiquetas;
     private String serie;
     private Integer folioInicialEnviado;
     private Integer folioFinalEnviado;
     private Integer cantidadEnviado;
     private Integer folioInicialRecibido;
     private Integer folioFinalRecibido;
     private Integer cantidadRecibido;
     private Integer folioInicialNoRecibido;
     private Integer folioFinalNoRecibido;
     private Integer cantidaNoRecibido;
     private Boolean devolver;
     private String motivoNoRecepcion;

    public LinkMovimientoEtiquetasSnics() {
    }

	
    public LinkMovimientoEtiquetasSnics(LinkMovimientoEtiquetasSnicsId id, CatUnidadSnics catUnidadSnics, CatStatusMovimientoEtiqueta catStatusMovimientoEtiqueta, DatMovimientoEtiquetas datMovimientoEtiquetas) {
        this.id = id;
        this.catUnidadSnics = catUnidadSnics;
        this.catStatusMovimientoEtiqueta = catStatusMovimientoEtiqueta;
        this.datMovimientoEtiquetas = datMovimientoEtiquetas;
    }
    public LinkMovimientoEtiquetasSnics(LinkMovimientoEtiquetasSnicsId id, CatUnidadSnics catUnidadSnics, CatStatusMovimientoEtiqueta catStatusMovimientoEtiqueta, DatMovimientoEtiquetas datMovimientoEtiquetas, String serie, Integer folioInicialEnviado, Integer folioFinalEnviado, Integer cantidadEnviado, Integer folioInicialRecibido, Integer folioFinalRecibido, Integer cantidadRecibido, Integer folioInicialNoRecibido, Integer folioFinalNoRecibido, Integer cantidaNoRecibido, Boolean devolver, String motivoNoRecepcion) {
       this.id = id;
       this.catUnidadSnics = catUnidadSnics;
       this.catStatusMovimientoEtiqueta = catStatusMovimientoEtiqueta;
       this.datMovimientoEtiquetas = datMovimientoEtiquetas;
       this.serie = serie;
       this.folioInicialEnviado = folioInicialEnviado;
       this.folioFinalEnviado = folioFinalEnviado;
       this.cantidadEnviado = cantidadEnviado;
       this.folioInicialRecibido = folioInicialRecibido;
       this.folioFinalRecibido = folioFinalRecibido;
       this.cantidadRecibido = cantidadRecibido;
       this.folioInicialNoRecibido = folioInicialNoRecibido;
       this.folioFinalNoRecibido = folioFinalNoRecibido;
       this.cantidaNoRecibido = cantidaNoRecibido;
       this.devolver = devolver;
       this.motivoNoRecepcion = motivoNoRecepcion;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idMovimientoEtiquetas", column=@Column(name="Id_Movimiento_Etiquetas", nullable=false) ), 
        @AttributeOverride(name="idUnidadSnicsEntrega", column=@Column(name="Id_Unidad_Snics_entrega", nullable=false) ) } )
    public LinkMovimientoEtiquetasSnicsId getId() {
        return this.id;
    }
    
    public void setId(LinkMovimientoEtiquetasSnicsId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Unidad_Snics_entrega", nullable=false, insertable=false, updatable=false)
    public CatUnidadSnics getCatUnidadSnics() {
        return this.catUnidadSnics;
    }
    
    public void setCatUnidadSnics(CatUnidadSnics catUnidadSnics) {
        this.catUnidadSnics = catUnidadSnics;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Status_Envio_Etiqueta", nullable=false)
    public CatStatusMovimientoEtiqueta getCatStatusMovimientoEtiqueta() {
        return this.catStatusMovimientoEtiqueta;
    }
    
    public void setCatStatusMovimientoEtiqueta(CatStatusMovimientoEtiqueta catStatusMovimientoEtiqueta) {
        this.catStatusMovimientoEtiqueta = catStatusMovimientoEtiqueta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Id_Movimiento_Etiquetas", nullable=false, insertable=false, updatable=false)
    public DatMovimientoEtiquetas getDatMovimientoEtiquetas() {
        return this.datMovimientoEtiquetas;
    }
    
    public void setDatMovimientoEtiquetas(DatMovimientoEtiquetas datMovimientoEtiquetas) {
        this.datMovimientoEtiquetas = datMovimientoEtiquetas;
    }

    
    @Column(name="Serie", length=45)
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }

    
    @Column(name="Folio_Inicial_Enviado")
    public Integer getFolioInicialEnviado() {
        return this.folioInicialEnviado;
    }
    
    public void setFolioInicialEnviado(Integer folioInicialEnviado) {
        this.folioInicialEnviado = folioInicialEnviado;
    }

    
    @Column(name="Folio_Final_Enviado")
    public Integer getFolioFinalEnviado() {
        return this.folioFinalEnviado;
    }
    
    public void setFolioFinalEnviado(Integer folioFinalEnviado) {
        this.folioFinalEnviado = folioFinalEnviado;
    }

    
    @Column(name="Cantidad_Enviado")
    public Integer getCantidadEnviado() {
        return this.cantidadEnviado;
    }
    
    public void setCantidadEnviado(Integer cantidadEnviado) {
        this.cantidadEnviado = cantidadEnviado;
    }

    
    @Column(name="Folio_Inicial_Recibido")
    public Integer getFolioInicialRecibido() {
        return this.folioInicialRecibido;
    }
    
    public void setFolioInicialRecibido(Integer folioInicialRecibido) {
        this.folioInicialRecibido = folioInicialRecibido;
    }

    
    @Column(name="Folio_Final_Recibido")
    public Integer getFolioFinalRecibido() {
        return this.folioFinalRecibido;
    }
    
    public void setFolioFinalRecibido(Integer folioFinalRecibido) {
        this.folioFinalRecibido = folioFinalRecibido;
    }

    
    @Column(name="Cantidad_Recibido")
    public Integer getCantidadRecibido() {
        return this.cantidadRecibido;
    }
    
    public void setCantidadRecibido(Integer cantidadRecibido) {
        this.cantidadRecibido = cantidadRecibido;
    }

    
    @Column(name="Folio_Inicial_No_Recibido")
    public Integer getFolioInicialNoRecibido() {
        return this.folioInicialNoRecibido;
    }
    
    public void setFolioInicialNoRecibido(Integer folioInicialNoRecibido) {
        this.folioInicialNoRecibido = folioInicialNoRecibido;
    }

    
    @Column(name="Folio_Final_No_Recibido")
    public Integer getFolioFinalNoRecibido() {
        return this.folioFinalNoRecibido;
    }
    
    public void setFolioFinalNoRecibido(Integer folioFinalNoRecibido) {
        this.folioFinalNoRecibido = folioFinalNoRecibido;
    }

    
    @Column(name="Cantida_No_Recibido")
    public Integer getCantidaNoRecibido() {
        return this.cantidaNoRecibido;
    }
    
    public void setCantidaNoRecibido(Integer cantidaNoRecibido) {
        this.cantidaNoRecibido = cantidaNoRecibido;
    }

    
    @Column(name="Devolver")
    public Boolean getDevolver() {
        return this.devolver;
    }
    
    public void setDevolver(Boolean devolver) {
        this.devolver = devolver;
    }

    
    @Column(name="Motivo_No_recepcion", length=300)
    public String getMotivoNoRecepcion() {
        return this.motivoNoRecepcion;
    }
    
    public void setMotivoNoRecepcion(String motivoNoRecepcion) {
        this.motivoNoRecepcion = motivoNoRecepcion;
    }




}


