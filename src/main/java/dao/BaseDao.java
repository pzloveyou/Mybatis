package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	private static String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/blankyours?useUnicode=true&amp&characterEncoding=utf-8";
	String user="root";
	String  password="0000";
	Connection con = null;
	/*static {
		init();
	}

	public static void init() {
		Properties params = new Properties();
		String configFile = "database.properties";
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(
				configFile);
		try {
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("username");
		pwd = params.getProperty("password");
	}*/

	public Connection getConnection() {
		if (con == null) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// 若结果集对象不为空,则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空,则关闭
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空,则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int exceuteUpdate(String sql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, pstmt, null);
		}
		return num;
	}

	public ResultSet exceuteQuery(String sql, Object[] param) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return rs;
	}
}
