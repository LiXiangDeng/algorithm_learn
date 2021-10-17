package homework2;

import java.util.Scanner;

public class C {
    public static double n = 0;
    public static double m = 1.0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextDouble();
        while(m<n){
            m *= 18;
        }
        if(n==1)
            System.out.print("181818181818");
        else if(n <= m/2)
            System.out.print("181818181818");
        else
            System.out.print("ZBT");
        in.close();
    }
}
