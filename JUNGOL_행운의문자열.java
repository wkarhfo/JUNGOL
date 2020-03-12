import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class JUNGOL_행운의문자열 {
	static char[] arr;
	static int[] alpha = new int[26];
	static Set<String> list;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		arr = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
		}

		for (int i = 0; i < arr.length; i++) {
			alpha[arr[i] - 'a']++;
		}
		list=new HashSet<>();
		for (int i = 0; i < 26; i++) {
			if (alpha[i] > 0) {
				temp = new int[26];
				for (int j = 0; j < 26; j++)
					temp[j] = alpha[j];
				temp[i]--;
				String re=(char)(i+'a')+" ";
				dfs(i,1,re);
			}
		}
		System.out.println(list.size());
	}

	private static void dfs(int idx, int cnt,String sum) {
		if(cnt==arr.length) {
			list.add(sum);
			return;
		}
		for(int i=0;i<26;i++) {
			if(temp[i]>0&&i!=idx) {
				
				System.out.println(sum);
				temp[i]--;
				dfs(i,cnt+1,sum+((char)(i+'a'))+" ");
				temp[i]++;
				
			}
		}
	}

	/*
	 * private static void dfs(char c, String result, int cnt) { if (cnt ==
	 * arr.length) { list.add(result); return; } for (int i = 0; i < 26; i++) { if
	 * (alpha[i] > 0 && c != (char) (i + 'a')) { alpha[i]--; dfs((char) (i + 'a'),
	 * result + ((char) (i + 'a') + ""), cnt + 1); alpha[i]++; } }
	 * 
	 * }
	 */

}
