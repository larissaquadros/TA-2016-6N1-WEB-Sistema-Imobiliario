/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Telefone;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controlePessoaFisica")
@ViewScoped
public class ControlePessoaFisica implements Serializable{
    @EJB
    private PessoaFisicaDAO<PessoaFisica> dao;
    private PessoaFisica objeto;
    
    @EJB
    private CidadeDAO<Cidade> daoCidade;
    
    private Telefone telefone;
    private Boolean novoTelefone;

    public ControlePessoaFisica() {

    }
    
    public String listar(){
        return "/privado/pessoafisica/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new PessoaFisica();
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
            
    public PessoaFisica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaFisica objeto) {
        this.objeto = objeto;
    }

    public PessoaFisicaDAO<PessoaFisica> getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDAO<PessoaFisica> dao) {
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
