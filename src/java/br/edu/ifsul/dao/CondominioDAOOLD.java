/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Condominio;
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
public class CondominioDAOOLD implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<Condominio> listarTodos;
    private List<Cidade> listarCidades;

    public CondominioDAOOLD(){
        
    }
    
    public void persist(Condominio obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Condominio obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(Condominio obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Condominio getObjectById(Integer id) throws Exception {
        return  em.find(Condominio.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Condominio> getListarTodos() {
        return em.createQuery("from Condominio order by nome").getResultList();
    } 

    public List<Cidade> getListarCidades() {
        return em.createQuery("from Cidade order by nome").getResultList();
    }
    
}
