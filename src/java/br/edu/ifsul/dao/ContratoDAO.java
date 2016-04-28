/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Contrato;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Imovel;
import br.edu.ifsul.modelo.PessoaFisica;
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
public class ContratoDAO implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<Contrato> listarTodos;
    private List<PessoaFisica> listarPessoasFisicas;
    private List<Imovel> listarImovel;

    public ContratoDAO(){
        
    }
    
    public void persist(Contrato obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Contrato obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(Contrato obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Contrato getObjectById(Integer id) throws Exception {
        return  em.find(Contrato.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Contrato> getListarTodos() {
        return em.createQuery("from Contrato order by id").getResultList();
    }

    public void setListarTodos(List<Contrato> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public List<PessoaFisica> getListarPessoasFisicas() {
         return em.createQuery("from PessoaFisica order by nome").getResultList();
    }

    public void setListarPessoasFisicas(List<PessoaFisica> listarPessoasFisicas) {
        this.listarPessoasFisicas = listarPessoasFisicas;
    }

    public List<Imovel> getListarImovel() {
        return em.createQuery("from Imovel order by id").getResultList();
    }

    public void setListarImovel(List<Imovel> listarImovel) {
        this.listarImovel = listarImovel;
    }

   
    
    
}
