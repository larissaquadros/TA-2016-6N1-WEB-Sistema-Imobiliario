/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

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
public class EstadoDAO implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<Estado> listarTodos;

    public EstadoDAO(){
        
    }
    
    public void persist(Estado obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Estado obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(Estado obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Estado getObjectById(Integer id) throws Exception {
        return  em.find(Estado.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Estado> getListarTodos() {
        return em.createQuery("from Estado order by nome").getResultList();
    }

    public void setListarTodos(List<Estado> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
