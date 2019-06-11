package br.gov.ba.pm.sga.model.enums;

public enum EnumPerfil {

	ROLE_ADMIN,
	ROLE_USER,
	ROLE_INSTRUTOR,
	ROLE_ALUNO;
	
	
	
	
	public static EnumPerfil getPerfil(String perfil) {
		switch (perfil) {
		case "Admin": return ROLE_ADMIN;
		case "Usuario": return ROLE_USER;
		case "Instrutor": return ROLE_INSTRUTOR;
		case "Aluno": return ROLE_ALUNO;
		default: return ROLE_USER;
		
		}
	}
	
}
