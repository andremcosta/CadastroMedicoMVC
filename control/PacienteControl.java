package control;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import modelo.Medico;
import modelo.Paciente;

public class PacienteControl {
	public static boolean validaCpf(String cpf) {
		cpf = cpf.replaceAll("[.-]", "");
		int soma1 = 0;
		int soma2 = 0;
		int resto1;
		int resto2;
		int i;
		for (i=0; i<9; i++) {
			 soma1 += (cpf.charAt(i)-'0') * (10-i);
		}
		for (i=0; i<10; i++) {
			 soma2 += (cpf.charAt(i)-'0') * (11-i);
		}
		resto1 = (soma1 % 11);
		resto2 = (soma2 % 11);
		if(resto1 == 0 || resto1 == 1) {
			if (cpf.charAt(9)-'0'!=0) {return false;}
		} else {
			if (cpf.charAt(9)-'0'!=(11-resto1)) { return false;}
		}
		if(resto2 == 0 || resto2 == 1) {
			if (cpf.charAt(10)-'0'!=0) {return false;}
		} else {
			if (cpf.charAt(10)-'0'!=(11-resto2)) {return false;}
		}
		
		return true;
	}
	
	public static boolean validaNome(String nome) {
		if (nome.matches("[^0-9]*"))	{
			return true;
		} else {
			return false;
		}		
	}
	
	public static boolean savePaciente(String cpf, String nome,
			String Nascimento, String Registro) {
			
		try {
			LocalDate ld = LocalDate.parse(Nascimento,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Date dataNasc = Date.valueOf(ld);
			
			ld = LocalDate.parse(Registro,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Date dataRegistro = Date.valueOf(ld);
			
			Paciente m = new Paciente(cpf, nome, dataNasc, dataRegistro);
			System.out.println(m.getNome());
			return m.Persistir();			
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

}
