package pluszle.pojo;

import lombok.Getter;
import solver.perfectsum.ObjectWithInteger;

import java.util.List;

@Getter
public class RowSolution {
    private List<ObjectWithInteger> potentialRowSolution;

    public RowSolution(List<ObjectWithInteger> potentialRowSolution){
        this.potentialRowSolution = potentialRowSolution;
    }

    @Override
    public String toString() {
        return String.valueOf(potentialRowSolution);
    }
}

