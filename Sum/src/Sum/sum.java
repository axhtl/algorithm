package Sum;

/*
 <접근방법>
 어차피 연속된 수니까 첫 번째 배열 요소를 어떻게 구할지만 정하고 나머지는 첫 번째 요소에 +1해서 넣어주기만 하면 된다.
 생각나는 방법은 두 가지인데
 방법1) 첫 번째 배열 요소를 변수 k로 두고, k+(k+1)+(k+2)...=total 방정식을 k로 풀어서 계산
 방법2) 첫 번째 배열 요소를 num과 total의 관계로 정의하고 시작
 
 방법1부터 생각해보면
 첫 번째 배열 요소를 k라고 하고 i=0부터 num-1까지 더한 값을 k에 대한 식으로 정리해야 되는데
 어떻게 정리하지?
 
 일단 경우는 두 가지로 나눠진다
 경우1) num이 짝수인 경우
 num이 짝수면 
 예를 들어 1 2 3 4 에서
 배열요소의 총합은, (맨 앞 배열요소 + 맨 뒤 배열요소)가 배열총개수/2 만큼 있는거니까
 => ( k+(k+(num-1)) )*(num/2)=total 이렇게 정리할 수 있다.
 이 방정식으로는 k값을 못 구하니까, k= 식으로 변형시키면
 => k=(2*total/num + 1 - n)*1/2
 
 경우2) num이 홀수인 경우
 (맨 앞 배열요소 + 맨 뒤 배열요소)가 배열총개수/2 만큼 합이 반복되고, 거기에 중간값이 한번 더 더해져야함
 => ﻿( (k)+(k+(num-1)) )*(num/2-1/2) + ( (k)+(k+(num-1)) )/2 == total
 이걸 k= 식으로 변형시키면 되는데,
 위 식에서 num/2는 소수점이 나오게 되므로(num이 홀수니까) 1/2를 빼준다.
 => k=(2*total/num+1-num)*(1/2)
 
 마지막으로 for문을 이용해서 
 i=0부터 num-1까지 answer[i]에 k+i를 대입한다.
 */

public class sum {
	public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int firstElement,a;
        
        if(num%2==0) {
            a = total/(num/2);
            firstElement=(a-num+1)/2;
            
            } else {
            	firstElement = (2*total/num+1-num);
            	firstElement /= 2;		
            }
        
                    for (int i = 0; i < num; i++) {
                answer[i] = firstElement + i;
            }

        
        return answer;
    }
}
