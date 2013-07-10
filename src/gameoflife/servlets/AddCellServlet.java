package gameoflife.servlets;

import gameoflife.model.CellsStorage;
import gameoflife.table.Cell;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 04.07.13
 * Time: 1:13
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "AddCellServlet", urlPatterns = "/cell")
public class AddCellServlet extends HttpServlet {

    private CellsStorage cellsStorage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cellsStorage = CellsStorage.getInstance();
        String idCell = req.getParameter("id");
        String isLife = req.getParameter("isLife");
        Cell cell = new Cell(idCell, isLife);
        cellsStorage.setCell(cell);
    }
}
