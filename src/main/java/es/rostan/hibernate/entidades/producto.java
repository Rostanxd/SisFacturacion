package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rostan on 07/05/2017.
 */
@Entity
@Table(name = "inv_producto")
public class producto implements Serializable {

    @Id
    @Column(name = "prdCodigo", length = 10)
    private String prdCodigo;

    @Column(name = "prdNombre", length = 30)
    private String prdNombre;

    @Column(name = "prdEstado", length = 1)
    private String prdEstado;

    @Column(name = "prdPrecio", precision = 13, scale = 2)
    private Double prdPrecio;

    @Column(name = "prdCosto", precision = 13, scale = 2)
    private Double prdCosto;

    @Column(name = "prdUsrCreacion", length = 10)
    private String prdUsrCreacion;

    @Column(name = "prdFecCreacion")
    private Date prdFecCreacion;

    @Column(name = "prdUsrModificacion", length = 10)
    private String prdUsrModificacion;

    @Column(name = "prdFecModificacion")
    private Date prdFecModificacion;

    @OneToOne(mappedBy = "producto")
    private facturaDet facturaDet;

    public producto(){}

    public producto(String prdCodigo, String prdNombre, String prdEstado, Double prdPrecio, Double prdCosto, String prdUsrCreacion, Date prdFecCreacion, String prdUsrModificacion, Date prdFecModificacion) {
        this.prdCodigo = prdCodigo;
        this.prdNombre = prdNombre;
        this.prdEstado = prdEstado;
        this.prdPrecio = prdPrecio;
        this.prdCosto = prdCosto;
        this.prdUsrCreacion = prdUsrCreacion;
        this.prdFecCreacion = prdFecCreacion;
        this.prdUsrModificacion = prdUsrModificacion;
        this.prdFecModificacion = prdFecModificacion;
    }

    public String getPrdCodigo() {
        return prdCodigo;
    }

    public void setPrdCodigo(String prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    public String getPrdNombre() {
        return prdNombre;
    }

    public void setPrdNombre(String prdNombre) {
        this.prdNombre = prdNombre;
    }

    public String getPrdEstado() {
        return prdEstado;
    }

    public void setPrdEstado(String prdEstado) {
        this.prdEstado = prdEstado;
    }

    public Double getPrdPrecio() {
        return prdPrecio;
    }

    public void setPrdPrecio(Double prdPrecio) {
        this.prdPrecio = prdPrecio;
    }

    public Double getPrdCosto() {
        return prdCosto;
    }

    public void setPrdCosto(Double prdCosto) {
        this.prdCosto = prdCosto;
    }

    public String getPrdUsrCreacion() {
        return prdUsrCreacion;
    }

    public void setPrdUsrCreacion(String prdUsrCreacion) {
        this.prdUsrCreacion = prdUsrCreacion;
    }

    public Date getPrdFecCreacion() {
        return prdFecCreacion;
    }

    public void setPrdFecCreacion(Date prdFecCreacion) {
        this.prdFecCreacion = prdFecCreacion;
    }

    public String getPrdUsrModificacion() {
        return prdUsrModificacion;
    }

    public void setPrdUsrModificacion(String prdUsrModificacion) {
        this.prdUsrModificacion = prdUsrModificacion;
    }

    public Date getPrdFecModificacion() {
        return prdFecModificacion;
    }

    public void setPrdFecModificacion(Date prdFecModificacion) {
        this.prdFecModificacion = prdFecModificacion;
    }
}
