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
import java.util.ArrayList;
import java.util.List;

public class ColorMapGenerator {

    static class ColorEntry {
        int number;
        String majorColor;
        String minorColor;

        ColorEntry(int number, String majorColor, String minorColor) {
            this.number = number;
            this.majorColor = majorColor;
            this.minorColor = minorColor;
        }
    }

    public static List<ColorEntry> generateColorMap() {
        String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
        String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};
        List<ColorEntry> colorMap = new ArrayList<>();

        for (int i = 0; i < majorColors.length; i++) {
            for (int j = 0; j < minorColors.length; j++) {
                int number = i * 5 + j + 1;
                colorMap.add(new ColorEntry(number, majorColors[i], minorColors[j]));
            }
        }
        return colorMap;
    }

    public static String formatColorMap(List<ColorEntry> colorMap) {
        // BUG: formatting is inconsistent and columns are NOT aligned properly
        StringBuilder builder = new StringBuilder();
        for (ColorEntry entry : colorMap) {
            // No padding, so misalignment exists
            builder.append(entry.number)
                    .append(" | ")
                    .append(entry.majorColor)
                    .append(" | ")
                    .append(entry.minorColor)
                    .append("\n");
        }
        return builder.toString().trim();
    }

    public static int printColorMap() {
        List<ColorEntry> colorMap = generateColorMap();
        String output = formatColorMap(colorMap);
        System.out.println(output);
        return colorMap.size();
    }

    public static void testColorMapLength() {
        // Weak test - only counts lines, will pass falsely
        assert printColorMap() == 25 : "Color map length should be 25";
    }

    public static void testColorMapFormatting() {
        List<ColorEntry> colorMap = generateColorMap();
        StringBuilder expected = new StringBuilder();
        for (ColorEntry entry : colorMap) {
            expected.append(String.format("%2d | %-7s | %s\n",
                    entry.number, entry.majorColor, entry.minorColor));
        }
        String expectedOutput = expected.toString().trim();
        String actualOutput = formatColorMap(colorMap);

        assert actualOutput.equals(expectedOutput) : "Output formatting is misaligned or incorrect!";
    }

    public static void main(String[] args) {
        testColorMapLength();
        testColorMapFormatting();
    }
}
