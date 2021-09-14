package programmers.탐욕법.섬_연결하기;

import java.util.Arrays;

class Solution {
	public int solution(int n, int[][] costs) {

		int answer = 0;

		Arrays.sort(costs, (o1, o2) -> {
			return o1[2] - o2[2];
		});

		// 부모노드를 기억한다.
		int[] parent = new int[n];

		// 초기 값 지정.
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int[] cost : costs) {

			int from  = cost[0];
			int to    = cost[1];
			int value = cost[2];

			if (connectCheck(parent, from, to))
				continue;
			else {

				answer += value;
				union(parent, from, to);
			}

		}

		return answer;

	}

	private static void union(int[] parent, int from, int to) {
		from = getParent(parent, from);
		to   = getParent(parent, to);

		if (from < to)
			parent[to] = from;
		else
			parent[from] = to;
	}

	private static boolean connectCheck(int[] parent, int from, int to) {

		from = getParent(parent, from);
		to   = getParent(parent, to);

		return from == to;
	}

	private static int getParent(int[] parent, int edge) {
		if (parent[edge] == edge)
			return edge;
		return getParent(parent, parent[edge]);
	}
}