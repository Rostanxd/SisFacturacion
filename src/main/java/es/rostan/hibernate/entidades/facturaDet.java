package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 07/05/2017.
 */
@Entity
@Table(name = "pvt_facturas_det")
@IdClass(facturaDetPK.class)
public class facturaDet implements Serializable {

    @Id
    @Column(name = "facAnio", length = 4)
    private Integer facAnio;

    @Id
    @Column(name = "facNumero", length = 6)
    private Integer facNumero;

    @Id
    @Column(name = "facLinea", length = 4)
    private Integer facLinea;

    @Column(name = "facCantidad", length = 4)
    private Integer facCantidad;

    @Column(name = "facPrecio", precision = 13, scale = 2)
    private Double facPrecio;

    @Column(name = "facTotLineal", precision = 13, scale = 2)
    private Double facTotLineal;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "facAnio", updatable = false, insertable = false, referencedColumnName = "facAnio"),
            @JoinColumn(name = "facNumero", updatable = false, insertable = false, referencedColumnName = "facNumero")
    })
    private facturaCab facturaCab;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prdCodigo")
    private producto producto;

    public facturaDet(){

    }

    public facturaDet(Integer facAnio, Integer facNumero, Integer facLinea, Integer facCantidad, Double facPrecio, Double facTotLineal) {
        this.facAnio = facAnio;
        this.facNumero = facNumero;
        this.facLinea = facLinea;
        this.facCantidad = facCantidad;
        this.facPrecio = facPrecio;
        this.facTotLineal = facTotLineal;
    }

    public Integer getFacAnio() {
        return facAnio;
    }

    public void setFacAnio(Integer facAnio) {
        this.facAnio = facAnio;
    }

    public Integer getFacNumero() {
        return facNumero;
    }

    public void setFacNumero(Integer facNumero) {
        this.facNumero = facNumero;
    }

    public Integer getFacLinea() {
        return facLinea;
    }

    public void setFacLinea(Integer facLinea) {
        this.facLinea = facLinea;
    }

    public Integer getFacCantidad() {
        return facCantidad;
    }

    public void setFacCantidad(Integer facCantidad) {
        this.facCantidad = facCantidad;
    }

    public Double getFacPrecio() {
        return facPrecio;
    }

    public void setFacPrecio(Double facPrecio) {
        this.facPrecio = facPrecio;
    }

    public Double getFacTotLineal() {
        return facTotLineal;
    }

    public void setFacTotLineal(Double facTotLineal) {
        this.facTotLineal = facTotLineal;
    }

    public es.rostan.hibernate.entidades.facturaCab getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(es.rostan.hibernate.entidades.facturaCab facturaCab) {
        this.facturaCab = facturaCab;
    }

    public es.rostan.hibernate.entidades.producto getProducto() {
        return producto;
    }

    public void setProducto(es.rostan.hibernate.entidades.producto producto) {
        this.producto = producto;
    }
}
