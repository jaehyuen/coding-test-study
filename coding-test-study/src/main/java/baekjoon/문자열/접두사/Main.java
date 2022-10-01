package baekjoon.문자열.접두사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import org.hyperledger.fabric.protos.common.Collection;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = N;
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		Collections.sort(list);

		for (int i = 1; i < N; i++) {
			String prev = list.get(i - 1);
			String now = list.get(i);

			if (now.startsWith(prev)) {
				result--;
			}
		}

		System.out.println(result);
	}

}
