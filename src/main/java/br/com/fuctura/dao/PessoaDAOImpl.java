package br.com.fuctura.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.fuctura.model.Pessoa;

public class PessoaDAOImpl implements PessoaDAO {

	private SessionFactory factory;

	public PessoaDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void salvar(Pessoa pessoa) throws Exception {
		Session session = factory.openSession();
		Transaction trx = null;

		trx = session.beginTransaction();
		session.persist(pessoa);

		trx.commit();
		session.close();
	}

	@Override
	public void alterar(Pessoa pessoa) throws Exception {
		Session session = factory.openSession();
		Transaction trx = null;

		trx = session.beginTransaction();
		session.merge(pessoa);
		trx.commit();

		session.close();

	}

	@Override
	public void remover(Pessoa pessoa) throws Exception {
		Session session = factory.openSession();
		Transaction trx = null;

		trx = session.beginTransaction();
		session.delete(pessoa);
		trx.commit();

		session.close();
	}

	@Override
	public Pessoa pesquisar(String cpf) throws Exception {
		Session session = factory.openSession();

		Pessoa pessoa = (Pessoa) session.get(Pessoa.class, cpf);

		session.close();
		return pessoa;
	}

	@Override
	public List<Pessoa> pesquisar(Pessoa pessoa) throws Exception {
		Session session = factory.openSession();
		Query query = session.createQuery("SELECT p FROM Pessoa p WHERE 1=1 " + montarWherePesquisa(pessoa));
		List<Pessoa> pessoas = query.list();
		session.close();
		return pessoas;
	}

	private String montarWherePesquisa(Pessoa pessoa) {
		String where = "";

		if (pessoa.getNome() != null && !pessoa.getNome().isEmpty()) {
			where += "and UPPER(p.nome) like UPPER('%" + pessoa.getNome() + "%')";
		}

		if (pessoa.getCpf() != null && !pessoa.getCpf().isEmpty()) {
			where += "and p.cpf = '" + pessoa.getCpf() + "'";
		}

		if (pessoa.getIdade() != null) {
			where += "and p.idade >= " + pessoa.getIdade();
		}

		if (pessoa.getSexo() != null && !pessoa.getSexo().isEmpty()) {
			where += "and p.sexo = '" + pessoa.getSexo() + "'";
		}
		return where;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todas() throws Exception {
		Session session = factory.openSession();
		Query query = session.createQuery("SELECT p FROM Pessoa p");
		List<Pessoa> todasPessoas = query.list();
		session.close();
		return todasPessoas;
	}

}
