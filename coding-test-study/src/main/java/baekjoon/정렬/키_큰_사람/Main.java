package baekjoon.정렬.키_큰_사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			ArrayList<Person> list = new ArrayList<Person>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				list.add(new Person(st.nextToken(), st.nextToken()));

			}

			//키순으로 정렬
			Collections.sort(list, (o1, o2) -> {
				return Double.compare(o2.height, o1.height);
			});
			

			String result = list.get(0).name;

			for (int i = 1; i < N; i++) {
				Person p1 = list.get(i - 1);
				Person p2 = list.get(i);

				if (p1.height == p2.height) {
					result += " " + p2.name;
				} else {
					break;
				}

			}
			System.out.println(result);
		}

	}
}

class Person {
	String name;
	double height;

	public Person(String name, String height) {
		this.name   = name;
		this.height = Double.parseDouble(height);
	}

}
