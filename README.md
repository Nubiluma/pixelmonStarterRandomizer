# pixelmonStarterRandomizer

This project was created for Minecraft 1.12 Pixelmon mod.
The mod's hocon file offers customization of the available starter Pokémon. A starter has to be picked when joining a new Minecraft world (or by '/pokerestart' command ingame). Instead of having to choose between the default starters from the original Pokémon games (currently 24), you can pick one of the Pokémon written in the "starter" section of the hocon file.

This project is meant to bring a little diversity and fun to the game by completely randomzing the available starter Pokémon. However, I made it to allow only those Pokémon which are at the first stage of their evolution line AND which are still able to evolve (legendaries excluded). Every possible starter defined is listed in the 'starters.txt' file.

For safety reasons, the original hocon file will not be replaced or overwritten in the config's and/or project's directories. Instead, the customized hocon file will be created in the project's directory as 'new_pixelmon.hocon' and has to be renamed to 'pixelmon.hocon' when placed in the according instance's config directory.
