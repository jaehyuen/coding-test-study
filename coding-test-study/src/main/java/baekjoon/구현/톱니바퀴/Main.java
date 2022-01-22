package baekjoon.±¸Çö.Åé´Ï¹ÙÄû;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static Gear gear1;
	static Gear gear2;
	static Gear gear3;
	static Gear gear4;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear1 = new Gear(br.readLine().toCharArray());
		gear2 = new Gear(br.readLine().toCharArray());
		gear3 = new Gear(br.readLine().toCharArray());
		gear4 = new Gear(br.readLine().toCharArray());

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int gearNum = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());

			switch (gearNum) {
			case 1:
				spinGear1(direction, true);
				break;
			case 2:
				spinGear2(direction, true);
				break;
			case 3:
				spinGear3(direction, true);
				break;
			case 4:
				spinGear4(direction, true);
				break;

			default:
				break;
			}

//			System.out.println(gear1.now);
//			System.out.println(gear2.now);
//			System.out.println(gear3.now);
//			System.out.println(gear4.now);
//			System.out.println("---------------------------");

		}
		int result = 0;

		result += (gear1.gear[gear1.now] - 48) * 1;
		result += (gear2.gear[gear2.now] - 48) * 2;
		result += (gear3.gear[gear3.now] - 48) * 4;
		result += (gear4.gear[gear4.now] - 48) * 8;
		System.out.println(result);
	}

	public static char spinGear1(int direction, boolean flag) {

		char now = gear1.gear[gear1.now];

		boolean b1 = gear1.compare(gear2, true);
		boolean b2 = gear2.compare(gear3, true);
		boolean b3 = gear3.compare(gear4, true);

		gear1.changeNow(direction);

		if (flag) {

			if (b1) {
				spinGear2(-1 * direction, false);
				if (b2) {
					spinGear3(direction, false);
					if (b3) {
						spinGear4(-1 * direction, false);
					}
				}
			}

		}

		return now;

	}

	public static void spinGear2(int direction, boolean flag) {

		char now = gear2.gear[gear2.now];

		boolean b1 = gear2.compare(gear1, false);
		boolean b2 = gear2.compare(gear3, true);
		boolean b3 = gear3.compare(gear4, true);

		gear2.changeNow(direction);

		if (flag) {

			if (b1) {
				spinGear1(-1 * direction, false);
			}
			if (b2) {
				spinGear3(-1 * direction, false);
				if (b3) {
					spinGear4(direction, false);
				}
			}

		}
	}

	public static void spinGear3(int direction, boolean flag) {

		char now = gear3.gear[gear3.now];

		boolean b1 = gear3.compare(gear2, false);
		boolean b2 = gear2.compare(gear1, false);
		boolean b3 = gear3.compare(gear4, true);

		gear3.changeNow(direction);

		if (flag) {

			if (b1) {
				spinGear2(-1 * direction, false);
				if (b2) {
					spinGear1(direction, false);
				}
			}

			if (b3) {
				spinGear4(-1 * direction, false);
			}

		}
	}

	public static void spinGear4(int direction, boolean flag) {

		char now = gear4.gear[gear4.now];

		boolean b1 = gear4.compare(gear3, false);
		boolean b2 = gear3.compare(gear2, false);
		boolean b3 = gear2.compare(gear1, false);

		gear4.changeNow(direction);

		if (flag) {

			if (b1) {
				spinGear3(-1 * direction, false);
				if (b2) {
					spinGear2(direction, false);
					if (b3) {
						spinGear1(-1 * direction, false);
					}
				}
			}

		}
	}

}

class Gear {
	char[] gear;
	int now;

	public Gear(char[] gear) {
		this.gear = gear;
		this.now = 0;
	}

	void changeNow(int i) {

		this.now += i * -1;

		if (this.now == -1) {
			this.now = 7;
		} else if (this.now == 8) {
			this.now = 0;
		}
	}

	boolean compare(Gear gear2, boolean flag) {

		if (flag) {
			int lIndex = (2 + this.now) % 8;
			int rIndex = (6 + gear2.now) % 8;

			if (this.gear[lIndex] == gear2.gear[rIndex]) {
				return false;
			} else {
				return true;
			}

		} else {
			int rIndex = (6 + this.now) % 8;
			int lIndex = (2 + gear2.now) % 8;

			if (this.gear[rIndex] == gear2.gear[lIndex]) {
				return false;
			} else {
				return true;
			}
		}

	}

}
