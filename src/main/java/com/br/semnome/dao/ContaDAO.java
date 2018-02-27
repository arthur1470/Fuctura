package com.br.semnome.dao;

import com.br.semnome.entidade.Conta;
import java.sql.SQLException;
import java.util.List;

public interface ContaDAO {
	public void salvar(Conta conta) throws SQLException;
	public void alterar(Conta conta) throws SQLException;
	public void remover(Conta conta) throws SQLException;
	public Conta pesquisar(String numero) throws SQLException;
	public List<Conta> recuperarTodos() throws SQLException;
        public List<Conta> pesquisar(Conta conta) throws SQLException;
}
