package prac2;

import java.util.Scanner;
import java.util.StringTokenizer;

class Shape{
	int a,b,c;
	
	public Shape(int a) {
		this.a=a;		
		System.out.println("직선의 길이는 : " + this.a);
	}
	
	public Shape(int a,int b) {
		this.a=a;
		this.b=b;		
		System.out.println("직사각형의 넓이는 : "+(this.a)*(this.b));
	}
	
	public Shape(int a, int b, int c) {
		this.a=a;
		this.b=b;
		this.c=c;	   
		System.out.println("직육면체 부피는 : "+(this.a)*(this.b)*(this.c));
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수치를 입력하시오 (1개 : 직선, 2개 : 직사각형, 3개 : 직육면체)");
		String input_line = sc.nextLine();
		String []arr = input_line.split(" ");
		
		int []num = new int[arr.length]; 
		
		for(int i=0;i<num.length;i++) {
			num[i]=Integer.parseInt(arr[i]);
		}
		
		Shape shape;
		switch(num.length) {	
		case 1:
			shape = new Shape(num[0]); // ->생성자 호출되는 시점
			break;
		case 2:
			shape = new Shape(num[0],num[1]);
			break;
		case 3:
			shape = new Shape(num[0],num[1],num[2]);
		}	
		
	}
}

