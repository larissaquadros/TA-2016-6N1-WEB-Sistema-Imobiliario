/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaJuridica;
import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Larissa
 */
@Stateless
public class PessoaJuridicaDAOOLD implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<PessoaJuridica> listarTodos;
    private List<Cidade> listarCidades;

    public PessoaJuridicaDAOOLD(){
        
    }
    
    public void persist(PessoaJuridica obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(PessoaJuridica obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(PessoaJuridica obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public PessoaJuridica getObjectById(Integer id) throws Exception {
        return  em.find(PessoaJuridica.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<PessoaJuridica> getListarTodos() {
        return em.createQuery("from PessoaJuridica order by nome").getResultList();
    }

    public void setListarTodos(List<PessoaJuridica> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public List<Estado> getListarCidades() {
        return em.createQuery("from Cidade order by nome").getResultList();
    }

    public void setListarCidades(List<Cidade> listarCidades) {
        this.listarCidades = listarCidades;
    }
    
    
}
