package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 07/05/2017.
 */
@Embeddable
public class facturaDetPK implements Serializable {
    @Column(name = "facAnio")
    private Integer facAnio;

    @Column(name = "facNumero")
    private Integer facNumero;

    @Column(name = "facLinea")
    private Integer facLinea;

    public facturaDetPK() {
    }

    public facturaDetPK(Integer facAnio, Integer facNumero, Integer facLinea) {
        this.facAnio = facAnio;
        this.facNumero = facNumero;
        this.facLinea = facLinea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        facturaDetPK that = (facturaDetPK) o;

        if (!facAnio.equals(that.facAnio)) return false;
        if (!facNumero.equals(that.facNumero)) return false;
        return facLinea.equals(that.facLinea);

    }

    @Override
    public int hashCode() {
        int result = facAnio.hashCode();
        result = 31 * result + facNumero.hashCode();
        result = 31 * result + facLinea.hashCode();
        return result;
    }
}
