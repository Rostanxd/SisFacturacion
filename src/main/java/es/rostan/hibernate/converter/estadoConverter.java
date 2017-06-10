package es.rostan.hibernate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by Rostan on 08/05/2017.
 */
@FacesConverter("estadoConverter")
public class estadoConverter implements Converter {

    public Object getAsObject(FacesContext contect, UIComponent component, String value){
        return value;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value){
        String estado = "";

        if(value != null) {
            estado = (String) value;
            if (estado.equals("A")) {
                estado = "Activo";

            } else if (estado.equals("P")) {
                estado = "Procesado";

            } else if (estado.equals("N")){
                estado = "Anulado";
            }
        }
        return estado;
    }
}
