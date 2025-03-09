import java.sql.SQLOutput;
import java.util.Scanner;
public class java_quiz_game {
    public static void main(String[] args) {
        System.out.println("**************************");
        System.out.println("Welcome to java quiz game!");
        System.out.println("**************************\n");
        Scanner sc = new Scanner(System.in);
        int guess;
        int[] answers = {1,3,2,3,4};
        int score = 0;
        String[] questions = {"Number of carbon atom in benzene? ",
                              "GDP formula is?",
                              "Happiness depends upon ourselves is said by?",
                              "What is the capital of Brazil?",
                              "What is the unit of Torque?"};

        String[][] options = {{"1. 6", "2. 3", "3. 7", "4. 5"},
                              {"1. G+C+I+(X+M)", "2. G-C+I+(X+M)", "3. G+I+C+(X-M)", "4. G+C-I+(X-M)"},
                              {"1. Plato ", "2. Aristotle", "3. Machiavelli", "4. John s mill"},
                              {"1. Burkina", "2. Columbia", "3. Brasília", "4. Rio de Janeiro"},
                              {"1. N", "2. NM^2", "3. N/M", "4 NM"}};

        for(int i=0;i<questions.length;i++){
            System.out.println(questions[i]);
            for(String option : options[i]){
                System.out.println(option);
            }
            System.out.print("Enter the required option number: ");
            guess = sc.nextInt();
            if(guess == answers[i]){
                score ++;
                System.out.println("*******");
                System.out.println("CORRECT");
                System.out.println("*******\n");
            }
            else{
                System.out.println("*******");
                System.out.println(" WRONG ");
                System.out.println("*******");
                System.out.println("Correct option is " + options[i][answers[i]-1] + "\n");
            }
        }
        System.out.println("your score is " + score + " out of " + questions.length);
    }
}
