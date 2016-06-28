/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Imovel;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class ImovelDAO <T> extends DAOGenerico<Imovel> implements Serializable{
    
    public ImovelDAO(){
        super();
        super.setClassePersistente(Imovel.class);
    }
    
    @Override
    public Imovel getObjectById(Integer id) throws Exception {
        Imovel  obj = (Imovel) super.getEm().find(super.getClassePersistente(), id);
        obj.getCaracteristicas().size();
        return obj;
    } 
    
    @Override
    public void remove(Imovel obj) throws Exception {
        Imovel objeto = super.getEm().find(Imovel.class, obj.getId());
        super.getEm().remove(objeto);
    }
}
