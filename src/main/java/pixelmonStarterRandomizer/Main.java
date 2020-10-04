package pixelmonStarterRandomizer;

public class Main {

private static Randomizer r = new Randomizer();
private static ConfigLoader cf = new ConfigLoader();

    public static void main(String[] args) {
        r.randomizeStarters();
        cf.load();
    }


}
