package tdsi;

//public class MedcinTdsiImpl {
//package dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import metier.SingletonConnection;
	import metier.entities.Medcin;
public class MedcinTdsiImpl implements MedcinTdsi {
	@Override
	public Medcin save(Medcin p) {
	Connection conn=SingletonConnection.getConnection();
	try {
	PreparedStatement ps= conn.prepareStatement("INSERT INTO MEDCIN (NOM_MEDCIN,MATRICUL) VALUES(?,?)");
		ps.setString(1, p.getNomMedcin());
		ps.setString(2, p.getMatricul());
		ps.executeUpdate();
	PreparedStatement ps2= conn.prepareStatement
	("SELECT MAX(ID_MEDCIN) as MAX_ID FROM MEDCIN");
	ResultSet rs =ps2.executeQuery();
	if (rs.next()) {
	p.setIdMedcin(rs.getLong("MAX_ID"));
	}
	ps.close();
	ps2.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
}
	
@Override
public List<Medcin> medcinsParMC(String mc) {
List<Medcin> prods= new ArrayList<Medcin>();
Connection conn=SingletonConnection.getConnection();
try {
	PreparedStatement ps= conn.prepareStatement("select * from MEDCIN where NOM_MEDCIN LIKE ?");
	ps.setString(1, "%"+mc+"%");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	Medcin p = new Medcin();
	p.setIdMedcin(rs.getLong("ID_MEDCIN"));
	p.setNomMedcin(rs.getString("NOM_MEDCIN"));
	p.setMatricul(rs.getString("MATRICUL"));
	prods.add(p);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
	return prods;
}
@Override
public Medcin getMedcin(Long id) {
	Connection conn=SingletonConnection.getConnection();
	Medcin p = new Medcin();
	try {
		PreparedStatement ps= conn.prepareStatement("select * from MEDCIN  where ID_MEDCIN = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			p.setIdMedcin(rs.getLong("ID_MEDCIN"));
			p.setNomMedcin(rs.getString("NOM_MEDCIN"));
			p.setMatricul(rs.getString("MATRICUL"));
		}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
	
}
@Override
public Medcin updateMedcin(Medcin p) {
	Connection conn=SingletonConnection.getConnection();
	try {
		PreparedStatement ps= conn.prepareStatement("UPDATE Medcin SET NOM_MEDCIN=?,MATRICUL=? WHERE ID_MEDCIN=?");
		ps.setString(1, p.getNomMedcin());
		ps.setString(2, p.getMatricul());
		ps.setLong(3, p.getIdMedcin());
		ps.executeUpdate();
		ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
}
@Override
public void deleteMedcin(Long id) {
// TODO Auto-generated method stub
	Connection conn=SingletonConnection.getConnection();
	try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM MEDCIN WHERE ID_MEDCIN = ?");
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
}
}