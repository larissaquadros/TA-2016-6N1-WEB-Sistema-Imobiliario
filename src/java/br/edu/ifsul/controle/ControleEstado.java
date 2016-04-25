/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleEstado")
@ViewScoped
public class ControleEstado implements Serializable{
    @EJB
    private EstadoDAO dao;
    private Estado objeto;

    public ControleEstado() {

    }
    
    public String listar(){
        return "/privado/estado/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Estado();
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
            
    

    public EstadoDAO getDao() {
        return dao;
    }

    public void setDao(EstadoDAO dao) {
        this.dao = dao;
    }

    public Estado getObjeto() {
        return objeto;
    }

    public void setObjeto(Estado objeto) {
        this.objeto = objeto;
    }
}
