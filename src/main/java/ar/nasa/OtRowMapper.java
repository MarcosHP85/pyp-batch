package ar.nasa;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OtRowMapper implements RowMapper<Ot> {

	@Override
	public Ot mapRow(ResultSet rs, int rowNum) throws SQLException {

		Ot ot = new Ot();
		
		ot.setOt(rs.getLong("WO_NO"));
		ot.setEstado(rs.getString("STATE"));
		ot.setOtMadre(rs.getString("WO_NO_MADRE"));
		ot.setFinalizacionReal(rs.getTimestamp("REAL_F_DATE"));
		ot.setPlantaOt(rs.getString("CONTRACT"));
		ot.setSubestadoPlanif(rs.getString("SUBESTADO_PLANIF"));
		ot.setComIntPla(rs.getString("COM_INT_PLA"));
		ot.setFinProg(rs.getTimestamp("PLAN_F_DATE"));
		ot.setInicioProg(rs.getTimestamp("PLAN_S_DATE"));
		ot.setComponente(rs.getString("MCH_CODE"));
		ot.setOrgMant(rs.getString("ORG_CODE"));
		ot.setTipoParada(rs.getString("TIPO_PARADA"));
		ot.setTipoTrabajo(rs.getString("WORK_TYPE_ID"));
		ot.setPrioridad(rs.getString("PRIORITY_ID"));
		ot.setTarea(rs.getString("TAREA"));
		ot.setClaseSeg(rs.getString("CATEGORY_ID"));
		ot.setFechaRegistro(rs.getTimestamp("REG_DATE"));
		ot.setFirmaPaqTrab(rs.getString("FIRMA_PAQ_TRAB"));
		ot.setRespTarea(rs.getString("WORK_LEADER_SIGN"));
		ot.setConfirmacion1(rs.getString("CONFIRMACION_1"));
		ot.setPlanifica(rs.getString("PREPARED_BY"));
		ot.setComIntPro(rs.getString("COM_INT_PRO"));
		ot.setRecinto(rs.getString("MCH_LOC"));
		ot.setPosEnTab(rs.getString("MCH_POS"));
		ot.setComPlaPro(rs.getString("COM_PLA_PRO"));
		ot.setComImpPla(rs.getString("COM_IMP_PLA"));
		ot.setComImpPro(rs.getString("COM_IMP_PRO"));
		ot.setRequierePaqTrabajo(rs.getString("REQ_PAQ_TAB"));
		ot.setPalabraClave(rs.getString("PALABRA_CLAVE"));
		ot.setNotasMotivo(rs.getString("NOTAS_MOTIVO"));
		ot.setEquiposIndisponibles(rs.getString("EQUIPOS_INDISPONIBLES"));
		ot.setRequiereQc(rs.getString("REQUIERE_QC"));
		ot.setNovedadSemanal(rs.getString("NOVEDAD_SEMANAL"));
		ot.setAgrupProg(rs.getString("AGRUP_PROG"));
		ot.setTipoPaqTrab(rs.getString("TIPO_PAQ_TRAB"));
		ot.setComentOtrasAreas(rs.getString("COMENT_OTRAS_AREAS"));
		ot.setRevisionPaqTrab(rs.getString("REVISION_PAQ_TRAB"));

		return ot;
	}

}
