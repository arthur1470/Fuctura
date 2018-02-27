/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.semnome.dao;

import com.br.semnome.entidade.Conta;
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
public class ContaDAOImpl implements ContaDAO, Serializable{

    private SessionFactory sf;

    public ContaDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void salvar(Conta conta) throws SQLException{
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.persist(conta);
        tx.commit();
        
    }

    @Override
    public void alterar(Conta conta) throws SQLException {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.merge(conta);
        tx.commit();
    }

    @Override
    public void remover(Conta conta) throws SQLException {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.delete(conta);
        tx.commit();
    }

    public Conta pesquisar(Long numero) throws SQLException{
        
        Session session = sf.openSession();
        
        Conta conta = (Conta) session.get(Conta.class, numero);
        return conta;
    }

    @Override
    public List<Conta> recuperarTodos() throws SQLException{
        Session session = sf.openSession();
        org.hibernate.Query query = session.createQuery("from Conta e");
        List<Conta> contas = query.list();
        return contas;
    }

    @Override
    public Conta pesquisar(String numero) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conta> pesquisar(Conta conta) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
