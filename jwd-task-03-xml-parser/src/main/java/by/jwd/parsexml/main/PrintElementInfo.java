package by.jwd.parsexml.main;

import by.jwd.parsexml.entity.Element;

public class PrintElementInfo {
	public static void print(Element element) {
		boolean isEmpty = element == null ;
		if( !isEmpty ) {
			TreeTraversal tr = new TreeTraversalImpl();
			System.out.println(tr.getTreeContent(element));
		}
	}
}
