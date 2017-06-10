package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.clienteDAO;
import es.rostan.hibernate.dao.facturaDAO;
import es.rostan.hibernate.dao.productoDAO;
import es.rostan.hibernate.entidades.cliente;
import es.rostan.hibernate.entidades.facturaCab;
import es.rostan.hibernate.entidades.facturaDet;
import es.rostan.hibernate.entidades.producto;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostan on 07/05/2017.
 */
@ManagedBean
@ViewScoped
public class facturaBean {

    private facturaCab facturaCab;

    private cliente clienteSelected;

    private Set<facturaDet> lstFacturaDet = new HashSet<>();

    private producto productoSelected = new producto();

//    CONSTRUCTOR
    public facturaBean(){
    }

    @PostConstruct
    public void init(){
        iniciarFactura();
    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.facturaCab getFacturaCab() {
        return facturaCab;
    }

    public void setFacturaCab(es.rostan.hibernate.entidades.facturaCab facturaCab) {
        this.facturaCab = facturaCab;
    }

    public cliente getClienteSelected() {
        return clienteSelected;
    }

    public void setClienteSelected(cliente clienteSelected) {
        this.clienteSelected = clienteSelected;
    }

    public Set<facturaDet> getLstFacturaDet() {
        return lstFacturaDet;
    }

    public void setLstFacturaDet(Set<facturaDet> lstFacturaDet) {
        this.lstFacturaDet = lstFacturaDet;
    }

    public producto getProductoSelected() {
        return productoSelected;
    }

    public void setProductoSelected(producto productoSelected) {
        this.productoSelected = productoSelected;
    }

    //    METODOS
    public void iniciarFactura(){
        facturaDAO facturaDAO = new facturaDAO();
        this.facturaCab = facturaDAO.iniciarFactura();
        this.lstFacturaDet.clear();
    }

    public void asignarCliente(cliente cliente){
        this.facturaCab.setCliente(cliente);
    }

    public void agregarProducto(producto producto){
        this.productoSelected = producto;

        Integer facLinea = 0;
        for(facturaDet fd : this.lstFacturaDet){
            facLinea += 1;
        }

        facturaDet facturaDet = new facturaDet();
        facturaDet.setFacAnio(this.facturaCab.getFacAnio());
        facturaDet.setFacNumero(this.facturaCab.getFacNumero());
        facturaDet.setFacLinea(facLinea + 1);
        facturaDet.setProducto(this.productoSelected);
        this.lstFacturaDet.add(facturaDet);

        this.productoSelected = null;
    }

    public void procesarFactura(){
        this.facturaCab.setCliente(clienteSelected);
        this.facturaCab.setFacEstado("P");

        this.calculaSubTotales();
        this.facturaCab.setLstFacturasDet(this.lstFacturaDet);

        facturaDAO facturaDAO = new facturaDAO();
        facturaDAO.procesarFactura(this.facturaCab);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("D'Carol",  "Factura guardada correctamente") );
    }

    private void calculaSubTotales(){
        for (facturaDet fd : lstFacturaDet){
            fd.setFacTotLineal(fd.getFacCantidad()*fd.getFacPrecio());
        }
    }

    public void nuevaFactura(){
        this.iniciarFactura();
    }
}

