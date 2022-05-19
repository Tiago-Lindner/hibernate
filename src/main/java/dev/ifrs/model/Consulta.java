package dev.ifrs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Consulta extends PanacheEntity {

    //Atributos
	private int codigo;
	private double data;
	private double inicioHora;
	private double fimHora;
	private String situacao;
	
	@ManyToOne (cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
	
	private Paciente paciente;
	@ManyToOne (cascade= CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Quiropraxista quiro;
	
	//Contrutores
	public Consulta() {};
	public Consulta(int codigo, double inicioHora, double fimHora, String sit) {
		this.codigo = codigo;
		this.inicioHora = inicioHora;
		this.fimHora = fimHora;
		this.situacao = sit;
	}
	
	public Consulta(int codigo, double inicioHora, double fimHora, String sit, Paciente paciente,
			Quiropraxista quiro) {
		this.codigo = codigo;
		this.inicioHora = inicioHora;
		this.fimHora = fimHora;
		this.situacao = sit;
		this.paciente = paciente;
		this.quiro = quiro;
	}
	
	public Consulta(int codigo, double data, double inicioHora, double fimHora, String sit, Paciente paciente,
			Quiropraxista quiro) {
		this.codigo = codigo;
		this.data = data;
		this.inicioHora = inicioHora;
		this.fimHora = fimHora;
		this.situacao = sit;
		this.paciente = paciente;
		this.quiro = quiro;
	}
	
	//Getters e Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double getData() {
		return data;
	}
	public void setData(double data) {
		this.data = data;
	}
	
	public double getInicioHora() {
		return inicioHora;
	}
	public void setInicioHora(double inicioHora) {
		this.inicioHora = inicioHora;
	}
	
	public double getFimHora() {
		return fimHora;
	}
	public void setFimHora(double fimHora) {
		this.fimHora = fimHora;
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
