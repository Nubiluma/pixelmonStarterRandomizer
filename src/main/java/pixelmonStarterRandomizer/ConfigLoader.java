package pixelmonStarterRandomizer;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigList;

public class ConfigLoader {

    public void load(){
        Config config = ConfigFactory.load("pixelmon");
        System.out.println(config);
        ConfigList configList = config.getList("Starters.starterList");
        System.out.println(configList);
    }
}
