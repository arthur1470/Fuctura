package com.br.semnome.dao;

import com.br.semnome.entidade.Pessoa;
import java.sql.SQLException;
import java.util.List;

public interface PessoaDAO {
	public void salvar(Pessoa pessoa) throws SQLException;
	public void alterar(Pessoa pessoa) throws SQLException;
	public void remover(Pessoa pessoa) throws SQLException;
	public Pessoa pesquisar(String cpf) throws SQLException;
	public List<Pessoa> recuperarTodos() throws SQLException;
        public List<Pessoa> pesquisar(Pessoa pessoa) throws SQLException;
}

