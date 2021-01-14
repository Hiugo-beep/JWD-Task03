package by.jwd.parsexml.dao.impl;


import by.jwd.parsexml.dao.ParserDAO;
import by.jwd.parsexml.entity.Element;
import by.jwd.parsexml.parser.Parser;
import by.jwd.parsexml.reader.ParserReader;
import by.jwd.parsexml.reader.impl.ParserReaderImpl;

public class ParserDAOImpl implements ParserDAO{

	@Override
	public Element parse(String fileName) {
		ParserReader reader = new ParserReaderImpl();
		String fileRead = reader.readFile(fileName);
		
		Parser tree = new Parser(); //Stack используется в этмоу классе
		Element rootElement = tree.createElement(fileRead);
		return rootElement;
	}
}
