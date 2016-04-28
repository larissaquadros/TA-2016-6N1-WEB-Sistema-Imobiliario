/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaFisica;
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
public class PessoaFisicaDAO implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<PessoaFisica> listarTodos;
    private List<Cidade> listarCidades;

    public PessoaFisicaDAO(){
        
    }
    
    public void persist(PessoaFisica obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(PessoaFisica obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(PessoaFisica obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public PessoaFisica getObjectById(Integer id) throws Exception {
        return  em.find(PessoaFisica.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<PessoaFisica> getListarTodos() {
        return em.createQuery("from PessoaFisica order by nome").getResultList();
    }

    public void setListarTodos(List<PessoaFisica> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public List<Estado> getListarCidades() {
        return em.createQuery("from Cidade order by nome").getResultList();
    }

    public void setListarCidades(List<Cidade> listarCidades) {
        this.listarCidades = listarCidades;
    }
    
    
}
