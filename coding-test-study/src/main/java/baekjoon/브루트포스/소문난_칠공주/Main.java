package baekjoon.브루트포스.소문난_칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int total = 0;
	public static ArrayList<Integer> yList = new ArrayList<Integer>();
	public static ArrayList<Integer> sList = new ArrayList<Integer>();
	public static LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

	public static int[] yArr = { 1, -1, 0, 0 };
	public static int[] xArr = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 이다솜파와 임도파를 나눈다
		for (int i = 0; i < 5; i++) {
			char[] arr = br.readLine().toCharArray();

			for (int j = 0; j < 5; j++) {
				if (arr[j] == 'S') {
					sList.add(j + (i * 5));
				} else {
					yList.add(j + (i * 5));
				}
			}
		}

		findS(0, 0);
		System.out.println(total);
	}

	public static void findS(int start, int idx) {
		// 이다솜파를 먼저 조합하는 함수
		// 7명이상 모이면 멈춤
		if (idx > 7) {
			return;
		} else if (idx >= 4) {
			// 이다솜파가 4명이상 조합되면 나머지를 임도연파로 채운다
			findY(0, set.size());
		}

		for (int i = start; i < sList.size(); i++) {
			int now = sList.get(i);

			// 방문처리
			set.add(now);

			findS(i + 1, idx + 1);

			// 등록 해제
			set.remove(now);
		}

	}

	public static void findY(int start, int idx) {
		// 남은자리에 임도연파로 채우는 함수
		if (idx == 7) {

			// 7명이 다 모이면 가로세로로 붙었는지 체크한다
			check();
			return;
		}

		for (int i = start; i < yList.size(); i++) {
			int now = yList.get(i);

			// 방문처리
			set.add(now);

			findY(i + 1, idx + 1);

			// 등록 해제
			set.remove(now);
		}

	}

	public static void check() {
		// 시작 위
		int now = set.iterator().next();
		int x = now / 5;
		int y = now % 5;
		int cnt = 0;

		boolean[][] v = new boolean[5][5];

		// 방문처리
		v[x][y] = true;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(now);

		// bfs시작
		while (!q.isEmpty()) {

			now = q.poll();
			x = now / 5;
			y = now % 5;
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nextX = x + xArr[i];
				int nextY = y + yArr[i];

				if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) {
					continue;
				}

				// 7공주에 속해있고 방문 안햇으면 큐에 넣어줌
				if (set.contains(nextY + (nextX * 5)) && !v[nextX][nextY]) {
					q.add(nextY + (nextX * 5));
					v[nextX][nextY] = true;
				}
			}
		}

		// 7이 붙어있으면 경우의수 증가
		if (cnt == 7) {
			total++;
		}
	}

}
