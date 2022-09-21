package baekjoon.구현.숫자세는_양;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            T   = Integer.parseInt(br.readLine());
		int            cnt = 1;
		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				System.out.println("Case #" + cnt + ": INSOMNIA");
				continue;
			}

			int[] arr = new int[10];

			int   j   = 1;
			
			while (true) {
				int num = j * N;

				while (num > 0) {
					arr[num % 10]++;
					num /= 10;
				}

				boolean flag = true;

				// 숫자 채웟는지 확인
				for (int a : arr) {
					if (a == 0) {
						flag = false;
						break;
					}
				}

				if (flag) {
					System.out.println("Case #" + cnt + ": " + (j * N));
					break;
				}
				j++;
			}

			cnt++;
		}

	}
}
