package Mode;

/*
<접근방법>
같은 숫자가 여러 개면 해당 숫자를 모두 출력하는 게 아니라 그냥 -1을 출력하는 거니까
정확히 뭔지는 몰라도 되네 그냥 같은게 있는지만 확인하면 되네

일단 최빈값을 구하는거고, 최빈값 개수가 같으면 -1도 출력해야되니까
'같은 값이 몇 번 나왔는지'를 저장해야 한다.
그니까 만약에 2가 2번 나왔으면 '2번'나왔다는 데이터를 저장해야 한다.
그래야 몇 번 나왔는지를 비교해서 최빈값을 구할 수 있으니까

그러면 몇 번 나왔는지를 저장해야되니까 배열이나 리스트에 저장해야되는데
사실상 정확히 몇 번 나왔는지가 중요한 건 아니고 지금 가장 많이 나온 숫자만 구하면 되잖아
그러니까 그 방식을 이런식으로 구하는거지↓
배열 countArray[]를 하나 만들어서 여기다 '같은 경우가 몇 번 생기는지'를 저장할것임
만약 1 2 2 3 3 3 4 5 이런 배열이 있다고 하면
0번째 숫자 1과 나머지 2 2 3 3 3 4 5를 비교해서 같은 경우가 생기면 countArray[0]이 1씩 증가되는거지
1번째 숫자 2는 나머지 2 3 3 3 4 5와 비교(0번째부터 다시 비교할 필요는 없으니까)
2번째 숫자 3는 나머지 3 3 3 4 5와 비교
...
이렇게 되면 countArray[3]=2 로 '(3이 나온 횟수)-1'은 countArray[3]인 3이 되는거지
이런 방식으로 하면 다른 숫자가 같은 횟수로 나오는 경우도 인식할 수 있지

그렇다면 이제 최빈값을 리턴해야하는데
그러면 countArray[i]에서 가장 큰 값의 i를 구하면, array[i]가 최빈값이 되는거지
일단 max 변수에 값이 가장 큰 countArray[i]를 대입한다
그 다음 for문으로 i=0 부터 array.length-1 까지 만들고
만약 countArray[i]와 max가 같은 경우
변수 value에 array[i](최빈값)을 대입하고,
최빈값이 여러 개일 경우를 대비해서 count+=1;을 해준다.

만약 최빈값이 여러 개라면 count는 2개 이상이 나올 것이고,
따라서 마지막으로
if문을 써서 만약 count>=2라면 -1을 리턴하고,
아니라면 value를 answer에 대입해서 최빈값을 리턴하면 된다.
*/

public class mode {
	public int solution(int[] array) {
		int[] countArray=new int[array.length] ;
		int i, j, max=0, count=0, value=0;
       int answer = 0;
		
		for(i=0; i<array.length; i++) {
			for(j=i+1; j<array.length; j++) {
				if(array[i]==array[j]) {
					countArray[i]+=1;
				}
			}
		}
		
		for(i=0; i<array.length; i++) {
			if(max<countArray[i]){
				max=countArray[i];
			} 
		}
		
		//max값이 정해진 상태.
		
		for(i=0; i<array.length; i++) {
			if(countArray[i]==max) {
				count++;
				value=array[i];
			}
		}
		
		if(count>=2) {
			answer=-1;
		}else {
			answer=value;
			//최빈값을 answer에 넣어야지..
		}
		

       return answer;
   }
}

