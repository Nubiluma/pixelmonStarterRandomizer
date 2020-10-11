package pixelmonStarterRandomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Randomizer {

    private final Random random = new Random();
    List<String> starters = new ArrayList<>();
    private List<String> possibleStarters;
    private final List<String> priorityList = Arrays.asList("Dreepy", "Sandile", "Riolu", "Gastly", "Charmander", "Eevee",
            "Trapinch", "Beldum", "Timburr", "Venipede", "Litwick", "Froakie", "Honedge", "Goomy", "Scorbunny");
    
    private void readStartersFile(){

        try {
            possibleStarters = Files.readAllLines(Paths.get("starters.txt"));

        } catch (IOException e) {
            System.err.println("File not found");
            e.printStackTrace();
        }
        if (possibleStarters != null) {
            System.out.println("Amount of Pokémon in starters.txt: " + possibleStarters.size());
        }
    }

    public List<String> randomizeStarters(){

        readStartersFile();

        List<String> combineStarters = Stream.concat(possibleStarters.stream(), priorityList.stream()).collect(Collectors.toList());
        starters.clear();

        for (int i = 0; i < 24; i++){

            String randomStarter = combineStarters.get(random.nextInt(combineStarters.size()));

            if (!starters.contains(randomStarter)){
                starters.add(i, randomStarter);
            }else {
                i--;
            }
        }

        return starters;
    }

    /**
     * Method for testing of the randomizer:
     * Prints exactly 24 different Pokémon names separated by lines and commas
     */
    public void printStarterList(){ //test method
        for (int i = 0; i < starters.size(); i++) {
            if (i < (starters.size() - 1)){
                System.out.println(starters.get(i) + ",");
            } else {
                System.out.println(starters.get(i));
            }

        }
    }
}
