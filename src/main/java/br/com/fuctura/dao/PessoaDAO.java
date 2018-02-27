package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.model.Pessoa;

public interface PessoaDAO {

	void salvar(Pessoa pessoa) throws Exception;

	void alterar(Pessoa pessoa) throws Exception;

	void remover(Pessoa pessoa) throws Exception;

	Pessoa pesquisar(String cpf) throws Exception;

	List<Pessoa> pesquisar(Pessoa pessoa) throws Exception;

	List<Pessoa> todas() throws Exception;
}
