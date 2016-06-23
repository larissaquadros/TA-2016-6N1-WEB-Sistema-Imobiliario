/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CobrancaAluguelDAO;
import br.edu.ifsul.modelo.CobrancaAluguel;
import br.edu.ifsul.modelo.CobrancaAluguelID;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleCobranca")
@ViewScoped
public class ControleCobranca implements Serializable{
    @EJB
    private CobrancaAluguelDAO<CobrancaAluguel> dao;
    private CobrancaAluguel objeto;
    
    public String listar(){
        return "/privado/cobrancas/listar?faces-redirect=true";
    }
    
    public void editar(CobrancaAluguelID id){
        try {
            objeto = dao.getObjectById(id);            
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao recuperar objeto");
        }
    }
    
    public void salvarPagamento(){
        try {
            dao.merge(objeto);
            UtilMensagens.mensagemInformacao("Pagamento efetuado");
        } catch(Exception e){
            UtilMensagens.mensagemErro("Erro ao persistir pagamento: "+
                    e.getMessage());
        }
            
    }

    public ControleCobranca() {
    }

    public CobrancaAluguelDAO<CobrancaAluguel> getDao() {
        return dao;
    }

    public void setDao(CobrancaAluguelDAO<CobrancaAluguel> dao) {
        this.dao = dao;
    }

    public CobrancaAluguel getObjeto() {
        return objeto;
    }

    public void setObjeto(CobrancaAluguel objeto) {
        this.objeto = objeto;
    }
    
    
}
