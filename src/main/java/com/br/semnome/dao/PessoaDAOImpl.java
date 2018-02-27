/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.semnome.dao;

import com.br.semnome.entidade.Pessoa;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Cleiton
 */
public class PessoaDAOImpl implements PessoaDAO, Serializable {

    private SessionFactory sf;

    public PessoaDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void salvar(Pessoa pessoa) throws SQLException{
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.persist(pessoa);
        tx.commit();
        
    }

    @Override
    public void alterar(Pessoa pessoa) throws SQLException {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.merge(pessoa);
        tx.commit();
    }

    @Override
    public void remover(Pessoa pessoa) throws SQLException {
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.delete(pessoa);
        tx.commit();
    }

    @Override
    public Pessoa pesquisar(String cpf) throws SQLException{
        
        Session session = sf.openSession();
        
        Pessoa pessoa = (Pessoa) session.get(Pessoa.class, cpf);
        return pessoa;
    }
    
    
    @Override
    public List<Pessoa> recuperarTodos() throws SQLException{
        Session session = sf.openSession();
        Query query = session.createQuery("from Pessoa p");
        List<Pessoa> pessoas = query.list();
        return pessoas;
    }
    
    public List<Pessoa> pesquisar(Pessoa pessoa) throws SQLException{
        
        Session session = sf.openSession();
        Query query = session.createQuery("from Pessoa p where 1=1 " + montarWherePesquisa(pessoa));
        List<Pessoa> pessoas = query.list();
        return pessoas;
    }

    private String montarWherePesquisa(Pessoa pessoa) {
        String where = "";
        if(pessoa.getNome()!= null && !pessoa.getNome().isEmpty()){
            where +="and UPPER(p.nome) like UPPER('%"+ pessoa.getNome()+"%')";
            
        }
        if(pessoa.getCpf()!= null && !pessoa.getCpf().isEmpty()){
            where += "and p.cpf = '" + pessoa.getCpf()+"'";
            
        }
        if(pessoa.getSexo()!=null && !pessoa.getSexo().isEmpty()){
            where += " and p.sexo= '" + pessoa.getSexo () +"'";
            
        }
        if(pessoa.getIdade()!= null && pessoa.getIdade()!=0){
            where += " and p.idade >= " + pessoa.getIdade ();
            
        }
        
        return where;
    }
}
