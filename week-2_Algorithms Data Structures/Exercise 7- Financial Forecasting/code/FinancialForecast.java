package FinancialForecast;

import java.util.Scanner;

public class FinancialForecast {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue; 
        }
        return calculateFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial amount (e.g. 10000): ");
        double initialAmount = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (in %, e.g. 5 for 5%): ");
        double ratePercent = scanner.nextDouble();
        double annualGrowthRate = ratePercent / 100;

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(initialAmount, annualGrowthRate, years);

        System.out.printf("Future value after %d years: ₹%.2f\n", years, futureValue);

        scanner.close();
    }
}