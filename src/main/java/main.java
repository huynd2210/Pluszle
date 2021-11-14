import pluszle.pojo.Board;
import pluszle.pojo.PotentialSolution;
import pluszle.pojo.PuzzleContainer;
import solver.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }

    private static void markSolutionOnBoard(PotentialSolution solution, int iLength, int jLength) {
        String string = solution.toString();
        String[] tokens = string.split(",");
        char[][] mark = new char[iLength][jLength];

        int iCoord = 0;
        int jCoord = 0;
        for (String token : tokens) {
            String coordinates = token.substring(token.indexOf("{") + 1, token.indexOf("}"));
            String[] coordTokens = coordinates.split(";");
            iCoord = Character.getNumericValue(coordTokens[0].charAt(2));
            jCoord = Character.getNumericValue(coordTokens[1].charAt(2));
            mark[iCoord][jCoord] = 'x';
        }
        print(mark);
    }

    private static void printSolution(List<Integer> rowSum, List<Integer> colSum, Board board) {
        PuzzleContainer container = new PuzzleContainer(board, rowSum, colSum);
        PotentialSolution solution = Solver.getSolution(container);
        markSolutionOnBoard(solution, rowSum.size(), colSum.size());
    }

    private static void start() {
        System.out.println("Insert row sum");
        List<Integer> rowSum = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("x")) {
            rowSum.add(Integer.parseInt(input));
            input = scanner.nextLine();
        }
        System.out.println("Insert col sum");
        List<Integer> colSum = new ArrayList<>();
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
        while (!input.equalsIgnoreCase("x")) {
            colSum.add(Integer.parseInt(input));
            input = scanner.nextLine();
        }
        System.out.println("Insert board as a List, in order first to last line");
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
        List<Integer> boardInput = new ArrayList<>();
        while (!input.equalsIgnoreCase("x")) {
            boardInput.add(Integer.parseInt(input));
            input = scanner.nextLine();
        }
        Board board = new Board(boardInput, rowSum.size());
        printSolution(rowSum, colSum, board);
    }

    public static void main(String[] args) {
//        List<Integer> rowSum = Arrays.asList(17,7,5,9);
//        List<Integer> colSum = Arrays.asList(13,11,6,8);
//
//        Board board = new Board(Arrays.asList(8,9,3,8,5,2,7,3,3,1,1,5,4,6,6,3), 4);

//        List<Integer> rowSum = Arrays.asList(11, 13, 9);
//        List<Integer> colSum = Arrays.asList(14, 9, 10);
//
//        Board board = new Board(Arrays.asList(7, 4, 7, 7, 4, 6, 9, 5, 4), 3);

//        System.out.println(solution);
        start();

    }
}
