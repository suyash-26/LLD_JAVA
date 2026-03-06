package org.example.snakeLadder.entities;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
}
