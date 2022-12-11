package com.bookshelf.Models;

public class RandomGenerator {
    private static String[] tressureIslandNames = {
            "Jim Hawkins",
            "Long John Silver",
            "Ben Gunn",
            "Dr. Livesey",
            "Squire Trelawney",
            "Capitan Smollet",
            "Blind Pew" };
    private static String[] tressureIslandDescriptions = {
            "The treasure is hidden in a chest.",
            "The treasure is hidden in a cave.",
            "The treasure is hidden in a ship.",
            "The treasure is hidden in a bottle.",
            "The treasure is hidden in a barrel." };

    public static String getRandomName() {
        return tressureIslandNames[(int) (Math.random() * tressureIslandNames.length)];
    }

    public static String getRandomDescription() {
        return tressureIslandDescriptions[(int) (Math.random() * tressureIslandDescriptions.length)];
    }

    public static int getRandomYear() {
        return (int) (Math.random() * 100 + 1700);
    }
}
