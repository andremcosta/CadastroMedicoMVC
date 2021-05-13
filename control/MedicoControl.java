package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import modelo.Medico;

import java.sql.Date;

public class MedicoControl {
	public static boolean validaCrm(String s) {
		if (s.matches("[0-9]{4,10}-[A-Z][A-Z]"))	{
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validaNome(String s) {
		if (s.matches("[^0-9]*"))	{
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validaCarga(String s) {
		int i;
		try { 
			i = Integer.parseInt(s);
		} catch(Exception e) {
			i=0;
		}
		if (i>=20 && i <=60 ){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validaData(String s) {
		try { 
			LocalDate ld = LocalDate.parse(s,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Date dataNasc = Date.valueOf(ld);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static boolean saveMedico(String crm, String nome, String carga,
			String Nascimento, String Contrato) {
		
		int horasSemanais = Integer.parseInt(carga);
		
		try {
			LocalDate ld = LocalDate.parse(Nascimento,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Date dataNasc = Date.valueOf(ld);
			
			ld = LocalDate.parse(Contrato,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Date dataContrato = Date.valueOf(ld);
			
			Medico m = new Medico(crm, nome, horasSemanais, dataNasc, dataContrato);
			return m.Persistir();			
		} catch (Exception e) {
			 return false;
		}
		
		
				
		
	}
	
	
	

}
