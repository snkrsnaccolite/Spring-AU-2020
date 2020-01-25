import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class Item {
    private int id;
    private String name;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item ID: " + this.id + "\tItem Name: " + this.name;
    }
}

class MyHandler extends DefaultHandler {
    private List<Item> items = null;
    private Item item = null;
    private StringBuilder data = null;

    public List<Item> getItems() {
        return this.items;
    }

    boolean bName = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Item")) {
            String id = attributes.getValue("id");
            this.item = new Item();
            this.item.setId(Integer.parseInt(id));

            if (items == null) {
                this.items = new ArrayList<Item>();
            }
        } else if (qName.equalsIgnoreCase("name")) {
            this.bName = true;
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            item.setName(data.toString());
            bName = false;
        }

        if (qName.equalsIgnoreCase("Item")) {
            this.items.add(item);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

public class XmlParser {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("./items.xml"), handler);

            List<Item> items = handler.getItems();

            for (Item i : items) {
                System.out.println(i);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
