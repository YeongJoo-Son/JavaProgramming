package java_notion_4th;
import java.util.Scanner;

/* Bear : 사용자의 키 입력에 따라 왼쪽, 아래, 위, 오른쪽으로 한 칸씩 움직임*/
public class Bear extends GameObject{
	
	private Scanner sc = null;
	
	public Bear(int x, int y, int distance) {
		super(x, y, distance);
		sc = new Scanner(System.in);
	}
	
	@Override
	public void move() {
		System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
		char c = sc.next().charAt(0);
		
		if (x>=0 && x<Game.MAX_X && y>=0 && y<Game.MAX_Y) {
			switch(c) {
			/* 왼쪽일 경우 */
			case 'a':
				x--;
				if(x<0) {
					x=0;
				}
				break;
			
			/* 아래쪽일 경우 */	
			case 's':
				y++;
				if(y>=Game.MAX_Y) {
					y=Game.MAX_Y-1;
				}
				break;
		
			/* 위쪽일 경우 */	
			case 'd':
				y--;
				if(y<0) {
					y=0;
				}
				break;
			
			/* 오른쪽일 경우 */	
			case 'f':
				x++;
				if(x>=Game.MAX_X) {
					x=Game.MAX_X-1;
				}
				break;
			}
		}
	}
	
	@Override
	public char getShape() { 
		return 'B'; 
	}



}