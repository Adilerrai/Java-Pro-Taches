public class CompoundInterest {
    public static void main(String[] args) {
        double initialAmount = 1000.0;
        double interestRate = 0.05; // 5% annual interest rate
        int years = 50;

        // Calculate compound interest using double
        double finalAmountDouble = calculateCompoundInterest(initialAmount, interestRate, years);
        System.out.println("Final amount (double): " + finalAmountDouble);

        // Calculate compound interest using long
        long finalAmountLong = (long) calculateCompoundInterest(initialAmount, interestRate, years);
        System.out.println("Final amount (long): " + finalAmountLong);

        // Compare the precision and performance
        System.out.println("Difference in precision: " + (finalAmountDouble - finalAmountLong));
    }

    public static double calculateCompoundInterest(double initialAmount, double interestRate, int years) {
        return initialAmount * Math.pow(1 + interestRate, years);
    }
}