/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.semnome.dao;

import com.br.semnome.entidade.Endereco;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cleiton
 */
public interface EnderecoDAO {
    
    public void salvar(Endereco endereco) throws SQLException;
    
    public void alterar(Endereco endereco) throws SQLException;
    
    public void remover(Endereco endereco) throws SQLException;
    
    public Endereco pesquisar(Long id) throws SQLException;
    
    public List<Endereco> recuperarTodos() throws SQLException;
}
