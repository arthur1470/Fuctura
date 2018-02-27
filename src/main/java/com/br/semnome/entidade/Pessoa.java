/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.semnome.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Cleiton
 */
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CPF")
    private String cpf;
    
    @Column(name = "IDADE")
    private Integer idade;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "SEXO")
    private String sexo;
    
    @JoinColumn(name = "NUMERO_CONTA", referencedColumnName = "NUMERO")
    @ManyToOne
    private Conta conta;
    
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO")
    @ManyToOne
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setIdEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.semnome.entidade.Pessoa[ cpf=" + cpf + " ]";
    }
    
}
