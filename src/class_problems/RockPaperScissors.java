import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player | Computer | Result");

        for (int i = 1; i <= 5; i++) {

            System.out.print("Round " + i + " - Enter Rock, Paper or Scissors: ");
            String player = sc.nextLine();

            String computer = moves[random.nextInt(3)];

            String result = playRound(player, computer);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println(i + " | " + player + " | " + computer + " | " + result);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}