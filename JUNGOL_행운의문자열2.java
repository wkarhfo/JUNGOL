import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JUNGOL_행운의문자열2 {
	static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		arr = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		Arrays.sort(arr);
		int count=0;
		while(true) {
			if(Isokay(arr)) {
				count++;
			}
			if(!nextpermitation()) {
				break;
			}
		}
		System.out.println(count);
	}
	private static boolean Isokay(char[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1])
				return false;
		}
		return true;
	}
	private static boolean nextpermitation() {
		int temp=arr.length-1;
		while(temp>0&&arr[temp-1]>=arr[temp]) temp--;
		if(temp<=0)
			return false;
		
		int last=arr.length-1;
		while(arr[temp-1]>=arr[last]) last--;
		
		char swap=arr[temp-1];
		arr[temp-1]=arr[last];
		arr[last]=swap;
		
		last=arr.length-1;
		while(temp<last) {
			swap=arr[temp];
			arr[temp]=arr[last];
			arr[last]=swap;
			temp++;
			last--;
		}
		
		return true;
	}
}
