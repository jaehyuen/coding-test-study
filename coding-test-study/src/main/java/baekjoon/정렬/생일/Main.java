package baekjoon.정렬.생일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		int            N    = Integer.parseInt(br.readLine());

		ArrayList<P>   list = new ArrayList<P>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new P(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		}

		// 나이가 많은 순서대로 정렬
		Collections.sort(list, (o1, o2) -> {
			if (o1.yyyy == o2.yyyy) {
				if (o1.mm == o2.mm) {
					return o1.dd - o2.dd;
				}
				return o1.mm - o2.mm;

			}
			return o1.yyyy - o2.yyyy;
		});

		System.out.println(list.get(list.size() - 1).name);
		System.out.println(list.get(0).name);

	}

}

class P {
	String name;
	int    mm;
	int    dd;
	int    yyyy;

	public P(String name, String dd, String mm, String yyyy) {

		this.name = name;
		this.dd   = Integer.parseInt(dd);
		this.mm   = Integer.parseInt(mm);
		this.yyyy = Integer.parseInt(yyyy);

	}
}
