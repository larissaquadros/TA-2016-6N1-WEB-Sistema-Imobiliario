/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleRelatorio")
@SessionScoped
public class ControleRelatorios implements Serializable{
    @EJB
    private EstadoDAO<Estado> daoEstado;
    
    @EJB
    private CidadeDAO<Cidade> daoCidade;

    public ControleRelatorios() {
        
    } 
    
    public void imprimeRelatorioEstados(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioEstadosBeans", parametros, daoEstado.getListaTodos());
    }
    
    public void imprimeRelatorioCidades(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioCidades", parametros, daoCidade.getListaTodos());
    }

    public EstadoDAO<Estado> getDaoEstado() {
        return daoEstado;
    }

    public void setDaoEstado(EstadoDAO<Estado> daoEstado) {
        this.daoEstado = daoEstado;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
    
    
    
}
