package gameoflife.model;

import gameoflife.table.Cell;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 04.07.13
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class ProcessingCells {
    private final int LOWER_LIMIT = 2;
    private final int APPER_LIMIT = 3;

    private CellsStorage cellsStorage;

    private void whoWillAlive(){
        for(Cell cell : cellsStorage.getListOfCells()){
            if(isKeepAlive(cell)){

            } else {

            }
        }
    }

    private boolean isKeepAlive(Cell cell){
        int countOfContains = 0;
        for(Coordinate coordinateOfNeighbor : getCordinatesOfNeighbors(cell)){
            if(cellsStorage.isExisting(coordinateOfNeighbor.row, coordinateOfNeighbor.column)){
                countOfContains++;
                if (countOfContains > APPER_LIMIT){
                    return false;
                }
            }
        }
        if(countOfContains < LOWER_LIMIT){
            return false;
        }
        return true;
    }

    private Coordinate[] getCordinatesOfNeighbors(Cell cell){
        int row = cell.getRow();
        int column = cell.getColumn();
        return new Coordinate[] {
                new Coordinate(row + 1, column),
                new Coordinate(row - 1, column),
                new Coordinate(row, column + 1),
                new Coordinate(row, column - 1),
                new Coordinate(row + 1, column - 1),
                new Coordinate(row + 1, column + 1),
                new Coordinate(row - 1, column - 1),
                new Coordinate(row + 1, column + 1)
        };
    }

    private static class Coordinate{
        int row;
        int column;

        Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
