// public class Misaligned {
//     static int printColorMap() {
//         String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
//         String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
//         int i = 0, j = 0;
//         for(i = 0; i < 5; i++) {
//             for(j = 0; j < 5; j++) {
//                 System.out.printf("%d | %s | %s\n", i * 5 + j, majorColors[i], minorColors[i]);
//             }
//         }
//         return i * j;
//     }
//     public static void main(String[] args) { 
//         int result = printColorMap();
//         assert(result == 25);
//         System.out.println("All is well (maybe!)");
//     }
// }
public class Misaligned {

    // Method to initialize colors
    static String[][] initializeColorMap() {
        String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
        String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
        return new String[][] {majorColors, minorColors};
    }

    // Method to print the color map
    static int printColorMap(String[] majorColors, String[] minorColors) {
        int count = 0;
        for(int i = 0; i < majorColors.length; i++) {
            for(int j = 0; j < minorColors.length; j++) {
                System.out.printf("%d | %s | %s\n", count++, majorColors[i], minorColors[j]);
            }
        }
        return count; // Return total count of combinations
    }

    public static void main(String[] args) { 
        String[][] colorMap = initializeColorMap(); // Get color map
        String[] majorColors = colorMap[0];
        String[] minorColors = colorMap[1];

        int result = printColorMap(majorColors, minorColors); // Print color map
        assert(result == 25); // Check that the number of combinations is correct
        System.out.println("All is well (maybe!)");
    }
}
