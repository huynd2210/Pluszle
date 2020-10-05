import pluszle.pojo.Board;
import pluszle.pojo.PuzzleContainer;
import solver.Solver;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> rowSum = Arrays.asList(17,7,5,9);
        List<Integer> colSum = Arrays.asList(13,11,6,8);

        Board board = new Board(Arrays.asList(8,9,3,8,5,2,7,3,3,1,1,5,4,6,6,3), 4);
        PuzzleContainer container = new PuzzleContainer(board, rowSum, colSum);

        System.out.println(Solver.getSolution(container));


    }
}
