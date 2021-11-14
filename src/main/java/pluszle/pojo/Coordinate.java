package pluszle.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Coordinate {
    private Integer i;
    private Integer j;

    public Coordinate(Integer i, Integer j){
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Coordinate{");
        sb.append("i=").append(i);
        sb.append(";j=").append(j);
        sb.append('}');
        return sb.toString();
    }
}
