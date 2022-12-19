package java_khj_prj.pr10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureCallExample {

	public static void main(String[] args) {
	Connection conn = null;
	try {
		//JDBC Driver ���
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//�����ϱ�
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/prj", 
				"javaprj", 
				"12345"
			);
		
		//�Ű�����ȭ�� ȣ�⹮ �ۼ��� CallableStatement ���
		String sql = "{call user_create(?,?,?,?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);

		//�� ���� �� ���� Ÿ�� ����
		cstmt.setString(1, "summer");
		cstmt.setString(2, "�ѿ���");
		cstmt.setString(3, "12345");
		cstmt.setInt(4, 26);
		cstmt.setString(5, "summer@mycompany.com");
		cstmt.registerOutParameter(6, Types.INTEGER);
		
		//���ν��� ���� �� ���ϰ� ���
		cstmt.execute();
		int rows = cstmt.getInt(6);
		System.out.println("����� �� �� "+ rows);
		
		//CallableStatement �ݱ�
		cstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					//�������
					conn.close();
				}catch(SQLException e){}
			}
		}
}
}