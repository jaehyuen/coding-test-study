package programmers.해시.베스트앨범;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public int[] solution(String[] genres, int[] plays) {

		Map<String, Integer>       genresCntMap = new HashMap<String, Integer>();       // 장르별 재생횟수 카운트
		Map<String, List<Integer>> album        = new HashMap<String, List<Integer>>(); // 앨범 수록곡

		for (int i = 0; i < genres.length; i++) {
			genresCntMap.put(genres[i], genresCntMap.getOrDefault(genres[i], 0) + plays[i]);
			List<Integer> tmp = album.getOrDefault(genres[i], new ArrayList<Integer>());

			if (tmp.size() < 1) {
				// 수록곡이 비었을때
				tmp.add(i);
			} else if (tmp.size() == 1) {
				// 수록곡이 하나있다면

				if (plays[tmp.get(0)] >= plays[i]) {
					// 1번 수록곡보다 재생수가 적으면 2번쨰 수록곡으로 추가
					tmp.add(i);
				} else {
					// 1번 수록곡보다 재생수가 많으면 1번쨰 수록곡으로 추가
					tmp.add(tmp.get(0));
					tmp.set(0, i);
				}

			} else if (tmp.size() == 2) {
				// 수록곡이 2개가 있을떄
				int max1 = tmp.get(0);
				int max2 = tmp.get(1);

				if (plays[i] == plays[max1] && plays[i] != plays[max2]) {
					// 1번 수록곡과 재생수가 같다면 2번째 수록곡으로 추가
					tmp.remove(1);
					tmp.add(i);

				} 
				else if (plays[i] > plays[max1] && plays[i] > plays[max2]) {
					// 1번 수록곡보다 재생수가 많으면 1번쨰 수록곡으로 추가

					tmp.set(1, max1);
					tmp.set(0, i);

				} else if (plays[i] < plays[max1] && plays[i] > plays[max2]) {
					// 2번 수록곡보다 재생수가 많으면 2번쨰 수록곡으로 추가
					tmp.set(1, i);
				}

			}

			album.put(genres[i], tmp);

		}

		// 많이 재생된 순서 정렬
		List<String> listKeySet = new ArrayList<>(genresCntMap.keySet());
		Collections.sort(listKeySet, (value1, value2) -> (genresCntMap.get(value2)
			.compareTo(genresCntMap.get(value1))));

		List<Integer> result = new ArrayList<Integer>();
		for (String key : listKeySet) {
			result.addAll(album.get(key));
		}

		return result.stream()
			.mapToInt(i -> i)
			.toArray();
	}

}
