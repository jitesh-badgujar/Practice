
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {

		/*
		 * String s = "abaabb"; System.out.println("Longest Palindrom substring:" +
		 * getLongestSubStringWhichIsPalindrom(s));
		 * 
		 * String str = "I am Jitesh";
		 * 
		 * System.out.println("Reversed string of workds:" +
		 * getReversedStringOfWords(str));
		 * 
		 * String s1 = "greeksforgreeks"; String s2 = "forgreksgreeeks";
		 * 
		 * System.out.println("Is Anagram:" + isAnagram(s1, s2));
		 * 
		 * String strArr[] = { "12", "3", "5" };
		 * 
		 * System.out.println("Largest number:" +
		 * getLongestNumberFormedFromArray(strArr));
		 * 
		 * int numArr[] = { 1, 4, 0, 0, 3, 10, 5 };
		 * 
		 * System.out.println("Sub Array with given sum: ");
		 * 
		 * subArraySum(numArr, 7);
		 * 
		 * printZigZagArray();
		 * 
		 * System.out.println("leftSmallRightLarge: " + leftSmallRightLarge());
		 * 
		 * missingNumberInArray();
		 * 
		 * sortArrayOf012();
		 * 
		 * reverseArrayInGroups();
		 * 
		 * permutation("", "ABC");
		 * 
		 * removeDuplicates("abbaca");
		 * 
		 * commonCharsInString(); rearrangeArray();
		 */

	}

	public static boolean isAnagram(String s1, String s2) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		boolean anagram = false;
		for (char c : s1.toCharArray()) {
			if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) + 1);
			} else {
				freq.put(c, 1);
			}
		}

		for (char c : s2.toCharArray()) {
			if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) - 1);
			} else {
				return false;
			}
		}

		for (Entry<Character, Integer> m : freq.entrySet()) {
			if (m.getValue() == 0) {
				anagram = true;
			} else {
				return false;
			}
		}

		return anagram;
	}

	public static String getLongestSubStringWhichIsPalindrom(String s) {
		List<String> palindroms = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length() - 1; j++) {
				String subString = s.substring(i, j);
				// System.out.println("subString:" + subString);
				if (subString.length() > 1 && subString.equals(new StringBuilder(subString).reverse().toString())) {
					palindroms.add(subString);
					// System.out.println("Palindrom");
				}
			}
		}
		System.out.println("All:" + palindroms);
		return Collections.max(palindroms, Comparator.comparing(String::length));
	}

	public static String getReversedStringOfWords(String str) {
		String arr[] = str.split(" ");
		StringBuilder result = new StringBuilder("");
		for (int i = arr.length - 1; i >= 0; i--) {
			result.append(" " + new StringBuilder(arr[i]).reverse());
		}
		return result.toString();
	}

	public static <T> String getLongestNumberFormedFromArray(String a[]) {
		Collections.sort(Arrays.asList(a), new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String XY = o1 + o2;
				String YX = o2 + o1;
				return XY.compareTo(YX) > 0 ? -1 : 1;

			}

		});
		return Arrays.toString(a);

	}

	public static void subArraySum(int arr[], int sum) {
		System.out.println("Array:" + Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			int currentSum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				currentSum = currentSum + arr[j];
				if (currentSum == sum) {
					System.out.println("Current sum matched:" + i + " and " + j);
				} else if (currentSum > sum) {
					break;
				}
			}
		}
	}

	public static int equilibrium() {
		int a[] = { -7, 1, 5, 2, -4, 3, 0 };
		int n = a.length;
		int i = 0;
		int j = 0;
		int leftsum = 0;
		int rightsum = 0;
		for (i = 0; i < n; ++i) {

			/* get left sum */
			leftsum = 0;
			for (j = 0; j < i; j++)
				leftsum += a[j];

			/* get right sum */
			rightsum = 0;
			for (j = i + 1; j < n; j++)
				rightsum += a[j];

			/*
			 * if leftsum and rightsum are same, then we are done
			 */
			if (leftsum == rightsum)
				return i;
		}
		return 0;
	}

	public static void printZigZagArray() {
		int n = 7, arr[] = { 4, 3, 7, 8, 6, 2, 1 };
		Arrays.sort(arr);
		// 1,2,3,4,6,7,8
		for (int i = 1; i <= n - 2; i = i + 2) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;

		}
		System.out.print(Arrays.toString(arr));

	}

	public static int leftSmallRightLarge() {
		int a[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		int n = a.length;
		boolean leftSmall = false;
		boolean rightLarge = false;
		int i;
		for (i = 1; i < n - 1; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					leftSmall = true;
				} else {
					leftSmall = false;
					break;
				}
			}
			if (leftSmall) {
				for (int j = i + 1; j < n; j++) {
					if (a[j] > a[i]) {
						rightLarge = true;
					} else {
						rightLarge = false;
						break;
					}
				}
				if (rightLarge)
					return i;
			}
		}
		return i;
	}

	public static void missingNumberInArray() {
		int a[] = { 1, 2, 4, 6, 3, 7, 8 };
		int n = a.length + 1;
		int sum = n * (n + 1) / 2;
		int currentSum = 0;
		for (int i = 0; i < n - 1; i++) {
			currentSum = currentSum + a[i];
		}
		System.out.println("Missing number:" + (sum - currentSum));
	}

	public static void sortArrayOf012() {

		/*
		 * int a[] = { 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0 };
		 * 
		 * int low = 0; int high = a.length - 1;
		 * 
		 * while (low < high) { if (a[low] == 1) { a[low] = 0; a[high] = 1; low++;
		 * high--; } else { low++; }
		 * 
		 * } System.out.println(Arrays.toString(a));
		 */

		int a[] = { 1, 2, 1, 0, 0, 1, 0, 0, 0, 1, 0, 2, 0 };
		int n = a.length;
		int temp = 0;
		int low = 0;
		int high = n - 1;
		int mid = 0;

		while (mid <= high) {
			switch (a[mid]) {
			case 0:
				temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = a[high];
				a[high] = a[mid];
				a[mid] = temp;
				high--;
				break;
			}
		}
		System.out.println("Sorted array:" + Arrays.toString(a));
	}

	/*
	 * int count0 = 0; int count1 = 0; int count2 = 0;
	 * 
	 * for (int i = 0; i < n; i++) { switch (a[i]) { case 0: count0++; break; case
	 * 1: count1++; break; case 2: count2++; break; } } int i = 0; while (count0 >
	 * 0) { a[i] = 0; count0--; i++; } while (count1 > 0) { a[i] = 1; count1--; i++;
	 * } while (count2 > 0) { a[i] = 2; count2--; i++; }
	 */

	public static void reverseArrayInGroups() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int n = a.length + 1;

		List<Integer> list = new ArrayList();
		int temp = 0;

		for (int i = 0; i < n - 1; i = i + k) {
			List<Integer> tempGroup = new ArrayList();
			temp = k;
			int index = i;

			while (temp > 0 && index < n - 1) {
				temp--;
				tempGroup.add(a[index]);
				index++;
			}

			Collections.reverse(tempGroup);
			list.addAll(tempGroup);
		}

		System.out.println("Revered in group:" + list.toString());

	}

	public static void permutation(String p, String s) {
		if (s.length() == 0) {
			System.out.println(p);
		} else {
			for (int i = 0; i < s.length(); i++) {
				permutation(p + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
			}
		}
	}

	public static void removeDuplicates(String s) {
		/*
		 * if (s.length() >= 2) { for (int i = 0; i < s.length() - 1; i++) { if
		 * (s.charAt(i) == s.charAt(i + 1)) { String dup =
		 * Character.toString(s.charAt(i)) + Character.toString(+s.charAt(i + 1)); s =
		 * s.replaceAll(dup, ""); removeDuplicates(s); } else { continue; } } }
		 */

		Stack<Character> stack = new Stack();

		for (int i = 0; i < s.length(); i++) {
			if (stack.empty()) {
				stack.push(s.charAt(i));
			} else if (stack.peek() == s.charAt(i)) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}

		}
		System.out.println("String after removing duplicates:" + stack);
	}

	public static void commonCharsInString() {
		String str[] = { "apple", "orange" };
		Set<String> ans = new TreeSet();
		List<Set<String>> setList = new ArrayList();
		for (String s : str) {
			Set<String> a1 = new TreeSet();
			for (char c : s.toCharArray()) {
				a1.add(Character.toString(c));
			}
			setList.add(a1);
		}
		int i = 0;
		for (Set<String> s : setList) {
			if (i == 0) {
				ans.addAll(setList.get(0));
				System.out.println("Index: " + i + " Set:" + ans);
				i++;
			} else {
				s.retainAll(ans);
				System.out.println("Index: " + i + " Ans:" + ans + " S: " + s);
				ans = s;
			}

		}

		System.out.print(ans);
	}

	public static void reverseArrayInSubGroup() {
		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
		int n = arr.size();
		int k = 3;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ArrayList<Integer> tempArr = new ArrayList<Integer>();
		for (int i = 0; i < n; i = i + k) {
			int tempK = k;
			int index = i;
			while (tempK > 0 && index < n) {
				tempArr.add(arr.get(index));
				index++;
				tempK--;
			}
			Collections.reverse(tempArr);
			ans.addAll(tempArr);
			tempArr.clear();
		}
		// arr = ans;
		Collections.copy(arr, ans);
		System.out.println(arr);
	}

	public static void test2() {
		int a[] = { -7, 1, 5, 2, -4, 3, 0 };

		int n = a.length;

		for (int i = 0; i < n; i++) {
			int leftSum = 0;
			int rightSum = 0;
			for (int j = 0; j < i; j++) {
				leftSum = leftSum + a[j];
			}
			for (int j = i + 1; j < n - 1; j++) {
				rightSum = rightSum + a[j];
			}

			if (leftSum == rightSum) {
				System.out.println("Index:" + i);
				break;
			}
		}

	}

	public static void rearrangeArray() {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		// 6 1 5 2 4 3
		int n = a.length;
		int temp[] = new int[a.length];

		int l = 0;
		int h = n - 1;
		int i = 0;

		/*
		 * for (i = 0; i < n - 1; i = i + 2) { temp[i] = a[h--]; temp[i + 1] = a[l++];
		 * 
		 * } if (i == n - 1) { temp[i] = a[h]; }
		 */
		boolean flag = true;
		for (i = 0; i < n; i++) {
			if (flag) {
				temp[i] = a[h--];
			} else {
				temp[i] = a[l++];
			}
			flag = !flag;

		}

	}

	public static void sort012() {
		/*
		 * Node reverseList(Node head) { Node prev = null; Node current = head; Node
		 * next = null; while (current != null) { next = current.next; current.next =
		 * prev; prev = current; current = next; } head = prev; return head; }
		 */
		int a[] = { 0, 2, 0, 2, 1, 1, 1, 2, 1 };
		int l = 0;
		int h = a.length - 1;
		int m = 0;
		int temp = 0;
		/*
		 * while (l <= h) { if (a[l] < a[h]) { l++; } else if (a[l] > a[h]) { int temp =
		 * a[l]; a[l] = a[h]; a[h] = temp; l++; h--; } else { if (a[l] == 0) { l++; }
		 * else { h--; }
		 * 
		 * } }
		 */

		while (m < h && l < h) {
			switch (a[m]) {
			case 0:
				// swap l and m
				temp = a[l];
				a[l] = a[m];
				a[m] = temp;
				l++;
				m++;
				break;
			case 1:
				m++;
				break;
			case 2:
				temp = a[h];
				a[h] = a[m];
				a[m] = temp;
				h--;
				// swap h and m
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}

	public static void largestNumberFromArray() {
		int a[] = { 1, 34, 3, 98, 9, 76, 45, 4 };
		// 998764543431
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				String s1 = Integer.toString(a[i]) + Integer.toString(a[j]);
				String s2 = Integer.toString(a[j]) + Integer.toString(a[i]);
				if (Integer.parseInt(s1) < Integer.parseInt(s2)) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for (int i : a) {
			System.out.print(i);
		}
	}

	public static void mergeTwoSortedArrays() {
		int a1[] = { 1, 3, 5, 7 };
		int a2[] = { 0, 2, 6, 8, 9 };
		int m = a2.length;
		int n = a1.length;
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (a1[i] > a2[j]) {
				int temp = a1[i];
				a1[i] = a2[j];
				a2[j] = temp;
				i++;
				Arrays.sort(a2);
			} else {
				// i++;
			}
		}
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
	}

	public static void largestIn3() {
		int a = 0;
		int b = 0;
		int c = 0;
		if (a == b && a == c) {
			System.out.println("A");
			System.out.println("B");
			System.out.println("C");
		} else if (a == b && a > c) {
			System.out.println("A");
			System.out.println("B");
		} else if (b == c && b > a) {
			System.out.println("B");
			System.out.println("C");
		} else if (a == c && a > b) {
			System.out.println("A");
			System.out.println("C");
		} else if (a > b && a > c) {
			System.out.println("A");
		} else if (b > a && b > c) {
			System.out.println("B");
		} else if (c > b && c > a) {
			System.out.println("C");
		}
	}

	public static void binaryToString() {
		int n = 18;

		String s = Integer.toBinaryString(n);
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '1') {
				System.out.println("Char 1 found at:" + (s.length() - i));
			}
		}
		List<Integer> ans = new ArrayList<>();
		System.out.println(s);
		while (n > 0) {
			ans.add(n % 2);
			n = n / 2;
		}
		Collections.reverse(ans);

		ans.stream().forEach(System.out::print);

	}

	public static void maxSumByIgnoringStartOrEndOfKElements() {
		int a[] = { 2, 3, 7, 5, 6, 4 };
		int n = 6;
		int k = 3;
		// output 18
		// int a[] = { 6, 4, 2, 2, 9, 9, 3, 3 };
		// int n = 8;
		// int k = 4;
		// output 24
		List<Integer> sums = new ArrayList();
		int l = 0;
		int h = k;
		while (h >= 0 && l <= k) {
			int sum = 0;
			for (int i = l; i < n - h; i++) {
				sum = sum + a[i];
			}
			sums.add(sum);
			l++;
			h--;
		}

		System.out.println("All sums: " + sums);
		System.out.println("Max sums: " + Collections.max(sums));

	}
}
