package team2_1.sec01;

import java.util.Scanner;

public class HotelOpen {
	Scanner sc = new Scanner(System.in); //����
	  boolean[] room = new boolean[5]; //5�� room
	  int num = 0; //����
	  

	public static void main(String[] args) {
		HotelOpen guest = new HotelOpen(); //�޼ҵ� ȣ��
	    System.out.println("*** ȣ�� ��������ý��� ***");
	    int sel; //����
	    guest.printAll(); //���� ��ü ��ȸ

	    while(true) {
	      try {
	        sel = guest.menu();// menu ���� �Է¹��� �� sel �� ����

	        if(sel == 9) { // �Է¹��� ���� 9 �� myExit(); ����
	          myExit();
	          break;
	        }

	        switch(sel) { //�Է¹��� sel ���� ���� method ȣ�� 
	          case 1 : 
	            guest.input();
	            guest.printAll();
	            break;

	          case 2 : 
	            guest.output();
	            guest.printAll();
	            break;

	          case 3 : 
	            guest.printAll();
	            break;
	            
	          case 4 : 
	        	  guest.goGaeg();
	        	  guest.printAll();
		          break;
	          default : // �߸��� ���� �Է½�
	            System.out.println("1 ~ 4 ������ �޴��� �Է��ϼ���.");break;
	        }
	      }catch (Exception e) {}//����ó��

	    }
	  }

	  public int menu() { //�޴�
	    System.out.print("\n1.�Խǿ���  2.���  3.������Ȳ 4.�� ���/����  9.���� : ");
	    int sel = Integer.parseInt(sc.nextLine()); // ���α׷� ���� �� �� ����
	    return sel; // �Է¹��� ���� main(���๮) ����
	  }

	  public void input() { //�Խǿ���
	    System.out.print("ȣ�� �����ȣ �Է� >> ");
	    num = Integer.parseInt(sc.nextLine()); 
	    if(num < 1 || num > 5) { //num 1~5 ���̰� �ƴ� ��
	    	System.out.println(room[num]);
	    	System.out.println(num);
	    	System.out.println(room);
	      System.out.println(num + "��ȣ�� ����� �� �����ϴ�.");
	    }else if(room[num-1] == true){ // �Է¹��� ���� �̹� true ���̸� (boolean = 0 : false , 1 : true)
	    	System.out.println("room [" + num + "] ����Ǿ��ִ� �����Դϴ�.");
	    	System.out.println(room[num]);
	    	System.out.println(num);
	    	System.out.println(room);
	    }else{// �Է¹��� ���� false ���̸� ���� ����
	    	System.out.println("room[" + num + "] ���� ���� ����");
	    	System.out.println(room[num]);
	    	System.out.println(num);
	    	System.out.println(room);
		    room[num-1] = true;
	    }
	  }

	  public void output() { //���
	    System.out.print("��� �� ��ȣ �Է� >>");
	    num = Integer.parseInt(sc.nextLine());
	    if(room[num-1] == true) { // �Է¹��� ���� �̹� true ���̸�
	      System.out.println("room [" + num + "] ���� ��� �Ͽ����ϴ�.");
	      room[num-1]=false; 
	    }else { // �Է¹��� ���� �̹� false �� 
	      System.out.println("room [" + num + "] ����ִ� �����Դϴ�.");
	    }
	  }

	  public void printAll() { //������Ȳ
	    for(int i=0; i<room.length; i++) {
	      if(room[i] == true) {//true : �����   room[i] : room��ȣ(�迭)
	        System.out.println("  " + (i+1) + "��° �� ȣ�� ���� ������Դϴ�.");
	        System.out.println(room[i]);
	      }else {// false �� ����ִ� ���� (�ʱⰪ)
	        System.out.println("  " + (i+1) + "��° �� ȣ�� ���� ����ֽ��ϴ�.");
	        System.out.println(room[i]);
	      }
	    }
	  }

	  public static void myExit() {
	    System.out.println("\nȣ�� ���� ���α׷��� �����մϴ�.");
	    System.exit(1);//�������� (0�� ��������)
	}


	  	//-------------------------������
		public static void regi(Scanner g_sc, String[] name, int[] id, String[] dept, String[] ph) {
			int count = 0; // �ʱⰪ ����
			boolean over = true; // �ʱⰪ ����
			while(count<id.length) { // coount�� ������ŭ �ݺ�
				System.out.print("�����ȣ : ");
				id[count] = g_sc.nextInt(); //  �Է��� �����ȣ id[count] �� ���� 
		
				if(count == 0) {//count �� 0�̴� ������ �ѹ��� ����
					System.out.print("�̸� : ");
					name[count] = g_sc.next();
					System.out.print("������� : ");
					dept[count] = g_sc.next();
					System.out.print("��ȭ��ȣ : ");
					ph[count] = g_sc.next();
					System.out.println("----------------------");
					count++;
				} else {
					for(int j=(count-1); j>=0; j--) {
						if(id[count] == id[j]) {// �Է¿����ȣ�� ����� �迭�� id[j]�� ������ ��
							System.out.println("[������ �����ȣ�Դϴ�. �ٽ� �Է��ϼ���.]");
							over = false; // false�� ���� ������ �ߺ������ȣ
							break;
						}
						over = true; // true ���� �༭ �ؿ� if���� ����
					}
					if(over) {
						System.out.print("�̸�  : ");
						name[count] = g_sc.next();
						System.out.print("������� : ");
						dept[count] = g_sc.next();
						System.out.print("��ȭ��ȣ : ");
						ph[count] = g_sc.next();
						System.out.println("----------------------");
						count++; //�ݺ����� �����ϱ� ����
					}
							
				}
			}
		}

		public static void print(String[] name, int[] id, String[] dept, String[] ph) {//��ü��ȸ
			for(int i=0; i<id.length; i++) {//id.length : ó�� �Է¹��� �� ��(�迭��¹�)
				System.out.println("�����ȣ : " + id[i]); // id[i] �����ȣ
				System.out.println("�̸� : " + name[i]);
				System.out.println("������� : " + dept[i]);
				System.out.println("��ȭ��ȣ : " + ph[i]);
				System.out.println("----------------------");
			}
		}

	public static void search(int sid, String[] name, int[] id, String[] dept, String[] ph) {//������ȸ
		for(int i=0; i<id.length; i++) {//id.length : ó�� �Է¹��� �� ��(�迭��¹�)
			if(id[i] == sid) {// id[i] �����ȣ == sid ��ĳ�ʷ� �Է¹��� ��
				System.out.println("�����ȣ : " + id[i]);
				System.out.println("�̸� : " + name[i]);
				System.out.println("������� : " + dept[i]);
				System.out.println("��ȭ��ȣ : " + ph[i]);
				System.out.println("----------------------");
				break;// ������ Ż��
			} else if(i == (id.length-1)){// i : 0~ �������� ���� == id.length : ó�� �Է¹��� �� �� 
				// ���α׷��� ����� �������� (0,1,2,3 or 1,2,3,4) ���α׷��������� �����ȣ���ƴ� ���ȣ�� ã��
				
				// ������ 3�̸� ���ȣ�� 0,1,2 �� ������ �����ȣ�� 111,222,333 �� �� 111,222,333 �� ã�°� �ƴ϶�
				// 0,1,2 �� ���� ���� ������� �� ������ ã���� �� ������ �� ���� ��ġ�ϸ� ���� 
				
				System.out.println("[��ġ�ϴ� �����ȣ�� �����ϴ�.]");//break ������ �ݺ�
			}
		}
	}

	public static void modify(Scanner g_sc, int sid, String[] name, int[] id, String[] dept, String[] ph) {//����
		for(int i=0; i<id.length; i++) {//id.length : ó�� �Է¹��� �� ��(�迭��¹�)
			if(id[i] == sid) {// id[i] �����ȣ == sid ��ĳ�ʷ� �Է¹��� ��
				System.out.println("�����ȣ : " + id[i]);
				System.out.println("�̸� : " + name[i]);
				System.out.print("������� �Է� : ");
				dept[i] = g_sc.next();//�������� �Է� �� (i = ��) �������� �Է¹��� ���� ��µ�
				System.out.print("��ȭ��ȣ �Է� : ");
				ph[i] = g_sc.next();
				System.out.println("----------------------");
				break;
			} else if(i == (id.length-1)){
				// ���α׷��� ����� �������� (0,1,2,3 or 1,2,3,4) ���α׷��������� �����ȣ���ƴ� ���ȣ�� ã��
				
				// ������ 3�̸� ���ȣ�� 0,1,2 �� ������ �����ȣ�� 111,222,333 �� �� 111,222,333 �� ã�°� �ƴ϶�
				// 0,1,2 �� ���� ���� ������� �� ������ ã���� �� ������ �� ���� ��ġ�ϸ� ���� 
				System.out.println("[��ġ�ϴ� �����ȣ�� �����ϴ�.]");
			}
		}
	}

	public void goGaeg() {//������ ���� �޼ҵ�
		Scanner g_sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է��ϼ��� : ");//������ �� ó�� �Է� ��
	
		int[] id = new int[g_sc.nextInt()];//�Է¹��� ���� ���� �� �뺸 [0][1][2][3]
		String[] name = new String[id.length];//��������
		String[] dept = new String[id.length];
		String[] ph = new String[id.length];
		
		while(true) {//���๮
			System.out.println("------------------------");
			System.out.println("1. ���� ���");
			System.out.println("2. ��ü ��ȸ");
			System.out.println("3. ���� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. �������� ���ư���");
			
			System.out.print("��ȣ�� �Է��ϼ���. : ");
			int num = g_sc.nextInt();//switch���� case���� ��ȣ �Է�
			System.out.println("------------------------");
			
	if(num > 5 || num < 0) { // 1~5 ���� ��ȣ�� ���
		System.out.println("[�߸��� ��ȣ �Դϴ�. �ٽ� �Է��ϼ���.]");
	} else {
		switch (num) {
		case 1:
			System.out.println("[������ ����մϴ�.]");
			regi(g_sc, name, id, dept, ph);
			break;
			
		case 2:
			System.out.println("====== ��ü �� ��� ======");
			print(name, id, dept, ph);
			break;
			
		case 3:
			System.out.println("[���� ��ȸ �մϴ�.]");
			System.out.print("�����ȣ�� �Է��ϼ���. : ");
			search(g_sc.nextInt(), name, id, dept, ph);
			break;
			
		case 4:
			System.out.println("[�� ������ �����մϴ�.]");
			System.out.print("�����ȣ��  �Է��ϼ���. : ");
			modify(g_sc, g_sc.nextInt(), name, id, dept, ph);
			break;

		default://5�� �������� ���ư���
			System.out.println("*** ȣ�� ��������ý��� ***");
			return; //���θ޼ҵ�� ���ư���
		}
		}
		}
	}
}
