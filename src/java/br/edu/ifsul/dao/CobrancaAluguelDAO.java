/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.CobrancaAluguel;
import br.edu.ifsul.modelo.CobrancaAluguelID;
import br.edu.ifsul.modelo.Contrato;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Larissa
 */
@Stateful
public class CobrancaAluguelDAO <T> extends DAOGenerico<CobrancaAluguel> implements Serializable{
    private Boolean filtroVencimento = false;
    private Calendar dataInicial;
    private Calendar dataFinal;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public CobrancaAluguelDAO() {
        super();
        super.setClassePersistente(CobrancaAluguel.class);
    }

    public CobrancaAluguel getObjectById(CobrancaAluguelID id) throws Exception {
        CobrancaAluguelID idObj = new CobrancaAluguelID();
        idObj.setId(id.getId());
        idObj.setContrato(super.getEm().find(Contrato.class, id.getContrato().getId()));
        CobrancaAluguel obj = super.getEm().find(CobrancaAluguel.class, idObj);
        return obj;
    }
    
    @Override
    public List<CobrancaAluguel> getListaObjetos() {
        String jpql = "from " + super.getClassePersistente().getSimpleName();
        String where = "";
        if (super.getFiltro().length() > 0) {
            if (super.getOrdem().equals("cobrancaID.numero")) {
                try {
                    Integer.parseInt(super.getFiltro());
                    where += " where " + super.getOrdem() + " = '" + super.getFiltro() + "' ";
                } catch (Exception e) {

                }
            } else {
                where += " where upper(" + super.getOrdem() + ") like '"
                        + super.getFiltro().toUpperCase() + "%' ";
            }
        }
        if (filtroVencimento) {
            if (!(where.length() > 0)) {
                where += " where ";
            } else {
                where += " and ";
            }
            where += " vencimento >= '" + sdf.format(dataInicial.getTime())
                    + "' and vencimento <= '" + sdf.format(dataFinal.getTime()) + "' ";
        }
        jpql += where;
        jpql += " order by " + super.getOrdem();        
        super.setTotalObjetos(super.getEm().createQuery("select id from "
                + super.getClassePersistente().getSimpleName()
                + where + " order by " + super.getOrdem()).getResultList().size());
        return super.getEm().createQuery(jpql).setFirstResult(super.getPosicaoAtual()).
                setMaxResults(super.getMaximoObjetos()).getResultList();
    }

    public Boolean getFiltroVencimento() {
        return filtroVencimento;
    }

    public void setFiltroVencimento(Boolean filtroVencimento) {
        this.filtroVencimento = filtroVencimento;
    }

    public Calendar getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Calendar dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Calendar getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }
}
