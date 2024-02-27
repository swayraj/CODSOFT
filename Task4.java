import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Task4 {
    private static final String API_KEY = "2bb6c9a30663d8f81f591acc";

    public static void main(String[] args) {
        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "CAD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "INR");

        String fromcode, tocode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome To Currency Converter");

        // To convert
        System.out.println("Currency Converting From?");
        System.out.println("1.USD  2.CAD  3.EUR  4.HKD  5.INR");
        fromcode = currencyCodes.get(sc.nextInt());

        // To convert to
        System.out.println("Convert Currency To");
        System.out.println("1.USD  2.CAD  3.EUR  4.HKD  5.INR");
        tocode = currencyCodes.get(sc.nextInt());

        // Get amount
        System.out.println("Enter Amount:");
        amount = sc.nextDouble();

        // Fetch and use API
        double convertedAmount = sendHttpGETRequest(fromcode, tocode, amount);
        System.out.println("Converted Amount: " + convertedAmount);

        System.out.println("Thank You!");
        sc.close();
    }

    public static double sendHttpGETRequest(String fromcode, String tocode, double amount) {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + fromcode);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response to extract exchange rate
            String jsonResponse = response.toString();
            double exchangeRate = parseExchangeRate(jsonResponse, tocode);

            // Perform currency conversion
            return amount * exchangeRate;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Return a negative value to indicate conversion failure
        }
    }

    public static double parseExchangeRate(String jsonResponse, String tocode) {
        HashMap<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0); // Assuming USD is the base currency
        exchangeRates.put("CAD", 1.25); // Example exchange rate
        exchangeRates.put("EUR", 0.85); // Example exchange rate
        exchangeRates.put("HKD", 7.78); // Example exchange rate
        exchangeRates.put("INR", 73.85); // Example exchange rate

        return exchangeRates.get(tocode);
    }
}
