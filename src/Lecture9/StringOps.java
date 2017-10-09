package Lecture9;

public class StringOps {

	public static void main(String[] args) {
		// Part 1
//		PrintSubString("Hello");
//		System.out.println("**********************************");
//		// part 2
//		System.out.println(IsPalindrome("Hello"));
//		System.out.println(IsPalindrome("ee"));
//		System.out.println("**********************************");
//		// Part 3
//		System.out.println(CountPalindromicSS("ello"));
//		System.out.println("**********************************");
//		// Part 4
//		System.out.println(toggle("HEllO"));
//		System.out.println("**********************************");
//		// Part 5
//		System.out.println(PatternOne("Heelo"));
//		System.out.println("**********************************");
//		// part 6
//		System.out.println(PatternTwo("Hhello"));
//		System.out.println("**********************************");
//		// part 7
//		MostOccuringChar("Hellohhh");
//		System.out.println("**********************************");
//		// part 8
//		System.out.println(DuplicateRemove("aabccba"));
//		System.out.println("**********************************");
//		// part 9
//		System.out.println(StringCompress("aaabbccdsss"));
//		System.out.println("**********************************");
//		// part 10
		subsequences("abcd");
		System.out.println("**********************************");
//		//part 11
//		System.out.println(Reverse("Hello"));
//		System.out.println("**********************************");
//		//part 12
//		permutations("hello");
//		System.out.println("**********************************");

	}

	public static void PrintSubString(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length(); j > i; j--) {
				System.out.println(s.substring(i, j));
			}
		}
	}

	public static boolean IsPalindrome(String sh) {
		String reverse = Reverse(sh);
		if (sh.compareTo(reverse) == 0) {
			return true;
		} else
			return false;
	}

	public static String Reverse(String original) {
		String reverse = "";
		int length = original.length();
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		return reverse;
	}

	public static int CountPalindromicSS(String s) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length(); j > i; j--) {
				if (IsPalindrome(s.substring(i, j)) == true)
					counter++;
			}

		}
		return counter;
	}

	public static String toggle(String s) {
		String toggled = "";
		char now, after;
		int ascii;
		for (int i = 0; i < s.length(); i++) {
			now = s.charAt(i);
			if ('a' <= now && now <= 'z') {
				ascii = now + 'A' - 'a';
				after = (char) ascii;
				toggled = toggled + after;
			} else if ('A' <= now && now <= 'Z') {
				ascii = now + 'a' - 'A';
				after = (char) ascii;
				toggled = toggled + after;
			} else
				toggled = toggled + now;

		}
		return toggled;
	}

	public static String PatternOne(String s) {
		String Final = "";
		int counter = 1;
		char now, after;
		int ascii;
		for (int i = 0; i < s.length(); i++) {
			if (counter % 2 == 0) {
				now = s.charAt(i);
				ascii = now - 1;
				after = (char) ascii;
				Final = Final + after;
			} else {
				now = s.charAt(i);
				ascii = now + 1;
				after = (char) ascii;
				Final = Final + after;
			}
			counter++;
		}
		return Final;
	}

	public static String PatternTwo(String s) {
		String Final = "";
		char now, next;
		int diff;
		for (int i = 0; i < s.length() - 1; i++) {
			now = s.charAt(i);
			next = s.charAt(i + 1);
			diff = next - now;
			Final = Final + now + diff;
		}
		Final += s.charAt(s.length() - 1);
		return Final;
	}

	public static void MostOccuringChar(String s) {
		char maxchar = ' ';
		int counter = 1, maxcounter = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					counter++;

			}
			if (counter > maxcounter) {
				maxcounter = counter;
				maxchar = s.charAt(i);
			}
			counter = 1;
		}
		System.out.println(maxchar + " = " + maxcounter);
	}

	public static String DuplicateRemove(String s) {
		String Final = "";
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				Final += s.charAt(i);
				i++;
			} else {
				Final += s.charAt(i);
				if (i == s.length() - 2 && s.charAt(s.length() - 2) != s.charAt(s.length() - 1)) {
					Final += s.charAt(s.length() - 1);
				}
			}
		}
		return Final;

	}

	public static String StringCompress(String s) {
		String Final = "";
		int counter = 1;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					counter++;
				} else
					break;
			}
			Final += s.charAt(i);
			if (counter > 1)
				Final += counter;
			i += counter - 1;
			counter = 1;
		}
		return Final;
	}

	public static void subsequences(String s) {
		int counter;
		for (int i = 0; i < Math.pow(2, s.length()); i++) {
			counter = 0;
			System.out.print("{");
			int num = i;
			while (num > 0) {
				if (num % 2 == 1) {
					System.out.print(s.charAt(counter) + " ");

				}
				counter++;
				num = num / 2;
			}
			System.out.println("}");
		}
	}
	public static void permutations(String s) {
		System.out.println(s);
		char[] input = s.toCharArray();
		int size = input.length;
		int[] p = new int[size];
		int i = 1;
		while (i < size) {
			if (p[i] < i) {
				int j = 0;
				if (i % 2 != 0) {
					j = p[i];
				}
				swap(input, i, j);
				System.out.println(input);
				p[i]++;
				i = 1;
			} else {
				p[i] = 0;
				i++;

			}
		}
	}

	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}