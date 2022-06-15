package baekjoon.구현.올림픽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader   br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st   = new StringTokenizer(br.readLine());

		int              N    = Integer.parseInt(st.nextToken());
		int              K    = Integer.parseInt(st.nextToken());
		ArrayList<Medal> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp = Integer.parseInt(st.nextToken());
			int g   = Integer.parseInt(st.nextToken());
			int s   = Integer.parseInt(st.nextToken());
			int b   = Integer.parseInt(st.nextToken());

			list.add(new Medal(tmp, g, s, b));
		}

		Collections.sort(list);

		int   grade = 1;
		int   tmp   = 1;
		Medal prev  = list.get(0);

		if (prev.country == K) {
			System.out.println(1);
		} else {
			for (int i = 1; i < list.size(); i++) {
				Medal now = list.get(i);

				// 점수가 같으면 같은등수
				if (prev.g == now.g && prev.s == now.s && prev.b == now.b) {
					tmp++;
				} else {
					// 점수가 다르면 등수에 변화를 줌
					grade += tmp;
					tmp    = 1;
				}
				if (now.country == K) {
					System.out.println(grade);
					return;
				}
				prev = now;

			}
		}

	}
}

class Medal implements Comparable<Medal> {
	int country;
	int g;
	int s;
	int b;

	@Override
	public String toString() {
		return "Medal [country=" + country + ", g=" + g + ", s=" + s + ", b=" + b + "]";
	}

	public Medal(int country, int g, int s, int b) {
		super();
		this.country = country;
		this.g       = g;
		this.s       = s;
		this.b       = b;
	}

	// 금은동 순으로 정렬
	@Override
	public int compareTo(Medal o) {
		if (this.g == o.g) {
			if (this.s == o.s) {
				return -(this.b - o.b);
			} else
				return -(this.s - o.s);
		} else
			return -(this.g - o.g);
	}

}
