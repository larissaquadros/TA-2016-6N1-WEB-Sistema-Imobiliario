/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PessoaJuridicaDAO;
import br.edu.ifsul.modelo.PessoaJuridica;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controlePessoaJuridica")
@ViewScoped
public class ControlePessoaJuridica implements Serializable{
    @EJB
    private PessoaJuridicaDAO<PessoaJuridica> dao;
    private PessoaJuridica objeto;

    public ControlePessoaJuridica() {

    }
    
    public String listar(){
        return "/privado/pessoajuridica/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new PessoaJuridica();
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
           
    public PessoaJuridica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaJuridica objeto) {
        this.objeto = objeto;
    }

    public PessoaJuridicaDAO<PessoaJuridica> getDao() {
        return dao;
    }

    public void setDao(PessoaJuridicaDAO<PessoaJuridica> dao) {
        this.dao = dao;
    }
    
    
}
