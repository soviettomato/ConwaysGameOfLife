package gameoflife.table;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 02.07.13
 * Time: 4:23
 * To change this template use File | Settings | File Templates.
 */
public class HTMLTable {
    private int rows;
    private int columns;
    private static HTMLTable instanceOfTable;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document tableDocument;

    public static HTMLTable getInstanceOfTable(int rows, int columns){
        if(instanceOfTable == null){
            instanceOfTable = new HTMLTable(rows, columns);
        }
        return instanceOfTable;
    }

    private HTMLTable(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = getDocumentBuilder();
        tableDocument = documentBuilder.newDocument();
        createNewTable();
    }

    public Document getTableDocument() {
        return tableDocument;
    }

    public void changeExistingTable(int rows, int columns) {
        if(this.rows != rows){
            changeRowsCount(rows);
            this.rows = rows;
        }
        if(this.columns != columns){
            changeColumnsCount(columns);
            this.columns = columns;
        }
    }

    protected void createNewTable(){
        Element root = tableDocument.createElement("table");
        setTableAttributes(root);
        tableDocument.appendChild(root);
        for (int row = 0; row < rows; ++row){
            Element rowElement = tableDocument.createElement("tr");
            appendInnerColumns(rowElement, row, 0, columns);
            root.appendChild(rowElement);
        }
    }

    private DocumentBuilder getDocumentBuilder(){
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка создания DocumentBuilder.");
            e.printStackTrace();
        }
        return null;
    }

    private void setTableAttributes(Element root){
        root.setAttribute("id", "myField");
        root.setAttribute("height", "800");
        root.setAttribute("width", "1100");
        root.setAttribute("border", "1");
    }

    private void changeRowsCount(int newRowsCount){
        if(newRowsCount < rows){
            deleteRows(newRowsCount);
        } else {
            appendRows(newRowsCount);
        }
    }

    private void changeColumnsCount(int newColumnsCount){
        if(newColumnsCount < columns){
            deleteColumns(newColumnsCount);
        } else {
            appendColumns(newColumnsCount);
        }
    }

    private void deleteRows(int newRowsCount){
        NodeList tableElement = tableDocument.getChildNodes();
        int newLength = tableElement.item(0).getChildNodes().getLength();
        for(int row = newRowsCount; row < newLength; ++row){
            Node rowElement = tableElement.item(0);
            rowElement.removeChild(rowElement.getLastChild());
        }
    }

    private void appendRows(int newRowsCount){
        Node root = tableDocument.getElementsByTagName("table").item(0);
        NodeList tableElement = tableDocument.getChildNodes();
        int oldLength = tableElement.item(0).getChildNodes().getLength();
        for(int row = oldLength; row < newRowsCount; ++row){
            Element rowElement = tableDocument.createElement("tr");
            appendInnerColumns(rowElement, row, 0, columns);
            root.appendChild(rowElement);
        }
    }

    private void deleteColumns(int newColumnsCount){
        NodeList tableElement = tableDocument.getChildNodes();
        NodeList rowElements = tableElement.item(0).getChildNodes();
        int length = tableElement.item(0).getChildNodes().getLength();
        for(int row = 0; row < length; ++row){
            Node rowElement = rowElements.item(row);
            deleteInnerColumns(rowElement, newColumnsCount);
        }
    }

    private void appendColumns(int newColumnsCount){
        NodeList tableElement = tableDocument.getChildNodes();
        NodeList rowElements = tableElement.item(0).getChildNodes();
        int length = rowElements.getLength();
        for(int row = 0; row < length; ++row){
            appendInnerColumns(rowElements.item(row), row, columns, newColumnsCount);
        }
    }

    private void appendInnerColumns(Node rowElement, int parentNumber, int startPos, int endPos){
        for (int columnNumber = startPos; columnNumber < endPos; ++columnNumber){
            Element columnElement = tableDocument.createElement("td");
            columnElement.setAttribute("bgcolor", "#FFFFFF");
            columnElement.setAttribute("data-islife", "false");
            columnElement.setAttribute("onclick", "transformCell(this.id);");
            columnElement.setAttribute("onmouseover", "this.setAttribute('bgcolor', '#F2A96F');");
            columnElement.setAttribute("onmouseout", "mouseOut(this);");
            columnElement.setAttribute("id", parentNumber + "_" + columnNumber);
            rowElement.appendChild(columnElement);
        }
    }

    private void deleteInnerColumns(Node rowElement, int newColumnsCount){
        for (int i = columns; i > newColumnsCount; --i){
            rowElement.removeChild(rowElement.getLastChild());
        }
    }
}
