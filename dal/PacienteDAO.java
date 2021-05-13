package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Paciente;

public class PacienteDAO {
	
	public boolean cadastarPaciente(Paciente paciente){
		String sql = "insert into paciente (cpf, nome, "
				+ "data_nascimento, data_registro) "
				+ " value (?,?,?,?)";

		try(
				Connection conexao = Conexao.conector();
				PreparedStatement pS = conexao.prepareStatement(sql);
				)
		{
			pS.setString(1, paciente.getCpf());
			pS.setString(2, paciente.getNome());
			pS.setDate(3, paciente.getDataNasc());
			pS.setDate(4, paciente.getDataRegistro());
			pS.execute();
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
