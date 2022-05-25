package dev.ifrs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Consulta extends PanacheEntity {

    //Atributo
	private double data;
	private double horario;
	private String situacao;
	
	@ManyToOne (cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Paciente paciente;
	@ManyToOne (cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Quiropraxista quiro;
	
	//Contrutores
	public Consulta() {};
	public Consulta(double horario, String sit) {
		this.horario = horario;
		this.situacao = sit;
	}
	
	public Consulta(double horario, String sit, Paciente paciente,
			Quiropraxista quiro) {
		this.horario = horario;
		this.situacao = sit;
		this.paciente = paciente;
		this.quiro = quiro;
	}
	
	public Consulta(double data, double horario, String sit, Paciente paciente,
			Quiropraxista quiro) {
		this.data = data;
		this.horario = horario;
		this.situacao = sit;
		this.paciente = paciente;
		this.quiro = quiro;
	}
	
	//Getters e Setters
	public double getData() {
		return data;
	}
	public void setData(double data) {
		this.data = data;
	}
	
	public double getHorario() {
		return horario;
	}
	public void setHorario(double horario) {
		this.horario = horario;
	}
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Quiropraxista getQuiro() {
		return quiro;
	}
	public void setQuiro(Quiropraxista quiro) {
		this.quiro = quiro;
	}
	
}
