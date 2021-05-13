package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Medico;

public class MedicoDAO {
//	Normalmente fazer todo o CRUD. Aqui apenas o C precisa ser implmentado
	
	public boolean cadastarMedico(Medico medico){
		String sql = "insert into medico (crm, nome, carga_horaria_semanal, "
				+ "data_nascimento, data_contrato) "
				+ " value (?,?,?,?,?)";

		try(
				Connection conexao = Conexao.conector();
				PreparedStatement pS = conexao.prepareStatement(sql);
				)
		{
			pS.setString(1, medico.getCrm());
			pS.setString(2, medico.getNome());
			pS.setInt(3, medico.getHorasSemanais());
			pS.setDate(4, medico.getDataNasc());
			pS.setDate(5, medico.getDataContrato());
			pS.execute();
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
