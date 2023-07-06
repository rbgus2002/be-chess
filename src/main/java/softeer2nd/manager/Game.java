package softeer2nd.manager;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class Game {
    private Board board;

    public Game() {
        this.board = new Board();
    }

    public void run() {
        System.out.println("game start!");

        while (true){
            board.initialize();

            System.out.println("input : 'start' | 'end'");

            Scanner in = new Scanner(System.in);
            String input = in.next();

            if(!verifyInput(input))
                break;

            System.out.println(board.showBoard());
        }

        System.out.println("game end!");
    }

    private boolean verifyInput(String input){
        if(input.equals("start"))
            return true;
        else{
            if(!input.equals("end"))
                System.out.println("Input Error!"); // TODO : Exception 생성 (Business Exception => InvalidInputException이 적당할듯)
            return false;
        }
    }
}
