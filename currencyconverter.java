import java.util.*;

class currencyconverter2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Available currencies : USD, EUR, INR");
        System.out.print("Enter source currency : ");
        String from = sc.next().toUpperCase();
        System.out.print("Enter target currency : ");
        String to = sc.next().toUpperCase();
        System.out.print("Enter amount : ");
        double amount = sc.nextDouble();

        double convertedAmount = 0.0;
        boolean valid = true;

        double USD_TO_EUR = 0.85;
        double USD_TO_INR = 83.15;
        double EUR_TO_USD = 1 / USD_TO_EUR; // instead of hardcoding 1
        double INR_TO_USD = 1 / USD_TO_INR;

        if (from.equals("USD")) {
            if (to.equals("EUR")) {
                convertedAmount = amount * USD_TO_EUR;
            } else if (to.equals("INR")) {
                convertedAmount = amount * USD_TO_INR;
            } else if (to.equals("USD")) {
                convertedAmount = amount;
            } else {
                valid = false;
            }
        } else if (from.equals("EUR")) {
            if (to.equals("USD")) {
                convertedAmount = amount * EUR_TO_USD;
            } else if (to.equals("INR")) {
                convertedAmount = amount * EUR_TO_USD * USD_TO_INR;
            } else if (to.equals("EUR")) {
                convertedAmount = amount;
            } else {
                valid = false;
            }
        } else if (from.equals("INR")) {
            if (to.equals("USD")) {
                convertedAmount = amount * INR_TO_USD;
            } else if (to.equals("EUR")) {
                convertedAmount = amount * INR_TO_USD * USD_TO_EUR;
            } else if (to.equals("INR")) {
                convertedAmount = amount;
            } else {
                valid = false;
            }
        } else {
            valid = false;
        }

        if (valid) {
            System.out.printf("%.2f %s = %.2f %s%n", amount, from, convertedAmount, to);
        } else {
            System.out.println("INVALID CURRENCY INPUT");
        }

        sc.close();}
}
