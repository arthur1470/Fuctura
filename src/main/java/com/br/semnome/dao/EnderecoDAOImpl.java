/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.semnome.dao;

import com.br.semnome.entidade.Endereco;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Cleiton
 */
public class EnderecoDAOImpl implements EnderecoDAO, Serializable{

    private SessionFactory sf;

    public EnderecoDAOImpl(SessionFactory em) {
        this.sf = sf;
    }

    @Override
    public void salvar(Endereco end) throws SQLException{
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.persist(end);
        tx.commit();
        
    }

    @Override
    public void alterar(Endereco end) throws SQLException {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.merge(end);
        tx.commit();
    }

    @Override
    public void remover(Endereco end) throws SQLException {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.delete(end);
        tx.commit();
    }

    @Override
    public Endereco pesquisar(Long id) throws SQLException{
        
        Session session = sf.openSession();
        
        Endereco end = (Endereco) session.get(Endereco.class, id);
        return end;
    }

    @Override
    public List<Endereco> recuperarTodos() throws SQLException{
        Session session = sf.openSession();
        org.hibernate.Query query = session.createQuery("from Endereco e");
        List<Endereco> enderecos = query.list();
        return enderecos;
    }

    
}
