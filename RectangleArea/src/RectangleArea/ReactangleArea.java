package RectangleArea;

/*
직사각형의 특성
그니까 가로 길이랑 세로 길이만 알면 되는거잖아
그걸 어떻게 구할까?
s
x좌표가 다른게 2개가 있을건데
for문 돌려서 x좌표가 다르면 차를 구해서 절댓값 붙이면 되지
근데 굳이 또 for문으로 다 돌릴 필요가?
그니까 모든 좌표를 다 비교할 필요 없이 딱 x좌표가 다르다고 하면 거기서 끝내야 되는거지
그럼 for문을 쓰긴 써야 하는거 아니야?
그러면 for문에서 if문 써서 x좌표가 다를 때 break; 쓰면 되지
y좌표도 마찬가지
그러면 x좌표 차랑 y좌표 차 구하는 방법이 아예 동일하니까 
그냥 함수를 만들면 되겠넹
-> 아니네 다르네 x는 dots[i][0] 인데 y는 dots[i][1]임
그냥 따로 만들어야겠네

다른 방법은... 딱히 없는듯 어차피 가로세로 길이를 구하려면 좌표 차를 구하는 수밖에 없으니까
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
[의사코드]
//가로 길이 구하기
	for(i는 0부터 3까지){
		if(dots[i][0]이랑 [i+1][0]이 다르면){
			가로길이 = 차 구해서 절댓값 붙이기
			break;
		}
	}
//세로 길이 구하기 
	for(i는 0부터 3까지){
		if(dots[i][1]이랑 [i+1][1]이 다르면){
			세로길이 = 차 구해서 절댓값 붙이기
			break;
		}
	}	
answer=가로*세로;
*/

public class ReactangleArea {
	public int solution(int[][] dots) {
		int answer = 0;
		int xDifference = 0;
		int yDifference = 0;
		int widthLength = 0;
		int heightLength = 0;

		// 가로 길이 구하기
		for (int i = 0; i < 4; i++) {
			if (dots[i][0] != dots[i + 1][0]) {
				xDifference = dots[i][0] - dots[i + 1][0];
				widthLength = (xDifference > 0) ? xDifference : -xDifference;
				break;
			}
		}

		// 세로 길이 구하기
		for (int i = 0; i < 4; i++) {
			if (dots[i][1] != dots[i + 1][1]) {
				yDifference = dots[i][1] - dots[i + 1][1];
				heightLength = (yDifference > 0) ? yDifference : -yDifference;
				break;
			}
		}

		answer = widthLength * heightLength;

		return answer;
	}

}
