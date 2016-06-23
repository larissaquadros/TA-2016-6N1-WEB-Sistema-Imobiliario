/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ContratoDAO;
import br.edu.ifsul.dao.ImovelDAO;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.CobrancaAluguel;
import br.edu.ifsul.modelo.Contrato;
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
@ManagedBean(name = "controleContrato")
@ViewScoped
public class ControleContrato implements Serializable{
    @EJB
    private ContratoDAO<Contrato> dao;
    private Contrato objeto;

    @EJB
    private PessoaDAO<Pessoa> daoPessoa;
    
    @EJB
    private ImovelDAO<Imovel> daoImovel;
    
    
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
            
    public Contrato getObjeto() {
        return objeto;
    }

    public void setObjeto(Contrato objeto) {
        this.objeto = objeto;
    }

    public ContratoDAO<Contrato> getDao() {
        return dao;
    }

    public void setDao(ContratoDAO<Contrato> dao) {
        this.dao = dao;
    }

    public PessoaDAO<Pessoa> getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO<Pessoa> daoPessoa) {
        this.daoPessoa = daoPessoa;
    }

    public ImovelDAO<Imovel> getDaoImovel() {
        return daoImovel;
    }

    public void setDaoImovel(ImovelDAO<Imovel> daoImovel) {
        this.daoImovel = daoImovel;
    }
    
    public void gerarCobrancas() {
        boolean temPagamento = false;
        for (CobrancaAluguel p : objeto.getListaCobrancas()) {
            if (p.getDataPagamento() != null || p.getValorPagamento() != null) {
                temPagamento = true;
            }
        }
        if (!temPagamento) {
            objeto.getListaCobrancas().clear();
            objeto.gerarCobrancas();
            UtilMensagens.mensagemInformacao("Cobranças geradas com sucesso!");
        } else {
            UtilMensagens.mensagemErro("Cobranças não podem ser geradas novamente "
                    + "por já existir um pagamento!");
        }

    }
    
    
}
