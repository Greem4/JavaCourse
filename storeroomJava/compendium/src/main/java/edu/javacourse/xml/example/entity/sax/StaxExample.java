package edu.javacourse.xml.example.entity.sax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StaxExample {

    public static void main(String[] args) {
        final String fileName = "Phonebook.xml";

        try {

            XMLStreamReader xmlr = XMLInputFactory.newInstance()
                    .createXMLStreamReader(new FileInputStream(fileName));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    System.out.println(xmlr.getLocalName());
                } else if (xmlr.isEndElement()) {
                    System.out.println("/" + xmlr.getLocalName());
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    System.out.println("  " + xmlr.getText());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
