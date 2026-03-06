package org.example.snakeLadder.entities;

import java.util.Random;

public class Dice {
    final Random random = new Random();
    public int roll(){
        return random.nextInt(6)+1;
    }
}
