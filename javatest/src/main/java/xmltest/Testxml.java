package xmltest;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by tdd on 2019/6/11.
 */

public class Testxml {

    public static void main(String[] args)throws Exception {
        File fl=new File("/Users/tdd/Desktop/JdomXML.xml");
        DocumentBuilderFactory df=DocumentBuilderFactory.newInstance();
        DocumentBuilder  builder=df.newDocumentBuilder();
        Document dom=builder.parse(fl);
        //System.out.println(dom.getElementById("id"));
        //System.out.println(dom.getDocumentElement().getTagName());

        //System.out.println(dom.getElementsByTagName("linkman").getLength());
        //System.out.println(dom.getDocumentElement().getChildNodes().getLength());
        //System.out.println(dom.getDocumentElement().getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
        //System.out.println(dom.getDocumentElement().getChildNodes().item(0).getChildNodes().item(0).getTextContent());
        //for (int i=0;i<dom.getDocumentElement().getChildNodes().getLength();i++){
            //System.out.println(dom.getDocumentElement().getChildNodes().item(i).getNodeName());

        //}
        //System.out.println(dom.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue());
        //System.out.println(dom.getDocumentElement().getNodeType()+"&&&"+dom.getDocumentElement().getNodeName());
        //NamedNodeMap nodeMap =dom.getDocumentElement().getAttributes();
        //System.out.println(nodeMap.item(0).getNodeName()+"&&&"+nodeMap.item(0).getNodeValue());

        System.out.println(dom.getElementsByTagName("testcase").getLength());
        int i=dom.getElementsByTagName("testcase").getLength();
        NodeList lists=dom.getElementsByTagName("testcase");
        System.out.println(lists.item(0).getAttributes().item(0).getNodeValue());
        System.out.println(lists.item(0).getAttributes().item(1).getNodeValue());
        System.out.println(lists.item(0).getAttributes().item(2).getNodeValue());





        for (int j = 0; j <i ; j++) {
            if (lists.item(j).getAttributes().item(0).getNodeValue()!="com.shishike.calm.testcases.common.Login"){

                dom.getDocumentElement().removeChild(dom.getDocumentElement().getChildNodes().item(7));
            }
            //System.out.println(dom.getElementsByTagName("testcase").getLength());

        }




    }
}
