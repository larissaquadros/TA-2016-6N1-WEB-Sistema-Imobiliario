/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Contrato;
import br.edu.ifsul.modelo.Estado;
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
        super.setClassePersistente(Estado.class);
    }
}