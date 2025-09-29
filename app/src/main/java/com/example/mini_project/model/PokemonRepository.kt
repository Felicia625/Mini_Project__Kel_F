package com.example.mini_project.model

object PokemonRepository {

    private val pokemonList = listOf(
        PokemonModel(
            "#0025",
            "Pikachu",
            listOf(PokemonType.Electric),
            "Mouse Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
            "Pikachu, the Mouse Pokémon. It can generate electric attacks from the sacs on its cheeks, which it releases in the form of powerful thunderbolts. " +
                    "Pikachu often lives in forests close to people, and when threatened, its tail stands up as a signal. " +
                    "Despite its small size, its electricity can cause blackouts in entire villages if gathered in large groups. " +
                    "Pikachu bonds deeply with its trainer, and its loyalty makes it one of the most iconic Pokémon in the world."
        ),
        PokemonModel(
            "#0054",
            "Psyduck",
            listOf(PokemonType.Water),
            "Duck Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/054.png",
            "Psyduck, the Duck Pokémon. It is constantly plagued by headaches that give it mysterious psychic powers. " +
                    "When the pain becomes intense, Psyduck’s latent psychic abilities burst out uncontrollably, often surprising even itself. " +
                    "Despite looking clueless, it can unleash telekinetic waves strong enough to level boulders. " +
                    "Its confused nature makes it a comic yet powerful companion for any trainer."
        ),
        PokemonModel(
            "#0079",
            "Slowpoke",
            listOf(PokemonType.Water, PokemonType.Psychic),
            "Dopey Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/079.png",
            "Slowpoke, the Dopey Pokémon. It spends its days idly at riverbanks, staring at the water for hours. " +
                    "Though it looks vacant, its relaxed nature hides powerful psychic abilities that manifest unpredictably. " +
                    "If its tail is bitten by a Shellder, it evolves into Slowbro, unlocking greater strength. " +
                    "Legends say that Slowpoke’s yawns can summon rain, making it a Pokémon tied to natural phenomena."
        ),
        PokemonModel(
            "#0132",
            "Ditto",
            listOf(PokemonType.Normal),
            "Transform Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/132.png",
            "Ditto, the Transform Pokémon. It can reconstruct its entire molecular structure, allowing it to perfectly copy the appearance of any opponent. " +
                    "However, if Ditto tries to transform while distracted, small mistakes—like facial expressions—often give it away. " +
                    "Scientists study Ditto to understand cloning and genetic mutation. " +
                    "Despite its simple form, its adaptability makes it a versatile and mysterious Pokémon."
        ),
        PokemonModel(
            "#0143",
            "Snorlax",
            listOf(PokemonType.Normal),
            "Sleeping Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/143.png",
            "Snorlax, the Sleeping Pokémon. Known for its enormous appetite, it consumes over 880 pounds of food daily before dozing off. " +
                    "Its body acts like an impenetrable wall while it sleeps, often blocking paths and roads. " +
                    "Despite its laziness, Snorlax is incredibly powerful when roused, capable of using devastating physical attacks. " +
                    "Its calm demeanor hides its true strength, making it both a gentle giant and a fearsome opponent."
        ),
        PokemonModel(
            "#0150",
            "Mewtwo",
            listOf(PokemonType.Psychic),
            "Genetic Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/150.png",
            "Mewtwo, the Genetic Pokémon. Created by scientists through genetic manipulation of the legendary Mew, it was designed as the ultimate warrior. " +
                    "Mewtwo possesses unmatched psychic abilities, allowing it to bend spoons, control minds, and unleash cataclysmic energy. " +
                    "However, it struggles with its own identity, questioning its existence as an artificial Pokémon. " +
                    "Its intelligence rivals humans, and some legends say it isolates itself due to its distrust of mankind."
        ),
        PokemonModel(
            "#0194",
            "Wooper",
            listOf(PokemonType.Water, PokemonType.Ground),
            "Water Fish Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/194.png",
            "Wooper, the Water Fish Pokémon. It lives in cold, damp environments, often emerging from the water with a clueless smile. " +
                    "Its skin is coated with a slimy, toxic film that protects it from predators, making physical contact unpleasant. " +
                    "Despite its goofy appearance, Wooper is resilient and cheerful, relying on instinct rather than intelligence. " +
                    "Its carefree nature has made it a beloved symbol of innocence in many regions."
        ),
        PokemonModel(
            "#0385",
            "Jirachi",
            listOf(PokemonType.Psychic, PokemonType.Steel),
            "Wish Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/385.png",
            "Jirachi, the Wish Pokémon. It awakens once every thousand years and is said to grant any wish written on the notes attached to its head. " +
                    "During its brief awakening, Jirachi radiates mystical energy strong enough to heal barren lands and purify polluted water. " +
                    "Legends describe it as a celestial guardian that listens to the hopes of humanity. " +
                    "When asleep, it encases itself in a crystalline shell for protection, waiting until the next era of dreams awakens it."
        ),
        PokemonModel(
            "#0393",
            "Piplup",
            listOf(PokemonType.Water),
            "Penguin Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/393.png",
            "Piplup, the Penguin Pokémon. Proud and stubborn, it dislikes accepting help from others. " +
                    "Despite its small size, it has remarkable swimming ability, diving over 30 feet with ease. " +
                    "Its pride sometimes gets it into trouble, but it also gives it a determined spirit. " +
                    "Trainers value Piplup for its resilience and its ability to evolve into powerful water-type companions."
        ),
        PokemonModel(
            "#0492",
            "Shaymin",
            listOf(PokemonType.Grass),
            "Gratitude Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/492.png",
            "Shaymin, the Gratitude Pokémon. It has the miraculous ability to purify polluted air and turn barren fields into lush gardens. " +
                    "Legends tell of Shaymin appearing to those who feel true gratitude in their hearts. " +
                    "Its small, hedgehog-like form is unassuming, yet when exposed to the energy of flowers, it transforms into its graceful Sky Forme. " +
                    "Shaymin is regarded as a guardian of nature, embodying the bond between Pokémon, people, and the environment."
        ),
        PokemonModel(
            "#0501",
            "Oshawott",
            listOf(PokemonType.Water),
            "Sea Otter Pokémon",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/501.png",
            "Oshawott, the Sea Otter Pokémon. It carries a scalchop on its belly, which it uses as both a weapon and a tool. " +
                    "In battle, Oshawott skillfully wields its scalchop to block attacks and retaliate with precision. " +
                    "Though playful by nature, it is also courageous, standing up to stronger foes with determination. " +
                    "As it grows, its loyalty and bravery make it a reliable partner for any trainer on their journey."
        )
    )

    fun getPokemonList(): List<PokemonModel> = pokemonList

    fun getPokemonById(pokedexId: String): PokemonModel? {
        return pokemonList.find { it.pokedexId == pokedexId }
    }
}
