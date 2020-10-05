package solver;

import com.google.common.collect.Lists;
import pluszle.pojo.*;
import solver.perfectsum.ObjectWithInteger;
import solver.perfectsum.SubsetSumSolver;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    private Solver(){

    }

    public static PotentialSolution getSolution(PuzzleContainer container) {
        List<List<RowSolution>> potentialPuzzleSolutionList = getPotentialSolution(container);
        List<List<RowSolution>> tmp = cartesianProduct(potentialPuzzleSolutionList);
        List<PotentialSolution> allPotentialSolution = new ArrayList<>();
        for (List<RowSolution> rowSolutions : tmp) {
            allPotentialSolution.add(new PotentialSolution(rowSolutions));
        }
        for (PotentialSolution potentialSolution : allPotentialSolution) {
            if (checkSolution(potentialSolution, container)) {
                return potentialSolution;
            }
        }
        return null;
    }


    public static List<List<RowSolution>> getPotentialSolution(PuzzleContainer container) {
        List<List<RowSolution>> potentialPuzzleSolutionList = new ArrayList<>();
        for (int i = 0; i < container.getBoard().getBoard().size(); i++) {
            List<ObjectWithInteger> tmp = new ArrayList<>(container.getBoard().getBoard().get(i));
            SubsetSumSolver subsetSolver = new SubsetSumSolver(tmp, container.getRowSums().get(i));
            List<List<ObjectWithInteger>> solutionTmp = subsetSolver.getSolution();
            List<RowSolution> allPotentialRowSolutions = new ArrayList<>();
            for (List<ObjectWithInteger> solution : solutionTmp) {
                allPotentialRowSolutions.add(new RowSolution(solution));
            }
            potentialPuzzleSolutionList.add(allPotentialRowSolutions);
        }
        return potentialPuzzleSolutionList;
    }

    private static List<List<RowSolution>> cartesianProduct(List<List<RowSolution>> potentialPuzzleSolutionList) {
        return Lists.cartesianProduct(potentialPuzzleSolutionList);
    }

    private static boolean checkSolution(PotentialSolution potentialSolution, PuzzleContainer container) {
        Board boardTmp = container.getBoard();
        List<CoordinateInteger> coordinateIntegers = getCoordinateIntFromSolution(potentialSolution);
        int sumTmp = 0;
        for (int i = 0; i < boardTmp.getBoard().size(); i++) {
            for (int j = 0; j < boardTmp.getBoard().get(i).size(); j++) {
                if (coordinateIntegers.contains(boardTmp.getBoard().get(j).get(i))) {
                    sumTmp += boardTmp.getBoard().get(j).get(i).getInteger();
                }
            }
            if (sumTmp != container.getColSums().get(i)) {
                return false;
            }
            sumTmp = 0;
        }
        return true;
    }

    private static List<CoordinateInteger> getCoordinateIntFromSolution(PotentialSolution potentialSolution) {
        List<RowSolution> potentialPuzzleSolution = potentialSolution.getPotentialPuzzleSolution();
        List<CoordinateInteger> coordinateIntegers = new ArrayList<>();

        for (RowSolution rowSolution : potentialPuzzleSolution) {
            for (int j = 0; j < rowSolution.getPotentialRowSolution().size(); j++) {
                coordinateIntegers.add(((CoordinateInteger) rowSolution.getPotentialRowSolution().get(j)));
            }
        }
        return coordinateIntegers;
    }
}
