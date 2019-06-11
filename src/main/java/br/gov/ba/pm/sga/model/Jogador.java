package br.gov.ba.pm.sga.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jogador")
public class Jogador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 private String nome;
	 private int estado;
	 private String descricao;
	 private byte[] foto;
	 
	public String getDescricao() {
	 return descricao;
	 }
	 
	public void setDescricao(String descricao) {
	 this.descricao = descricao;
	 }
	 
	public int getEstado() {
	 return estado;
	 }
	 
	public void setEstado(int estado) {
	 this.estado = estado;
	 }
	 
	public byte[] getFoto() {
	 return foto;
	 }
	 
	public void setFoto(byte[] foto) {
	 this.foto = foto;
	 }
	 
	public int getId() {
	 return id;
	 }
	 
	public void setId(int id) {
	 this.id = id;
	 }
	 
	public String getNome() {
	 return nome;
	 }
	 
	public void setNome(String nome) {
	 this.nome = nome;
	 }
	 }
