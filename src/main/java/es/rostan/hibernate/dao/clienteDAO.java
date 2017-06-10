package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 07/05/2017.
 */
public class clienteDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    @SuppressWarnings("unchecked")
    public List<cliente> lstClientes(){
        List<cliente> lstClientes = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        lstClientes = (List<cliente>) em.createQuery("SELECT c FROM cliente as c").getResultList();
        return lstClientes;
    }
}
