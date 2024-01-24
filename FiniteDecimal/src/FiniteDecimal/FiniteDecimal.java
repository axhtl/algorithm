package FiniteDecimal;

public class FiniteDecimal {
    public int solution(int a, int b) {
        int answer = 0;
        
        for(int i=1; i<1000; i++) {
        	if(a%i==0 && b%i==0) {
        		a/=i;
        		b/=i;
        	}
        }
        
        while(b%2==0) {
        	b/=2;
        }
        while(b%5==0) {
        	b/=5;
        }    
        
//        int denominator2=divideNum(b,2);
//        b=divideNum(denominator2,5);
        
       answer = (b==1) ? 1 : 2;
       
       return answer;
    }
    
//    static int divideNum(int denominator, int num) {
//    	while(denominator%num==0) {
//    		denominator/=num;
//    	}
//    	return denominator;
//    }
}
