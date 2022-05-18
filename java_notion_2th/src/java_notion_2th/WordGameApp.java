package java_notion_2th;
import java.util.Scanner;

/*=========================Player 클래스=========================*/
/*게임 참가자의 이름 필드와 사용자로부터 단어를 입력 받는 메소드 등으로 구성*/
class Player{
	Scanner sc = new Scanner(System.in);
	private String player_name; // 변수 : 게임 참가자의 이름 
	private String input_word;  // 변수 : 단어 입력받기 위한 변수
	static String left_word; // 변수 : 끝말잇기 할 때 왼쪽(앞) 단어
	static String right_word; // 변수 : 끝말잇기 할 때 오른쪽(뒤) 단어
	
	/* 생성자 : String매개변수를 받아와 초기화*/
	public Player(String player_name) {  
		this.player_name=player_name;
	}
	
	/* 사용자로부터 단어를 입력 받는 메소드 */
	public boolean input(String input_word) {
		this.input_word=input_word;
		left_word=input_word;
		right_word=sc.next();
		
		int end = left_word.length()-1;
		char end_char = left_word.charAt(end);
		char start_char = right_word.charAt(0);
		
		if(end_char != start_char) { // 앞 단어의 끝 문자와 뒷 단어의 앞 문자가 다른 경우
			System.out.println(getPlayerName()+"이 졌습니다.");
			return false; //종료
		}
		return true;
	}
	
	/* player_name이 private이므로 public메소드를 통해 private 변수 얻기 위함*/
	public String getPlayerName() {
		return player_name;
	}
	
	/* input_word가 private이므로 public메소드를 통해 private 변수 얻기 위함*/
	public String getInputWord() {
		return input_word;
	}
}

/*=========================WordGameApp 클래스=========================*/
/* 생성자, main(), 게임을 전체적으로 진행하는 run()메소드 등으로 구성*/
public class WordGameApp {
	private String start_word = "와이파이";
	private Player []arr;
	Scanner sc = new Scanner(System.in);

	/* 생성자 */
	public WordGameApp() {
	}
	
	/* run() : 선수 숫자 만큼의 Player 객체 생성, while문을 통해 게임 진행 */
	public void run(int num) {
		Player []arr = new Player[num];
		for(int i=0;i<num;i++) {
			System.out.print("참가자의 이름을 입력하세요 >> ");
			String player_name=sc.next();			
			this.arr[i]=new Player(player_name);
					
		}
		System.out.println("시작하는 단어는 " + this.start_word + "입니다.");
		
		boolean flag=true;
		while(flag) {
			for(int i=0;i<num;i++) {
				System.out.print(this.arr[i].getPlayerName() + " >> " );
				flag=this.arr[i].input(this.start_word);
				if(!flag) {
					break;
				}
				this.start_word = this.arr[i].right_word;
				
				
			}
		}
	}
	
	/* 게임 참가자 수를 입력 받고 player객체 생성, private*/
	private void createPlayer() {
		System.out.print("게임에 참가하는 인원은 몇명입니까 >> ");
		int num = sc.nextInt();
		this.arr = new Player[num];
		run(num);  /*run메소드에 num값을 넘겨줌으로써 참가자 수 정보 제공*/
	}
	
	public static void main(String[] args) {
		WordGameApp wga = new WordGameApp();
		wga.createPlayer();
		
	}

}
