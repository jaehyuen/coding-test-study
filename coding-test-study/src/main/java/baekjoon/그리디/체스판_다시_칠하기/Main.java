package baekjoon.그리디.체스판_다시_칠하기;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner  s     = new Scanner(System.in);
		String[] str   = s.nextLine().split(" ");

		int      N     = Integer.parseInt(str[0]);
		int      M     = Integer.parseInt(str[1]);

		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = s.nextLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}

		}

		int min = 1000;

		for (int i = 0; i <= N - 8; i++) {

			for (int j = 0; j <= M - 8; j++) {
				boolean isWhite = true;
				int     cnt1    = 0;
				int     cnt2    = 0;
				for (int a = i; a < i + 8; a++) {

					for (int b = j; b < j + 8; b++) {
						if (board[a][b] == 'W' && isWhite) {
							cnt2++;
						} else if (board[a][b] == 'B' && !isWhite) {
							cnt2++;
						} else if (board[a][b] == 'B' && isWhite) {
							cnt1++;
						} else if (board[a][b] == 'W' && !isWhite) {
							cnt1++;
						}
						if (b != j + 7)
							isWhite = !isWhite;

					}
				}

				min = Math.min(cnt1, Math.min(min, cnt2));
//				
			}

		}

		System.out.println(min);

	}

}
