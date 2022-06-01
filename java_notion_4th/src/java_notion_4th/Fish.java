package java_notion_4th;

/* Fish : 다섯 번 중 세 번은 제자리에 있고, 나머지 두 번은 4가지 방향 중 랜덤하게 한 칸씩 움직임*/
public class Fish extends GameObject{
	public Fish(int x, int y, int distance) {
		super(x,y,distance);
	}
	  
	@Override
	public void move() {
		int xORy;
		int n;
		
		//이때만 움직일 수 있도록 (Bear도 마찬가지)
		if (x>=0 && x<Game.MAX_X && y>=0 && y<Game.MAX_Y) {					 
			n = (int)(Math.random()*5); //0,1,2,3,4 
				
			if(n==0) {
				/*xORy는 0과 1 중 랜덤으로! 0이면 x좌표로 +1움직이고, 1이면 y좌표로 +1움직이기*/
				xORy = (int)(Math.random()*2);
				if(xORy==0) {
					x+=distance;
				}
				else {
					y+=distance;
				}		
			}
			else if(n==1){
				/*xORy는 0과 1 중 랜덤으로! 0이면 x좌표로 -1움직이고, 1이면 y좌표로 -1움직이기*/
				xORy = (int)(Math.random()*2);
				if(xORy==0) {
					x-=distance;
				}
				else {
					y-=distance;
				}
			}
			 
		 } 
	 
		/*맵 크기를 벗어나지 않기 위함*/
		 else if(x<0) {
			x=0;
		}
		 else if(x>=Game.MAX_X) {
			x = Game.MAX_X-1;
		}
		
		/*맵 크기를 벗어나지 않기 위함*/
		 else if(y<0) {
			y=0;
		}
		 else if(y>=Game.MAX_Y) {
			y=Game.MAX_Y-1;
		}

			
	}	
	
	@Override
	public char getShape() { 
		return '@'; 
	}

}
