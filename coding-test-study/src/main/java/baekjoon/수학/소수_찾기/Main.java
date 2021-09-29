package baekjoon.수학.소수_찾기;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s   = new Scanner(System.in);
		int     N   = s.nextInt();

		int     cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = s.nextInt();

			if (num == 2) {
				cnt++;
			} else if (num != 1 && num % 2 == 1) {
				boolean flag = true;
				for (int j = 2; j < num / 2; j++) {
					if (num % j == 0) {
						flag = false;
						break;
					}

				}
				if (flag == true)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
