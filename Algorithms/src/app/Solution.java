package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 1;
		while (t > 0) {
			int output = 0;
			List<Fabric> list = new ArrayList<>();
			List<Fabric> list1;
			List<Fabric> list2;
			int noOfFabrics = sc.nextInt();
			sc.nextLine();
			while (noOfFabrics > 0) {
				String[] input = sc.nextLine().split(" ");
				list.add(new Fabric(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
				noOfFabrics--;
			}

			Collections.sort(list, (fab1, fab2) -> fab1.color.compareToIgnoreCase(fab2.color));
			list1 = new ArrayList<Solution.Fabric>(list);
			Collections.sort(list, (fab1, fab2) -> {
				if (fab1.durable - fab2.durable == 0) {
					return fab1.id - fab2.id;
				} else {
					return fab1.durable - fab2.durable;
				}
			});
			list2 = new ArrayList<Solution.Fabric>(list);
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).equals(list2.get(i))) {
					output++;
					// break;
				}
			}
			list.clear();
			list1.clear();
			list2.clear();
			System.out.println("Case #" + count + ": " + output);
			t--;
			count++;
		}
	}

	static class Fabric {
		public String color;
		public int durable;
		public int id;

		public Fabric(String f, int d, int id) {
			color = f;
			durable = d;
			this.id = id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fabric other = (Fabric) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Fabric [color=" + color + ", durable=" + durable + ", id=" + id + "]";
		}

	}
}
