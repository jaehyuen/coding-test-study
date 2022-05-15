package baekjoon.그래프.줄_세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 간선의 갯수 저장 배열
		int[] v = new int[N + 1];

		//그래프를 그리기 위한 리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		//그래프 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list.get(tmp1).add(tmp2);
			// 간선의 갯수를 증가
			v[tmp2]++;

		}

		Queue<Integer> q = new LinkedList<>();

		//간선이 없으면 큐에 넣어준다
		for (int i = 1; i <= N; i++) {
			if (v[i] == 0) {
				q.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		
		//간선을 계속 줄이는 형태로 bfs
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + " ");
			for (int next : list.get(now)) {
				v[next]--;
				if (v[next] == 0) {
					q.add(next);
				}
			}

		}
		System.out.println(sb.toString());
	}

}
