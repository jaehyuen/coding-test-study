package baekjoon.자료구조.듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader    br   = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer   st   = new StringTokenizer(br.readLine());

		int               N    = Integer.parseInt(st.nextToken());
		int               M    = Integer.parseInt(st.nextToken());

		HashSet<String>   set  = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			set.add(tmp);

		}

		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();

			if (set.contains(tmp))
				list.add(tmp);
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (String str : list) {
			System.out.println(str);
		}

	}

}
