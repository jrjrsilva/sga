package br.gov.ba.pm.sga.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.gov.ba.pm.sga.model.Aluno;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/y");
		String niver = "14/09/69";
		
		 Date data =  format.parse(niver);
		 System.out.println(data);
		 
		 Calendar calendario = Calendar.getInstance();
		 calendario.setTime(data);
		 
		 System.out.println(calendario.getTime());
		 
		 Aluno al = new Aluno();
		 
		 
	}

}
