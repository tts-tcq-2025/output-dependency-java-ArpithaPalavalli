import java.util.ArrayList;
import java.util.List;

public class ColorMapBug {

    static String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
    static String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};

    static class ColorEntry {
        int number;
        String major;
        String minor;

        ColorEntry(int number, String major, String minor) {
            this.number = number;
            this.major = major;
            this.minor = minor;
        }
    }

    // Equivalent to generate_color_map()
    static List<ColorEntry> generateColorMap() {
        List<ColorEntry> colorMap = new ArrayList<>();
        for (int i = 0; i < majorColors.length; i++) {
            for (int j = 0; j < minorColors.length; j++) {
                int number = i * 5 + j + 1;
                colorMap.add(new ColorEntry(number, majorColors[i], minorColors[j]));
            }
        }
        return colorMap;
    }

    // Equivalent to format_color_map()
    static String formatColorMap(List<ColorEntry> colorMap) {
        StringBuilder sb = new StringBuilder();
        for (ColorEntry entry : colorMap) {
            // BUG: formatting is inconsistent and columns are NOT aligned properly
            sb.append(entry.number + " | " + entry.major + " | " + entry.minor + "\n");
        }
        return sb.toString().trim();
    }

    // Equivalent to print_color_map()
    static int printColorMap() {
        List<ColorEntry> colorMap = generateColorMap();
        String output = formatColorMap(colorMap);
        System.out.println(output);
        return colorMap.size();
    }

    // Equivalent to test_color_map_length()
    static void testColorMapLength() {
        assert printColorMap() == 25 : "Color map length should be 25";
    }

    // Equivalent to test_color_map_formatting()
    static void testColorMapFormatting() {
        List<ColorEntry> colorMap = generateColorMap();
        StringBuilder expected = new StringBuilder();

        for (ColorEntry entry : colorMap) {
            expected.append(String.format("%2d | %-7s | %s%n", entry.number, entry.major, entry.minor));
        }

        String expectedOutput = expected.toString().trim();
        String actualOutput = formatColorMap(colorMap);

        assert actualOutput.equals(expectedOutput) : "Output formatting is misaligned or incorrect!";
    }

    public static void main(String[] args) {
        testColorMapLength();
        testColorMapFormatting(); // This will fail due to formatting bug
    }
}
