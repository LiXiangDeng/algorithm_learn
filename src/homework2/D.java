package homework2;

import java.util.Scanner;

public class D {
    public static long solve(int n , int m){
        if(m==0 || n<m){
            return 0;
        }
        if(m==1 || m==n){
            return 1;
        }
        return m * solve(n-1,m) + solve(n-1,m-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            long sum = 0;
            int n = in.nextInt();
            for(int i=1;i<=n;++i){
                sum += solve(n,i);
            }
            System.out.print(sum+"\n");
        }
        in.close();
    }
}
