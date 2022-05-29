package prac1;

import java.util.Scanner;

class Mart{
	int purchase;  //구매금액
	String membername;  //회원아이디
	boolean member=false;  //회원여부
	
	public Mart(int purchase) {
		this.purchase=purchase;
	}
	
	public Mart(String membername, int purchase) {
		this.membername = membername;
		this.member = true;
		this.purchase=purchase;
	}
	
	public void Sale() {
		/*구매금액이 백만원일 경우거나 음수를 입력할 경우*/
		if(this.purchase>1000000 || this.purchase<0) {
			System.out.println("올바르지 않습니다.");
		}
		
		if(this.purchase>=10000&&this.purchase<50000) {
			/*회원일 경우*/
			if(member)
				this.purchase = (int)(this.purchase*0.85);
			else
				this.purchase = (int)(this.purchase*0.95);
		}
		else if(this.purchase>=50000 && this.purchase<100000) {
			if(member)
				this.purchase = (int)(this.purchase*0.8);
			else
				this.purchase = (int)(this.purchase*0.9);
		}
		else {
			if(member)
				this.purchase = (int)(this.purchase*0.7);
			else
				this.purchase = (int)(this.purchase*0.8);
		}
		
		if(member)
			System.out.println("회원 ID : " + this.membername + "의 최종 결제액은 " + this.purchase + "입니다.");
		else
			System.out.println("최종 결제액은 " + this.purchase + "입니다.");
	}	
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("구매할 금액을 입력하세요 : ");
		int a_purchase = sc.nextInt();
		/*비회원 객체 생성 및 Sale() 메소드 실행*/
		Mart a = new Mart(a_purchase);
		a.Sale();
		
		System.out.print("회원번호와 금액을 입력하세요 : ");
		String member = sc.next();
		int b_purchase = sc.nextInt();
		/*회원 객체 생성 및 Sale() 메소드 실행*/
		Mart b = new Mart(member,b_purchase);
		b.Sale();
	}

}