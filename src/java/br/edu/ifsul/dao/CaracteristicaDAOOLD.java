/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Caracteristica;
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
public class CaracteristicaDAOOLD implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<Caracteristica> listarTodos;

    public CaracteristicaDAOOLD(){
        
    }
    
    public void persist(Caracteristica obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Caracteristica obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(Caracteristica obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Caracteristica getObjectById(Integer id) throws Exception {
        return  em.find(Caracteristica.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Caracteristica> getListarTodos() {
        return em.createQuery("from Caracteristica order by nome").getResultList();
    }

    public void setListarTodos(List<Caracteristica> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
