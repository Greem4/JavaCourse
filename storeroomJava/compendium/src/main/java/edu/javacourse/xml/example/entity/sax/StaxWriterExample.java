package edu.javacourse.xml.example.entity.sax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;

public class StaxWriterExample {

    public static void main(String[] args) {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("result.xml"));
            writer.writeStartDocument();
            writer.writeStartElement("a");
            writer.writeAttribute("b", "blah");
            writer.setPrefix("d", "http://c");
            writer.writeEmptyElement("d");
            writer.writeAttribute("chris", "fry");
            writer.writeCharacters("Jean Arp");
            writer.writeEndElement();
            writer.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
