package br.com.fuctura.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fuctura.dao.PessoaDAO;
import br.com.fuctura.dao.PessoaDAOImpl;
import br.com.fuctura.model.Pessoa;
import br.com.fuctura.util.HibernateUtil;
import br.com.fuctura.util.MensagensUtil;

@ManagedBean(name = "pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String MANTER = "manterPessoa";
//	private static final String PESQUISAR = "pesquisarPessoa";
	
	private Pessoa pessoa;
	private Pessoa pessoaEditar;
	private PessoaDAO pessoaDAO;
	private List<Pessoa> pessoas;
	
	public PessoaBean() {
		pessoaDAO = new PessoaDAOImpl(HibernateUtil.getSessionFactory());
		pessoa = new Pessoa();
		pessoaEditar = new Pessoa();
	}
	
	public void salvar() {		
		try {
			pessoaDAO.salvar(this.pessoa);
			MensagensUtil.info("Pessoa cadastrada com sucesso!");
		} catch (Exception e) {
			MensagensUtil.error("Não foi possível cadastrar essa pessoa.");			
		}	
		pessoa = new Pessoa();		
	}
	
	public void editar() {
		try {
			pessoaDAO.alterar(this.pessoaEditar);			
		} catch (Exception e) {}
	}
	
	public void remover(Pessoa pessoa) {
		try {
			pessoaDAO.remover(pessoa);
			pesquisar();
			Thread.sleep(600);
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
	public void prepararEditar(Pessoa pessoa) {
		this.pessoaEditar = pessoa;
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {}
		
	}
	
	public void pesquisar(){
		try {
			this.pessoas = pessoaDAO.pesquisar(this.pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//Getters and setters
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Pessoa getPessoaEditar() {
		return pessoaEditar;
	}

}
