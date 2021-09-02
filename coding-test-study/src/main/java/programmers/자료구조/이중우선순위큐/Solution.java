package programmers.자료구조.이중우선순위큐;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public int[] solution(String[] operations) {
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		ArrayList<Integer>     list  = new ArrayList<Integer>();

		for (String operation : operations) {

			String op  = operation.substring(0, 1);
			int    cnt = Integer.parseInt(operation.substring(1).trim());

			System.out.println(op + ", " + cnt);

			if (op.equals("I")) {
//				queue.add(cnt);
				list.add(cnt);
				list.sort(null);

			} else {
				if (cnt == 1) {
					list.remove(list.size() - 1);
				} else {
					System.out.println(list + ", " + (list.size() - 1));
					list.remove(0);
					System.out.println(list);

				}
			}

		}
		if (list.isEmpty()) {
			return new int[] { 0, 0 };
		} else {
			return new int[] { list.get(list.size() - 1), list.get(0) };
		}

	}

}
