/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ImovelDAO;
import br.edu.ifsul.modelo.Imovel;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleImovel")
@ViewScoped
public class ControleImovel implements Serializable{
    @EJB
    private ImovelDAO<Imovel> dao;
    private Imovel objeto;

    public ControleImovel() {

    }
    
    public String listar(){
        return "/privado/imovel/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Imovel();
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
            
    public Imovel getObjeto() {
        return objeto;
    }

    public void setObjeto(Imovel objeto) {
        this.objeto = objeto;
    }

    public ImovelDAO<Imovel> getDao() {
        return dao;
    }

    public void setDao(ImovelDAO<Imovel> dao) {
        this.dao = dao;
    }
    
    
}
