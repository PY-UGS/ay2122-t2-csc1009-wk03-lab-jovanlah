import java.util.Date;
import java.util.Scanner;

public class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private double monthlyPayment;
    private double totalPayment;
    
    public Loan(){
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return this.numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        Date loanDate = new Date();
        return loanDate;
    }

    public double getMonthlyPayment(double annualInterestRate, int numberOfYears, double loanAmount){
        double monthlyInterestRate =(annualInterestRate/12)/100;
        this.monthlyPayment = (loanAmount*monthlyInterestRate) / (1-(1/Math.pow((1+monthlyInterestRate),numberOfYears*12)));
        return this.monthlyPayment;
    }

    public double getTotalPayment(int numberOfYears, double loanAmount){
        this.totalPayment = this.monthlyPayment*numberOfYears*12;
        return this.totalPayment;
    }

    public static void main(String[] args)
    {
        Loan carLoan = new Loan();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter annual interest rate, for example, 8.25: ");
        carLoan.annualInterestRate = in.nextDouble();

        System.out.print("Enter number of years as an integer: ");
        carLoan.numberOfYears = in.nextInt();

        System.out.print("Enter loan amount, for example, 120000.95: ");
        carLoan.loanAmount = in.nextDouble();

        System.out.println("The loan was created on " + carLoan.getLoanDate());

        System.out.printf("The monthly payment is %.2f", carLoan.getMonthlyPayment(carLoan.annualInterestRate,carLoan.numberOfYears,carLoan.loanAmount));

        System.out.printf("\nThe total payment is %.2f", carLoan.getTotalPayment(carLoan.numberOfYears,carLoan.loanAmount));
        in.close();
    }
}
