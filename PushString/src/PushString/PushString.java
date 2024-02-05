/*
for문으로 알파벳 개수만큼 문자열 밀면서 카운트 세다가
B랑 같아지면 카운트 리턴하면 되고
B랑 안 같아지면 -1 리턴하면 되잖아

맨 첫글자를 맨 뒤로 보내고, 맨 뒷글자를 맨 앞으로 보내면 되지
만약에 A가 hello다 그러면 맨 마지막 o + substring으로 hell 까지만 해서 다시 A를 정의하면 된다
*/

package PushString;

public class PushString {
	public int solution(String A, String B) {
		int answer = 0;

		return getPushNum(answer, A, B);
	}

	public static int getPushNum(int answer, String A, String B) {
		for (int i = 0; i < A.length(); i++) {
			if (A.equals(B)) {
				return answer;
			}

			A = A.charAt(A.length() - 1) + A.substring(0, A.length() - 1);
			
			answer++;

		}

		answer = -1;

		return answer;
	}
}
