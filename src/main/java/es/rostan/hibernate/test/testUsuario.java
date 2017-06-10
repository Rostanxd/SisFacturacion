package es.rostan.hibernate.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import es.rostan.hibernate.entidades.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostan on 07/05/2017.
 */
public class testUsuario {

    private static EntityManagerFactory emf = new Persistence().createEntityManagerFactory("Persistencia");

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        crearUsuario();
        imprimirUsuarios();
    }

    public static void crearUsuario(){

        EntityManager em = emf.createEntityManager();

        Date date = new Date();
        usuario u = new usuario("RSORIANO", "Roberth", "Soriano", "rostan", "A", date,"RSORIANO", date,"RSORIANO");

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }

    public static void imprimirUsuarios(){
        List<usuario> lstUsuario = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("select u from usuario  as u");

        lstUsuario = qry.getResultList();

        System.out.println("Los usuarios son...");
        for(usuario u : lstUsuario){
            System.out.println("-" + u.toString());
        }
    }
}
