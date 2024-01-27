/*
1. 문제 이해, 재정의(공책)
2. 어떻게 해결할지 계획
	-> 푸는 방향은 간단해 보이는데
	1) 두 분수를 더한다
	2) 기약분수로 만든다
	3) 분자, 분모를 배열에 담아 리턴
	다른 방법이랄게 없음 그냥 이걸 어떻게 할건지만 해결하면됨
	
	1) 두 분수 더하기
	   1-1) 더한 분수의 분모 구하기 
	   컴퓨터상에서 직접 분수를 더하면 정확하지 않으므로, 분자 분모를 따로따로 구해야 한다
	   분모는 최소공배수
	   
	   1-2) 더한 분수의 분자 구하기
	   분모가 이미 정해졌으므로 분모를 더하기전분모1로 나눈 수를 더하기전분자1과 곱한 수 a와
	   분모를 더하기전분모2로 나눈 수를 더하기전분자2와 곱한 수b를 더하면 더한 후의 분자가 나온다.
	 
	2) 기약분수로 만든다
		어차피 분자 분모 따로 구해서 배열에 담아야 하니까 분자 분모 따로 구한다
		최대공약수(gcd) 구해서 분자 분모에 나눈다
	
	3) 분자, 분모를 배열에 담아 리턴
	
		
[의사코드]
	int[] answer=new int[2];
	
	int denom=lcm(denom1, denom2);
	int numer=addFractionN(denom, numer1, numer2);
	
	int gcd=gcd(numer, denom);
	int irreducibleNumer=기약분수(numer);
	int irreducibleNumer=기약분수(denom);
	
	addAnswer(irreducibleNumer, irreducibleNumer);
	
	
	//더한 분수의 분모 구하기(최소공배수)
	public int lcm(int denom1, int denom2){
		최소공배수 구하기
	}
	//더한 분수의 분자 구하기
	public int AddFractionN(int lcm, int denom1, int denom2, int numer1, int numer2){
		분자 구하기(lcm을 기존 분모로 나눈 값을 기존 분자와 곱하면 됨 그 후 합을 구한다)
	}
	
	//기약분수를 만들기 위해 최대공약수 구하기(gcd)
	public int gcd(int numer, int denom){
		최대공약수 구하기
	}
	//기약분수의 분모, 분자 구하기
	public int 기약분수(int num){
		num/gcd;
	}
	
	//배열에 분자 분모 담기
	public void addAnswer(int number, int denom){
		answer[0]=numer;
		answer[1]=denom;
	}
	
3. 계획 검증
4. 프로그램 짜기
 */

package FractionAddition;

class Solution {
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = new int[2];

		int denom = lcmCalculate(denom1, denom2);
		int numer = numerCalculate(denom, denom1, denom2, numer1, numer2);

		int gcd = gcd(numer, denom);
		int irreducibleNumer = irreduceNum(numer, gcd);
		int irreducibleDenom = irreduceNum(denom, gcd);

		addAnswer(irreducibleNumer, irreducibleDenom, answer);
		return answer;
	}

	// 더한 분수의 분모 구하기(최소공배수)
	public static int lcmCalculate(int a, int b) {
		int gcd = gcd(a, b);
		return Math.abs(a * b) / gcd;
	}

	// 더한 분수의 분자 구하기
	private static int numerCalculate(int lcm, int denom1, int denom2, int numer1, int numer2) {
		return (lcm / denom1) * numer1 + (lcm / denom2) * numer2;
	}

	// 기약분수를 만들기 위해 최대공약수 구하기(gcd)
	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	// 기약분수의 분모, 분자 구하기
	public int irreduceNum(int num, int gcd) {
		return num / gcd;
	}

	// 배열에 분자 분모 담기
	private static void addAnswer(int numer, int denom, int[] answer) {
		answer[0] = numer;
		answer[1] = denom;
	}

}
