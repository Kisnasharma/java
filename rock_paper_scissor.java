import java.util.Random;
import java.util.Scanner;

public class rock_paper_scissor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String myMove;
        String compMove;
        int num;
        boolean isPlaying = true;

//        loop
        while(isPlaying){
            System.out.print("Enter your move: ");
            myMove = sc.nextLine().toLowerCase();


            num = random.nextInt(1,4);
            if(num == 1) {
                compMove = "rock";
                System.out.println("Computer choice: rock");
            }
            else if(num == 2){
                compMove = "paper";
                System.out.println("Computer choice: paper");
            }
            else{
                compMove = "scissors";
                System.out.println("Computer choice: scissors");
            }
            rockPaperScissor(myMove,compMove);
            System.out.print("Play again (true/false): ");
            isPlaying = sc.nextBoolean();
            sc.nextLine();
        }
        System.out.println("Thank's for playing");
        sc.close();

    }

    static void rockPaperScissor(String myMove, String compMove){
        if(myMove.equals(compMove)) {
            System.out.println("tie");
            return;
        }

        switch (myMove){
            case "scissors"->{
                if(compMove.equals("rock")){
                    System.out.println("computer win !");
                }
                else{
                    System.out.println("You win !");
                }
            }
            case "rock"->{
                if(compMove.equals("paper")){
                    System.out.println("computer win !");
                }
                else{
                    System.out.println("You win !");
                }
            }
            case "paper"->{
                if(compMove.equals("scissors")){
                    System.out.println("computer win !");
                }
                else{
                    System.out.println("You win !");
                }
            }
        }
    }
}
