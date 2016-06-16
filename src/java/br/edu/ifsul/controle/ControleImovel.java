/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.CondominioDAO;
import br.edu.ifsul.dao.ImovelDAO;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Imovel;
import br.edu.ifsul.modelo.Pessoa;
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
    
    @EJB
    private PessoaDAO<Pessoa> daoPessoa;
    
    @EJB
    private CondominioDAO<Condominio> daoCondominio;
    
    @EJB
    private CidadeDAO<Cidade> daoCidade;

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

    public PessoaDAO<Pessoa> getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO<Pessoa> daoPessoa) {
        this.daoPessoa = daoPessoa;
    }    

    public CondominioDAO<Condominio> getDaoCondominio() {
        return daoCondominio;
    }

    public void setDaoCondominio(CondominioDAO<Condominio> daoCondominio) {
        this.daoCondominio = daoCondominio;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
    
    
}
