package gameoflife.utils;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 02.07.13
 * Time: 4:30
 * To change this template use File | Settings | File Templates.
 */
public class XMLConverter {
    private final Document tableDocument;

    public XMLConverter(Document tableDocument) {
        this.tableDocument = tableDocument;
    }

    public String XMLtoFormatString(){
        Writer out = null;
        try {
            OutputFormat format = new OutputFormat(tableDocument);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(tableDocument);
        } catch (IOException e) {
            System.out.println("Ошибка преобразования.");
        } finally {
            return out.toString();
        }
    }

    public String XMLtoString(){
        Transformer transformer = null;
        StringWriter stringWriter = new StringWriter();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(tableDocument), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            System.out.println("Ошибка преобразования.");
            e.printStackTrace();
        }
        return stringWriter.toString();
    }
}
