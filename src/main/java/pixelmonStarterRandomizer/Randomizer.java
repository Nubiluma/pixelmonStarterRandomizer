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

    //these Pixelmon will be selected with a higher possibility
    private final List<String> priorityList = Arrays.asList("Dreepy", "Charmander", "Eevee",
            "Trapinch", "Beldum", "Timburr", "Venipede", "Machop", "Froakie", "Honedge", "Goomy", "Scorbunny", "Dewpider",
            "Dratini", "Meditite", "Gligar", "Jangmo-o", "Golett", "Hatenna", "Rookidee", "Togepi", "Rowlet", "Horsea", "Treecko", "Mudkip",
            "Ralts", "Tympole", "Drilbur", "Zorua", "Axew", "Deino", "Litwick", "Clauncher", "Tyrunt", "Phantump", "Sandygast", "Mareanie");


    /**
     * Method will convert content of 'starters.txt' to a list(possibleStarters) of strings
     */
    private void readStartersFile() {

        try {
            possibleStarters = Files.readAllLines(Paths.get("starters.txt"));

        } catch (IOException e) {
            System.err.println("File not found");
            e.printStackTrace();
        }
        //for testing/debugging
        if (possibleStarters != null) {
            System.out.println("Amount of entities in starters.txt: " + possibleStarters.size());
        }
    }

    /**
     * Will return a list of 24 different Pixelmon entities as strings. (The mod allows up to 24 starters to be defined in the hocon file)
     */
    public List<String> randomizeStarters() {

        readStartersFile();

        //combines strings of starters.txt with strings of priorityList to increase the chances of getting an entity defined in priorityList above
        List<String> combineStarters = Stream.concat(possibleStarters.stream(), priorityList.stream()).collect(Collectors.toList());

        for (int i = 0; i < 24; i++) {

            String randomStarter = combineStarters.get(random.nextInt(combineStarters.size()));

            if (!starters.contains(randomStarter)) {
                starters.add(i, randomStarter);
            } else {
                i--;
            }
        }

        return starters;
    }

    /**
     * Method for testing of the randomizer:
     * Prints all(24) entity names of generated starters in the new hocon file, separated by lines and commas.
     */
    public void printStarterList() {
        System.out.println("The following starters have been selected: ");
        for (int i = 0; i < starters.size(); i++) {
            if (i < (starters.size() - 1)) {
                System.out.println(starters.get(i) + ",");
            } else {
                System.out.println(starters.get(i));
            }

        }
    }
}
