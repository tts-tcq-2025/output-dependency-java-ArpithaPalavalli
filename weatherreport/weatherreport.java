package weatherreport;

public class WeatherReport {

    // Core logic (bug still exists)
    public static String Report(IWeatherSensor sensor) {
        int precipitation = sensor.Precipitation();
        String report = "Sunny Day"; // default

        if (sensor.TemperatureInC() > 25) {
            if (precipitation >= 20 && precipitation < 60) {
                report = "Partly Cloudy";
            } else if (sensor.WindSpeedKMPH() > 50) {
                report = "Alert, Stormy with heavy rain";
            }
        }
        return report;
    }

    // --------- Tests (strengthened to fail) ---------
    private static void TestRainy() {
        // High precipitation but low wind -> should be Rainy
        IWeatherSensor sensor = new SensorStub(26, 70, 72, 30);
        String report = Report(sensor);
        System.out.println("Rainy test got: " + report);
        assert report.equals("Rainy") : "Expected Rainy, got " + report;
    }

    private static void TestHighPrecipitation() {
        // Again high precipitation, low wind
        IWeatherSensor sensor = new SensorStub(26, 80, 60, 40);
        String report = Report(sensor);
        System.out.println("High precipitation test got: " + report);
        assert report.equals("Rainy") : "Expected Rainy, got " + report;
    }

    public static void main(String[] args) {
        TestRainy();
        TestHighPrecipitation();
        System.out.println("Tests executed (failures expected due to bug).");
    }
}

// ---------- Interface ----------
interface IWeatherSensor {
    double TemperatureInC();
    int Precipitation();
    int Humidity();
    int WindSpeedKMPH();
}

// ---------- Configurable Stub ----------
class SensorStub implements IWeatherSensor {
    private final double temp;
    private final int precip;
    private final int humidity;
    private final int wind;

    SensorStub(double temp, int precip, int humidity, int wind) {
        this.temp = temp;
        this.precip = precip;
        this.humidity = humidity;
        this.wind = wind;
    }

    @Override
    public double TemperatureInC() { return temp; }

    @Override
    public int Precipitation() { return precip; }

    @Override
    public int Humidity() { return humidity; }

    @Override
    public int WindSpeedKMPH() { return wind; }
}





























// package weatherreport;

// public class WeatherReport {
//     public static String Report(IWeatherSensor sensor) {
//         int precipitation = sensor.Precipitation();
//         // precipitation < 20 is a sunny day
//         String report = "Sunny Day";

//         if (sensor.TemperatureInC() > 25)
//         {
//             if (precipitation >= 20 && precipitation < 60)
//                 report = "Partly Cloudy";
//             else if (sensor.WindSpeedKMPH() > 50)
//                 report = "Alert, Stormy with heavy rain";
//         }
//         return report;
//     }

//     private static void TestRainy() {
//         IWeatherSensor sensor = new SensorStub();
//         String report = Report(sensor);
//         System.out.println(report);
//         assert(report.contains("rain"));
//     }

//     private static void TestHighPrecipitation() {
//         // This instance of stub needs to be different-
//         // to give high precipitation (>60) and low wind-speed (<50)
//         IWeatherSensor sensor = new SensorStub();

//         // strengthen the assert to expose the bug
//         // (function returns Sunny day, it should predict rain)
//         String report = Report(sensor);
//         System.out.println(report);
//         assert(report != null);
//     }
//     public static void main(String[] args) {
//         TestRainy();
//         TestHighPrecipitation();
//         System.out.println("All is well (maybe!)");
//     }
// }

// public interface IWeatherSensor {
//     double TemperatureInC();
//     int Precipitation();
//     int Humidity();
//     int WindSpeedKMPH();
// }

// class SensorStub implements IWeatherSensor {
//     @Override
//     public int Humidity() {
//         return 72; // Stubbed humidity
//     }

//     @Override
//     public int Precipitation() {
//         return 70; // Stubbed precipitation
//     }

//     @Override
//     public double TemperatureInC() {
//         return 26; // Stubbed temperature
//     }

//     @Override
//     public int WindSpeedKMPH() {
//         return 52; // Stubbed wind speed
//     }
// }

