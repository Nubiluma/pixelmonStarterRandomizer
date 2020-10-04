package pixelmonStarterRandomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {

    private final Random random = new Random();
    private List<String> possibleStarters;
    
    private void readStartersFile(){

        try {
            possibleStarters = Files.readAllLines(Paths.get("starters.txt"));

        } catch (IOException e) {
            System.err.println("File not found");
            e.printStackTrace();
        }
        if (possibleStarters != null) {
            System.out.println("Amount of possible starters: " + possibleStarters.size());
        }
    }

    public void randomizeStarters(){

        readStartersFile();

        List<String> starters = new ArrayList<>();

        for (int i = 0; i < 24; i++){

            String randomStarter = possibleStarters.get(random.nextInt(possibleStarters.size()));

            if (!starters.contains(randomStarter)){
                starters.add(i, randomStarter);
            }else {
                i--;
            }
        }
        System.out.println("Starters:");
//        for (String name : starters) {
//        }

        for (int i = 0; i < starters.size(); i++) {
            if (i < (starters.size() - 1)){
                System.out.println(starters.get(i) + ",");
            } else {
                System.out.println(starters.get(i));
            }

        }
    }
}
