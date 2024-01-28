/*
일단 1. keyinput 배열 요소가 up이면 y좌표가 +1 되는 식으로 먼저 짜고
그 다음에 2. board 범위를 벗어나면 방향키가 무시되는 조건을 추가하는 식으로 나눠서 생각하자

1. keyinput 배열 요소에 따라 좌표 설정하기
keyinput 배열 요소에 따라 answer 배열의 요소를 변화시켜야 한다.
그 케이스가 4가지가 존재하므로, if문으로 쓰면 복잡할거같고 switch문을 쓰는게 좋겠다
switch문을 이용해서 keyinput의 배열요소가 만약에 "up"이라면, answer[1]을 +1한다.

2. board 범위를 벗어나는 방향키 무시하는 조건 추가
keyinput의 배열요소로 인해 answer의 배열요소가 바뀌는 과정에서,
만약 "up" 상황에서 board는 [7,9]인데 이미 answer[1]은 4인 상황이라면 그냥 break 한다
== 만약 board[1]/2==answer[1]인 상황이라면 break
*/

package CharacterCoordinate;

public class CharacterCoordinate {

	public int[] solution(String[] keyinput, int[] board) {
		int[] answer = new int[2];

		getAnswer(keyinput, board, answer);

		return answer;
	}

	public static void getAnswer(String[] keyinput, int[] board, int[] answer) {
		for (int i = 0; i < keyinput.length; i++) {
			switch (keyinput[i]) {
			case "up":
				if (board[1] / 2 == answer[1]) {
					break;
				}
				answer[1]++;
				break;
			case "down":
				if (-board[1] / 2 == answer[1]) {
					break;
				}
				answer[1]--;
				break;
			case "left":
				if (-board[0] / 2 == answer[0]) {
					break;
				}
				answer[0]--;
				break;
			case "right":
				if (board[0] / 2 == answer[0]) {
					break;
				}
				answer[0]++;
				break;
			}
		}
	}
}
