package java_notion_4th;
import java.util.Scanner;

/* 전체 게임을 진행하는 클래스*/
public class Game {
	public static final int MAX_X = 20;
	public static final int MAX_Y = 10;
	private char map[][] = new char[MAX_Y][MAX_X];
	private GameObject m[]= new GameObject[2];  // Bear와 Fish를 나타내므로 크기가 2
	
	/*생성자*/
	public Game() { 
		for(int i=0;i<MAX_Y;i++) {
			for(int j=0;j<MAX_X;j++) {
				map[i][j]='-';
			}
		}
		m[0] = new Bear(0,0,1);
		m[1] = new Fish(5,5,1);
	}
	
	public void run() {
		System.out.println("*** Bear의 Fish 먹기 게임을 시작합니다. ***");
		
		update(); // 초기 좌표에 따른 맵 설정
		draw(); // 초기 게임 맵을 보여줌
		
		/* doesEnd가 false이면, !doesEnd가 true이므로 while문 실행됨 */
		/* doesEnd가 false라는 뜻은 Bear와 Fish가 충돌하지 않았다는 뜻 */
		while(!doesEnd()) {
			clear(); // 현재의 맵 지움
			for(int i=0;i<m.length;i++) {
				m[i].move();
			}
			update(); //움직임에 따른 변경 -> 맵 새로 적용
			draw();  // 새로운 맵 표시
		}
		System.out.println("Bear Wins!!");
	}
	
	/* Bear의 m[0]과 Fish의 m[1]의 위치에 해당 객체 모양을 값으로 대입*/
	private void update() {
		for(int i=m.length-1;i>=0;i--) {
			map[m[i].getY()][m[i].getX()] = m[i].getShape();
		}
	}
	
	/*맵 지우기 -> '-'로 값 설정*/
	private void clear() {
		for(int i=0;i<m.length;i++) {
			map[m[i].getY()][m[i].getX()] = '-';
		}
	}
	
	/*맵 그리기*/
	private void draw() {
		System.out.println();
		for(int i=0;i<MAX_Y;i++) {
			for(int j=0;j<MAX_X;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	private boolean doesEnd() {
		/*m[0]는 Bear 객체, m[1]은 Fish 객체*/
		/* Bear와 Fish가 충돌했다는 뜻은 Bear의 WIN이므로 true값 반환*/
		if(m[0].collide(m[1])) {
			return true;
		}
		/* Bear와 Fish가 충돌하지 못했으므로 false값 반환*/
		return false;
	}

	public static void main(String[] args) { 
		Game game = new Game();
		game.run();
	}


}
