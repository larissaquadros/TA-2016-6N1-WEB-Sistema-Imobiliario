/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Imovel;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.PessoaJuridica;
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
public class ImovelDAO implements Serializable{
    @PersistenceContext(unitName = "TA-2016-6N1-WEB-Sistema-ImobiliarioPU")
    private EntityManager em;
    private List<Imovel> listarTodos;
    private List<Cidade> listarCidades;
    private List<Condominio> listarCondominios;
    private List<PessoaFisica> listarPessoasFiscas;
    private List<PessoaJuridica> listarPessoasJuridicas;
    

    public ImovelDAO(){
        
    }
    
    public void persist(Imovel obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Imovel obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(Imovel obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Imovel getObjectById(Integer id) throws Exception {
        return  em.find(Imovel.class, id);
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Imovel> getListarTodos() {
        return em.createQuery("from Imovel order by id").getResultList();
    }

    public void setListarTodos(List<Imovel> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public List<Estado> getListarCidades() {
        return em.createQuery("from Cidade order by nome").getResultList();
    }

    public void setListarCidades(List<Cidade> listarCidades) {
        this.listarCidades = listarCidades;
    }

    public List<Condominio> getListarCondominios() {
        return em.createQuery("from Condominio order by nome").getResultList();
    }

    public void setListarCondominios(List<Condominio> listarCondominios) {
        this.listarCondominios = listarCondominios;
    }

    public List<PessoaFisica> getListarPessoasFiscas() {
         return em.createQuery("from PessoaFisica order by nome").getResultList();
    }

    public void setListarPessoasFiscas(List<PessoaFisica> listarPessoasFiscas) {
        this.listarPessoasFiscas = listarPessoasFiscas;
    }

    public List<PessoaJuridica> getListarPessoasJuridicas() {
         return em.createQuery("from PessoaJuridica order by nome").getResultList();
    }

    public void setListarPessoasJuridicas(List<PessoaJuridica> listarPessoasJuridicas) {
        this.listarPessoasJuridicas = listarPessoasJuridicas;
    }
    
    
    
    
}
