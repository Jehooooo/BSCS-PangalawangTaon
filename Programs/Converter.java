import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nConverter Menu");
            System.out.println("[D] Decimal");
            System.out.println("[B] Binary");
            System.out.println("[O] Octal");
            System.out.println("[H] Hexa");
            System.out.println("[E] Exit");
            System.out.print("Enter choice: ");
            char choice = sc.next().toUpperCase().charAt(0);

            if (choice == 'E') {
                running = false;
                System.out.println("Exiting program...");
                break;
            }

            // Ask for first 4 numbers of the series
            System.out.println("\nEnter the first 4 numbers of the series: ");
            int[] firstFour = new int[4];
            for (int i = 0; i < 4; i++) {
                firstFour[i] = sc.nextInt();
            }

            // Generate series using difference from the first four
            int[] series = generateSeries(firstFour, 200);

            // Measure runtime
            long startTime = System.currentTimeMillis();

            System.out.println("\n" + getSystemName(choice));
            System.out.print("First 10: ");
            for (int i = 0; i < 10; i++) {
                System.out.print(convert(series[i], choice) + " ");
            }

            System.out.print("\n50th to 70th: ");
            for (int i = 49; i < 70; i++) {
                System.out.print(convert(series[i], choice) + " ");
            }

            System.out.print("\n8th to 15th: ");
            for (int i = 7; i < 15; i++) {
                System.out.print(convert(series[i], choice) + " ");
            }

            System.out.print("\n95th to 85th: ");
            for (int i = 94; i >= 84; i--) {
                System.out.print(convert(series[i], choice) + " ");
            }

            long endTime = System.currentTimeMillis();
            System.out.println("\n\nRuntime: " + (endTime - startTime) + " ms");
        }

        sc.close();
    }
    // Generate series based on first 4 numbers (assumes arithmetic progression)
    private static int[] generateSeries(int[] firstFour, int size) {
        int[] arr = new int[size];
        int diff = firstFour[1] - firstFour[0]; // common difference
        arr[0] = firstFour[0];
        for (int i = 1; i < size; i++) {
            arr[i] = arr[i - 1] + diff;
        }
        return arr;
    }

    private static String getSystemName(char c) {
        switch (c) {
            case 'B': return "BINARY";
            case 'O': return "OCTAL";
            case 'H': return "HEXADECIMAL";
            case 'D':
            default:  return "DECIMAL";
        }
    }

    // Manual binary conversion
    private static String decimalToBinary(int num) {
        if (num == 0) return "0";
        String binary = "";
        while (num > 0) {
            binary = (num % 2) + binary;
            num /= 2;
        }
        return binary;
    }

    // Manual octal conversion
    private static String decimalToOctal(int num) {
        if (num == 0) return "0";
        String octal = "";
        while (num > 0) {
            octal = (num % 8) + octal;
            num /= 8;
        }
        return octal;
    }

    // Manual hexadecimal conversion
    private static String decimalToHex(int num) {
        if (num == 0) return "0";
        String hex = "";
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (num > 0) {
            hex = hexChars[num % 16] + hex;
            num /= 16;
        }
        return hex;
    }

    // Conversion dispatcher
    private static String convert(int num, char choice) {
        switch (choice) {
            case 'B': return decimalToBinary(num);
            case 'O': return decimalToOctal(num);
            case 'H': return decimalToHex(num);
            case 'D':
            default:  return String.valueOf(num);
        }
    }
}
