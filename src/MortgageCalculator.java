/*
This program will take a given loan amount, interest rate, and term length and return the total balance owed as well
as the minimum monthly payment.
 */

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double loanAmount = 0;
        double interestRate = 0;
        double monthlyPayment = 0;
        double balanceOwed = 0;
        int termLengthInYears;

        System.out.printf("Enter the loan amount: ");
        loanAmount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interestRate = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        termLengthInYears = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, termLengthInYears);

        //The total balance owed by multiplying monthly payments by the total number of months in the term
        balanceOwed = -(monthlyPayment*(termLengthInYears*12));

        System.out.format("%-30s$%-+10.2f%n", "Balance owed to bank: ", balanceOwed);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", monthlyPayment);

        keyboard.close();
    }

    /*
    Calculates the monthly payment using the given loan amount, interest rate,and term length (years)
     */
    public static double calculateMonthlyPayment(double loanAmount, double interestRate, int termLengthInYears) {
        // calculates the monthly payment
        double rate = (interestRate/ 100) / 12;
        double base = (1 + rate);
        double termLengthInMonths = termLengthInYears* 12;
        double monthlyPayment = 0.0;
        monthlyPayment = ((rate * loanAmount) / (1 - Math.pow(base, -termLengthInMonths)));

        return monthlyPayment;
    }
}