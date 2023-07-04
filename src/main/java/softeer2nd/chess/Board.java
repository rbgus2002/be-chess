package softeer2nd.chess;

import softeer2nd.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> pawnList = new ArrayList<>();

    public int size(){
        return pawnList.size();
    }

    public void add(Pawn pawn){
        pawnList.add(pawn);
    }

    public Pawn findPawn(int idx) {
        return pawnList.get(idx);
    }
}
