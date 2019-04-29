package dsas;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by tdd on 2019/4/19.
 * 输出xml文档工具类.
 */

public class Xmtest {
    public void testXm(){

        Map<String,String> map=new HashMap<>();
        map.put("xiaoming","123@abc.com");
        map.put("xiaowang","456@abc.com");

        Document document=null;

        Element addresslist = new Element("addresslist");
        //声明一个Document对象
        document = new Document(addresslist);

        //Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int i=0;
        while(iterator.hasNext()){
            Map.Entry<String, String> mapentry = iterator.next();
            //定义节点
            Element linkman = new Element("linkman");
            Element name = new Element("name");
            Element email = new Element("email");
            //定义属性
            Attribute id = new Attribute("id", ++i+"");
            //设置节点内容
            name.setText(mapentry.getKey());
            email.setText(mapentry.getValue());
            //将属性添加到节点
            name.setAttribute(id);
            //连接节点
            linkman.addContent(name);
            linkman.addContent(email);
            addresslist.addContent(linkman);
        }

        //用来输出XML文件
        XMLOutputter out = new XMLOutputter();
        //设置输出编码
        out.setFormat(out.getFormat().setEncoding("UTF-8"));

        try{
            //输出XML文件
            out.output(document, new FileOutputStream("/Users/tdd/Desktop"+ File.separator+"JdomXML.xml"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Xmtest().testXm();
    }



}
