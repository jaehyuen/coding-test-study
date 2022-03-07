package baekjoon.그래프.다익스트라.백도어;

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

		int N = Integer.parseInt(st.nextToken());// 분기점 갯수
		int M = Integer.parseInt(st.nextToken());// 분기점을 잇는 길의 수

		int[] ward = new int[N];// 시야 배열

		// 분기점 리스트
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		// 분기점 리스트 초기화 및 시야정보 저장
		for (int i = 0; i < N; i++) {
			ward[i] = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<>());
		}

		// 마지막 분기점이 아니며 시야에 노출 안되는 길만 저장한다
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

		// 우선순위큐 선언
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			return Long.compare(o1.dis, o2.dis);
		});

		Node[] nodeList = new Node[N];
		boolean[] v = new boolean[N];

		//다익스트라용 배열 초기화
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				nodeList[i] = new Node(i, 0);
			} else {
				nodeList[i] = new Node(i, Long.MAX_VALUE);
			}
		}

		//시작점 큐에 등록
		q.add(nodeList[0]);

		while (!q.isEmpty()) {
			Node now = q.poll();

			//방문했었으면 컨티뉴
			if (v[now.y])
				continue;

			v[now.y] = true;

			for (Node next : list.get(now.y)) {
				//거리가 더 짧다면 큐 수정
				if (nodeList[next.y].dis > nodeList[now.y].dis + next.dis) {
					nodeList[next.y].dis = nodeList[now.y].dis + next.dis;
					q.remove(nodeList[next.y]);
					q.add(nodeList[next.y]);
				}
			}
		}

		//최대 거리로 나오면 -1 출력 아니면 최단거리 출력
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
