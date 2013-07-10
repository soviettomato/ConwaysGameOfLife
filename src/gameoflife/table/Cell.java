package gameoflife.table;

import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 04.07.13
 * Time: 20:24
 * To change this template use File | Settings | File Templates.
 */
public class Cell {
    private int row;
    private int column;
    private boolean isLife;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (column != cell.column) return false;
        if (row != cell.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }

    public Cell(String id, String isLife){
        this.isLife = Boolean.valueOf(isLife);
        getRowColumnFromString(id);
    }

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isLife() {
        return isLife;
    }

    public void setLife(boolean life) {
        isLife = life;
    }

    private void getRowColumnFromString(String id){
        StringTokenizer getInfo = new StringTokenizer(id, "_");
        row = Integer.parseInt(getInfo.nextToken());
        column = Integer.parseInt(getInfo.nextToken());
    }
}
