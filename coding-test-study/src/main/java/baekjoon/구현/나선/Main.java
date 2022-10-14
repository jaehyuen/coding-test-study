package baekjoon.구현.나선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int x1 = 0;
		int x2 = N-1 ;

		int y1 = 0;
		int y2 = M-1 ;

		int idx = 1;
		while (x1 != x2 && y1 != y2) {

			//각 방향에 맞게 한다
			if (idx % 4 == 1) {
				x1++;
			} else if (idx % 4 == 2) {
				y2--;
			} else if (idx % 4 == 3) {
				x2--;
			} else {
				y1++;
			}
			idx++;
			
		}

		//방향별 마지막 위치를 출력
		if (idx % 4 == 1) {
			System.out.println(x2 + " " + y2);
		} else if (idx % 4 == 2) {
			System.out.println(y1 + " " + x1);
		} else if (idx % 4 == 3) {
			System.out.println(y1 + " " + x1);
		} else {
			System.out.println(x2 + " " + y2);
		}
		
	}
}
