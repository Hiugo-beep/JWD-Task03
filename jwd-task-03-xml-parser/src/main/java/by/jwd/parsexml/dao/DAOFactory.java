package by.jwd.parsexml.dao;

import by.jwd.parsexml.dao.impl.ParserDAOImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ParserDAO parserDAO = new ParserDAOImpl();
	
	private DAOFactory() {}
	
	public ParserDAO getParserDAO() {
		return parserDAO;
	}
	
	public static DAOFactory getInstance() {
		return instance;
	}
}
