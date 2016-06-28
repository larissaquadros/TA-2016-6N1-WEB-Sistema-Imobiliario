/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Caracteristica;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class CaracteristicaDAO<T> extends DAOGenerico<Caracteristica> implements Serializable{
    
    public CaracteristicaDAO(){
        super();
        super.setClassePersistente(Caracteristica.class);
    }
    
    @Override
    public Caracteristica getObjectById(Integer id) throws Exception {
        Caracteristica  obj = (Caracteristica) super.getEm().find(super.getClassePersistente(), id);
        obj.getCaracteristicas().size();
        return obj;
    } 
    
    
}
