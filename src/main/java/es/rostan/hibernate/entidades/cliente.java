package es.rostan.hibernate.entidades;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rostan on 07/05/2017.
 */
@Entity
@Table(name = "crm_clientes")
public class cliente implements Serializable {

    @Id
    @Column(name = "cliCodigo", length = 13)
    private String cliCodigo;

    @Column(name = "cliNombres", length = 40)
    private String cliNombres;

    @Column(name = "cliApellidos", length = 40)
    private String cliApellidos;

    @Column(name = "cliEmail", length = 40)
    private String cliEmail;

    @Column(name = "cliTelefono", length = 15)
    private String cliTelefono;

    @Column(name = "cliCelular", length = 15)
    private String cliCelular;

    @Column(name = "cliUsrCreacion", length = 10)
    private String cliUsrCreacion;

    @Column(name = "cliFecCreacion")
    private Date cliFecCreacion;

    @Column(name = "cliUsrModificacion", length = 10)
    private String cliUsrModificacion;

    @Column(name = "cliFecModificacion")
    private Date cliFecModificacion;

    @OneToOne(mappedBy = "cliente")
    private facturaCab facturaCab;

    public cliente(){}

    public cliente(String cliCodigo, String cliNombres, String cliApellidos, String cliEmail, String cliTelefono, String cliCelular, String cliUsrCreacion, Date cliFecCreacion, String cliUsrModificacion, Date cliFecModificacion) {
        this.cliCodigo = cliCodigo;
        this.cliNombres = cliNombres;
        this.cliApellidos = cliApellidos;
        this.cliEmail = cliEmail;
        this.cliTelefono = cliTelefono;
        this.cliCelular = cliCelular;
        this.cliUsrCreacion = cliUsrCreacion;
        this.cliFecCreacion = cliFecCreacion;
        this.cliUsrModificacion = cliUsrModificacion;
        this.cliFecModificacion = cliFecModificacion;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombres) {
        this.cliNombres = cliNombres;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliUsrCreacion() {
        return cliUsrCreacion;
    }

    public void setCliUsrCreacion(String cliUsrCreacion) {
        this.cliUsrCreacion = cliUsrCreacion;
    }

    public Date getCliFecCreacion() {
        return cliFecCreacion;
    }

    public void setCliFecCreacion(Date cliFecCreacion) {
        this.cliFecCreacion = cliFecCreacion;
    }

    public String getCliUsrModificacion() {
        return cliUsrModificacion;
    }

    public void setCliUsrModificacion(String cliUsrModificacion) {
        this.cliUsrModificacion = cliUsrModificacion;
    }

    public Date getCliFecModificacion() {
        return cliFecModificacion;
    }

    public void setCliFecModificacion(Date cliFecModificacion) {
        this.cliFecModificacion = cliFecModificacion;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "cliCodigo='" + cliCodigo + '\'' +
                ", cliNombres='" + cliNombres + '\'' +
                ", cliApellidos='" + cliApellidos + '\'' +
                ", cliEmail='" + cliEmail + '\'' +
                ", cliTelefono='" + cliTelefono + '\'' +
                ", cliCelular='" + cliCelular + '\'' +
                ", cliUsrCreacion='" + cliUsrCreacion + '\'' +
                ", cliFecCreacion=" + cliFecCreacion +
                ", cliUsrModificacion='" + cliUsrModificacion + '\'' +
                ", cliFecModificacion=" + cliFecModificacion +
                '}';
    }
}
