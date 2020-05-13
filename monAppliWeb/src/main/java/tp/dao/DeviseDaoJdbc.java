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
		Connection cn = null;
		try {
			cn = this.etablirConnection();
			PreparedStatement st = cn.prepareStatement("DELETE FROM Devise WHERE code=?");
			st.setString(1, code);
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("echec delete",e);
		}
		finally {
			try{cn.close();}
			catch(Exception ex) { 
				System.err.println(ex.getMessage());
			}
		}
	}


	@Override
	public void saveOrUpdateDevise(Devise d) {
		if(findDeviseByCode(d.getCode())==null) {
			insertDevise(d);	
		}else {
		   updateDevise(d);
		}
	}
	
	public void insertDevise(Devise d) {
		Connection cn = null;
		try {
			cn = this.etablirConnection();
			PreparedStatement st = cn.prepareStatement("INSERT INTO Devise(code,nom,eChange) VALUES(?,?,?)");
			st.setString(1, d.getCode());
			st.setString(2, d.getNom());
			st.setDouble(3, d.getChange());
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("echec insert",e);
		}
		finally {
			try{cn.close();}
			catch(Exception ex) { 
				System.err.println(ex.getMessage());
			}
		}
		
	}
	
	public void updateDevise(Devise d) {
		Connection cn = null;
		try {
			cn = this.etablirConnection();
			PreparedStatement st = cn.prepareStatement("UPDATE Devise set nom=? , eChange=? WHERE code=?");
			st.setString(3, d.getCode());
			st.setString(1, d.getNom());
			st.setDouble(2, d.getChange());
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("echec update",e);
		}
		finally {
			try{cn.close();}
			catch(Exception ex) { 
				System.err.println(ex.getMessage());
			}
		}
		
	}

}
