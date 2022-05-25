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
	
	/*a=-1이면 오류, a!=-1이라면 input[a--]을 반환*/
	String pop() {
		if(a==-1) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		else {
			return input[a--]+" ";
		}		
	}
	
	/*스택이 가득차 있다는 오류, 그렇지 않으면 ob값을 input배열에 저장*/
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
