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
		
		int a=0,b=0,c=0;   
		
		String []arr = input_line.split(" ");
		/*입력받은 수 구분짓기*/
		switch(arr.length) {
		/*직선일 경우*/
		case 1:
			a=Integer.parseInt(arr[0]);
			break;
		/*직사각형일 경우*/
		case 2:
			a=Integer.parseInt(arr[0]);
			b=Integer.parseInt(arr[1]);
			break;
		/*직육면체일 경우*/
		case 3:
			a=Integer.parseInt(arr[0]);
			b=Integer.parseInt(arr[1]);
			c=Integer.parseInt(arr[2]);
			break;
		}
		
		/*직선일 경우*/
		if(a!=0 && b==0 && c==0) {
			Shape shape_line = new Shape(a);
		}
		/*직사각형일 경우*/
		else if(a!=0 && b!=0 && c==0) {
			Shape shape_rectangle = new Shape(a,b);
		}
		/*직육면체일 경우*/
		else if(a!=0 && b!=0 && c!=0) {
			Shape shape_cuboid = new Shape(a,b,c);
		}
		
	}
}

