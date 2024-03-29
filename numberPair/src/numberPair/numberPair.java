package numberPair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class numberPair {
	class Solution {
		public String solution(String X, String Y) {
			String answer = "";
			// ArrayList<Integer> listY = new ArrayList<Integer>();
			HashMap<Integer, Integer> mapY = new HashMap<>();
			ArrayList<Integer> common = new ArrayList<Integer>();
			StringBuilder sb = new StringBuilder();

			// Y를 arrayList로 만들기
			// for (int i = 0; i < Y.length(); i++) {
			// listY.add(Character.getNumericValue(Y.charAt(i)));
			// }

			// 중복 for문으로 X와 Y비교해서 arrayList Common에 공통 숫자 넣기
			// for (int i = 0; i < X.length(); i++) {
			// for (int j = 0; j < listY.size(); j++) {
			// if (Character.getNumericValue(X.charAt(i)) == listY.get(j)) {
			// common.add(Character.getNumericValue(X.charAt(i)));
			// listY.set(j, -1);
			// break;
			// }
			// }
			// }

			// Y를 HashMap으로 만들기
			for (int i = 0; i < Y.length(); i++) {
				int num = Character.getNumericValue(Y.charAt(i));
				mapY.put(num, mapY.getOrDefault(num, 0) + 1);
			}

			// X와 Y의 공통 숫자 찾기
			for (int i = 0; i < X.length(); i++) {
				int numX = Character.getNumericValue(X.charAt(i));
				if (mapY.containsKey(numX) && mapY.get(numX) > 0) {
					common.add(numX);
					mapY.put(numX, mapY.get(numX) - 1);
				}
			}

			// 만약 common이 비어있으면 -1, 원소개수가 1개면 원소, 아니라면 정렬한다.
			if (common.isEmpty()) {
				answer = "-1";
			} else if (common.size() == 1) {
				answer = Integer.toString((common.get(0)));
			} else if (Collections.frequency(common, 0) == common.size()) {
				answer = "0";
			} else {
				Collections.sort(common, Collections.reverseOrder());
				for (int i = 0; i < common.size(); i++) {
					sb.append(common.get(i));
				}
				answer = sb.toString();
			}

			return answer;
		}
	}
}
