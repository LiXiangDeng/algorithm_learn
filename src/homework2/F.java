package homework2;

import java.util.Scanner;

public class F {
    private static int getBin(int n,int i){
        return (n>>i) & 1;
    }
    private  static void solve(int n){
        int flag = 1;
        for(int i=15 ; i>=0 ; --i){
           if(getBin(n,i)==1){
               if (flag==0)
               {
                   System.out.print("+");
               }
               else
               {
                   flag = 0;
               }
               if(i==0)
               {
                   System.out.print("2(0)");
               }
               else if(i==1)
               {
                   System.out.print("2");
               }
               else
               {
                   System.out.print("2(");
                   solve(i);
                   System.out.print(")");
               }
           }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve(n);
        in.close();

    }
}
