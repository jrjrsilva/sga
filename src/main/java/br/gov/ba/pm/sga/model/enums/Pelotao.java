package br.gov.ba.pm.sga.model.enums;

public enum Pelotao {

	PEL1(1, "1º Pel"),
	PEL2(2, "2º Pel"),
	PEL3(3, "3º Pel"),
	PEL4(4, "4º Pel"),
	PEL5(5, "5º Pel"),
	PEL6(6, "6º Pel"),
	PEL7(7, "7º Pel"),
	PEL8(8, "8º Pel");
	
	private int cod;
	private String descricao;
	
	private Pelotao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
