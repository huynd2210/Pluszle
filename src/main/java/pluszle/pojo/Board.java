package pluszle.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {

    private List<List<CoordinateInteger>> board;

    public Board(List<Integer> inputList, int rowLength){
        this.board = new ArrayList<>();
        List<List<Integer>> integerBoard = listTo2d(inputList, rowLength);
        for (int i = 0; i < integerBoard.size(); i++){
            List<CoordinateInteger> tmp = new ArrayList<>();
            for (int j = 0; j < integerBoard.get(i).size(); j++){
                tmp.add(new CoordinateInteger(integerBoard.get(i).get(j), new Coordinate(i,j)));
            }
            this.board.add(tmp);
        }
    }


    public List<List<Integer>> listTo2d(List<Integer> inputList, int rowLength) {
        List<List<Integer>> board = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            if ((i + 1) % rowLength != 0) {
                list.add(inputList.get(i));
            } else {
                list.add(inputList.get(i));
                board.add(List.copyOf(list));
                list.clear();
            }
        }
        return board;
    }



}
