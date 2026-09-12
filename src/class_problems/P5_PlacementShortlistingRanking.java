import java.util.Arrays;

public class P5_PlacementShortlistingRanking
        implements Comparable<P5_PlacementShortlistingRanking> {

    private String name;
    private double cgpa;
    private int codingScore;

    public P5_PlacementShortlistingRanking(
            String name, double cgpa, int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    private double getCompositeScore() {
        return cgpa * 10 + codingScore;
    }

    @Override
    public int compareTo(P5_PlacementShortlistingRanking other) {

        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    static String shortlistAndRank(
            P5_PlacementShortlistingRanking[] candidates) {

        P5_PlacementShortlistingRanking[] temp =
                new P5_PlacementShortlistingRanking[candidates.length];

        int count = 0;

        for (P5_PlacementShortlistingRanking candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {

                temp[count] = candidate;
                count++;
            }
        }

        P5_PlacementShortlistingRanking[] shortlisted =
                Arrays.copyOf(temp, count);

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result += (i + 1) + ". "
                    + shortlisted[i].name
                    + " ("
                    + shortlisted[i].getCompositeScore()
                    + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        P5_PlacementShortlistingRanking[] candidates = {

                new P5_PlacementShortlistingRanking(
                        "Aisha", 8.2, 40),

                new P5_PlacementShortlistingRanking(
                        "Rohit", 6.8, 65),

                new P5_PlacementShortlistingRanking(
                        "Meena", 6.0, 90),

                new P5_PlacementShortlistingRanking(
                        "Karan", 7.5, 20)
        };

        System.out.println(
                shortlistAndRank(candidates)
        );
    }
}