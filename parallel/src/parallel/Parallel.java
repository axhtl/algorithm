package parallel;

public class Parallel {
	
	/*
	 평행의 조건은 기울기가 같아야 하는 것임
	따라서 (y2-y1)/(x2-x1) 의 값이 동일하면 평행이다.
	모든 경우의 수를 구해본 뒤, 같은 값이 있으면 1을 반환한다. 없으면 0 반환
	
	모든 기울기를 구하는 경우의 수는 for문으로 하면 될거같은데, 나온 기울기 값끼리 비교는 어떻게 하지?
	비교 자체를 for문으로 해야하나?
	그러면 두 점의 기울기가 다른 두 점의 기울기와 비교하는 걸 for문으로 반복하면 되겠다
	
	반복은 어떤식으로 하지?
	1,2 / 3,4(점)
	1,3 / 2,4 
	1,4 / 2,3
	-> 모든 경우의 수는 1이 2,3,4와 한 번씩 짝을 맺는 경우가 전부다.
	
	근데 경우의 수가 얼마 없어서 그냥 for문 말고 if문으로만 써도 될 거 같은데
	그러면 1,2가 짝지어진 경우 / 1,3이~ / 1,4가~ 인 경우로 나눠서 기울기가 같은 경우가 있는지 확인하면 되겠다.
	*/
	
	
    public int solution(int[][] dots) {
        int answer = 0;
        
        int slope12=(dots[1][1]-dots[0][1]) / (dots[1][0]-dots[0][0]);
		int slope34=(dots[3][1]-dots[2][1]) / (dots[3][0]-dots[2][0]);
		
		int slope13=(dots[2][1]-dots[0][1]) / (dots[2][0]-dots[0][0]);
		int slope24=(dots[3][1]-dots[1][1]) / (dots[3][0]-dots[1][0]);
		
		int slope14=(dots[3][1]-dots[0][1]) / (dots[3][0]-dots[0][0]);
		int slope23=(dots[2][1]-dots[1][1]) / (dots[2][0]-dots[1][0]);
		
		//경우가 생각보다 많은데? for문으로 못 쓰나? 근데 for문으로 쓰면 결과값을 저장하려면 배열을 만들어야 하지않나? 일단 if문으로만 풀어보자
        
        
        if(slope12==slope34) {
			System.out.println("점 ["+dots[0][0]+","+dots[0][1]+"], ["+dots[1][0]+","+dots[1][1]+"]을 잇고 ["+dots[2][0]+","+dots[2][1]+"], "+dots[3][0]+","+dots[3][1]+"]를 이으면 두 선분은 평행합니다.");
            answer=1;
		}else if(slope13==slope24) {
			System.out.println("점 ["+dots[0][0]+","+dots[0][1]+"], ["+dots[2][0]+","+dots[2][1]+"]을 잇고 ["+dots[1][0]+","+dots[1][1]+"], "+dots[3][0]+","+dots[3][1]+"]를 이으면 두 선분은 평행합니다.");
            answer=1;
		}else if(slope14==slope23) {
			System.out.println("점 ["+dots[0][0]+","+dots[0][1]+"], ["+dots[3][0]+","+dots[3][1]+"]을 잇고 ["+dots[1][0]+","+dots[1][1]+"], "+dots[2][0]+","+dots[2][1]+"]를 이으면 두 선분은 평행합니다.");
            answer=1;
		}else {
			System.out.println("점을 어떻게 연결해도 평행하지 않습니다.");
            answer=0;
		}
    
        return answer;
    }
}
