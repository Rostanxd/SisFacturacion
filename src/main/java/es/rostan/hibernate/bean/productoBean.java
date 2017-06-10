package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.productoDAO;
import es.rostan.hibernate.entidades.producto;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostan on 07/05/2017.
 */
@ManagedBean
@ViewScoped
public class productoBean {

    private producto producto = new producto();

    private List<producto> lstProductos = new ArrayList<>();

    private String btnAccion = "";

    public productoBean(){

    }

    @PostConstruct
    private void init(){
        this.buscarProductos();
    }

    public es.rostan.hibernate.entidades.producto getProducto() {
        return producto;
    }

    public void setProducto(es.rostan.hibernate.entidades.producto producto) {
        this.producto = producto;
    }

    public List<es.rostan.hibernate.entidades.producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<es.rostan.hibernate.entidades.producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
        if (btnAccion.equals("Ingresar")){
            this.limpiar();
        }
    }

//    METODOS
    public void buscarProductos(){
        productoDAO pd = new productoDAO();
        this.lstProductos = pd.lstProductos();
    }

    public void limpiar(){
        Date date = new Date();

        this.producto.setPrdCodigo("");
        this.producto.setPrdNombre("");
        this.producto.setPrdEstado("A");
        this.producto.setPrdCosto(0.0);
        this.producto.setPrdPrecio(0.0);
        this.producto.setPrdUsrCreacion("RSRORIANO");
        this.producto.setPrdFecCreacion(date);
        this.producto.setPrdUsrModificacion("RSRORIANO");
        this.producto.setPrdFecModificacion(date);
    }

    public void operar() throws Exception{
        switch (btnAccion){
            case "Ingresar":
                this.ingresarProducto();
                this.limpiar();
                break;
            case "Actualizar":
                break;
            case "Anular":
                break;
        }
    }

    public void ingresarProducto(){
        productoDAO productoDAO = new productoDAO();
        productoDAO.ingresarProducto(this.producto);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto ingresado correctamente.","Exito"));
    }

    public void actualizarProducto(){

    }

    public void anularProducto(){

    }

}
