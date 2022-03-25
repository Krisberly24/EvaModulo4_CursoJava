package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DTOTitles {
	public static boolean insert(Connection conn, Titles title) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("INSERT INTO title_types VALUES (?,?)" );
			pst.setInt(1, title.getTitle_no());
			pst.setString(2, title.getTitle());
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}	
	
	public static Titles select(Connection conn,Titles title) {
		PreparedStatement pst;
		Titles titles = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM title_types WHERE title_no=?" );
			pst.setInt(1, title.getTitle_no());
			ResultSet rs = pst.executeQuery();
			rs.next();
			titles = new Titles(rs.getString("title_no"), rs.getString("title"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return titles;
	}
	
	public static boolean update(Connection conn, Titles title) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("UPDATE title_types SET title=? WHERE title_no=?" );
			pst.setString(1, title.getTitle());
			pst.setInt(2, title.getTitle_no());
			if (pst.executeUpdate() > 0) {
				vret = true;
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}
	
	public static boolean delete(Connection conn,Titles title) {
		PreparedStatement pst;
		boolean vret = false;
		try {
			pst = conn.prepareStatement("DELETE FROM title_types WHERE title_no=?" );
			pst.setInt(1, title.getTitle_no());
			pst.execute();
			vret = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return vret;
	}


}
