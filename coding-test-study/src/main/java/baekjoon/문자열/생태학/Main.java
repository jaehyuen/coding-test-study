package baekjoon.문자열.생태학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		double cnt = 0;

		while (true) {
			// 문자열 입력
			String str = br.readLine();

			if (str == null) {
				break;
			}

			map.put(str, map.getOrDefault(str, 0) + 1);
			cnt++;

		}

		ArrayList<Test> list = new ArrayList<>();

		// 저장된 정보 리스트에 저장
		for (Entry<String, Integer> e : map.entrySet()) {

			list.add(new Test(e.getKey(), e.getValue()));
		}

		// 사전순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			return o1.str.compareTo(o2.str);
		});

		StringBuilder sb = new StringBuilder();

		for (Test t : list) {
			// 소숫점 계산
			String tmp = String.format("%.4f", t.cnt / cnt * 100);
			sb.append(t.str + " " + tmp + "\n");
		}
		System.out.println(sb.toString());

	}

}

class Test {
	String str;
	double cnt;

	public Test(String str, double cnt) {
		this.str = str;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + str + ", " + cnt + ")";
	}
}
