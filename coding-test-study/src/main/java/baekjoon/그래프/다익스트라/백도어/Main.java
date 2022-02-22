package baekjoon.�׷���.���ͽ�Ʈ��.�鵵��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// �б��� ����
		int M = Integer.parseInt(st.nextToken());// �б����� �մ� ���� ��

		int[] ward = new int[N];// �þ� �迭

		// �б��� ����Ʈ
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		// �б��� ����Ʈ �ʱ�ȭ �� �þ����� ����
		for (int i = 0; i < N; i++) {
			ward[i] = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<>());
		}

		// ������ �б����� �ƴϸ� �þ߿� ���� �ȵǴ� �游 �����Ѵ�
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			long tmp3 = Long.parseLong(st.nextToken());

			if ((ward[tmp1] != 1 && ward[tmp2] != 1) || (tmp1 == N - 1 || tmp2 == N - 1)) {
				list.get(tmp1).add(new Node(tmp2, tmp3));
				list.get(tmp2).add(new Node(tmp1, tmp3));
			}

		}

		// �켱����ť ����
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return Long.compare(o1.dis, o2.dis);
		});

		Node[] nodeList = new Node[N];
		boolean[] v = new boolean[N];

		//���ͽ�Ʈ��� �迭 �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				nodeList[i] = new Node(i, 0);
			} else {
				nodeList[i] = new Node(i, Long.MAX_VALUE);
			}
		}

		//������ ť�� ���
		q.add(nodeList[0]);

		while (!q.isEmpty()) {
			Node now = q.poll();

			//�湮�߾����� ��Ƽ��
			if (v[now.y])
				continue;

			v[now.y] = true;

			for (Node next : list.get(now.y)) {
				//�Ÿ��� �� ª�ٸ� ť ����
				if (nodeList[next.y].dis > nodeList[now.y].dis + next.dis) {
					nodeList[next.y].dis = nodeList[now.y].dis + next.dis;
					q.remove(nodeList[next.y]);
					q.add(nodeList[next.y]);
				}
			}
		}

		//�ִ� �Ÿ��� ������ -1 ��� �ƴϸ� �ִܰŸ� ���
		System.out.println(nodeList[N - 1].dis == Long.MAX_VALUE ? -1 : nodeList[N - 1].dis);

	}
}

class Node {
	int y;
	long dis;

	Node(int y, long dis) {
		this.y = y;
		this.dis = dis;
	}
}
