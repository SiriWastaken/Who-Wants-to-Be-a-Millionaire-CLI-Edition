import java.util.*;

public class Lifelines {


    public static class LifelineS {
        private boolean fiftyFiftyUsed = false;
        private boolean audienceUsed = false;
        private boolean phoneUsed = false;
        private Random rand = new Random();


        public List<Integer> useFiftyFifty(Questions.Question q) {
            if (fiftyFiftyUsed) return null;
            fiftyFiftyUsed = true;

            List<Integer> wrongOptions = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                if (i != q.getCorrectAnswer()) wrongOptions.add(i);
            }

            Collections.shuffle(wrongOptions, rand);
            List<Integer> result = new ArrayList<>();
            result.add(q.getCorrectAnswer());
            result.add(wrongOptions.get(0));
            Collections.shuffle(result, rand);
            return result;
        }

        public Map<Integer, Integer> askAudience(Questions.Question q) {
            if (audienceUsed) return null;
            audienceUsed = true;

            Map<Integer, Integer> votes = new HashMap<>();
            int correctVote = 70 + rand.nextInt(26); // 70-95% correct
            int remaining = 100 - correctVote;

            List<Integer> wrongOptions = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                if (i != q.getCorrectAnswer()) wrongOptions.add(i);
            }

            int firstWrong = rand.nextInt(remaining + 1);
            int secondWrong = rand.nextInt(remaining - firstWrong + 1);
            int thirdWrong = remaining - firstWrong - secondWrong;

            votes.put(q.getCorrectAnswer(), correctVote);
            votes.put(wrongOptions.get(0), firstWrong);
            votes.put(wrongOptions.get(1), secondWrong);
            votes.put(wrongOptions.get(2), thirdWrong);

            return votes;
        }

        // PAP (phone a friend)
        public String phoneFriend(Questions.Question q) {
            if (phoneUsed) return null;
            phoneUsed = true;

            int chance = rand.nextInt(100);
            if (chance < 80) {
                return "Friend suggests: " + q.getCorrectAnswerText();
            } else {
                List<Integer> wrongOptions = new ArrayList<>();
                for (int i = 0; i < 4; i++)
                    if (i != q.getCorrectAnswer()) wrongOptions.add(i);
                int pick = wrongOptions.get(rand.nextInt(wrongOptions.size()));
                return "Friend suggests: " + q.getOptions()[pick];
            }
        }

        public class cashBoard {

            public static void printCashBoard(int currentQuestion) {
                int[] MONEY_LADDER = {
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

                System.out.println();
                System.out.println("╔══════════════════════════════════╗");
                System.out.println("║      💰 CASH BOARD 💰             ║");
                System.out.println("╠══════════════════════════════════╣");

                for (int i = MONEY_LADDER.length - 1; i >= 1; i--) {
                    String marker = (i == currentQuestion) ? "  ◄◄ YOU ARE HERE" : "";
                    System.out.printf("║ Q%-2d │ $%-10s %s%n", i, MONEY_LADDER[i], marker); // dont ask me what this means, chat coded the ASCII and we don't look back!
                }

                System.out.println("╚══════════════════════════════════╝");
                System.out.println();
            }
        }

        public void reset() {
            fiftyFiftyUsed = false;
            audienceUsed = false;
            phoneUsed = false;
        }
    }
}

