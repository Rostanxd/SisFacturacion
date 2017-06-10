package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.facturaCab;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostan on 07/05/2017.
 */
public class facturaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public facturaCab iniciarFactura(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int anio = cal.get(Calendar.YEAR);

        facturaCab nuevaFactura = new facturaCab();
        nuevaFactura.setFacAnio(anio);
        nuevaFactura.setFacNumero(facSecuencia(anio));
        nuevaFactura.setFacEstado("A");
        nuevaFactura.setFacTotDocmnto(0.0);
        nuevaFactura.setFacUsrCreacion("RSORIANO");
        nuevaFactura.setFacFecCreacion(date);
        nuevaFactura.setFacUsrModificacion("RSORIANO");
        nuevaFactura.setFacFecha(date);
        nuevaFactura.setFacFecModificacion(date);

        return nuevaFactura;
    }

    public Integer facSecuencia(Integer facAnio){

        Integer secuencia = 0;
        List<facturaCab> lstFacturaCab = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("select f from facturaCab as f where f.facAnio = :facAnio order by f.facNumero desc ");
        qry.setParameter("facAnio", facAnio);

        lstFacturaCab = (List<facturaCab>) qry.setMaxResults(1).getResultList();

        if(lstFacturaCab.size() == 0) {
            secuencia = 1;
        }else{
            for (facturaCab fc : lstFacturaCab){
                secuencia = fc.getFacNumero() + 1;
            }
        }
        return secuencia;
    }

    public void procesarFactura(facturaCab facturaCab){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(facturaCab);
        em.getTransaction().commit();
        em.close();
    }
}
