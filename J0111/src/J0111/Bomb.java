package J0111;

/* 
 <접근방법>
 리턴값을 구하려면 '총 지뢰수 + 지뢰주변 X 개수'를 구해야 한다.
 지뢰와 X는 구분되어야 한다. 그래야 각각의 지뢰를 인식해서 주변을 X로 만들 수 있으니까
 
 그러면 지뢰 위치에 1이 있으니까
 X를 2로 바꾸면 지뢰와 X를 구분할 수 있다.
 X를 2로 바꾸면 지뢰주위가 겹쳐도 상관없다.
 
 그렇다면 문제는 이제 지뢰의 위치에 따른 X를 어떻게 설정할 것이냐 인데
 경우를 나눠보면
 1) 지뢰가 구석에 있는 경우 - 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
 2) 지뢰가 구석이 아닌 모서리에 있는 경우 - 맨 윗줄, 맨 아랫줄, 맨 왼쪽줄, 맨 오른쪽줄
 3) 1,2의 경우가 모두 아닐 때
 
 if문을 써서 위치에 1이 있을 때 그 주변을 2로 바꾼다.
 만약 주변에 다른 지뢰가 있을 경우 1도 2로 바꿔버리게 되면 지뢰가 없어지는 꼴이 되므로
 if문 안에 if문을 만들어서 지뢰 주변이 1이 아닌 경우에만 2로 바꾼다.
 */


public class Bomb {
	    public int Bombcount(int[][] board) {
	        int answer = 0;
	        int bombCount=0;
	        
	        for(int p=0; p<board.length; p++){
                for(int q=0; q<board.length; q++){ //n행 n열이니까 둘다 board.length-1까지 해도 됨
	        
                	
                	if(p==0 && q==0 && board[p][q]==1){ //지뢰가 모서리 맨 왼쪽 위에 있는 경우
                		for(int i=0; i<=1; i++){
                			for(int j=0; j<=1; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else if(p==0 && q==board.length-1 && board[p][q]==1) {  //지뢰가 모서리 맨 오른쪽 위에 있는 경우
                		for(int i=0; i<=1; i++){
                			for(int j=board.length-2; j<=board.length-1; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else if(p==board.length-1 && q==0 && board[p][q]==1) {  //지뢰가 모서리 맨 왼쪽 아래에 있는 경우
                		for(int i=board.length-2; i<=board.length-1; i++){
                			for(int j=0; j<=1; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else if(p==board.length-1 && q==board.length-1 && board[p][q]==1) { //지뢰가 모서리 맨 오른쪽 아래에 있는 경우
                		for(int i=board.length-2; i<=board.length-1; i++){
                			for(int j=board.length-2; j<=board.length-1; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else if(p==0 && q!=0 && q!=board.length-1 && board[p][q]==1 ) { //맨 위 모서리에 지뢰가 있는 경우 
                		for(int i=p; i<=p+1; i++){
                			for(int j=q-1; j<=q+1; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else if(p==board.length-1 && q!=0 && q!=board.length-1 && board[p][q]==1) { //맨 아래 모서리에 지뢰가 있는 경우
                		for(int i=p-1; i<=p; i++){
                			for(int j=q-1; j<=q+1; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else if(q==0 && p!=0 && p!=board.length-1 && board[p][q]==1) { //맨 왼쪽 모서리에 지뢰가 있는 경우
                		for(int i=p-1; i<=p+1; i++){
                			for(int j=q; j<=q+1; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else if(q==board.length-1 && p!=0 && p!=board.length-1 && board[p][q]==1) { //맨 오른쪽 모서리에 지뢰가 있는 경우
                		for(int i=p-1; i<=p+1; i++){
                			for(int j=q-1; j<=q; j++){
                				if(board[i][j]!=1){
                					board[i][j]=2;
                				}
                			}
                		}
                	}else { //모서리에 없는 경우
                		if(board[p][q]==1) {
                			for(int i=p-1; i<=p+1; i++){
                    			for(int j=q-1; j<=q+1; j++){
                    				if(board[i][j]!=1){
                    					board[i][j]=2;
                    				}
                    			}
                			}
                		}
                	}
                	
                }
	        }
	        	
	        for(int i=0; i<board.length-1; i++){
	                for(int j=0; j<board.length-1; j++){
	                    if(board[i][j]==1 || board[i][j]==2){
	                        bombCount+=1;
	                    }
	                }
	        }
	        answer=(board.length)*(board.length)-bombCount;
	        
	        return answer;
	    }
}
