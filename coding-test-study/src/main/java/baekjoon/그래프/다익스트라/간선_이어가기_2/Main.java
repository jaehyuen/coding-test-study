package baekjoon.�׷���.���ͽ�Ʈ��.����_�̾��_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		// ���ͽ�Ʈ�� �˰����� �̿��ϱ����� ����Ʈ �ʱ�ȭ
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		// �� ������ ����ġ�� ����Ʈ�� �����Ѵ�
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		// ����, ���� ���� �Է�
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		Node[] nodeList = new Node[n + 1];
		boolean[] v = new boolean[n + 1];

		
		//s -> t ����ġ �ʱ�ȭ (�ڱ��ڽ��϶� 0)
		for (int i = 1; i <= n; i++) {
			if (i == s) {

				nodeList[i] = new Node(i, 0);
			} else {
				nodeList[i] = new Node(i, 987654321);
			}

		}

		//���ͽ�Ʈ�� �˰����� ���� ť ����
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return o1.dis - o2.dis;
		});
		q.add(nodeList[s]);
		v[s] = true;

		while (!q.isEmpty()) {
			Node now = q.poll();
			v[now.y] = true;

			for (Node next : list.get(now.y)) {
				if (v[next.y])
					continue;

				// �ٸ����� ���İ��� ����ġ�� �� ������ ť ������Ʈ
				if (nodeList[next.y].dis > nodeList[now.y].dis + next.dis) {

					nodeList[next.y].dis = nodeList[now.y].dis + next.dis;

					q.remove(nodeList[next.y]);
					q.add(nodeList[next.y]);

				}
			}
		}
		
		System.out.println(nodeList[t].dis);

	}
}

class Node {
	int y;
	int dis;

	Node(int y, int dis) {
		this.y = y;
		this.dis = dis;
	}
}
