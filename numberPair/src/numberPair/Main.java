package numberPair;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String X = "100";
        String Y = "203045";

        ArrayList<Integer> listY = new ArrayList<Integer>();
		ArrayList<Integer> common = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();

		// Y를 arrayList로 만들기
		for (int i = 0; i < Y.length(); i++) {
			listY.add(Character.getNumericValue(Y.charAt(i)));
		}

        //System.out.println("Y의 리스트: " + listY);
        
        
        
        
		for (int i = 0; i < X.length(); i++) {
			for (int j = 0; j < listY.size(); j++) {
				if (Character.getNumericValue(X.charAt(i)) == listY.get(j)) {
					//listY.remove(j);
					common.add(Character.getNumericValue(X.charAt(i)));
					listY.set(j, -1);
					break;
				}
			}
		}
		
        System.out.println("common: " + common);
        
        System.out.println((X.charAt(0)));


		
    }
}
