/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class CidadeDAO <T> extends DAOGenerico<Cidade> implements Serializable{
    
    public CidadeDAO(){
        super();
        super.setClassePersistente(Cidade.class);
    }
}
