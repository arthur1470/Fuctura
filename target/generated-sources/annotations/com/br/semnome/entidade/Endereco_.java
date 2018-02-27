package com.br.semnome.entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> complemento;
	public static volatile SingularAttribute<Endereco, Integer> numero;
	public static volatile SingularAttribute<Endereco, Integer> id;
	public static volatile SingularAttribute<Endereco, String> rua;
	public static volatile ListAttribute<Endereco, Pessoa> pessoaList;

}

