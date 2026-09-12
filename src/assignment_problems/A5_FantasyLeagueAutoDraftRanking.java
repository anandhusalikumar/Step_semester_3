import java.util.Arrays;

public class A5_FantasyLeagueAutoDraftRanking
        implements Comparable<A5_FantasyLeagueAutoDraftRanking> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public A5_FantasyLeagueAutoDraftRanking(
            String name,
            int matchesPlayed,
            double battingAverage,
            boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(
            int matchesPlayed,
            boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(
            A5_FantasyLeagueAutoDraftRanking other) {

        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    static String draftAndRank(
            A5_FantasyLeagueAutoDraftRanking[] players) {

        A5_FantasyLeagueAutoDraftRanking[] temp =
                new A5_FantasyLeagueAutoDraftRanking[players.length];

        int count = 0;

        for (A5_FantasyLeagueAutoDraftRanking player : players) {

            if (isDraftable(player.matchesPlayed)
                    || isDraftable(
                    player.matchesPlayed,
                    player.injured)) {

                temp[count] = player;
                count++;
            }
        }

        A5_FantasyLeagueAutoDraftRanking[] draftable =
                Arrays.copyOf(temp, count);

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result += (i + 1)
                    + ". "
                    + draftable[i].name;

            if (i < draftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        A5_FantasyLeagueAutoDraftRanking[] players = {

                new A5_FantasyLeagueAutoDraftRanking(
                        "Virat", 15, 48.0, false),

                new A5_FantasyLeagueAutoDraftRanking(
                        "Rahul", 7, 55.0, false),

                new A5_FantasyLeagueAutoDraftRanking(
                        "Sameer", 3, 60.0, false),

                new A5_FantasyLeagueAutoDraftRanking(
                        "Dev", 12, 20.0, true)
        };

        System.out.println(
                draftAndRank(players)
        );
    }
}