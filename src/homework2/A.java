package homework2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==5)
            System.out.print("JMcat Win");
        else if(n%2==0)
            System.out.print("JMcat Win");
        else
            System.out.print("PZ Win");
        in.close();
    }
}
