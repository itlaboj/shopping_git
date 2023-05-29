package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private static final String URL = "jdbc:postgresql:shop_db";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	
	protected Connection connect() throws Exception {

		//JDBCドライバの登録
		Class.forName("org.postgresql.Driver");

		//データベースへの接続
		Connection con = DriverManager.getConnection(URL, USER, PASS);

		return con;
	}
}
