package baekjoon.����.����_�ѹ�;

public class Main {

	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10000; i++) {

			int num = i;
			int sum = i;

			while (num != 0) {
				sum = sum + (num % 10);
				num = num / 10;
			}

			if (sum < 10001) { // 10000 �� �Ѵ� ���� �ʿ䰡 ����
				arr[sum] = true;
			}

		}

		for (int i = 1; i < 10001; i++) {
			if (!arr[i]) { // false �� �ε����� ���
				sb.append(i+"\n");
			}
		}
		System.out.println(sb.toString());

		// System.out.println(result < 0 ? 0 : result);

	}

}
