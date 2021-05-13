package modelo;

import java.sql.Date;

import dal.MedicoDAO;

public class Medico {
	private String crm;
	private String nome;
	private int horasSemanais;
	private Date dataNasc;
	private Date dataContrato;
	
	public Medico(String crm, String nome, int horasSemanais, Date dataNasc, Date dataContrato) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.horasSemanais = horasSemanais;
		this.dataNasc = dataNasc;
		this.dataContrato = dataContrato;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getHorasSemanais() {
		return horasSemanais;
	}
	public void setHorasSemanais(int horasSemanais) {
		this.horasSemanais = horasSemanais;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Date getDataContrato() {
		return dataContrato;
	}
	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}
	
    public boolean Persistir(){
    	try {
    		MedicoDAO dao = new MedicoDAO();
    		boolean ok = dao.cadastarMedico(this);
    		return ok;
    	}catch(Exception e) {
    		return false;
    	}
    }
	

}
