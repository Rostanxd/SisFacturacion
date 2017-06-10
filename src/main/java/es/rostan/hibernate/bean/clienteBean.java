package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.clienteDAO;
import es.rostan.hibernate.entidades.cliente;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 07/05/2017.
 */
@ManagedBean
@ViewScoped
public class clienteBean {

    private cliente cliente = new cliente();

    private List<cliente> lstClientes = new ArrayList<>();

    private String btnAccion;

    public clienteBean(){

    }

    public es.rostan.hibernate.entidades.cliente getCliente() {
        return cliente;
    }

    public void setCliente(es.rostan.hibernate.entidades.cliente cliente) {
        this.cliente = cliente;
    }

    public List<es.rostan.hibernate.entidades.cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<es.rostan.hibernate.entidades.cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }

//    METODOS
    public void buscarClientes(){
        clienteDAO clienteDAO = new clienteDAO();
        this.lstClientes = clienteDAO.lstClientes();
    }
}
