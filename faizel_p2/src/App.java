import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    private static Boolean moreInput() {
        // create scanner and print input prompt
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to input a user? (Y or N): ");

        String answer = scan.nextLine();
        Boolean temp = true;

        // for loop to ask to continue taking inputs
        switch(answer) {
            case "Y":
                break;
            case "N":
                temp = false;
                break;
        }
        return temp;
    }

    private static double getUserHeight() {
        // initialize height double and create scanner
        double height = 0;
        Scanner scan = new Scanner(System.in);

        // while loop to ensure that positive inputs are taken
        while (height <= 0){
            System.out.println("Enter the user's height in inches (only positive values): ");
            height = scan.nextDouble();
        }

        return height;
    }

    private static double getUserWeight() {
        // initialize weight double and create scanner
        double weight = 0;
        Scanner scan = new Scanner(System.in);

        // while loop to ensure that positive inputs are taken
        while (weight <= 0) {
            System.out.println("Enter the user's weight in pounds (only positive values): ");
            weight = scan.nextDouble();
        }

        return weight;
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        // uses formatter to round double to one decimal place
        NumberFormat formatter = new DecimalFormat("#0.0");

        // prints bmi and category element of bmi class
        System.out.println("User's BMI: " + formatter.format(bmi.bmi));
        System.out.println("Category: " + bmi.category);
        System.out.println("----------------------------");
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiArray) {
        // uses formatter to round double to one decimal place
        NumberFormat formatter = new DecimalFormat("#0.0");

        // for loop to add bmi elements to average
        int i;
        int ctr = bmiArray.size();
        double average = 0;
        for (i = 0; i < ctr; i++) {
            average += bmiArray.get(i).bmi;
        }
        // System.out.println(average);
        average = average/ctr;

        // System.out.println(average);

        System.out.println("----------------------------");
        System.out.println("Average User BMI: " + formatter.format(average));
    }

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
}
