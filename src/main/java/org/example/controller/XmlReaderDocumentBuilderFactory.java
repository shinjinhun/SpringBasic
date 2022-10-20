package org.example.controller;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReaderDocumentBuilderFactory {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        ClassPathResource resource = new ClassPathResource("config/main_menu.xml");

        try {
            File file = new File("" + resource.getFile());  // new File("D:/Study/java/SpringBasic/src/main/webapp/WEB-INF/company.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("main_menu_code");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("main_menu_code : " + eElement.getAttribute("id"));
                    System.out.println("main_menu_nm : " + eElement.getElementsByTagName("main_menu_nm").item(0).getTextContent());
                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
