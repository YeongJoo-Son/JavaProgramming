package prac3;
import java.util.Scanner;

class Conversion{
	int num; //10진수 
	String bin, hex; //2진수, 16진수
	
	/*10진수를 2진수로 변환*/
	public void toBinary(int num) {
		this.num=num;
		this.bin=Integer.toBinaryString(this.num);
	}
	
	/*10진수를 16진수로 변환*/
	public void toHex(int num) {
		this.num=num;
		this.hex=Integer.toHexString(this.num);	
	}
	
	/*2진수를 10진수로 변환*/
	public void binaryToNum(String bin) {
		this.bin=bin;
		this.num=Integer.parseInt(this.bin,2);		
	}
	
	/*2진수를 16진수로 변환*/
	public void binaryToHex(String bin) {
		this.bin=bin;
		this.hex=Integer.toHexString(Integer.parseInt(this.bin,2)); // 2진수 -> 10진수 ->16진수
	}
	
	/*16진수를 2진수로 변환*/
	public void hexToBinary(String hex) {
		this.hex=hex;
		this.bin=Integer.toBinaryString(Integer.parseInt(this.hex,16));  // 16진수 -> 10진수 -> 2진수
	}
	
	/*16진수를 10진수로 변환*/
	public void hexToNum(String hex) {
		this.hex=hex;
		this.num=Integer.parseInt(this.hex,16);  
	}
	
	/*10진수 출력*/
	public void printNum() {
		System.out.println("10진수 : " + this.num);
	}
	
	/*2진수 출력*/
	public void printBinary() {
		System.out.println("2진수 : "+ this.bin); 
	}
	
	/*16진수 출력*/
	public void printHex() {
	 	System.out.println("16진수 : "+ this.hex);
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input_line = sc.nextLine();
		String []arr = input_line.split(" ");
		
		Conversion cc = new Conversion();
		
		/*진수 구분하기*/
		switch(Integer.parseInt(arr[0])) {
		/*2진수*/
		case 2:
			cc.binaryToHex(arr[1]);
			cc.binaryToNum(arr[1]);
			break;
		
		/*10진수*/
		case 10:
			cc.toBinary(Integer.parseInt(arr[1]));
			cc.toHex(Integer.parseInt(arr[1]));
			break;
		
		/*16진수*/
		case 16:
			cc.hexToBinary(arr[1]);
			cc.hexToNum(arr[1]);
			break;
		}
		
		/*공통 부분*/
		cc.printNum();
		cc.printBinary();
		cc.printHex();
		
	}
}