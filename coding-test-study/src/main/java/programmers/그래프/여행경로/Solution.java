package programmers.그래프.여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

	static HashMap<String, ArrayList<String>> map;
	static ArrayList<String[]>                resultList = new ArrayList<String[]>();
	static String[]                           result;

	public String[] solution(String[][] tickets) {
		resultList.clear();

		// 티켓의 도착지를 알파벳순으로 정렬한다
		Arrays.sort(tickets, (o1, o2) -> {
			return o1[1].compareTo(o2[1]);
		});

		map = new HashMap<String, ArrayList<String>>();

		// 출발지, 도착지 맵을 구성한다
		for (String[] ticket : tickets) {
			ArrayList<String> list = map.getOrDefault(ticket[0], new ArrayList<String>());
			list.add(ticket[1]);
			map.put(ticket[0], list);
		}

		// 결과용 배열 초기화
		result    = new String[tickets.length + 1];

		// 출발지는 고정한다
		result[0] = "ICN";
		find(1, "ICN");

		return resultList.get(0);
	}

	public void find(int idx, String start) {

		// 티켓을 다 사용했으면 결과 배열에 등록(최초 등록이 답이다)
		if (idx == result.length) {
			resultList.add(result.clone());
			return;
		}

		ArrayList<String> list = map.getOrDefault(start, new ArrayList<String>());

		for (int i = 0; i < list.size(); i++) {

			String str = list.get(i);
			// 도착지가 널이 아니면 사용하지 않은 티켓이다
			if (str != null) {

				// 행선지에 추가
				result[idx] = str;

				// 사용체크
				list.set(i, null);
				find(idx + 1, str);
				list.set(i, str);
			}

		}

	}
}