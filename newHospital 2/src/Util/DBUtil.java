package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public Connection connection = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	private static final String URL = "jdbc:mysql://localhost:3306/doctorsys";
	private static final String UID = "root";
	private static final String PWD = "";
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL,UID,PWD);
	}
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(connection!=null)connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean executeUpdate(String sql, Object[] params) {
		int count = -1;
		try {
			connection=	getConnection();		
			pstmt = connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			count=pstmt.executeUpdate();
			if(count>0){
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally {
			closeAll(null, pstmt, connection);
		}
	}
	
	public ResultSet executeQuery(String sql,Object[] params) {
		try {			
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
}
