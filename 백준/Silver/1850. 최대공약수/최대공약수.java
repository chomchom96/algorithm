import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] numbers = br.readLine().split(" ");
		
		long n1 = Long.parseLong(numbers[0]);
		long n2 = Long.parseLong(numbers[1]);
		
		long repeat = gcd(n1,n2);
		
		String gcd = "1".repeat((int)repeat);

		bw.write(gcd +"\n");
		bw.flush();
		bw.close();
	}
	
	public static long gcd(long a,long b) {
		
		if(b == 0 ) return a;
		else {
			long r = a%b;
			return gcd(b,r);
		}
		
	}

		
}
