package team2_1.sec01;

import java.util.Scanner;

public class HotelOpen {
	Scanner sc = new Scanner(System.in); //전역
	  boolean[] room = new boolean[5]; //5개 room
	  int num = 0; //전역
	  

	public static void main(String[] args) {
		HotelOpen guest = new HotelOpen(); //메소드 호출
	    System.out.println("*** 호텔 예약관리시스템 ***");
	    int sel; //지역
	    guest.printAll(); //객실 전체 조회

	    while(true) {
	      try {
	        sel = guest.menu();// menu 에서 입력받은 값 sel 로 리턴

	        if(sel == 9) { // 입력받은 값이 9 면 myExit(); 종료
	          myExit();
	          break;
	        }

	        switch(sel) { //입력받은 sel 값을 통한 method 호출 
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
	          default : // 잘못된 숫자 입력시
	            System.out.println("1 ~ 4 사이의 메뉴를 입력하세요.");break;
	        }
	      }catch (Exception e) {}//예외처리

	    }
	  }

	  public int menu() { //메뉴
	    System.out.print("\n1.입실예약  2.퇴실  3.객실현황 4.고객 등록/관리  9.종료 : ");
	    int sel = Integer.parseInt(sc.nextLine()); // 프로그램 실행 시 값 받음
	    return sel; // 입력받은 값을 main(실행문) 리턴
	  }

	  public void input() { //입실예약
	    System.out.print("호텔 예약번호 입력 >> ");
	    num = Integer.parseInt(sc.nextLine()); 
	    if(num < 1 || num > 5) { //num 1~5 사이가 아닐 시
	    	System.out.println(room[num]);
	    	System.out.println(num);
	    	System.out.println(room);
	      System.out.println(num + "번호를 사용할 수 없습니다.");
	    }else if(room[num-1] == true){ // 입력받은 값이 이미 true 값이면 (boolean = 0 : false , 1 : true)
	    	System.out.println("room [" + num + "] 예약되어있는 객실입니다.");
	    	System.out.println(room[num]);
	    	System.out.println(num);
	    	System.out.println(room);
	    }else{// 입력받은 값이 false 값이면 예약 성공
	    	System.out.println("room[" + num + "] 객실 예약 성공");
	    	System.out.println(room[num]);
	    	System.out.println(num);
	    	System.out.println(room);
		    room[num-1] = true;
	    }
	  }

	  public void output() { //퇴실
	    System.out.print("퇴실 방 번호 입력 >>");
	    num = Integer.parseInt(sc.nextLine());
	    if(room[num-1] == true) { // 입력받은 값이 이미 true 값이면
	      System.out.println("room [" + num + "] 객실 퇴실 하였습니다.");
	      room[num-1]=false; 
	    }else { // 입력받은 값이 이미 false 면 
	      System.out.println("room [" + num + "] 비어있는 객실입니다.");
	    }
	  }

	  public void printAll() { //객실현황
	    for(int i=0; i<room.length; i++) {
	      if(room[i] == true) {//true : 사용중   room[i] : room번호(배열)
	        System.out.println("  " + (i+1) + "번째 ■ 호텔 객실 사용중입니다.");
	        System.out.println(room[i]);
	      }else {// false 면 비어있는 객실 (초기값)
	        System.out.println("  " + (i+1) + "번째 □ 호텔 객실 비어있습니다.");
	        System.out.println(room[i]);
	      }
	    }
	  }

	  public static void myExit() {
	    System.out.println("\n호텔 예약 프로그램을 종료합니다.");
	    System.exit(1);//강제종료 (0은 정상종료)
	}


	  	//-------------------------고객관리
		public static void regi(Scanner g_sc, String[] name, int[] id, String[] dept, String[] ph) {
			int count = 0; // 초기값 설정
			boolean over = true; // 초기값 설정
			while(count<id.length) { // coount가 고객수만큼 반복
				System.out.print("예약번호 : ");
				id[count] = g_sc.nextInt(); //  입력한 예약번호 id[count] 에 대입 
		
				if(count == 0) {//count 가 0이니 무조건 한번은 실행
					System.out.print("이름 : ");
					name[count] = g_sc.next();
					System.out.print("생년월일 : ");
					dept[count] = g_sc.next();
					System.out.print("전화번호 : ");
					ph[count] = g_sc.next();
					System.out.println("----------------------");
					count++;
				} else {
					for(int j=(count-1); j>=0; j--) {
						if(id[count] == id[j]) {// 입력예약번호와 저장된 배열의 id[j]가 동일할 시
							System.out.println("[동일한 예약번호입니다. 다시 입력하세요.]");
							over = false; // false를 주지 않으면 중복예약번호
							break;
						}
						over = true; // true 값을 줘서 밑에 if문을 실행
					}
					if(over) {
						System.out.print("이름  : ");
						name[count] = g_sc.next();
						System.out.print("생년월일 : ");
						dept[count] = g_sc.next();
						System.out.print("전화번호 : ");
						ph[count] = g_sc.next();
						System.out.println("----------------------");
						count++; //반복문을 실행하기 위해
					}
							
				}
			}
		}

		public static void print(String[] name, int[] id, String[] dept, String[] ph) {//전체조회
			for(int i=0; i<id.length; i++) {//id.length : 처음 입력받은 고객 수(배열출력문)
				System.out.println("예약번호 : " + id[i]); // id[i] 예약번호
				System.out.println("이름 : " + name[i]);
				System.out.println("생년월일 : " + dept[i]);
				System.out.println("전화번호 : " + ph[i]);
				System.out.println("----------------------");
			}
		}

	public static void search(int sid, String[] name, int[] id, String[] dept, String[] ph) {//개별조회
		for(int i=0; i<id.length; i++) {//id.length : 처음 입력받은 고객 수(배열출력문)
			if(id[i] == sid) {// id[i] 예약번호 == sid 스캐너로 입력받은 값
				System.out.println("예약번호 : " + id[i]);
				System.out.println("이름 : " + name[i]);
				System.out.println("생년월일 : " + dept[i]);
				System.out.println("전화번호 : " + ph[i]);
				System.out.println("----------------------");
				break;// 있으면 탈출
			} else if(i == (id.length-1)){// i : 0~ 고객수까지 실행 == id.length : 처음 입력받은 고객 수 
				// 프로그램과 사람의 생각차이 (0,1,2,3 or 1,2,3,4) 프로그램내에서는 예약번호가아닌 방번호를 찾음
				
				// 고객수가 3이면 방번호가 0,1,2 로 생성됨 예약번호가 111,222,333 일 시 111,222,333 을 찾는게 아니라
				// 0,1,2 에 대한 방을 순서대로 다 뒤져서 찾았을 때 고객수랑 방 값이 일치하면 실행 
				
				System.out.println("[일치하는 예약번호가 없습니다.]");//break 없으면 반복
			}
		}
	}

	public static void modify(Scanner g_sc, int sid, String[] name, int[] id, String[] dept, String[] ph) {//수정
		for(int i=0; i<id.length; i++) {//id.length : 처음 입력받은 고객 수(배열출력문)
			if(id[i] == sid) {// id[i] 예약번호 == sid 스캐너로 입력받은 값
				System.out.println("예약번호 : " + id[i]);
				System.out.println("이름 : " + name[i]);
				System.out.print("생년월일 입력 : ");
				dept[i] = g_sc.next();//수정받을 입력 값 (i = 방) 마지막에 입력받은 값이 출력됨
				System.out.print("전화번호 입력 : ");
				ph[i] = g_sc.next();
				System.out.println("----------------------");
				break;
			} else if(i == (id.length-1)){
				// 프로그램과 사람의 생각차이 (0,1,2,3 or 1,2,3,4) 프로그램내에서는 예약번호가아닌 방번호를 찾음
				
				// 고객수가 3이면 방번호가 0,1,2 로 생성됨 예약번호가 111,222,333 일 시 111,222,333 을 찾는게 아니라
				// 0,1,2 에 대한 방을 순서대로 다 뒤져서 찾았을 때 고객수랑 방 값이 일치하면 실행 
				System.out.println("[일치하는 예약번호가 없습니다.]");
			}
		}
	}

	public void goGaeg() {//고객관리 실행 메소드
		Scanner g_sc = new Scanner(System.in);
		
		System.out.print("고객의 수를 입력하세요 : ");//고객관리 시 처음 입력 값
	
		int[] id = new int[g_sc.nextInt()];//입력받은 값을 통해 수 통보 [0][1][2][3]
		String[] name = new String[id.length];//변수선언
		String[] dept = new String[id.length];
		String[] ph = new String[id.length];
		
		while(true) {//실행문
			System.out.println("------------------------");
			System.out.println("1. 정보 등록");
			System.out.println("2. 전체 조회");
			System.out.println("3. 개별 조회");
			System.out.println("4. 정보 수정");
			System.out.println("5. 이전으로 돌아가기");
			
			System.out.print("번호를 입력하세요. : ");
			int num = g_sc.nextInt();//switch문에 case실행 번호 입력
			System.out.println("------------------------");
			
	if(num > 5 || num < 0) { // 1~5 까지 번호만 허용
		System.out.println("[잘못된 번호 입니다. 다시 입력하세요.]");
	} else {
		switch (num) {
		case 1:
			System.out.println("[고객으로 등록합니다.]");
			regi(g_sc, name, id, dept, ph);
			break;
			
		case 2:
			System.out.println("====== 전체 고객 출력 ======");
			print(name, id, dept, ph);
			break;
			
		case 3:
			System.out.println("[고객을 조회 합니다.]");
			System.out.print("예약번호를 입력하세요. : ");
			search(g_sc.nextInt(), name, id, dept, ph);
			break;
			
		case 4:
			System.out.println("[고객 정보를 수정합니다.]");
			System.out.print("예약번호를  입력하세요. : ");
			modify(g_sc, g_sc.nextInt(), name, id, dept, ph);
			break;

		default://5번 이전으로 돌아가기
			System.out.println("*** 호텔 예약관리시스템 ***");
			return; //메인메소드로 돌아가라
		}
		}
		}
	}
}
