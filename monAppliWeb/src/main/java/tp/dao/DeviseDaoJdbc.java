package tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tp.entity.Devise;

public class DeviseDaoJdbc implements DeviseDao {
	
	//code classique du "design pattern SINGLETON" sans s'appuyer sur spring:
			private static DeviseDaoJdbc uniqueInstance = null;
			
			public  static DeviseDaoJdbc getInstance()	{ 
				if (uniqueInstance == null) {
			         uniqueInstance = new DeviseDaoJdbc();
			     }
			return uniqueInstance; // instance nouvellement ou anciennement creee .
			}

	
	Connection etablirConnection() {
		Connection cn=null;
		try {
			Class.forName("org.h2.Driver");
			String url="jdbc:h2:~/deviseDB";
			String user="sa";
			String password="";
			cn=DriverManager.getConnection(url, user, password);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

	public DeviseDaoJdbc() {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public Devise findDeviseByCode(String code) {
		Devise dev = null;
		Connection cn = null;
		try {
			cn = this.etablirConnection();
			PreparedStatement st = cn.prepareStatement("SELECT * FROM Devise WHERE code=?");
			st.setString(1, code);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
			    dev= new Devise(rs.getString("code"),rs.getString("nom"),
				           rs.getDouble("eChange"));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try{cn.close();}
			catch(Exception ex) { 
				System.err.println(ex.getMessage());
			}
		}
		return dev;
	}

	@Override
	public List<Devise> findAllDevise() {
		List<Devise> listeDev = new ArrayList<>();
		Connection cn = null;
		try {
			cn = this.etablirConnection();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Devise");
			while(rs.next()) {
			    listeDev.add(
				  new Devise(rs.getString("code"),rs.getString("nom"),
				           rs.getDouble("eChange"))
				);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try{cn.close();}
			catch(Exception ex) { 
				System.err.println(ex.getMessage());
			}
		}
		return listeDev;
	}

	@Override
	public void deleteDevise(String code) {
		// TODO Auto-generated method stub

	}


	@Override
	public void saveOrUpdateDevise(Devise d) {
		// TODO Auto-generated method stub
		
	}

}
