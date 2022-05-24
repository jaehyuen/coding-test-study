package baekjoon.브루트포스.에너지_모으기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	// 에너지 리스트
	static LinkedList<Integer> list = new LinkedList<>();

	// 최대값
	static int                 max  = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int             N  = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));

		}

		find(0);
		System.out.println(max);

	}

	// 모든 경우의 수를 파악해서 최대값을 구한다
	public static void find(int sum) {
		if (list.size() < 3) {
			max = Math.max(sum, max);
			return;
		}
		for (int i = 1; i < list.size() - 1; i++) {

			int tmp = list.remove(i);
			find(sum + list.get(i - 1) * list.get(i));
			list.add(i, tmp);
		}
	}
}