package pixelmonStarterRandomizer;

public class Main {

    private static final Randomizer r = new Randomizer();
    private static final ConfigLoader cf = new ConfigLoader();

    public static void main(String[] args) {

        cf.load();
        cf.setStarters(r.randomizeStarters());
        r.printStarterList();
        cf.save();

    }

}
