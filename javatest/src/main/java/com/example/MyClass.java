package com.example;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyClass {
    public static void main(String[] args) {
        String xmlFilePath = "/Users/tdd/Desktop/";
        String xslFilePath = "./reportTools/";
        Document document1 = readXml(xmlFilePath + "junit-reportAll.xml");
        Element root1 = document1.getDocumentElement();
        mergerDuplicateTestSuite(root1);
        saveXml(document1, xmlFilePath + "merger.xml");
        Document document2 = readXml(xmlFilePath + "merger.xml");
        Element root2 = document2.getDocumentElement();
        deleteEmptyTestSuite(root2);
        saveXml(document2, xmlFilePath + "junit-report.xml");
        String xmlFileName = xmlFilePath + "junit-report.xml";
        String xslFileName = xslFilePath + "TestReportTemp.xsl";
        String htmlFileName = xmlFilePath + "OnOS_TestReport.html";
        Transform(xmlFileName, xslFileName, htmlFileName);
    }

    public static void mergerDuplicateTestSuite(Element root) {
        NodeList suNodeList = root.getChildNodes();

        for(int i = 0; i < suNodeList.getLength() - 1; ++i) {
            for(int j = i + 1; j < suNodeList.getLength(); ++j) {
                if(suNodeList.item(i).getAttributes().item(0).toString().equals(suNodeList.item(j).getAttributes().item(0).toString()) && suNodeList.item(i).hasChildNodes() && suNodeList.item(j).hasChildNodes()) {
                    while(suNodeList.item(j).hasChildNodes()) {
                        suNodeList.item(i).appendChild(suNodeList.item(j).getLastChild());
                    }
                }
            }
        }

    }

    public static void Transform(String xmlFileName, String xslFileName, String htmlFileName) {
        try {
            TransformerFactory e = TransformerFactory.newInstance();
            StreamSource xslSource = new StreamSource(xslFileName);
            Transformer t = e.newTransformer(xslSource);
            File xmlFile = new File(xmlFileName);
            File htmlFile = new File(htmlFileName);
            StreamSource source = new StreamSource(xmlFile);
            StreamResult result = new StreamResult(htmlFile);
            t.transform(source, result);
        } catch (TransformerConfigurationException var10) {
            var10.printStackTrace();
        } catch (TransformerException var11) {
            var11.printStackTrace();
        }

    }

    public static void deleteEmptyTestSuite(Element root) {
        NodeList suNodeList = root.getChildNodes();

        for(int i = suNodeList.getLength() - 1; i >= 0; --i) {
            if(!suNodeList.item(i).hasChildNodes()) {
                root.removeChild(suNodeList.item(i));
            }
        }

    }

    public static void saveXml(Document document, String fileName) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            Transformer e = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new FileOutputStream(fileName));
            e.transform(domSource, streamResult);
        } catch (TransformerConfigurationException var6) {
            var6.printStackTrace();
        } catch (FileNotFoundException var7) {
            var7.printStackTrace();
        } catch (TransformerException var8) {
            var8.printStackTrace();
        }

    }

    public static Document readXml(String fineName) {
        Document document = null;

        try {
            DocumentBuilderFactory e = DocumentBuilderFactory.newInstance();
            FileInputStream xmlInputStream = new FileInputStream(fineName);
            DocumentBuilder builder = e.newDocumentBuilder();
            document = builder.parse(xmlInputStream);
        } catch (ParserConfigurationException var5) {
            var5.printStackTrace();
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (SAXException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        return document;
    }

}
