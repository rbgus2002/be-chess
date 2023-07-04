package softeer2nd;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class Game {

    public void run() {
        Board board = new Board();
        board.initialize();

        while (true){
            Scanner in = new Scanner(System.in);
            String input = in.next();

            if(!verifyInput(input))
                break;

            board.print();
        }
    }

    private boolean verifyInput(String input){
        if(input.equals("start"))
            return true;
        else{
            if(!input.equals("end"))
                System.out.println("Input Error!");
            return false;
        }
    }
}
