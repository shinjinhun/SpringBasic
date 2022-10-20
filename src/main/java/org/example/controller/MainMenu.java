package org.example.controller;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MainMenu {

    private static String[] Add(String[] originArray, String Val) {
        // 순서 1. (원본 배열의 크기 + 1)를 크기를 가지는 배열을 생성
        String[] newArray = new String[originArray.length + 1];

        // 순서 2. 새로운 배열에 값을 순차적으로 할당
        for(int index = 0; index < originArray.length; index++) {
            newArray[index] = originArray[index];
        }

        // 순서 3. 새로운 배열의 마지막 위치에 추가하려는 값을 할당
        newArray[originArray.length] = Val;

        // 순서 4. 새로운 배열을 반환
        return newArray;
    }

    public static String[] main_menu() throws ParserConfigurationException, SAXException{
        ClassPathResource resource = new ClassPathResource("config/main_menu.xml");

        String[] main_menu_nm = {};

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

                    main_menu_nm = Add(main_menu_nm, eElement.getElementsByTagName("main_menu_nm").item(0).getTextContent());
                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }

        return main_menu_nm;
    }


//    public static void main(String[] args){
//
//        try {
//            System.out.println("main_menu_nm = " + main_menu()[0]);
//        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
//        } catch (SAXException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("people", "사람");
        map.put("baseball", "야구");

        System.out.println(map.get("people"));
        System.out.println(map.containsKey("people"));
        System.out.println(map.remove("people"));
        System.out.println(map.size());
    }


    public static HashMap<String, String> main_menu_new() throws ParserConfigurationException, SAXException{
        ClassPathResource resource = new ClassPathResource("config/main_menu.xml");

//        String[] main_menu_nm = {};

        HashMap<String, String> main_menu = new HashMap<String, String>();

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
                    System.out.println("main_menu_code : " + eElement.getAttribute("code"));
                    System.out.println("main_menu_nm : " + eElement.getElementsByTagName("main_menu_nm").item(0).getTextContent());

//                    main_menu_nm = Add(main_menu_nm, eElement.getElementsByTagName("main_menu_nm").item(0).getTextContent());

                    main_menu.put(eElement.getAttribute("id"), eElement.getElementsByTagName("main_menu_nm").item(0).getTextContent());
                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }

        return main_menu;
    }

}
