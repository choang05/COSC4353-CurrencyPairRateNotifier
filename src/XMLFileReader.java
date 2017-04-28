import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLFileReader
{
	 public static double xmlJdom(String pair)  throws InterruptedException
	 {
	 	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 
		try
		{
			PriceUpdater priceUpdater = new PriceUpdater();
			PriceObserver obs1 = new PriceObserver(priceUpdater);

			DocumentBuilder documentBuilder =factory.newDocumentBuilder();
		   URL url = new URL("http://rates.fxcm.com/RatesXML");
		   URLConnection connection = url.openConnection();
		   connection.setRequestProperty("User-Agent", "Mozilla/5.0");

			Document document = documentBuilder.parse(connection.getInputStream());
			System.out.println("Root element :" + document.getDocumentElement().getNodeName());
			NodeList list=document.getElementsByTagName("Rate");

			for (int temp = 0; temp < list.getLength(); temp++)
			{
				Node node = list.item(temp);
				System.out.println("\nCurrent Element :" + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element e = (Element) node;
					priceUpdater.setSymbol(e.getAttribute("Symbol"));
					priceUpdater.setBid(Double.parseDouble(e.getElementsByTagName("Bid").item(0).getTextContent()));
					priceUpdater.setAsk(Double.parseDouble(e.getElementsByTagName("Ask").item(0).getTextContent()));
					priceUpdater.setHigh(Double.parseDouble(e.getElementsByTagName("High").item(0).getTextContent()));
					priceUpdater.setLow(Double.parseDouble(e.getElementsByTagName("Low").item(0).getTextContent()));
					priceUpdater.setDir(Double.parseDouble(e.getElementsByTagName("Direction").item(0).getTextContent()));

					if(priceUpdater.getSymbol().equalsIgnoreCase(pair))
					{
						NodeList list1 = e.getChildNodes();
						for ( int j = 0; j<list1.getLength(); j++)
						{
							Node node1 = list1.item(j);
							if(node1.getNodeType()==Node.ELEMENT_NODE)
							{
								Element e1 = (Element)node1;
								if(e1.getTagName()=="Bid")
								{
								  return Double.parseDouble(e1.getTextContent());
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("Wrong input");
		System.exit(0);
  		return 0;
	}
}
