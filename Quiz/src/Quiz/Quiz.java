package Quiz;

/*
(1. 필수로 해줘야 하는 과정을 생각)
일단 문제를 보면 문자열에 있는 내용을 컴퓨터가 직접 계산을 해야된단말임
그러면 문자열로 냅두면 컴퓨터가 계산을 못하잖아
그러니까 문자열을 수식으로 바꿔주는 과정이 일단 필요하지
그럼 어떻게 바꿔주지?

예를 한번 들어보자
quiz[0] = "-3 + 5 = 2"
그럼 이걸 수식으로 어떻게 바꾸지..?
공백을 기준으로 split 하면 될거같은데
그러면 -3 / + / 5 / = / 2 이렇게 나뉠거아니야
그러면 이걸 parts 배열에 담고
part 배열 요소에서 0번째, 2번째, 4번째만 정수로 바꿔(1,3번째는 항상 연산자니까)
그리고 연산자는 뭐 문자열에서 다시 연산자로 바꿀 수가 없는거같은데
그러면 if문으로 parts 3번째 요소를 문자열로 비교하면 되지 +인지 -인지


(2. 계획 세우기)
	for(){ //quiz 배열 요소 1부터 n까지(n은 배열의 크기) / quiz[i]을 하나씩 처리 -> 문자열 반환
		quiz[i]의 문자열을 공백으로 나눈다 그걸 parts 배열에 저장한다(0,2,4번째가 정수 / 1,3은 연산자 항상)
		for(){
			parts 배열의 0,2,4번째를 모두 정수로 변환!
		}
		
			if(만약 parts의 1번째 배열 요소가 "+"와 같다면){
				boolean OX = parts[0]+parts[2]=parts[4];
				if(OX가 true 라면){
					answer[i]="O";
				}else{
					answer[i]="X";
				}
			}
			
			if(만약 3번째 배열 요소가 "-"와 같다면){
				boolean OX = parts[0]-parts[2]=parts[4];
				if(OX가 true 라면){
					answer[i]="O";
				}else{
					answer[i]="X";
				}
			}
		}
		
		for(){
			answer의 배열 나열
		}
	
	(3. 계획을 검증)
	예제를 하나씩 대입해보자
	
	
	(4. 개선할 방법)
	for문 안에서 너무 한 번에 계산하려고 하니까 메서드를 따로 만들어서 나눠서 관리하기
	+인 경우, -인 경우를 모두 적지 말고, 메서드 하나 만들어서 매개변수만 바꿔주기
*/


class Quiz {
	public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];
		int[] numParts = new int[5];

		for (int i = 0; i < quiz.length; i++) {
			String[] parts = quiz[i].split(" ");

			for (int j = 0; j < 5; j += 2) {
				numParts[j] = Integer.parseInt(parts[j]);
			}

			if (parts[1].equals("+")) {
				if (numParts[0] + numParts[2] == numParts[4]) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			}
			if (parts[1].equals("-")) {
				if (numParts[0] - numParts[2] == numParts[4]) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			}
		}

		return answer;
	}
}
