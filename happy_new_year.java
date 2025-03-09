import java.util.Scanner;

public class happy_new_year {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many seconds to countdown from?: ");
        int start = sc.nextInt();

        for(int i = start; i>0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Happy new year🍷🍾🍾🍷");
        sc.close();
    }
}
