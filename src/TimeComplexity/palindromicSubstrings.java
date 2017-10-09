package TimeComplexity;

public class palindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countPalindromicSubstrings("aaba"));
	}

	public static int countPalindromicSubstrings(String str) {
		int count = 0;
		for (int axis = 0; axis <= str.length(); axis++) {
			count++;
			for (int orbit = 1; orbit < str.length(); orbit++) {
				if (axis - orbit < 0 || axis + orbit > str.length() - 1) {
					break;
				}
				if (str.charAt(axis + orbit) == str.charAt(axis - orbit)) {
					count++;
				}
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit-1)) {
					count++;
				} else
					break;
			}
		}
		if (str.length()<2)
		{
			count--;
		}
		return count;

	}
}
