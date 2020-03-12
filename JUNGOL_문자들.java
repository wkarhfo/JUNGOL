import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class JUNGOL_문자들 {
	static char[][] arr;
	static int[] dh = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int MAX;
	static boolean[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hang = Integer.parseInt(st.nextToken());
		int yeul = Integer.parseInt(st.nextToken());
		arr = new char[hang][yeul];
		visit = new boolean[hang][yeul];

		for (int i = 0; i < hang; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();

		}
		MAX = 0;
		list=new boolean[26];
		visit[0][0]=true;
		list[arr[0][0]-'A']=true;
		dfs(0, 0, 1);
		System.out.println(MAX);

	}

	private static void dfs(int h, int y, int cnt) {
		MAX = Math.max(MAX, cnt);
		for (int k = 0; k < 4; k++) {
			int ah = h + dh[k];
			int ay = y + dy[k];
			if (ah < 0 || ah >= arr.length || ay < 0 || ay >= arr[0].length || visit[ah][ay] == true)
				continue;
			if(list[arr[ah][ay]-'A']==true)
				continue;
			visit[ah][ay] = true;
			list[arr[ah][ay]-'A']=true;
			dfs(ah, ay, cnt + 1);
			visit[ah][ay] = false;
			list[arr[ah][ay]-'A']=false;
		}
	}
}
