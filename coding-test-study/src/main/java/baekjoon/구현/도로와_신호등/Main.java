package baekjoon.구현.도로와_신호등;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		PriorityQueue<TrafficLight> q = new PriorityQueue<>((o1, o2) -> {
			return o1.D - o2.D;
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new TrafficLight(st.nextToken(), st.nextToken(), st.nextToken()));
		}

		int time = 0;

		while (!q.isEmpty()) {
			TrafficLight now = q.peek();

			// 현재 무슨 불인지 확인
			int lightTmp = (now.D + time) % (now.R + now.G);

			// 빨간불일때 대기시간 증가
//			if (lightTmp <= now.R && lightTmp > 0) {
			if (lightTmp < now.R) {
				time += now.R - lightTmp;
			}
			q.poll();

		}

		// 거리 + 대기시간 출력
		System.out.println(L + time);

	}

}

class TrafficLight {
	int D;
	int R;
	int G;

	public TrafficLight(String D, String R, String G) {
		this.D = Integer.parseInt(D);
		this.R = Integer.parseInt(R);
		this.G = Integer.parseInt(G);
	}

	@Override
	public String toString() {
		return "TrafficLight [D=" + D + ", R=" + R + ", G=" + G + "]";
	}

}
