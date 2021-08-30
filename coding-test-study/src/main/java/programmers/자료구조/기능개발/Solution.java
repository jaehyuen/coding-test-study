package programmers.자료구조.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public int[] solution(int[] progresses, int[] speeds) {

		List<Integer>       progressesList  = Arrays.stream(progresses)
			.boxed()
			.collect(Collectors.toList());
		List<Integer>       speedsList      = Arrays.stream(speeds)
			.boxed()
			.collect(Collectors.toList());

		// 작업 진도, 작업 속도 큐 생성
		LinkedList<Integer> progressesQueue = new LinkedList<>(progressesList);
		LinkedList<Integer> speedsQueue     = new LinkedList<>(speedsList);

		List<Integer>       result          = new ArrayList<Integer>();

		while (true) {

			// 배포 카운트
			int cnt = 0;

			// 하루 작업 시작
			for (int i = 0; i < progressesQueue.size(); i++) {
				progressesQueue.set(i, progressesQueue.get(i) + speedsQueue.get(i));

			}

			// 배포 파일 체크
			for (int i = 0; i < progressesQueue.size(); i++) {

				if (progressesQueue.get(i) >= 100) {
					cnt++;
				} else {
					break;
				}
			}

			// 배포 (삭제)
			for (int i = 0; i < cnt; i++) {

				progressesQueue.removeFirst();
				speedsQueue.removeFirst();

			}

			// 배포 건수 추가
			if (cnt > 0) {
				result.add(cnt);
			}

			// 작업이 없으면 종료
			if (progressesQueue.isEmpty()) {
				break;
			}

		}
		return result.stream()
			.mapToInt(i -> i)
			.toArray();
	}
	


}
