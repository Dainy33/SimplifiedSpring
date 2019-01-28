package utils.Config;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLConfigLoader implements ConfigLoader {
    public List<String> getScanedPackagesFromXML(String sApplicationContext) {

        List<String> packageNames = new ArrayList<>();
        String path = this.getClass().getClassLoader().getResource(sApplicationContext).getPath();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(path);
            NodeList spackages = document.getElementsByTagName("spackage");

            for (int i = 0; i < spackages.getLength(); i++) {
                Node node = spackages.item(i);
                NodeList childNodes = node.getChildNodes();
                //TODO  Node item = childNodes.item(0); item(0)是回车.回车也算一个Node
//                <spackage>
//                     <spackage-name>model</spackage-name>
//                </spackage>


//                Node item = childNodes.item(1);
//                String packageName = item.getTextContent();
//                packageNames.add(packageName);

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node item1 = childNodes.item(j);
                    if (item1.getNodeType() == Node.ELEMENT_NODE) {
                        //valid node
                        if (item1.getNodeName().equals("spackage-name")) {
                            String packageName = item1.getTextContent();
                            packageNames.add(packageName);
                        }
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return packageNames;
    }

    @Test
    public void getPath() {
        String path = this.getClass().getClassLoader().getResource("SimplifiedApplicationContext.xml").getPath();
        System.out.println(path);
    }
}
/**
 * @program: SimplifiedSpringFrameWork
 * @description:
 * @author: Dainy33
 * @create: 2019-01-21 09:33
 **/
