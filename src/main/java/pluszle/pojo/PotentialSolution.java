package pluszle.pojo;

import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter

public class PotentialSolution {

    private List<RowSolution> potentialPuzzleSolution;

    public PotentialSolution(List<RowSolution> potentialPuzzleSolution){
        this.potentialPuzzleSolution = potentialPuzzleSolution;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(potentialPuzzleSolution);
        return sb.toString();
    }
}
