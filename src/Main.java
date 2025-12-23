import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lifelines.LifelineS mainLifelineLine = new Lifelines.LifelineS(); // initiating my class for lifelines

        System.out.println("WELCOME TO WHO WANTS TO BE A MILLIONAIRE!");
        System.out.println("Alright, let us begin!");
        System.out.println("***** WHO WANTS TO BE A MILLIONAIRE *****"); // i thought it looked nice. sooo, hence, it's here!
        int currentQuestion = 0;
        int currentMoney = 0;


        final int[] MONEY_LADDER = {
                0,
                100,
                200,
                300,
                500,
                1_000,
                2_000,
                4_000,
                8_000,
                16_000,
                32_000,
                64_000,
                125_000,
                250_000,
                500_000,
                1_000_000
        };


        List<Questions.Question> gameQuestions = Questions.getGameQuestions();

        for (int i = 0; i < gameQuestions.size(); i++) {
            Questions.Question q = gameQuestions.get(i);

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(q.getQuestion());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((char) ('A' + j) + ": " + options[j]);
            }


            System.out.print("Your answer: ");
            String input = scanner.nextLine().toUpperCase();
            if (input.equalsIgnoreCase("cb")) {
                Lifelines.LifelineS.cashBoard.printCashBoard(currentQuestion);
                continue;
            }

            int answer = input.charAt(0) - 'A';
            if (answer != q.getCorrectAnswer()) {
                System.out.println("Wrong. Game over.");
                System.out.println("The correct answer is option " + q.getCorrectAnswer());
                int fallBackMoney = currentQuestion >= 10 ? 32_000 :
                        currentQuestion >= 5  ? 1_000  :
                                0;
                System.out.println("Your final balance is.... " + fallBackMoney);
                break;
            } else {
                System.out.println("Correct! You now have " + currentMoney + " dollars.");
                currentQuestion++;
                currentMoney = MONEY_LADDER[currentQuestion - 1];
            }
        }

        scanner.close();
    }
}
