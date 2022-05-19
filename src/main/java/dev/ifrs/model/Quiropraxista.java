package dev.ifrs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Quiropraxista extends PanacheEntity{
    
    //Atributos
	
	private String nome;
	private String cpf;
	private String email;

	private String crm;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name="Consultas_Quiro")
	private Set<Consulta> consultas;

	//precisa de consultas?

	//Contrutores
	public Quiropraxista() {};
	public Quiropraxista(String nome, String cpf, String email, String crm) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.crm = crm;
		
	}
	
	public Quiropraxista(String nome, String cpf, String email, String crm, Set<Consulta> consultas) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.crm = crm;
		this.consultas = consultas;
	}
	

	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
	public Set<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}
