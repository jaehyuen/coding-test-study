package baekjoon.�׷���.�ּ�_���д�_Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // ������ ����
		int E = Integer.parseInt(st.nextToken()); // ������ ����

		// ������ ������ ����Ʈ
		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}

		// �������� �Է¹޾� ����Ʈ�� ����
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());

			list.get(tmp1).add(new Node(tmp2, tmp3));
			list.get(tmp2).add(new Node(tmp1, tmp3));
		}

		// ���� �˰����� ���� �켱����ť ����
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return o1.dis - o2.dis;
		});
		boolean[] v = new boolean[V + 1]; // �湮 ó�� �迭
		long result = 0;// �����
		int cnt = 0;// ��� �湮 ī��Ʈ

		q.add(new Node(1, 0));

		// ���� �˰��� ����
		while (!q.isEmpty()) {

			// �湮 Ƚ�� �߰�
			cnt++;
			Node now = q.poll();

			if (v[now.y])
				continue;

			result += now.dis;
			v[now.y] = true;

			// ��� ��带 �湮������� �ݸ�� ����
			if (cnt == V) {
				break;
			}

			// �湮 ������ ��� ť�� ����
			for (Node next : list.get(now.y)) {
				if (!v[next.y]) {
					q.add(next);
				}
			}

		}
		System.out.println(result);
	}

}

class Node {

	int y;
	int dis;

	public Node(int y, int dis) {
		this.y = y;
		this.dis = dis;
	}

}
