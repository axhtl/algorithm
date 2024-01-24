package ThreeVillage2;

public class ThreeVillage2 {
	public int solution(int n) {
		int answer = 0;
		int cnt = 0;

		while (cnt <= n) {
			answer++;
			if (!containsThree(answer)) {
				cnt++;
			}
		}
		return answer;
	}

	private boolean containsThree(int number) {
		if (number % 3 == 0 || number % 10 == 3 || number / 10 == 3 || (number / 10) % 10 == 3) {
			return true;
		} else {
			return false;
		}
	}
}