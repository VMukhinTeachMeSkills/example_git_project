package com.tms.courses.vm.lesson18.task1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static final String TXT_FORMAT = ".txt";


    public static void main(String[] args) throws IOException
    {
        Document doc;
        try
        {
            doc = getDocumentFromFile("/home/user/example_git_project/src/com/tms/courses/vm/lesson18/task1/file.xml");
            doc.getDocumentElement().normalize();
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
            return;
        }

        String resultFileName = getResultFileName(doc);
        File resultFile = new File("/home/user/example_git_project/src/com/tms/courses/vm/lesson18/task1/" + resultFileName);
        FileWriter writer = new FileWriter(resultFile);
        writer.write(getFileContent(doc));
        writer.close();
        System.out.println("Successfully parsed to " + resultFileName);
    }

    private static String getFileContent(Document doc)
    {
        StringBuilder contentBuilder = new StringBuilder();
        Element linesElement = (Element) doc.getElementsByTagName("lines").item(0);
        NodeList lines = linesElement.getElementsByTagName("line");
        for (int i = 0; i < lines.getLength(); i++)
        {
            contentBuilder.append(lines.item(i).getTextContent()).append("\n");
        }
        return contentBuilder.toString();
    }

    private static String getResultFileName(Document doc)
    {
        Node authorNode = doc.getElementsByTagName("author").item(0);
        Node titleNode = doc.getElementsByTagName("title").item(0);
        Element authorElement = (Element) authorNode;

        return authorElement.getElementsByTagName("firstName").item(0).getTextContent() + "_" +
                authorElement.getElementsByTagName("lastName").item(0).getTextContent() + "_" +
                titleNode.getTextContent() + TXT_FORMAT;
    }

    private static Document getDocumentFromFile(String path) throws ParserConfigurationException, IOException, SAXException
    {
        File file = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(file);
    }
}
