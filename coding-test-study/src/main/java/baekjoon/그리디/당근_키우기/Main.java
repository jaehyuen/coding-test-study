package baekjoon.그리디.당근_키우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		//햇빛과 물을 준다
		int total = X + Y;

		//감소한 부분을 채워준다
		if (X > Y) {
			total += Math.ceil(Y / 10);
		} else {
			total += Math.ceil(X / 10);
		}

		System.out.println(total);

	}

}
