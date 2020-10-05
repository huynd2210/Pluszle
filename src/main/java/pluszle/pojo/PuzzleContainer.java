package pluszle.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
public class PuzzleContainer {
    private Board board;
    private List<Integer> rowSums;
    private List<Integer> colSums;

}
