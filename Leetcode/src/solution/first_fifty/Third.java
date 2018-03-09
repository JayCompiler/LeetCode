package solution.first_fifty;
/**
 * Given a string, find the length of the longest substring without repeating characters.

	Examples:

	Given "abcabcbb", the answer is "abc", which the length is 3.

	Given "bbbbb", the answer is "b", with the length of 1.

	Given "pwwkew", the answer is "wke", with the length of 3. 
	Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author zy
 *
 */
public class Third {
	

	public static void main(String[] args) {
		String alString = "pwwkew";
		System.out.println(lengthOfLongestSubstring(alString));

	}
	/**
	 * find the longest substring which haven't repetition
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		/*
		 * 'maxcount' is the longest substring which haven't repetition finally 'count'
		 * is the longest substring which haven't repetition now
		 */
		int maxcount = 0, count = 0;
		int[] num = new int[65535];
		char[] ch = s.toCharArray();
		int lens = ch.length;
		for (int i = 0, j = 0; j < lens; j++) {
			int c = ch[j] - 0;
			int temp = ++num[c];
			if (temp == 1) {
				count++;
				if (count > maxcount)
					maxcount = count;
			} else {
				while ((--num[ch[i++] - 0]) != 1) {
					count--;
				}
			}
		}
		return maxcount;
	}

}
