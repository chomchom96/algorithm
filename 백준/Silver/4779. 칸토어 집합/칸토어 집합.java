import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.*;

public class Main {
    static int n;
    static char c[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = br.readLine()) != null){
            n = Integer.parseInt(str); //N

            int pow = (int) Math.pow(3,n);
            c = new char[pow];

            for(int i=0;i<pow;i++) c[i] = '-';

            back(0,pow);

            for(int i=0;i<pow;i++) bw.write(c[i]);
            bw.write("\n");
            bw.flush();
        }
    }

    static void back(int start,int length){
        if(length < 3) {
            return;
        }
        for(int i=start+length/3;i<start+length/3*2;i++) c[i] = ' ';
        back(start,length/3);
        back(start+length/3*2,length/3);
    }
}