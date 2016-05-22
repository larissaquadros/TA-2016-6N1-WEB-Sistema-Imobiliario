/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

stateful = um pra cada  e morre quando é fechado
stateles = um pra todos enquanti tiver gente conectado
stat = fica pra sempre estanciado
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class EstadoDAO<T> extends DAOGenerico<Estado> implements Serializable{
    
    public EstadoDAO(){
        super();
        super.setClassePersistente(Estado.class);
    }
}
