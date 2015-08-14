package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

public class XmlManager
{
  private static XmlManager self = null;

  private Document          document_;



  public static XmlManager getXmlManager()
  {
    if (self == null)
      self = new XmlManager();
    return self;
  }



  private XmlManager()
  {
    init();

  }



  public void init()
  {
    String s = AppProperties.getInstance().getProperties()
      .getProperty("XMLFILE");
    try {
      SAXBuilder b = new SAXBuilder();
      b.setExpandEntities(true);
      document_ = b.build(s);
    }

    catch (JDOMException e) {
      System.err.printf("%s",
        "DBMD: XMLManager : init : caught JDOMException\n");
      throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
    } catch (IOException e) {
      System.err.printf("%s", "DBMD: XMLManager : init : caught IOException\n");

      throw new RuntimeException("DBMD: XMLManager : init : IOException");
    }
  }



  public Document getDocument()
  {
    return document_;
  }



  public void saveDocument()
  {
    String xmlfile = AppProperties.getInstance().getProperties()
      .getProperty("XMLFILE");
    try (FileWriter fout = new FileWriter(xmlfile)) {
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      outputter.output(document_, fout);
      fout.close();
    } catch (IOException ioe) {
      System.err.printf("%s\n",
        "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlfile);
      throw new RuntimeException(
        "DBMD: XMLManager : saveDocument : error writing to file");
    }
  }
}
