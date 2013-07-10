package gameoflife.servlets;

import gameoflife.model.CellsStorage;
import gameoflife.table.HTMLTable;
import gameoflife.utils.XMLConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 29.06.13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "TableServlet", urlPatterns = {"/table"})
public class TableServlet extends HttpServlet{

    HTMLTable table;
    private boolean isFirstTime;

    @Override
    public void init() throws ServletException {
        isFirstTime = true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows = getRowsCount(req);
        int columns = getColumnsCount(req);
        if(isFirstTime){
            table = HTMLTable.getInstanceOfTable(rows, columns);
            CellsStorage.createStorage(rows, columns);
            isFirstTime = false;
        } else {
            table.changeExistingTable(rows, columns);
        }
        writeTableDocumentToWriter(resp.getWriter());
    }

    private void writeTableDocumentToWriter(Writer writer){
        XMLConverter xmlConverter = new XMLConverter(table.getTableDocument());
        try {
            writer.write(xmlConverter.XMLtoString());
        } catch (IOException e) {
            System.out.println("Ошибка при ответе на запрос о формировании табицы.");
            e.printStackTrace();
        }
        System.out.println(xmlConverter.XMLtoFormatString());
    }

    private int getRowsCount(HttpServletRequest request){
        String rowsFromRequest = request.getParameter("rows");
        int rows = Integer.parseInt(rowsFromRequest);
        return rows > 0 ? rows : 1;
    }

    private int getColumnsCount(HttpServletRequest request){
        String columnsFromRequest = request.getParameter("columns");
        int columns = Integer.parseInt(columnsFromRequest);
        return columns > 0 ? columns : 1;
    }
}
