/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
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
public class CidadeDAO implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<Cidade> listarTodos;
    private List<Estado> listarEstados;

    public CidadeDAO(){
        
    }
    
    public void persist(Cidade obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Cidade obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(Cidade obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Cidade getObjectById(Integer id) throws Exception {
        return  em.find(Cidade.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Cidade> getListarTodos() {
        return em.createQuery("from Cidade order by nome").getResultList();
    }

    public void setListarTodos(List<Cidade> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public List<Estado> getListarEstados() {
        return em.createQuery("from Estado order by nome").getResultList();
    }

    public void setListarEstados(List<Estado> listarEstados) {
        this.listarEstados = listarEstados;
    }
    
    
}
