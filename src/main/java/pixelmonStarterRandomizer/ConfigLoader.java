package pixelmonStarterRandomizer;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ConfigLoader {

    private static final String CONFIG_FILE = "pixelmon.hocon";
    private static final String STARTERS_CONFIG_PATH = "Starters.starterList";
    private static final String GENERATED_CONFIG_FILE = "new_pixelmon.hocon";
    private Config config;

    /**
     * Method loads original hocon file ('pixelmon.hocon') for the program to use. Will not be overwritten, because it only serves as a template.
     */
    public void load() {
        File file = new File(CONFIG_FILE);
        this.config = ConfigFactory.parseFile(file);
    }

    /**
     * Last method called by the program. Saves the generated copy of the original hocon file to project's directory as 'new_pixelmon.hocon' to prevent overwriting of the original file.
     */
    public void save() {
        String configContents = config.root().render();
        Path generatedConfigPath = Paths.get(GENERATED_CONFIG_FILE);

        try {
            Files.write(generatedConfigPath, configContents.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("An error occurred during file write operation");
            e.printStackTrace();
        }
    }

    /**
     * Alternates the 'starterList' section of the hocon file.
     *
     * @param customStarterList is the newly generated list of starter entities. In the main method, this parameter is a method call for the Randomizer class.
     */
    public void setStarters(List<String> customStarterList) {
        this.config = this.config.withValue(STARTERS_CONFIG_PATH, ConfigValueFactory.fromIterable(customStarterList));
    }
}
