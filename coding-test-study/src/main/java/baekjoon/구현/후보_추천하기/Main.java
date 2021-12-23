package baekjoon.구현.후보_추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int totalCnt = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Person> q = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < totalCnt; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			// 새로운 사람인지 플레그
			boolean flag = true;

			for (Person p : q) {
				// p.plusTime();
				if (p.num == tmp) {
					p.cnt++;
					// p.time = 0;
					flag = false;
					break;

				}
			}

			Collections.sort(q, (o1, o2) -> {

				if (o1.cnt == o2.cnt) {
					return o1.time - o2.time;
				} else {
					return Integer.compare(o1.cnt, o2.cnt);
				}

			});
//			// 공간이 남으면서 추가해야되면 추가하즈아
			if (q.size() < N && flag) {

				q.add(new Person(tmp, i));

			} else if (flag) {
				// 삭제한다
				q.remove(0);
				q.add(new Person(tmp, i));

			}

		}

		for (Person p : q) {
			list.add(p.num);
		}

		Collections.sort(list);

		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}

class Person {
	int num;
	int cnt;
	int time;

	public Person(int num) {
		this.num = num;
		this.cnt = 1;
		this.time = 0;
	}

	public Person(int num, int time) {
		this.num = num;
		this.cnt = 1;
		this.time = time;
	}

}
