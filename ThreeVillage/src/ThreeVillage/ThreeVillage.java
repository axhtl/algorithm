package ThreeVillage;

/*
음..그냥 규칙을 찾아야 하는 거 같은데?
일단 3의 배수는 3번마다 하나씩 생기지
그리고 숫자 3은 30번대를 제외하고는 항상 1,2, '3'번째에 존재하지.
두 케이스가 같아지는 때는 3, 33, 63, 93

근데 전체를 결정하는 하나의 규칙은 찾기가 좀 힘든거같고
좀 분류해서 봐야될거같은데
왜냐면 30번대는 아예 건너뛰는거니까 어차피 통합적인 규칙은 못 찾네 어차피 분류해야되는거구나

근데 어떻게 해야될지를 모르겠다
일단 예제1을 어떻게 나오게 하면 좋을지 그 알고리즘 먼저 생각해보자

for문으로 n이 3의배수, 3을10으로나눈몫이3인거, 나머지가3인거 제외하면서
cnt++ 했을 때 cnt가 n이 되는 시점까지 반복하면서
answer++은 계속 해주는거야
그러면 될거같은데

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
오류가 계속 나서 봤더니
30번대랑, 끝자리가 3인 경우 이외에도
130과 같은 숫자도 걸러야됨 이걸 못 걸렀음

n=100인 경우도 answer가 300을 넘진 않으니까 첫째자리숫자가 3인 경우 제외, 
맨 마지막 자리 숫자가 3인 경우는 조건으로 되어있음
그러면 중간 두 번째 자리 숫자가 3인 경우는 어떻게 조건으로 만들까?

계속 해봐도 안돼서.. (i/100)%10==3 이 조건을 추가했는데 안되네.
일단 예제2, n=40, result=76 까지 통과된걸 봐서는
확실히 i가 100이 넘어갔을 때 중간 자리가 3인 경우 때문에 통과가 안되는거같거든.
일단 확인을 해보자
if(i%3==0 || i/10==3 || i%10==3 || i==130 || i==131 || i==132 || i==131 ||
              i==132 || i==133 || i==134 || i==135 || i==136 ||i==137 ||
              i==138 ||i==139)
이렇게 했더니 통과됨. 맞네 그러면 (i/100)%10==3 < 이 조건이 잘못된 거구나
?? (i/10)%10==3 이거잖아... 뭐야
 */


public class ThreeVillage {
	public int solution(int n) {
		int answer = 0;
		int i = 1;
		int cnt = 0;

		while (true) {
			answer++;

			if (i % 3 == 0 || i / 10 == 3 || i % 10 == 3 || (i / 10) % 10 == 3) {
			} else {
				cnt++;
			}

			i++;
			if (cnt == n) {
				break;
			}
		}

		return answer;
	}
}