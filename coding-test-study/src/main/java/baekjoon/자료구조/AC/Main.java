package baekjoon.자료구조.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int            T  = Integer.parseInt(br.readLine());
		StringBuilder  sb = new StringBuilder();

		for (int i = 0; i < T; i++) {

			Deque<Integer> deque = new LinkedList<Integer>();

			String[]       func  = br.readLine()
				.split("");
			int            size  = Integer.parseInt(br.readLine());

			if (size < 1) {
				br.readLine();
			} else {
				for (String a : br.readLine()
					.replaceAll("\\[", "")
					.replaceAll("\\]", "")
					.split(",")) {
					deque.add(Integer.parseInt(a));
				}

			}

			boolean isReverse = false;
			boolean isError   = false;

			for (String f : func) {
				if (f.equals("R")) {
					isReverse = !isReverse;
				} else if (f.equals("D") && size > 0) {

					if (isReverse) {

						deque.removeLast();
					} else {
						deque.removeFirst();
					}

					size--;
				} else {
					isError = !isError;
					sb.append("error");
					break;
				}
			}

			if (!isError) {
				sb.append("[");
				if (isReverse) {
					for (int j = size - 1; j >= 0; j--) {

						sb.append(deque.removeLast());
						if (j != 0)
							sb.append(",");
					}
				} else {
					for (int j = 0; j < size; j++) {

						sb.append(deque.removeFirst());
						if (j != size - 1)
							sb.append(",");
					}
				}

				sb.append("]");
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());

	}

}
