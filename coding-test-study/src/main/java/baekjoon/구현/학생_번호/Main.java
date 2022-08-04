package baekjoon.구현.학생_번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		int            N   = Integer.parseInt(br.readLine());
		String[]       arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();

		}

		int length = arr[0].length() - 1;

		for (int i = 0; i <= length; i++) {

			HashMap<String, Integer> map  = new HashMap<String, Integer>();
			boolean                  flag = true;
			for (int j = 0; j < N; j++) {

				// 뒤에서부터 i+1 자리만큼 자른 수
				String num = arr[j].substring(length - i);
				int    tmp = map.getOrDefault(num, 0);

				// 이미 존재하면 i 증가
				if (tmp > 0) {
					flag = false;
					break;
				}
				map.put(num, tmp + 1);
			}

			// 전부 다르면 탐색 종료
			if (flag) {
				System.out.println(i + 1);
				return;
			}

		}

		// 위 로직에서 안걸리면 길이만큼 출력
		System.out.println(length + 1);
		return;
	}
}
