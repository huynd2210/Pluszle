package pluszle.pojo;

import lombok.Data;

@Data
public class Coordinate {
    private Integer i;
    private Integer j;

    public Coordinate(Integer i, Integer j){
        this.i = i;
        this.j = j;
    }

}
