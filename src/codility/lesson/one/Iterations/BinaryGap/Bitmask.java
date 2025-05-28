package codility.lesson.one.Iterations;

public class Bitmask {
    public static void main(String[] args) {
        int n = 5; // Number of bits
        System.out.println("n: " + n);
        System.out.println("n as a binary string: " + Integer.toBinaryString(n));
        System.out.println("1 << 0: " + (1 << 0));
        System.out.println("1 << 1: " + (1 << 1));
        System.out.println("1 << 2: " + (1 << 2));
        System.out.println("1 << 3: " + (1 << 3));
        System.out.println("1 << 4: " + (1 << 4));
        System.out.println("1 << 5: " + (1 << 5));

        // Example of using the mask
        int number = 0b11010; // Example number
        int mask = (1 << n) - 1; // All bits set to 1
        System.out.println("Number: " + number);
        System.out.println("Number as a binary string: " + Integer.toBinaryString(number));
        System.out.println("Mask: " + mask);
        System.out.println("Mask: " + Integer.toBinaryString(mask));
        int result = number & mask; // Apply the mask
        System.out.println("Result after applying mask: " + Integer.toBinaryString(result));
    }
}
