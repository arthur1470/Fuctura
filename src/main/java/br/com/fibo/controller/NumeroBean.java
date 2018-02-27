package br.com.fibo.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fibo.service.NumeroService;

@ManagedBean(name = "numeroBean")
@SessionScoped
public class NumeroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//O nossa classe de serviço
	private NumeroService service;
	//Número que a view passa
	private Long numero;

	//Construtor pra inicializar a classe de serviço
	public NumeroBean() {
		service = new NumeroService();		
	}
	
	//Método pra testar se existe o número na sequência de fibonacci
	public void testar() {
		service.numeroExiste(this.getNumero());
	}

	public Long getNumero() {
		if(numero == null) {
			numero = (long) 0;
		}
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

}
