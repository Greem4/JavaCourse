package edu.javacourse.xml.example.entity.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class SaxExample {

    public static void main(String[] args) {

        final String fileName = "Phonebook.xml";

        final List<String> names = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean name = false;
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("NAME")) {
                        name = true;
                    }
                }
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        names.add(new String(ch, start, length));
                        name = false;
                    }
                }
            };
            saxParser.parse(fileName, handler);

            System.out.println(names);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
