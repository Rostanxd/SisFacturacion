package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rostan on 07/05/2017.
 */
@Entity
@Table(name = "scg_usuarios")
public class usuario implements Serializable{

    @Id
    @Column(name = "usrCodigo", length = 10)
    private String usrCodigo;

    @Column(name = "usrNombre",length = 40)
    private String usrNombre;

    @Column(name = "usrApellido",length = 40)
    private String usrApellido;

    @Column(name = "usrPassword",length = 10)
    private String usrPassword;

    @Column(name = "usrEstado", length = 1)
    private String usrEstado;

    @Column(name = "usrFecCreacion")
    private Date usrFecCreacion;

    @Column(name = "usrUsrCreacion", length = 10)
    private String usrUsrCreacion;

    @Column(name = "usrFecModificacion")
    private Date usrFecModificacion;

    @Column(name = "usrUsrModificacion", length = 10)
    private String usrUsrModificacion;

    public usuario(){

    }

    public usuario(String usrCodigo, String usrNombre, String usrApellido, String usrPassword, String usrEstado, Date usrFecCreacion, String usrUsrCreacion, Date usrFecModificacion, String usrUsrModificacion) {
        this.usrCodigo = usrCodigo;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
        this.usrPassword = usrPassword;
        this.usrEstado = usrEstado;
        this.usrFecCreacion = usrFecCreacion;
        this.usrUsrCreacion = usrUsrCreacion;
        this.usrFecModificacion = usrFecModificacion;
        this.usrUsrModificacion = usrUsrModificacion;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Date getUsrFecCreacion() {
        return usrFecCreacion;
    }

    public void setUsrFecCreacion(Date usrFecCreacion) {
        this.usrFecCreacion = usrFecCreacion;
    }

    public String getUsrUsrCreacion() {
        return usrUsrCreacion;
    }

    public void setUsrUsrCreacion(String usrUsrCreacion) {
        this.usrUsrCreacion = usrUsrCreacion;
    }

    public Date getUsrFecModificacion() {
        return usrFecModificacion;
    }

    public void setUsrFecModificacion(Date usrFecModificacion) {
        this.usrFecModificacion = usrFecModificacion;
    }

    public String getUsrUsrModificacion() {
        return usrUsrModificacion;
    }

    public void setUsrUsrModificacion(String usrUsrModificacion) {
        this.usrUsrModificacion = usrUsrModificacion;
    }

    public String getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(String usrEstado) {
        this.usrEstado = usrEstado;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "usrCodigo='" + usrCodigo + '\'' +
                ", usrNombre='" + usrNombre + '\'' +
                ", usrApellido='" + usrApellido + '\'' +
                ", usrPassword='" + usrPassword + '\'' +
                ", usrEstado='" + usrEstado + '\'' +
                ", usrFecCreacion=" + usrFecCreacion +
                ", usrUsrCreacion='" + usrUsrCreacion + '\'' +
                ", usrFecModificacion=" + usrFecModificacion +
                ", usrUsrModificacion='" + usrUsrModificacion + '\'' +
                '}';
    }
}
