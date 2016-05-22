/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class PessoaFisicaDAO <T> extends DAOGenerico<PessoaFisica> implements Serializable{
    
    public PessoaFisicaDAO(){
        super();
        super.setClassePersistente(Estado.class);
    }
}
