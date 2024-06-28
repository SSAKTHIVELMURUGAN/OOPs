import java.util.Random;

public class Address {
    public static String generateRandomAddress() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        int n = 38; // length of the random address
        StringBuilder s = new StringBuilder(n);
        Random random = new Random();

        for (int y = 0; y < n; y++) {
            // generating a random number
            int index = random.nextInt(AlphaNumericString.length());
            // add Character one by one in end of s
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();
    }
}
