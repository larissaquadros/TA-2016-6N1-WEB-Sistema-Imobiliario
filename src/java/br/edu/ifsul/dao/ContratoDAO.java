/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Contrato;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class ContratoDAO <T> extends DAOGenerico<Contrato> implements Serializable{
    
    public ContratoDAO(){
        super();
        super.setClassePersistente(Contrato.class);
    }
    
    @Override
    public Contrato getObjectById(Integer id) throws Exception {
        Contrato  obj = (Contrato) super.getEm().find(super.getClassePersistente(), id);
        obj.getListaCobrancas().size();
        return obj;
    } 
}
