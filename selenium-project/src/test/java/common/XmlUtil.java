package common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {
    private static Map<String, String> confMap = new HashMap<>();
    static {
        try {
            // configure.xmlの読み込む
            File file = new File(System.getProperty("user.dir") + "/src/test/resources/configure.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Element root = doc.getDocumentElement();
            NodeList confs = root.getChildNodes();
            for (int i = 0; i < confs.getLength(); i++) {
                Node node = confs.item(i);
                confMap.put(node.getNodeName(), node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getConfAttribute(String attributeName) {
        return confMap.get(attributeName);
    }
}
