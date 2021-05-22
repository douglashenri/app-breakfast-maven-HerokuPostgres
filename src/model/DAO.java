package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
		private String driver = "org.postgresql.Driver";
	
	/** The url. */
	private String url = "jdbc:postgresql://"
			+ "ec2-52-0-114-209.compute-1.amazonaws.com/"
			+ "dd10a4julegbb2";
	/** The user. */
	private String user = "ksliabiuggebhz";
	
	/** The password. */
	private String password = "9b83b5a04dbeb2aa9f4ff6b958f2b27990e7a928b2ebaf534decefe55d0b722a";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * To insert coffeelist.
	 *
	 * @param list the list
	 */
	public void toInsertCoffeelist(JavaBeans list) {
		String create = "insert into coffeelist (cof_name, cof_cpf, cof_food) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, list.getPersonsName());
			pst.setString(2, list.getCpf());
			pst.setString(3, list.getFood());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * To list coffeelist.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> toListCoffeelist() {
		ArrayList<JavaBeans> list = new ArrayList<>();
		String read = "select * from coffeelist order by cof_name";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int idlist = rs.getInt(1);
				String personsName = rs.getString(2);
				String cpf = rs.getString(3);
				String food = rs.getString(4);
				list.add(new JavaBeans(idlist, personsName, cpf, food));
			}
			con.close();
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/**
	 * To select list.
	 *
	 * @param list the list
	 */
	public void toSelectList(JavaBeans list) {
		String read2 = "select * from coffeelist where id_list = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, list.getIdlist());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.setIdlist(rs.getInt(1));
				list.setPersonsName(rs.getString(2));
				list.setCpf(rs.getString(3));
				list.setFood(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Change list.
	 *
	 * @param list the list
	 */
	public void changeList(JavaBeans list) {
		String update = "update coffeelist set cof_name=?, cof_cpf=?, cof_food=? where id_list=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, list.getPersonsName());
			pst.setString(2, list.getCpf());
			pst.setString(3, list.getFood());
			pst.setInt(4, list.getIdlist());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Delete list.
	 *
	 * @param list the list
	 */
	public void deleteList(JavaBeans list) {
		String delete = "delete from coffeelist where id_list = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, list.getIdlist());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
