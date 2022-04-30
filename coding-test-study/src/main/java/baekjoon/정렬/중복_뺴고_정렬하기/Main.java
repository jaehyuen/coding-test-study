package baekjoon.정렬.중복_뺴고_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 중복 제거를 위한 셋
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		// 셋을 리스트로 변경하여 정렬한다
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		for (int i : list) {
			System.out.print(i + " ");
		}

	}

}
