/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ContratoDAO;
import br.edu.ifsul.modelo.Contrato;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleContrato")
@ViewScoped
public class ControleContrato implements Serializable{
    @EJB
    private ContratoDAO dao;
    private Contrato objeto;

    public ControleContrato() {

    }
    
    public String listar(){
        return "/privado/contrato/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Contrato();
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            UtilMensagens.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao persistir objeto: "+e.getMessage());
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = dao.getObjectById(id);            
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }
            
    

    public ContratoDAO getDao() {
        return dao;
    }

    public void setDao(ContratoDAO dao) {
        this.dao = dao;
    }

    public Contrato getObjeto() {
        return objeto;
    }

    public void setObjeto(Contrato objeto) {
        this.objeto = objeto;
    }
}
