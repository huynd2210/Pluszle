package pluszle.pojo;

import solver.perfectsum.ObjectWithInteger;

import java.util.Objects;


public class CoordinateInteger implements ObjectWithInteger {
    private Integer number;
    private Coordinate coordinate;

    public CoordinateInteger(Integer number, Coordinate coordinate){
        this.number = number;
        this.coordinate = coordinate;
    }

    @Override
    public Integer getInteger() {
        return this.number;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    //CoordinateInteger compares only coordinates for the sake of finding chosen coordinates on board to check if solution is correct
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinateInteger)) return false;

        CoordinateInteger that = (CoordinateInteger) o;

        return Objects.equals(coordinate, that.coordinate);
    }

    @Override
    public int hashCode() {
        return coordinate != null ? coordinate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.coordinate);
    }
}
