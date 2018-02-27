/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.semnome.controle;

import com.br.semnome.dao.HibernateUtil;
import com.br.semnome.dao.ContaDAO;
import com.br.semnome.dao.ContaDAOImpl;
import com.br.semnome.entidade.Conta;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *

 */
@ManagedBean(name = "ContaBean")
@SessionScoped
public class ContaBean implements Serializable {

    private Conta conta;
    private ContaDAO contaDAO;
    

    private String selecNUMERO;
    private List<Conta> listaConta = new ArrayList<Conta>();

    private static final String MANTER = "/pagina/manterConta";
    private static final String PESQUISAR = "/pagina/pesquisarConta";

    public ContaBean() {
        contaDAO = new ContaDAOImpl(HibernateUtil.getSessionFactory());
        conta = new Conta();
    }

    public void salvar() {
        try {
            contaDAO.salvar(getConta());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Sucesso."));

        } catch (SQLException ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));

        }
    }

    public void pesquisar() {
        try {
            listaConta = contaDAO.pesquisar(this.conta);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public String editar() {

        try {
            conta = contaDAO.pesquisar(selecNUMERO);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Sucesso."));

        } catch (SQLException ex) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));

        }
        
          return MANTER;
    }

    public String deletar() {
        try {
            contaDAO.remover(new Conta(selecNUMERO));

            this.pesquisar();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sucesso."));

        } catch (SQLException ex) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
        }

        return PESQUISAR;
    }

    /**
     * @return the pessoa
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the pessoa to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getSelecNUMERO() {
        return selecNUMERO;
    }

    public void setSelecCPF(String selecNUMERO) {
        this.selecNUMERO= selecNUMERO;
    }

    public List<Conta> getListaConta() {
        return listaConta;
    }

    public void setListaConta(List<Conta> listaConta) {
        this.listaConta = listaConta;
    }

}

