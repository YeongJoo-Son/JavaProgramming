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
	String []input;
	int a=-1;
	
	/* 생성자 */
	public StringStack(String[] input) {
		this.input=input;
	}
	
	/* 길이 반환하는 메소드*/
	int length() { 
		return this.input.length;
	}
	
	/* input을 초기화 시킨 후 배열 arr을 역순으로 input에 저장하여 리턴*/
	String pop() {
		if(a==-1) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		else {
			return input[a--]+" ";
		}
		
	}
	
	// stack 구조 push랑 pop정확하게 구현하기
	boolean push(String ob) {
		if(a==input.length-1) {
			System.out.println("스택이 가득 차 있습니다.");
			return false;
		}	
		else {
			input[++a]=ob;
			return true;
		}
	}
}

public class StackManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> ");
		String []input=new String[5];
		
		StringStack ss = new StringStack(input);
		
		for(int i=0;i<5;i++) {
			input[i]=sc.next();
			ss.push(input[i]);
		}
		
		for(int i=0;i<5;i++) {
			System.out.print(ss.pop());
		}
	}
}
