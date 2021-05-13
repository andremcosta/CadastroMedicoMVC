package modelo;

import java.sql.Date;

import dal.MedicoDAO;
import dal.PacienteDAO;

public class Paciente {
	private String cpf;
	private String nome;
	private Date dataNasc;
	private Date dataRegistro;
	
	
	public Paciente(String cpf, String nome, Date dataNasc, Date dataRegistro) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.dataRegistro = dataRegistro;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}


	public Date getDataRegistro() {
		return dataRegistro;
	}


	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
    public boolean Persistir(){
    	try {
    		PacienteDAO dao = new PacienteDAO();
    		boolean ok = dao.cadastarPaciente(this);
    		return ok;
    	}catch(Exception e) {
    		return false;
    	}
    }
	

}
