package gameoflife.model;

import gameoflife.table.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 05.07.13
 * Time: 1:16
 * To change this template use File | Settings | File Templates.
 */
public class CellsStorage {

    private static CellsStorage instance;

    public static CellsStorage getInstance(){
        return instance;
    }

    public static void createStorage(int row, int column){
        instance = new CellsStorage(row, column);
    }

    private Cell[][] storage;
    private int rows;
    private int columns;

    private CellsStorage(int row, int column){
        this.rows = rows;
        this.columns = column;
        storage = new Cell[row][column];
    }

    public void setCell(Cell cell){
        int row = cell.getRow();
        int column = cell.getColumn();
        boundsCheck(row, column);
        storage[row][column] = cell;
    }

    public boolean isExisting(int row, int column){
        boundsCheck(row, column);
        return storage[row][column] == null ? false : true;
    }

    public void killCell(int row, int column){
        boundsCheck(row, column);
        storage[row][column] = null;
    }

    public List<Cell> getListOfCells(){
        List<Cell> cellsList = new ArrayList<Cell>(rows * columns);
        for(Cell[] rowOfCell : storage){
            for(Cell cell : rowOfCell){
                if(cell != null){
                    cellsList.add(cell);
                }
            }
        }
        return cellsList;
    }

    private void boundsCheck(int row, int column){
        if((row < 0) || (row >= storage.length) || (column < 0) || (column >= storage.length)){
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива.");
        }
    }
}
