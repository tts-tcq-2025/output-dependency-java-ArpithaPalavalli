import java.util.ArrayList;
import java.util.List;

public class Misaligned {

    static String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
    static String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};

    static class ColorPair {
        String major;
        String minor;
        int pairNumber;

        ColorPair(int pairNumber, String major, String minor) {
            this.pairNumber = pairNumber;
            this.major = major;
            this.minor = minor;
        }
    }

    static List<ColorPair> generateColorPairs() {
        List<ColorPair> pairs = new ArrayList<>();
        for (int i = 0; i < majorColors.length; i++) {
            for (int j = 0; j < minorColors.length; j++) {
                int pairNumber = i * minorColors.length + j;
                pairs.add(new ColorPair(pairNumber, majorColors[i], minorColors[i]));
            }
        }
        return pairs;
    }

    static void printColorMap(List<ColorPair> pairs) {
        for (ColorPair pair : pairs) {
            System.out.printf("%d | %s | %s\n", pair.pairNumber, pair.major, pair.minor);
        }
    }

    public static void main(String[] args) {
        List<ColorPair> pairs = generateColorPairs();
        printColorMap(pairs);
        assert(pairs.size() == 25);
        System.out.println("All is well (maybe!)");
    }
}
