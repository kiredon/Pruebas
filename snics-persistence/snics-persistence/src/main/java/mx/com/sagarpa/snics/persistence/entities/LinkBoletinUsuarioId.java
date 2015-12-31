package mx.com.sagarpa.snics.persistence.entities;
// Generated 30/12/2015 05:02:20 PM by Hibernate Tools 3.2.4.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LinkBoletinUsuarioId generated by hbm2java
 */
@Embeddable
public class LinkBoletinUsuarioId  implements java.io.Serializable {


     private int idBoletin;
     private int idUsuario;

    public LinkBoletinUsuarioId() {
    }

    public LinkBoletinUsuarioId(int idBoletin, int idUsuario) {
       this.idBoletin = idBoletin;
       this.idUsuario = idUsuario;
    }
   


    @Column(name="Id_Boletin", nullable=false)
    public int getIdBoletin() {
        return this.idBoletin;
    }
    
    public void setIdBoletin(int idBoletin) {
        this.idBoletin = idBoletin;
    }


    @Column(name="Id_Usuario", nullable=false)
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LinkBoletinUsuarioId) ) return false;
		 LinkBoletinUsuarioId castOther = ( LinkBoletinUsuarioId ) other; 
         
		 return (this.getIdBoletin()==castOther.getIdBoletin())
 && (this.getIdUsuario()==castOther.getIdUsuario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdBoletin();
         result = 37 * result + this.getIdUsuario();
         return result;
   }   


}


