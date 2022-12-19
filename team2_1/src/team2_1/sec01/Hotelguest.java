package team2_1.sec01;

import java.util.Scanner;

public class Hotelguest {
	

	public static void regi(Scanner sc, String[] name, int[] id, String[] dept, String[] ph) {
		int count = 0;
		boolean over = true;
		while(count<id.length) {
			System.out.print("�����ȣ : ");
			id[count] = sc.nextInt();//�����ȣ

			if(count == 0) {
				System.out.println(count);
				System.out.println(id[count]);
				System.out.println(id);
				System.out.print("�̸� : ");
				name[count] = sc.next();
				System.out.print("������� : ");
				dept[count] = sc.next();
				System.out.print("��ȭ��ȣ : ");
				ph[count] = sc.next();
				System.out.println("----------------------");
				count++;
			} else {
				for(int j=(count-1); j>=0; j--) {
					if(id[count] == id[j]) {
						System.out.println("[������ �����ȣ�Դϴ�. �ٽ� �Է��ϼ���.]");
						over = false;
						break;
					}
					over = true;
				}
				if(over) {
					System.out.print("�̸�  : ");
					name[count] = sc.next();
					System.out.println(count);
					System.out.println(id[count]);
					System.out.println(id);
					System.out.print("������� : ");
					dept[count] = sc.next();
					System.out.print("��ȭ��ȣ : ");
					ph[count] = sc.next();
					System.out.println("----------------------");
					count++;
				}
						
			}
		}
	}

	public static void print(String[] name, int[] id, String[] dept, String[] ph) {
		for(int i=0; i<id.length; i++) {
			System.out.println(i);
			System.out.println(id.length);
			System.out.println(id[i]);
			System.out.println("�����ȣ : " + id[i]);
			System.out.println("�̸� : " + name[i]);
			System.out.println("������� : " + dept[i]);
			System.out.println("��ȭ��ȣ : " + ph[i]);
			System.out.println("----------------------");
		}
	}

	public static void search(int did, String[] name, int[] id, String[] dept, String[] ph) {
		for(int i=0; i<id.length; i++) {
			System.out.println(i);
			if(id[i] == did) {// id[i] �����ȣ == did ��ĳ�ʷ� �Է¹��� ��
				System.out.println(id[i]);
				System.out.println(i);
				System.out.println(id);
				System.out.println(did);// did �Է¹��� ��
				System.out.println("�����ȣ : " + id[i]);
				System.out.println("�̸� : " + name[i]);
				System.out.println("������� : " + dept[i]);
				System.out.println("��ȭ��ȣ : " + ph[i]);
				System.out.println("----------------------");
				break;
			} else if(i == (id.length-1)){
				System.out.println(did); // did �Է¹��� ��
				System.out.println(i);
				System.out.println(id.length-1);
				System.out.println("[��ġ�ϴ� �����ȣ�� �����ϴ�.]");
				
			}
		}
	}

	public static void modify(Scanner sc, int did, String[] name, int[] id, String[] dept, String[] ph) {
		for(int i=0; i<id.length; i++) {
			if(id[i] == did) {
				System.out.println(id[i]);
				System.out.println(did);
				System.out.println("�����ȣ : " + id[i]);
				System.out.println("�̸� : " + name[i]);
				System.out.print("������� �Է� : ");
				dept[i] = sc.next();
				System.out.print("��ȭ��ȣ �Է� : ");
				ph[i] = sc.next();
				System.out.println("----------------------");
				break;
			} else if(i == (id.length-1)){
				System.out.println("[��ġ�ϴ� �����ȣ�� �����ϴ�.]");
			}
		}
	}

	public static void end(Scanner sc) {
		System.exit(0);
		sc.close();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է��ϼ��� : ");

		int[] id = new int[sc.nextInt()];
		String[] name = new String[id.length];
		String[] dept = new String[id.length];
		String[] ph = new String[id.length];
		
		while(true) {
			System.out.println("****** ȣ�� �� ���� ���� ���α׷� ******");
			System.out.println("1. ���� ���");
			System.out.println("2. ��ü ��ȸ");
			System.out.println("3. ���� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���α׷� ����");
			
			System.out.print("��ȣ�� �Է��ϼ���. : ");
			int num = sc.nextInt();
			System.out.println("----------------------");
			
			if(num > 5 || num < 0) {
				System.out.println("[�߸��� ��ȣ �Դϴ�. �ٽ� �Է��ϼ���.]");
			} else {
				switch (num) {
				case 1:
					System.out.println("[������ ����մϴ�.]");
					regi(sc, name, id, dept, ph);
					break;
					
				case 2:
					System.out.println("====== ��ü �� ��� ======");
					print(name, id, dept, ph);
					break;
					
				case 3:
					System.out.println("[���� ��ȸ �մϴ�.]");
					System.out.print("�����ȣ�� �Է��ϼ���. : ");
					search(sc.nextInt(), name, id, dept, ph);
					break;
					
				case 4:
					System.out.println("[�� ������ �����մϴ�.]");
					System.out.print("�����ȣ��  �Է��ϼ���. : ");
					modify(sc, sc.nextInt(), name, id, dept, ph);
					break;

				default:
					System.out.println("[���α׷��� �����մϴ�.]");
						end(sc);
						break;
					}
				}
				
			}

			
		}

}
