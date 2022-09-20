package baekjoon.구현.네모네모_시력검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             N    = Integer.parseInt(st.nextToken());
		int             M    = Integer.parseInt(st.nextToken());

		char[][]        map  = new char[N][M];

		int             maxX = 0;
		int             maxY = 0;
		int             minX = N;
		int             minY = M;

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine()
				.toCharArray();
			map[i] = arr;
			// 정사각형 위치 파악
			for (int j = 0; j < M; j++) {
				if (arr[j] == '#') {
					maxX = Math.max(maxX, i);
					maxY = Math.max(maxY, j);
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
				}
			}
		}

		int tmp = (maxX - minX) / 2;

		if (map[minX + tmp][maxY] != '#') {
			System.out.println("RIGHT");
		} else if (map[maxX][minY + tmp] != '#') {
			System.out.println("DOWN");
		} else if (map[minX + tmp][minY] != '#') {
			System.out.println("LEFT");
		} else if (map[minX][minY + tmp] != '#') {
			System.out.println("UP");
		}

	}
}
