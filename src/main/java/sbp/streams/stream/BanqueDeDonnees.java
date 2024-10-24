package sbp.streams.stream;

import sbp.streams.stream.enums.AnimalTypeEnum;
import sbp.streams.stream.enums.SexeEnum;
import sbp.streams.stream.model.Animal;
import sbp.streams.stream.model.Personne;

import java.util.Arrays;
import java.util.List;

public class BanqueDeDonnees {

    static List<Animal> animals = Arrays.asList(
            new Animal("Milo", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Bella", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Leo", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Luna", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Charlie", AnimalTypeEnum.CHAT, SexeEnum.INCONNU),
            new Animal("Chloe", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Max", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Sophie", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Oscar", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Daisy", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),

            new Animal("Rex", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Bailey", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Buddy", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Coco", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Rocky", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Molly", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Duke", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Syn", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Buster", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Sadie", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Silly", AnimalTypeEnum.CHIEN, SexeEnum.INCONNU),
            new Animal("Mindy", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),



            new Animal("Shelly", AnimalTypeEnum.TORTUE, SexeEnum.FEMELLE),
            new Animal("Tank", AnimalTypeEnum.TORTUE, SexeEnum.MALE),
            new Animal("Turbo", AnimalTypeEnum.TORTUE, SexeEnum.MALE),
            new Animal("Speedy", AnimalTypeEnum.TORTUE, SexeEnum.FEMELLE),
            new Animal("Yoda", AnimalTypeEnum.TORTUE, SexeEnum.MALE),
            new Animal("Ninja", AnimalTypeEnum.TORTUE, SexeEnum.INCONNU),
            new Animal("Shere Khan", AnimalTypeEnum.TIGRE, SexeEnum.MALE),
            new Animal("Tigra", AnimalTypeEnum.TIGRE, SexeEnum.FEMELLE),
            // Additional 20 animals
            new Animal("Tiger", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Snowball", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Whiskers", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Shadow", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Rusty", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Simba", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Patches", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Toby", AnimalTypeEnum.CHAT, SexeEnum.MALE),
            new Animal("Mittens", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),
            new Animal("Tinkerbell", AnimalTypeEnum.CHAT, SexeEnum.FEMELLE),

            new Animal("Zeus", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Duke", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Bruno", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Sasha", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Ginger", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Sam", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Pepper", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE),
            new Animal("Bandit", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Scout", AnimalTypeEnum.CHIEN, SexeEnum.MALE),
            new Animal("Dakota", AnimalTypeEnum.CHIEN, SexeEnum.FEMELLE)
    );


    public static List<Personne> people = Arrays.asList(
            new Personne("Alice", 30, "Paris", SexeEnum.FEMELLE, 55000, Arrays.asList(animals.get(0))),
            new Personne("Bob", 20, "London", SexeEnum.MALE, 32000, Arrays.asList()),
            new Personne("Charlie", 10, "New York", SexeEnum.MALE, 0, Arrays.asList(animals.get(1), animals.get(2))),
            new Personne("David", 25, "San Francisco", SexeEnum.MALE, 47000, Arrays.asList()),
            new Personne("Eve", 40, "Berlin", SexeEnum.FEMELLE, 68000, Arrays.asList()),
            new Personne("Frank", 28, "Sydney", SexeEnum.MALE, 50000, Arrays.asList()),
            new Personne("Grace", 33, "Toronto", SexeEnum.FEMELLE, 65000, Arrays.asList()),
            new Personne("Hannah", 29, "Tokyo", SexeEnum.FEMELLE, 52000, Arrays.asList()),
            new Personne("Ivy", 22, "Rome", SexeEnum.FEMELLE, 41000, Arrays.asList()),
            new Personne("Jack", 27, "Moscow", SexeEnum.MALE, 48000, Arrays.asList(animals.get(1), animals.get(2))),
            new Personne("Karen", 31, "Amsterdam", SexeEnum.FEMELLE, 59000, Arrays.asList()),
            new Personne("Liam", 19, "Paris", SexeEnum.MALE, 30000, Arrays.asList(animals.get(3), animals.get(4))),
            new Personne("Mona", 36, "Berlin", SexeEnum.FEMELLE, 74000, Arrays.asList()),
            new Personne("Nathan", 42, "San Francisco", SexeEnum.MALE, 80000, Arrays.asList(animals.get(5), animals.get(6),animals.get(7), animals.get(8))),
            new Personne("Olivia", 21, "New York", SexeEnum.FEMELLE, 38000, Arrays.asList(animals.get(9), animals.get(10),animals.get(11))),
            new Personne("Paul", 37, "London", SexeEnum.INCONNU, 71000, Arrays.asList(animals.get(12), animals.get(13))),
            new Personne("Quincy", 32, "Toronto", SexeEnum.MALE, 63000, Arrays.asList( animals.get(14))),
            new Personne("Rita", 34, "Tokyo", SexeEnum.FEMELLE, 68000, Arrays.asList( animals.get(15))),
            new Personne("Sam", 29, "Sydney", SexeEnum.MALE, 50000, Arrays.asList( animals.get(16))),
            new Personne("Tina", 27, "Rome", SexeEnum.INCONNU, 49000, Arrays.asList(animals.get(17), animals.get(18))),
            new Personne("Uma", 41, "Moscow", SexeEnum.INCONNU, 76000, Arrays.asList(animals.get(19), animals.get(20))),
            new Personne("Victor", 38, "Amsterdam", SexeEnum.INCONNU, 78000, Arrays.asList()),
            new Personne("Wendy", 24, "Paris", SexeEnum.FEMELLE, 43000, Arrays.asList(animals.get(21), animals.get(22))),
            new Personne("Xander", 26, "London", SexeEnum.MALE, 46000, Arrays.asList(animals.get(23))),
            new Personne("Yara", 23, "Berlin", SexeEnum.FEMELLE, 44000, Arrays.asList(animals.get(24))),
            new Personne("Zoe", 39, "New York", SexeEnum.FEMELLE, 71000, Arrays.asList()),
            new Personne("Aaron", 30, "San Francisco", SexeEnum.MALE, 60000, Arrays.asList(animals.get(21), animals.get(22))),
            new Personne("Bella", 16, "Tokyo", SexeEnum.FEMELLE, 34000, Arrays.asList()),
            new Personne("Carl", 35, "Toronto", SexeEnum.MALE, 72000, Arrays.asList(animals.get(25))),
            new Personne("Diana", 28, "Sydney", SexeEnum.FEMELLE, 53000, Arrays.asList(animals.get(26))),
            new Personne("Elena", 17, "Lisbon", SexeEnum.INCONNU, 2, Arrays.asList()),
            new Personne("Fabian", 15, "Madrid", SexeEnum.INCONNU, 5, Arrays.asList()),
            new Personne("George", 50, "Cairo", SexeEnum.MALE, 79000, Arrays.asList(animals.get(27), animals.get(28))),
            new Personne("Harper", 16, "Vancouver", SexeEnum.INCONNU, 0, Arrays.asList()),
            new Personne("Isabella", 14, "Brussels", SexeEnum.INCONNU, 0, Arrays.asList()),
            new Personne("James", 18, "Dublin", SexeEnum.MALE, 29000, Arrays.asList()),
            new Personne("Katrina", 43, "Oslo", SexeEnum.FEMELLE, 68000, Arrays.asList(animals.get(29), animals.get(30))),
            new Personne("Leo", 39, "Stockholm", SexeEnum.MALE, 62000, Arrays.asList()),
            new Personne("Maya", 32, "Athens", SexeEnum.FEMELLE, 55000, Arrays.asList()),
            new Personne("Noah", 15, "Helsinki", SexeEnum.INCONNU, 0, Arrays.asList(animals.get(29), animals.get(30))),
            new Personne("Oscar", 17, "Vienna", SexeEnum.INCONNU, 0, Arrays.asList(animals.get(31), animals.get(32))),
            new Personne("Piper", 20, "Copenhagen", SexeEnum.INCONNU, 35000, Arrays.asList()),
            new Personne("Quinn", 28, "Warsaw", SexeEnum.INCONNU, 51000, Arrays.asList()),
            new Personne("Reese", 14, "Zagreb", SexeEnum.INCONNU, 0, Arrays.asList(animals.get(31), animals.get(34))),
            new Personne("Sofia", 44, "Prague", SexeEnum.FEMELLE, 69000, Arrays.asList()),
            new Personne("Tom", 16, "Bucharest", SexeEnum.INCONNU, 0, Arrays.asList(animals.get(31), animals.get(35))),
            new Personne("Ursula", 47, "Budapest", SexeEnum.FEMELLE, 78000, Arrays.asList()),
            new Personne("Vince", 13, "Ljubljana", SexeEnum.INCONNU, 0, Arrays.asList()),
            new Personne("Willow", 45, "Riga", SexeEnum.FEMELLE, 72000, Arrays.asList()),
            new Personne("Xena", 12, "Tallinn", SexeEnum.INCONNU, 0, Arrays.asList(animals.get(31), animals.get(36))),
            new Personne("George", 50, "Cairo", SexeEnum.MALE, 79000, Arrays.asList()),
            new Personne("Harper", 16, "Vancouver", SexeEnum.INCONNU, 0, Arrays.asList()),
            new Personne("Isabella", 14, "Brussels", SexeEnum.INCONNU, 0, Arrays.asList()),
            new Personne("James", 18, "Dublin", SexeEnum.MALE, 29000, Arrays.asList()),
            new Personne("Katrina", 43, "Oslo", SexeEnum.FEMELLE, 68000, Arrays.asList()),
            new Personne("Leo", 39, "Stockholm", SexeEnum.MALE, 62000, Arrays.asList()),
            new Personne("Maya", 32, "Athens", SexeEnum.FEMELLE, 55000, Arrays.asList()),
            new Personne("Noah", 15, "Helsinki", SexeEnum.INCONNU, 0, Arrays.asList(animals.get(24))),
            new Personne("Oscar", 17, "Vienna", SexeEnum.INCONNU, 0, Arrays.asList(animals.get(24))),
            new Personne("Piper", 20, "Copenhagen", SexeEnum.INCONNU, 35000, Arrays.asList(animals.get(35), animals.get(35)))
    );



    private BanqueDeDonnees() {
        // No Builder Needed
    }


}