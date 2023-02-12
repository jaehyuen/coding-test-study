package baekjoon.구현.낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int R;
	public static int C;
	public static int M;

	public static int[][] sea;

	public static HashMap<Integer, Shark> map = new HashMap<>();

	public static int[] xArr = { -1, 1 - 0, 0 };
	public static int[] yArr = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sea = new int[R][C];

		// 상어 입력
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(i, r, c, size, dir, speed);
			map.put(i, shark);

			// 상어 위치 저장
			sea[r][c] = i;

		}

		int total = 0;

		// 낚시 시작
		for (int i = 0; i < C; i++) {

			// 낚시왕이 오른쪽으로 이동

			// 상어를 잡는다
			for (int j = 0; j < R; j++) {

				// 상어를 찾으면 잡는다
				if (sea[j][i] != 0) {
					Shark shark = map.remove(sea[j][i]);
					total += shark.size;
					break;
				}
			}

			// 상어 이동
			move();

		}
		System.out.println(total);

	}

	public static void move() {

		// 잡아먹힌 상어 임시 저장 리스트
		ArrayList<Integer> removeTmp = new ArrayList<>();

		// 이동 이후 바다 배열
		int[][] newSea = new int[R][C];

		// 상어 이동 시작
		for (Shark shark : map.values()) {

			// 이동해야할 거리
			int distance = shark.speed;
			while (distance > 0) {

				// 상어 방향별 분기
				switch (shark.dir) {
				case 1:

					// 범위를 벗어나면 방향 전환
					if (shark.r - distance < 0) {

						distance -= shark.r;
						shark.dir = 2;
						shark.r = 0;

					} else {
						shark.r -= distance;
						distance = 0;
					}

					break;
				case 2:

					// 범위를 벗어나면 방향 전환
					if (shark.r + distance >= R) {

						distance -= R - shark.r - 1;
						shark.dir = 1;
						shark.r = R - 1;

					} else {
						shark.r += distance;
						distance = 0;
					}

					break;
				case 3:

					// 범위를 벗어나면 방향 전환
					if (shark.c + distance >= C) {

						distance -= C - shark.c - 1;
						shark.dir = 4;
						shark.c = C - 1;

					} else {
						shark.c += distance;
						distance = 0;
					}
					break;
				case 4:
					// 범위를 벗어나면 방향 전환
					if (shark.c - distance < 0) {

						distance -= shark.c;
						shark.dir = 3;
						shark.c = 0;

					} else {
						shark.c -= distance;
						distance = 0;
					}
					break;

				}

			}

			if (newSea[shark.r][shark.c] == 0) {
				// 자리가 비어있으면 저장
				newSea[shark.r][shark.c] = shark.num;
			} else {
				// 더 큰놈을 저장해야함
				Shark preShark = map.get(newSea[shark.r][shark.c]);

				if (preShark.size > shark.size) {

					// 기존께 더 크면 새로온 상어를 잡아먹음
					removeTmp.add(shark.num);
				} else {

					// 반대
					removeTmp.add(preShark.num);
					newSea[shark.r][shark.c] = shark.num;
				}

			}

		}

		for (int i : removeTmp) {
			// 먹힌 상어 삭제
			map.remove(i);
		}

		sea = newSea;
	}

}

class Shark {

	int num;
	int r;
	int c;
	int size;
	int dir;
	int speed;

	public Shark(int num, int r, int c, int size, int dir, int speed) {
		this.num = num;
		this.r = r;
		this.c = c;
		this.size = size;
		this.dir = dir;
		this.speed = speed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "num : " + num + ", (" + r + ", " + c + "), size : " + size + ", speed : " + speed + ", dir : " + dir;
	}
}
