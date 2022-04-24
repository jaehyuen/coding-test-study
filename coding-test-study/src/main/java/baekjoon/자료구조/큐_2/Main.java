package baekjoon.자료구조.큐_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String[] func = br.readLine().split(" ");

			switch (func[0]) {
			case "push":
				// 큐에 추가
				q.add(Integer.parseInt(func[1]));
				break;
			case "pop":
				// 큐가 비었으면 -1 아니면 맨 앞의 정수를 출력하며 큐에서 삭제
				sb.append((q.isEmpty() ? "-1" : q.poll()) + "\n");
				break;
			case "size":
				// 큐의 사이즈를 출력
				sb.append(q.size() + "\n");
				break;
			case "empty":
				// 큐가 비었으면 1 아니면 0 출력
				sb.append((q.isEmpty() ? "1" : "0") + "\n");
				break;
			case "front":
				// 큐가 비었으면 -1 아니면 맨 앞의 정수를 출력
				sb.append((q.isEmpty() ? "-1" : q.peek()) + "\n");
				break;
			case "back":
				// 큐가 비었으면 -1 아니면 맨 뒤의 정수를 출력
				sb.append((q.isEmpty() ? "-1" : q.get(q.size() - 1)) + "\n");
				break;
			}

		}
		System.out.println(sb.toString());

	}

}
