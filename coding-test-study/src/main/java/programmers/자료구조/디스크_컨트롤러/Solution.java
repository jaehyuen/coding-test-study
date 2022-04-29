package programmers.자료구조.디스크_컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public int solution(int[][] jobs) {

		// 배열 정렬
		Arrays.sort(jobs, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];

		});

		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> {
			return o1[1] - o2[1];
		});

		q.add(jobs[0]);
		int time = jobs[0][0];
		int sum  = 0;
		int idx  = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			// 종료(현재)시간 갱신
			time += now[1];

			// 종료시간에서 시작 시간을 빼서 계산
			sum  += time - now[0];

			// 큐에 증가
			while (idx < jobs.length && jobs[idx][0] <= time) {
				q.add(jobs[idx]);
				idx++;

			}

			// 일이 없으면 다음일이 나올떄까지 시간증가
			if (idx < jobs.length && q.isEmpty()) {
				
				time += jobs[idx][0];
				q.add(jobs[idx]);
				idx++;
			}

		}
//		System.out.println(sum);
//		System.out.println(sum / jobs.length);

		return sum / jobs.length;

	}

}
