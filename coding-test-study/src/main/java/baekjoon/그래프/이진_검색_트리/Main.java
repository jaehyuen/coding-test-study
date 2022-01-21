package baekjoon.그래프.이진_검색_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static Node root;;
	static BufferedReader br;

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		root = new Node(Integer.parseInt(br.readLine()));

		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			root.insert(Integer.parseInt(input));
		}

		postOrder(root);

	}

	static void postOrder(Node now) {
		if (now == null)
			return;

		postOrder(now.left);
		postOrder(now.right);
		System.out.println(now.num);
	}

}

class Node {
	int num;
	Node left, right;

	Node(int num) {
		this.num = num;
	}

	Node(int num, Node left, Node right) {
		this.num = num;
		this.left = left;
		this.right = right;
	}

	void insert(int n) {
		if (n < this.num) {
			if (this.left == null)
				this.left = new Node(n);
			else
				this.left.insert(n);
		} else {
			if (this.right == null)
				this.right = new Node(n);
			else
				this.right.insert(n);
		}
	}
}