/*
1. 문제 이해, 재정의
2. 어떻게 해결할지 계획
	일단 어떻게 풀어야할지 잘 모르겠으니까 예제를 보면서 흐름을 좀 본다
	치킨 1081마리를 시킴 -> 쿠폰 1081장 생김 -> (**)서비스치킨 1081/10 마리 & 쿠폰 1081&10 장 남음 -> 서비스치킨으로부터 쿠폰이 생성되므로 누적된 쿠폰은 ( 서비스치킨수+원래있던쿠폰수 )
	-> 그럼 다시 반복임. 만약 누적된 쿠폰(n장)이 10장 이상이라면, (**)반복 서비스치킨 n/10마리 & 쿠폰 n%10장 남음 -> ... 누적 쿠폰이 10장 미만이 될 때까지 반복
	
	정리)
	1. 처음 치킨을 시키면, 치킨 수만큼 쿠폰이 생김
	2. 쿠폰으로 서비스치킨(serviceChicken)을 시킴 + 시키고 남은 쿠폰 -> 총 쿠폰 수: 서비스치킨으로 받은 쿠폰 + 시키고 남은 쿠폰
	3. 만약 총 쿠폰 수가 10장 이상이라면 2번 다시 반복, 미만이라면 끝
	4. 총 서비스치킨 수(totalServiceChicken)를 리턴
	
3. 계획검증(예제에 대입해서 맞는 흐름인지 확인)
	
[의사코드]
totalCoupon=chicken;

totalServiceChickenCalculate(totalCoupon);

private static int totalServiceChickenCalculate(int totalCoupon){
	while(totalCoupon>=10){
		서비스치킨수=총쿠폰수/10;
		남은쿠폰수=총쿠폰수%10;
		총쿠폰수=남은쿠폰수+서비스치킨수
	
		총서비스치킨수+=서비스치킨수;
	}
	return 총서비스치킨수;
}

*/

package ChickenCoupon;

public class ChickenCoupon {
	int chicken;
	int coupon;
	int totalCoupon;
	int serviceChicken;
	int totalServiceChicken;

	public int solution(int chicken) {
		int answer = -1;

		totalCoupon = chicken;
		answer = totalServiceChickenCalculate(totalCoupon, serviceChicken, coupon, totalServiceChicken);

		return answer;
	}

	private static int totalServiceChickenCalculate(int totalCoupon, int serviceChicken, int coupon,
			int totalServiceChicken) {
		while (totalCoupon >= 10) {
			serviceChicken = totalCoupon / 10;
			coupon = totalCoupon % 10;
			totalCoupon = coupon + serviceChicken;

			totalServiceChicken += serviceChicken;
		}
		return totalServiceChicken;
	}
}
