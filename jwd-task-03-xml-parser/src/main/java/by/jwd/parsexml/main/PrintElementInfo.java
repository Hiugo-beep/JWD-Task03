package by.jwd.parsexml.main;

import by.jwd.parsexml.entity.Element;

public class PrintElementInfo {
	public static void print(Element element) {
		if(element != null) {
			System.out.println(element.getElementContent());
		}
	}
}
