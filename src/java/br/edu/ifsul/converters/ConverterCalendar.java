/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Larissa
 */
@FacesConverter(value = "converterCalendar")
public class ConverterCalendar implements Serializable, Converter{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
         if (string == null){
            return null;
        }
        try {
            Calendar obj = Calendar.getInstance();
            obj.setTime(sdf.parse(string));
            return obj;
        } catch (Exception e){
            return null;
        }
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
         if (o == null){
            return null;
        }
        Calendar obj = (Calendar) o;
        return sdf.format(obj.getTime());       
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
