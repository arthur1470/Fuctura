/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.semnome.controle;

import com.br.semnome.dao.HibernateUtil;
import com.br.semnome.dao.PessoaDAO;
import com.br.semnome.dao.PessoaDAOImpl;
import com.br.semnome.entidade.Pessoa;
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
@ManagedBean(name = "PessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

    private Pessoa pessoa;
    private PessoaDAO pessoaDAO;
    

    private String selecCPF;
    private List<Pessoa> listaPessoa = new ArrayList<Pessoa>();

    private static final String MANTER = "/pagina/manterPessoa";
    private static final String PESQUISAR = "/pagina/pesquisarPessoa";

    public PessoaBean() {
        pessoaDAO = new PessoaDAOImpl(HibernateUtil.getSessionFactory());
        pessoa = new Pessoa();
    }

    public void salvar() {
        try {
            pessoaDAO.salvar(getPessoa());

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
            listaPessoa = pessoaDAO.pesquisar(this.pessoa);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String editar() {

        try {
            pessoa = pessoaDAO.pesquisar(selecCPF);

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
            pessoaDAO.remover(new Pessoa(selecCPF));

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
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getSelecCPF() {
        return selecCPF;
    }

    public void setSelecCPF(String selecCPF) {
        this.selecCPF = selecCPF;
    }

    public List<Pessoa> getListaPessoa() {
        return listaPessoa;
    }

    public void setListaPessoa(List<Pessoa> listaPessoa) {
        this.listaPessoa = listaPessoa;
    }

}
