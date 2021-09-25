package baekjoon.정렬.나이순_정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = Integer.parseInt(s.nextLine());
		ArrayList<User> list = new ArrayList<User>();

		for (int i = 1; i <= N; i++) {
			String[] str = s.nextLine().split(" ");
			list.add(new User(Integer.parseInt(str[0]), i, str[1]));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.age == o2.age) {
				return o1.num - o2.num;
			}
			return o1.age - o2.age;
		});

		for (User u : list) {
			System.out.println(u.toString());
		}

	}

}

class User {

	int age;
	int num;
	String name;

	User(int age, int num, String name) {
		this.age = age;
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {

		return age + " " + name;
	}
}
