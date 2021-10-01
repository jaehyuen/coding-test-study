package baekjoon.자료구조.덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner        s     = new Scanner(System.in);
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st    = new StringTokenizer(br.readLine());
//		int            N     = Integer.parseInt(s.nextLine());
		int            N     = Integer.parseInt(br.readLine());

		StringBuilder  sb    = new StringBuilder();

		Deque<Integer> deque = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
//			String[] arr = s.nextLine()
//				.split(" ");
			String[] arr = br.readLine()
				.split(" ");

			switch (arr[0]) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(arr[1]));
				break;
			case "push_back":
				deque.offerLast(Integer.parseInt(arr[1]));
				break;
			case "pop_front":
//				System.out.println(deque.isEmpty() ? "-1" : deque.removeFirst());
				sb.append(deque.isEmpty() ? "-1\n" : deque.removeFirst() + "\n");
				break;
			case "pop_back":
//				System.out.println(deque.isEmpty() ? "-1" : deque.removeLast());
				sb.append(deque.isEmpty() ? "-1\n" : deque.removeLast() + "\n");
				break;
			case "size":
//				System.out.println(deque.size());
				sb.append(deque.size() + "\n");
				break;
			case "empty":
//				System.out.println(deque.isEmpty() ? "1" : "0");
				sb.append(deque.isEmpty() ? "1\n" : "0\n");
				break;
			case "front":
//				System.out.println(deque.isEmpty() ? "-1" : deque.getFirst());
				sb.append(deque.isEmpty() ? "-1\n" : deque.getFirst() + "\n");
				break;
			case "back":
//				System.out.println(deque.isEmpty() ? "-1" : deque.getLast());
				sb.append(deque.isEmpty() ? "-1\n" : deque.getLast() + "\n");
				break;

			default:
				break;
			}

		}
		System.out.println(sb.toString());

	}

}
