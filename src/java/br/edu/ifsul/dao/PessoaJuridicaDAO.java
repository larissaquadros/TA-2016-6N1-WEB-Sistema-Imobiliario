/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaJuridica;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class PessoaJuridicaDAO <T> extends DAOGenerico<PessoaJuridica> implements Serializable{
    
    public PessoaJuridicaDAO(){
        super();
        super.setClassePersistente(Estado.class);
    }
}
