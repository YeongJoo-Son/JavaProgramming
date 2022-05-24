package java_notion_3th;

import java.util.Scanner;

/* Stack : 추상 클래스*/
abstract class Stack{
	abstract int length();
	abstract String pop();
	abstract boolean push(String ob);
}

/* StringStack : Stack을 상속받는 클래스*/
class StringStack extends Stack{
	String input;
	String []arr;
	
	/* 생성자 */
	public StringStack(String input) {
		this.input=input;
	}
	
	/* 길이 반환하는 메소드*/
	int length() { 
		return this.arr.length;
	}
	
	/* input을 초기화 시킨 후 배열 arr을 역순으로 input에 저장하여 리턴*/
	String pop() {
		input="";
		for(int i=this.arr.length-1;i>=0;i--) {
			input +=(arr[i]+" ");
		}
		return input;
	}
	
	/* 문자열을 띄어쓰기로 구분하여 배열 arr에 저장하고 성공적인 push를 했다는 의미로 true 값 리턴*/
	boolean push(String ob) {
		this.arr=this.input.split(" ");
		return true;
	}
	
}

public class StackManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> ");
		String input = sc.nextLine();	// 한 줄로 받아오기	
		
		StringStack ss = new StringStack(input);  //input을 매개변수로 하여 객체 생성
		
		/*push가 성공적으로 수행되었으면 true를 반환하므로 if문 수행*/
		if(ss.push(input)) {
			System.out.println(ss.pop());  /*역순 출력*/
		}
	}
}
