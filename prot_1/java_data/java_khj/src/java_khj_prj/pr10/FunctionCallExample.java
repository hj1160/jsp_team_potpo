package java_khj_prj.pr10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionCallExample {
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
			String sql = "{? = call user_login(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			//? �� ���� �� ���� Ÿ�� ����
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, "winter");
			cstmt.setString(3, "12345");
			
			//�Լ� ���� �� ���ϰ� ���
			cstmt.execute();
			int result = cstmt.getInt(1);
			
			//CallableStatement �ݱ�
			cstmt.close();
			
			//�α��� ���(Switch Expressions �̿�)
			String message = switch(result) {
				case 0 -> "�α��� ����";
				case 1 -> "��й�ȣ�� Ʋ��";
				default -> "���̵� �������� ����";
			};
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try { 
					//���� ����
					conn.close(); 
				} catch (SQLException e) {}
			}
		}
	}
}