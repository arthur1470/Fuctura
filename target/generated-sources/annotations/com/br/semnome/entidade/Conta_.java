package com.br.semnome.entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conta.class)
public abstract class Conta_ {

	public static volatile SingularAttribute<Conta, String> dono;
	public static volatile SingularAttribute<Conta, Integer> numero;
	public static volatile SingularAttribute<Conta, Double> saldo;
	public static volatile SingularAttribute<Conta, Double> limite;
	public static volatile ListAttribute<Conta, Pessoa> pessoaList;

}

