package by.jwd.parsexml.service.impl;

import by.jwd.parsexml.service.ParserService;
import by.jwd.parsexml.service.validation.Validator;
import by.jwd.parsexml.entity.Element;
import by.jwd.parsexml.dao.ParserDAO;
import by.jwd.parsexml.dao.DAOFactory;

public class ParserServiceImpl implements ParserService{

	@Override
	public Element parse(String fileName) {
		if(!Validator.fileNameValidator(fileName)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ParserDAO parserDAO = factory.getParserDAO();
		
		Element rootElement = parserDAO.parse(fileName);
		return rootElement;	
	}
}
