package pixelmonStarterRandomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Randomizer {

    private final Random random = new Random();
    private List<String> possibleStarters;
    private List<String> priorityList = Arrays.asList("Dreepy", "Sandile", "Riolu", "Gastly", "Charmander", "Eevee",
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

    public void randomizeStarters(){

        readStartersFile();

        List<String> combineStarters = Stream.concat(possibleStarters.stream(), priorityList.stream()).collect(Collectors.toList());
        List<String> starters = new ArrayList<>();

        for (int i = 0; i < 24; i++){

            String randomStarter = combineStarters.get(random.nextInt(combineStarters.size()));

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
