package java_khj_prj.pr11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExample6 {
	//Field
	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	
	//Constructor
	public BoardExample6() {
		try {
			//JDBC Driver ���
Class.forName("com.mysql.cj.jdbc.Driver");
			
			//�����ϱ�
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/prj", 
					"javaprj", 
					"12345"
				);
		} catch(Exception e) {
			e.printStackTrace();
			exit();
		}
	}
	
	//Method	
	public void list() {
		//Ÿ��Ʋ �� �÷��� ���
		System.out.println();
		System.out.println("[�Խù� ���]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
		
		//boads ���̺����� �Խù� ������ �����ͼ� ����ϱ�
		try {
			String sql = "" +
				"SELECT bno, btitle, bcontent, bwriter, bdate " +
				"FROM boards " + 
				"ORDER BY bno DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {		
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s \n", 
						board.getBno(), 
						board.getBwriter(),
						board.getBdate(),
						board.getBtitle());
			}
			rs.close();
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			exit();
		}
		
		//���� �޴� ���
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("���θ޴�: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("�޴�����: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		
		switch(menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> exit();
		}
	}	
	
	public void create() {
		//�Է� �ޱ�
		Board board = new Board();
		System.out.println("[�� �Խù� �Է�]");
		System.out.print("����: "); 	
		board.setBtitle(scanner.nextLine());
		System.out.print("����: "); 	
		board.setBcontent(scanner.nextLine());
		System.out.print("�۾���: "); 	
		board.setBwriter(scanner.nextLine());
		
		//�����޴� ���
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("�����޴�: 1.Ok | 2.Cancel");
		System.out.print("�޴�����: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards ���̺��� �Խù� ���� ����
			try {
				String sql = "" +
					"INSERT INTO boards (btitle, bcontent, bwriter, bdate) " +
					"VALUES (?, ?, ?, now())";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		
		//�Խù� ��� ���
		list();
	}
	
	public void read() {
		//�Է� �ޱ�
		System.out.println("[�Խù� �б�]");
		System.out.print("bno: "); 	
		int bno = Integer.parseInt(scanner.nextLine());
		
		//boards ���̺����� �ش� �Խù��� ������ ���
		try {
			String sql = "" +
				"SELECT bno, btitle, bcontent, bwriter, bdate " +
				"FROM boards " +
				"WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("#############");
				System.out.println("��ȣ: " + board.getBno());
				System.out.println("����: " + board.getBtitle());
				System.out.println("����: " + board.getBcontent());
				System.out.println("����: " + board.getBwriter());
				System.out.println("��¥: " + board.getBdate());
				//�����޴� ���
				System.out.println("-------------------------------------------------------------------");
				System.out.println("�����޴�: 1.Update | 2.Delete | 3.List");
				System.out.print("�޴�����: ");
				String menuNo = scanner.nextLine();
				System.out.println();
				
				if(menuNo.equals("1")) {
					update(board);
				} else if(menuNo.equals("2")) {
					delete(board);
				}
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		
		//�Խù� ��� ���
		list();
	}
	
	public void update(Board board) {
		//���� ���� �Է� �ޱ�
		System.out.println("[���� ���� �Է�]");
		System.out.print("����: "); 	
		board.setBtitle(scanner.nextLine());
		System.out.print("����: "); 	
		board.setBcontent(scanner.nextLine());
		System.out.print("�۾���: "); 	
		board.setBwriter(scanner.nextLine());
		
		//�����޴� ���
		System.out.println("-------------------------------------------------------------------");
		System.out.println("�����޴�: 1.Ok | 2.Cancel");
		System.out.print("�޴�����: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards ���̺����� �Խù� ���� ����
			try {
				String sql = "" +
					"UPDATE boards SET btitle=?, bcontent=?, bwriter=? " +
					"WHERE bno=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		
		//�Խù� ��� ���
		list();
	}
	
	public void delete(Board board) {
		System.out.println("*** delete �޼ҵ� �����");
		list();
	}
	
	public void clear() {
		System.out.println("*** clear �޼ҵ� �����");
		list();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		BoardExample6 boardExample = new BoardExample6();
		boardExample.list();
	}
}