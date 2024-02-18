/*
[문제분석]
1. 매개변수는 등차수열 or 등비수열(등비는 0이 아닌 정수)인 common
2. return값은 마지막 원소 다음으로 올 숫자
3. common 길이는 3~999
4. common 원소값은 -999~1999, 정수

[알고리즘]
1. common이 등차인지 등비인지 구별
-> common 배열의 0번째 원소를 [0]이라 하면
[1]-[0] = [2]-[1] 이면 등차수열
[1]/[0] = [2]/[1] 이면 등비수열
2. 등차수열이면 앞뒤 원소값의 차를 마지막 원소에 더해주면 된다
3. 등비수열이면 앞뒤 원소값의 나머지가 0인 몫을 원소에 곱해주면 된다
*/

package nextNumber;

public class nextNumber {
	public static int kindOfSequence = 0;
	public static final int arithmeticalSequence = 1;
	public static final int geometricSequence = 2;

	public int solution(int[] common) {
		int answer = 0;
		int lastElement = common[(common.length) - 1];
		int commonDifference = 0;
		int commonRatio = 0;

		deicideKindOfSequence(common);
		answer = calculateAnswer(
				lastElement, 
				commonDifference, 
				commonRatio, 
				answer, 
				common);

		return answer;
	}

	public static void deicideKindOfSequence(int[] arr) {
		if (arr[1] - arr[0] == arr[2] - arr[1]) {
			kindOfSequence = arithmeticalSequence;
		} else {
			kindOfSequence = geometricSequence;
		}
	}

	public static int calculateAnswer(
			int lastElement, 
			int commonDifference, 
			int commonRatio, 
			int answer,
			int[] common) {
		
				if (kindOfSequence == arithmeticalSequence) {
					commonDifference = lastElement - common[(common.length - 2)];
					answer = lastElement + commonDifference;
					return answer;
				} else {
					commonRatio = lastElement / common[(common.length - 2)];
					answer = lastElement * commonRatio;
					return answer;
				}
			}	
}
