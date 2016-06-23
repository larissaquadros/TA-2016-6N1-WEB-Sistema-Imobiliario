/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.PessoaJuridicaDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaJuridica;
import br.edu.ifsul.modelo.Telefone;
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
    
    @EJB
    private CidadeDAO<Cidade> daoCidade;
    
    private Telefone telefone;
    private Boolean novoTelefone;

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

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
    
    public void novoTelefone(){
         setTelefone(new Telefone());
         setNovoTelefone((Boolean)true);
    }
    
    public void alterarTelefone(int index){
        setTelefone(objeto.getTelefones().get(index));
        setNovoTelefone((Boolean) false);
    }
    
    public void removerTelefone(int index){
        objeto.removerTelefone(index);
        UtilMensagens.mensagemInformacao("Telefone removido com sucesso");
    }
    
    public void savarTelefone(){
        if(getNovoTelefone()){
            objeto.adicionarTelefone(getTelefone());
        }
       
        UtilMensagens.mensagemInformacao("Alteração realizada com sucesso");
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Boolean getNovoTelefone() {
        return novoTelefone;
    }

    public void setNovoTelefone(Boolean novoTelefone) {
        this.novoTelefone = novoTelefone;
    }
}
