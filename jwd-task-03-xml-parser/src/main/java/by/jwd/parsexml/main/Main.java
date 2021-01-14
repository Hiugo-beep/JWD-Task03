package by.jwd.parsexml.main;

import by.jwd.parsexml.entity.Element;
import by.jwd.parsexml.service.ServiceFactory;
import by.jwd.parsexml.service.ParserService;

public class Main {
	private static String FILE_XML_PATH = "resources/doc.xml";
	public static void main(String[] args) {
		Element rootElement;
		
		ServiceFactory factory = ServiceFactory.getInstance();
		ParserService parser = factory.getParserService();
		/////////////////////////////////////////////////////
		
		rootElement = parser.parse(FILE_XML_PATH);
		
		PrintElementInfo.print(rootElement);
	}
}