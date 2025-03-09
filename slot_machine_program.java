import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class slot_machine_program {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
//        if two match -> won 1.5betAmount
//        if three match-> won 2betAmount
//        if loose -> loose $bet amt

//        welcome message
        System.out.println("*************************");
        System.out.println(" Welcome to Java Slots ");
        System.out.println("Symbols: 🍒 🍉 🍊 🍎 🍓");
        System.out.println("*************************");

//        declare var
        double currentBalance = 100;
        double betAmount;
        int count = 0;
        String isPlaying = "y";
        String[] eles = {"🍒", "🍉", "🍊", "🍎", "🍓"};

        do{
            //        defining
            System.out.println("Current balance: $" + currentBalance);
            System.out.print("Place your bet amount: ");
            betAmount = sc.nextDouble();
            sc.nextLine();
            if(betAmount<0){
                System.out.println("bet must be greater than zero");
            }
            System.out.println("Spinning...");
            Thread.sleep(1000);


            //spin();
            String slot1 = eles[random.nextInt(0,5)];
            String slot2 = eles[random.nextInt(0,5)];
            String slot3 = eles[random.nextInt(0,5)];
            if((slot1.equals(slot2)) && slot3.equals(slot1)) count = 3;
            else if ((slot1.equals(slot2)) ||
                    (slot1.equals(slot3)) ||
                    (slot2.equals(slot3))) count = 2;
            else count = 1;

//        spin display
            System.out.println("**************");
            System.out.println(slot1 + " | " + slot2 + " | " + slot3);
            System.out.println("**************");

//        adjusting the result to currentBalance
            if(count == 2){ //  2 matches
                currentBalance += .5*betAmount;
                System.out.println("you won $"+ .5*betAmount);
            }
            else if(count == 3){ //  3 matches
                currentBalance += (betAmount);
                System.out.println("you won $"+ betAmount);
            }
            else{ // loose
                currentBalance -= betAmount;
                System.out.println("Sorry you lost this round");
            }

//         want to play next round
            System.out.print("Do you want to play again(y/n): ");
            isPlaying = sc.nextLine().toLowerCase();

        }while(currentBalance>0 && isPlaying.equals("y"));

        System.out.println("Thanks for playing, your final balance is " + currentBalance);
        sc.close();
    }
}
