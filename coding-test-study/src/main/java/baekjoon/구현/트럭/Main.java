package baekjoon.구현.트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Truck> b = new LinkedList<Truck>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}

		int time = 0;
		int weight = 0;
		while (true) {

			for (Truck i : b) {
//				b.offer(new Truck(i.w, i.loc - 1));
//				b.poll();
				i.loc -= 1;
			}

			if (!b.isEmpty()) {
				if (b.peek().loc == 0) {
					weight -= b.peek().w;
					b.poll();
				}

			}

			if(!q.isEmpty()) {
				if (weight + q.peek() <= L) {
					weight += q.peek();
					b.offer(new Truck(q.poll(), w));
				}
			}
			
			
			time++;
			
			if (q.isEmpty() && b.isEmpty())
				break;

			
		}

		System.out.println(time);

	}

}

class Truck {
	int w;
	int loc;

	public Truck(int w, int loc) {
		this.w = w;
		this.loc = loc;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "w : " + w + ", loc: " + loc;
	}
}
