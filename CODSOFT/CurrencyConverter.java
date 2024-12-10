import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter 
{
    private static Map<String, Double> exchangeRates = new HashMap<>();

    static 
	{
        exchangeRates.put("USD", 1.0); // Base currency
        exchangeRates.put("EUR", 0.93);
        exchangeRates.put("GBP", 0.82);
        exchangeRates.put("INR", 83.2);
        exchangeRates.put("JPY", 150.1);
    }

    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY");
        System.out.print("Enter the base currency: ");
        String baseCurrency = scanner.next().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency)) 
		{
            System.out.println("Invalid base currency. Please restart the program.");
            return;
        }

        System.out.print("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        if (!exchangeRates.containsKey(targetCurrency)) 
		{
            System.out.println("Invalid target currency. Please restart the program.");
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amount;
        try 
		{
            amount = scanner.nextDouble();
            if (amount < 0) 
			{
                System.out.println("Invalid amount. Please enter a positive value.");
                return;
            }
        } 
		catch (Exception e) 
		{
            System.out.println("Invalid input. Please enter a numeric value.");
            return;
        }

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
        System.out.printf("%.2f %s is equivalent to %.2f %s.\n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount) 
	{
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        return (amount / baseRate) * targetRate;
    }
}
