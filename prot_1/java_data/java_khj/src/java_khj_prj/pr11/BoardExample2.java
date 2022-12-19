package java_khj_prj.pr11;

import java.util.Scanner;

public class BoardExample2 {
	//Field
		private Scanner scanner = new Scanner(System.in);
		
		//Constructor
		
		//Method	
		public void list() {
			System.out.println();
			System.out.println("[�Խù� ���]");
			System.out.println("-----------------------------------------------------------------------");
			System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
			System.out.println("-----------------------------------------------------------------------");
			System.out.printf("%-6s%-12s%-16s%-40s \n", 
					"1", "winter", "2022.01.27", "�Խ��ǿ� ���� ���� ȯ���մϴ�.");
			System.out.printf("%-6s%-12s%-16s%-40s \n", 
					"2", "winter", "2022.01.27", "�� �ܿ��� ���� ����ϴ�.");
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
			System.out.println("*** create �޼ҵ� �����");
			list();
		}
		
		public void read() {
			System.out.println("*** read �޼ҵ� �����");
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
			BoardExample2 boardExample = new BoardExample2();
			boardExample.list();
		}
	}