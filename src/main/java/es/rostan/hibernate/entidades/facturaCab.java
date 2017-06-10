package es.rostan.hibernate.entidades;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Rostan on 07/05/2017.
 */
@Entity
@Table(name = "pvt_facturas_cab")
public class facturaCab implements Serializable{

    @Id
    @Column(name = "facAnio", length = 4)
    private Integer facAnio;

    @Id
    @Column(name = "facNumero", length = 6)
    private Integer facNumero;

    @Column(name = "facFecha")
    private Date facFecha;

    @Column(name = "facEstado", length = 1)
    private String facEstado;

    @Column(name = "facTotDocmnto", precision = 10, scale = 2)
    private Double facTotDocmnto;

    @Column(name = "facUsrCreacion", length = 10)
    private String facUsrCreacion;

    @Column(name = "facFecCreacion")
    private Date facFecCreacion;

    @Column(name = "facUsrModificacion")
    private String facUsrModificacion;

    @Column(name = "facFecModificacion")
    private Date facFecModificacion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliCodigo")
    private cliente cliente;

    @OneToMany(mappedBy = "facturaCab", cascade = CascadeType.ALL)
    private Set<facturaDet> lstFacturasDet;

    public facturaCab(){

    }

    public facturaCab(Integer facAnio, Integer facNumero, Date facFecha, String facEstado, Double facTotDocmnto, String facUsrCreacion, Date facFecCreacion, String facUsrModificacion, Date facFecModificacion) {
        this.facAnio = facAnio;
        this.facNumero = facNumero;
        this.facFecha = facFecha;
        this.facEstado = facEstado;
        this.facTotDocmnto = facTotDocmnto;
        this.facUsrCreacion = facUsrCreacion;
        this.facFecCreacion = facFecCreacion;
        this.facUsrModificacion = facUsrModificacion;
        this.facFecModificacion = facFecModificacion;
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

    public Date getFacFecha() {
        return facFecha;
    }

    public void setFacFecha(Date facFecha) {
        this.facFecha = facFecha;
    }

    public String getFacEstado() {
        return facEstado;
    }

    public void setFacEstado(String facEstado) {
        this.facEstado = facEstado;
    }

    public Double getFacTotDocmnto() {
        return facTotDocmnto;
    }

    public void setFacTotDocmnto(Double facTotDocmnto) {
        this.facTotDocmnto = facTotDocmnto;
    }

    public String getFacUsrCreacion() {
        return facUsrCreacion;
    }

    public void setFacUsrCreacion(String facUsrCreacion) {
        this.facUsrCreacion = facUsrCreacion;
    }

    public Date getFacFecCreacion() {
        return facFecCreacion;
    }

    public void setFacFecCreacion(Date facFecCreacion) {
        this.facFecCreacion = facFecCreacion;
    }

    public String getFacUsrModificacion() {
        return facUsrModificacion;
    }

    public void setFacUsrModificacion(String facUsrModificacion) {
        this.facUsrModificacion = facUsrModificacion;
    }

    public Date getFacFecModificacion() {
        return facFecModificacion;
    }

    public void setFacFecModificacion(Date facFecModificacion) {
        this.facFecModificacion = facFecModificacion;
    }

    public es.rostan.hibernate.entidades.cliente getCliente() {
        return cliente;
    }

    public void setCliente(es.rostan.hibernate.entidades.cliente cliente) {
        this.cliente = cliente;
    }

    public Set<facturaDet> getLstFacturasDet() {
        return lstFacturasDet;
    }

    public void setLstFacturasDet(Set<facturaDet> lstFacturasDet) {
        this.lstFacturasDet = lstFacturasDet;
    }

    @Override
    public String toString() {
        return "facturaCab{" +
                "facAnio=" + facAnio +
                ", facNumero=" + facNumero +
                ", facFecha=" + facFecha +
                ", facEstado='" + facEstado + '\'' +
                ", facTotDocmnto=" + facTotDocmnto +
                ", facUsrCreacion='" + facUsrCreacion + '\'' +
                ", facFecCreacion=" + facFecCreacion +
                ", facUsrModificacion='" + facUsrModificacion + '\'' +
                ", facFecModificacion=" + facFecModificacion +
                '}';
    }
}
