package baekjoon.자료구조.최소_힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader         br    = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder          sb    = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int                    N     = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (queue.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(queue.poll()+"\n");
				}
			} else {
				queue.add(tmp);
			}

		}
		System.out.println(sb.toString());
	}

}
