package programmers.자료구조.다리를_지나는_트럭;

import java.util.LinkedList;

public class Solution {

	public int solution(int bridge_length, int weight, int[] truck_weights) {

		// 트럭이 지나는
		LinkedList<Integer> queue  = new LinkedList<Integer>();

		int                 answer = 0;
		int                 max    = 0;

		int                 cnt    = 0;
		while (true) {

			if (cnt == truck_weights.length) {
				break;
			}

			if (queue.isEmpty()) {
				queue.add(truck_weights[cnt]);
				max += truck_weights[cnt];
				answer++;
				cnt++;
			} else if (queue.size() == bridge_length) {
				max -= queue.removeFirst();
//				answer++;
			} else {
				if (max + truck_weights[cnt] > weight) {
					queue.add(0);
					answer++;
				} else {
					queue.add(truck_weights[cnt]);
					max += truck_weights[cnt];
					answer++;
					cnt++;
				}
			}

		}

		return answer + bridge_length;
	}

}
