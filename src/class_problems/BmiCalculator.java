import java.util.Scanner;

public class BmiCalculator {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("Person | Height | Weight | BMI | Status");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf(
                    "%d | %.2f | %.2f | %.2f | %s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi)
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] heights = new double[3];
        double[] weights = new double[3];

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter height of person " + (i + 1) + " in meters: ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight of person " + (i + 1) + " in kg: ");
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);

        sc.close();
    }
}