package homework2;
import java.util.Scanner;
public class B {
    public static int k = 0;
    public static int n = 0;
    public static int option = 0;
    public static int num = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        k = in.nextInt();
        for (int i=0;i<k;++i){//k组数据
            n = in.nextInt();
            option = in.nextInt();
            for(int j=0;j<n;j++){
                num =in.nextInt();
            }

            if(option == 1)
            {
                System.out.print("lolanv\n");
            }
            else
            {
                System.out.print("wind\n");
            }
        }
    }
}
