package by.jwd.parsexml.service;

import by.jwd.parsexml.service.impl.ParserServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ParserService parserService = new ParserServiceImpl();
	
	private ServiceFactory() {}

	public ParserService getParserService() {
		return parserService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}
}
