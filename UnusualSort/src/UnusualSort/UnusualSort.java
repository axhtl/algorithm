/*
1. n과의 '차'를 원소로 하는 배열 difference을 생성
2. difference를 정렬한 sortedDifference 배열 생성
3. sortedDifference 배열 요소 기준 for(int i)문 돌리고, 그 안에 difference 배열 요소 기준 for(int j)문 돌린다.
두 번째 for문 돌리면서 sortedDifference[i]랑 difference[j]가 같아질 때, answer[i]에 numlist[j]를 대입한다.

(조건)
1. 만약 i가 numlist.length-1 이라면 바로 두 번째 for문 돌리면서 sortedDifference[i]랑 difference[j]가 같아질 때, answer[i]에 numlist[j]를 대입한다.
왜냐면 2, 3번 조건에서 i+1을 쓰기 때문에 1번 조건을 따로 쓰지 않으면 ArrayIndexOutOfBoundsException이 발생한다.


2. 그렇지 않다면(1번 조건이 아니라면) -> 만약 sortedDifference[i]가 [i+1]과 다르다면 
그대로 두 번째 for문 돌리면서 sortedDifference[i]랑 difference[j]가 같아질 때, answer[i]에 numlist[j]를 대입한다.


3. 그렇지 않다면(1, 2번 조건 모두 아니라면) -> 만약 sortedDifference[i]가 [i+1]과 같다면

만약 n-numlist[j]가 0보다 크면 && 만약 sortedDifference[i]가 [i+1]과 같다면 
두 번째 for문 돌리면서 sortedDifference[i]랑 difference[j]가 같아질 때, answer[i+1]에 numlist[j]를 대입한다. 
-> 왜냐면 n-numlist[j]가 0보다 크다는 말은 같은 차이지만 numlist 배열 요소가 더 작다는 의미이기 때문

그렇지 않다면 n-numlist[j]가 0보다 작으면 && 만약 sortedDifference[i]가 [i+1]과 같다면
두 번째 for문 돌리면서 sortedDifference[i]랑 difference[j]가 같아질 때, answer[i]에 numlist[j]를 대입한다.
-> 왜냐면 n-numlist[j]가 0보다 크다는 말은 같은 차이지만 numlist 배열 요소가 더 크다는 의미이기 때문 따라서 answer에서 더 앞쪽에 와야함

sortedDifference[i]가 [i+1]과 같을 때 i와 i+1의 경우를 두 번째 for문을 통해서 한 번에 처리했으므로, i++을 통해 i를 +1 해준다.
만약 sortedDifference 배열이 0 1 1 2 2 와 같이, i와 i+1이 같은 경우에서 i+1이 마지막 배열 요소인 경우, i를 for문에서 돌릴때
for문은 종료되므로, 마지막 배열 요소 처리 과정인 1번 조건은 패스하게 된다.
*/

package UnusualSort;

import java.util.Arrays;

public class UnusualSort {
	public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int[] difference = new int[numlist.length];
        int[] sortedDifference = new int[numlist.length];
        
        // 배열 difference 생성
        for(int i=0; i<numlist.length; i++) {
        	difference[i]=Math.abs(numlist[i]-n);
        }
        
        // sortedDifference 생성(difference 정렬)
        sortedDifference = Arrays.copyOf(difference, difference.length);
        Arrays.sort(sortedDifference);
        
        // sortedDifference를 돌리면서 difference원소랑 같은 순간 answer에 numlist 대입
        for(int i=0; i<numlist.length; i++) {
        	
        	if(i==numlist.length-1) {
        		for(int j=0; j<numlist.length; j++) {
    				if(sortedDifference[i]==difference[j]) {
    					answer[i]=numlist[j];
    				}
    			}
    		}
        	
        	// sortDifference에서 값 중복이 없는 경우
        	else if(sortedDifference[i]!=sortedDifference[i+1]) {
    			for(int j=0; j<numlist.length; j++) {
    				if(sortedDifference[i]==difference[j]) {
    					answer[i]=numlist[j];
    				}
    			}
    		}
    		
    		// sortedDifference에서 값 중복이 있는 경우
        	else if(sortedDifference[i]==sortedDifference[i+1]) {
    			for(int j=0; j<numlist.length; j++) {
    				if(n-numlist[j]>0) {
        				if(sortedDifference[i]==difference[j]) {
        					answer[i+1]=numlist[j];
        				}
    				}else {
    					if(sortedDifference[i]==difference[j]) {
        					answer[i]=numlist[j];
        				}
    				}
    			}
    			i++;
    		}
        }
        
        return answer;
    }
}
