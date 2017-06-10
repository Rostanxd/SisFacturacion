package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 07/05/2017.
 */
public class productoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    @SuppressWarnings("unchecked")
    public List<producto> lstProductos(){
        List<producto> lstProducto = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        lstProducto = (List<producto>) em.createQuery("SELECT p FROM producto as p WHERE p.prdEstado = 'A'").getResultList();
        return lstProducto;
    }

    public void ingresarProducto(producto producto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }
}
