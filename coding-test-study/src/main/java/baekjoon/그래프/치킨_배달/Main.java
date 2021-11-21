package baekjoon.그래프.치킨_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static ArrayList<Address> house;
	static ArrayList<Address> chicken;
	static Address[] chicken2;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		house = new ArrayList<Address>();
		chicken = new ArrayList<Address>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken2 = new Address[M];
		// int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {

				int tmp = Integer.parseInt(st.nextToken());
				// arr[i][j] =tmp;
				if (tmp == 1) {
					house.add(new Address(i, j));
				} else if (tmp == 2) {
					chicken.add(new Address(i, j));
				}
			}
		}

		choiceChicken(0, 0);
		
		System.out.println(min);

	}

	public static void choiceChicken(int start, int cnt) {

		if (cnt == M) {
			min = Math.min(checkChicken(), min);
			//System.out.println(Arrays.toString(chicken2));
			//System.out.println(min);
			//System.out.println();
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			chicken2[cnt] = chicken.get(i);
			choiceChicken(i + 1, cnt + 1);
		}

	}

	public static int checkChicken() {

		int sum = 0;
		for (Address h : house) {
			int min = Integer.MAX_VALUE;
			for (Address c : chicken2) {
				int tmp = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
				min = Math.min(min, tmp);

			}
			sum+=min;
		}
		System.out.println(sum);
		return sum;

	}
}

class Address {
	int x;
	int y;

	public Address(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + x + ", " + y + "]";
	}
}
