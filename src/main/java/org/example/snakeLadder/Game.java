package org.example.snakeLadder;

import org.example.snakeLadder.entities.Board;
import org.example.snakeLadder.entities.Dice;
import org.example.snakeLadder.entities.Player;

import java.util.List;

public class Game {
    final private Board board;
    List<Player> players;
    final Dice dice = new Dice();
    Game(List<Player> players,Board board){
        this.players  = players;
        this.board = board;
    }
    public void start(){
        int currIndex = 0;
        while(true){
            System.out.println(players.get(currIndex).getName() + "turn:");
            
        }
    }
}
