package by.jwd.parsexml.stack;

import java.util.ArrayList;
import java.util.List;

import by.jwd.parsexml.entity.Element;

public class Stack {

	private List<String> stackTag;
	private List<Element> stackElement;
	
	public Stack() {
		stackTag = new ArrayList<String>();
		stackElement = new ArrayList<Element>();
	}

	public void push(String tag ) {
		stackTag.add(tag);
		stackElement.add(new Element(tag));
		int stackSize = stackElement.size() ;
		if(stackSize > 1) {
			List<Element> child = stackElement.get(stackSize-2).getChildElements();
			if(child == null) {
				child = new ArrayList<Element>();
				
			}
			child.add(stackElement.get(stackSize-1));
			stackElement.get(stackSize-2).setChildElements(child);
		}
	}
	public void  pop() {
		stackTag.remove(stackTag.size() -1 );
		stackElement.remove(stackElement.size() -1);
	}
	
	public String getLastTag(){
		return stackTag.get(stackTag.size() -1 );
	}
	public Element getLastElement() {
		return stackElement.get(stackElement.size() -1 );
	}
	public int getSize () {
		return stackTag.size();
	}
}
