import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long r = 0; // 결과 값을 저장할 변수
		long c = 1; // 현재 비트에 해당하는 숫자
		
		// 오른쪽 비트부터 1인지 확인
		while (N != 0) {
			if ((N & 1) == 1) {
				r += c;
			}
			c *= 3;
			N  /= 2;
		}
		
		System.out.println(r);
	}
}