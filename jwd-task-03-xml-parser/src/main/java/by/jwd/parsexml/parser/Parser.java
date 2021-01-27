package by.jwd.parsexml.parser;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.jwd.parsexml.entity.Element;
import by.jwd.parsexml.stack.Stack;
import by.jwd.parsexml.entity.Attribute;

public class Parser {
	private Stack stack = null;
	public Parser() {
		stack = new Stack();
	}
	
	public Element createElement(String fileRead) {
		Element rootElement = null;
		
		String tagSeparator = "\n+|\t+|\f+";
		String[] result;
		Pattern pattern = Pattern.compile(tagSeparator);
		result = pattern.split(fileRead);
		List<String> tags = new ArrayList<>();

		for(String str:result) {
			tags.add(str);
		}
		

		String[] bufResult;
		String tagEndSeparator = ">+";
		for(String strTag:tags) {
				Pattern tagPattern = Pattern.compile(tagEndSeparator);
				bufResult = tagPattern.split(strTag);
				
				Pattern tagPatternStart = Pattern.compile("<");
				Matcher attributeTagStart;
				
				Pattern tagPatternEnd = Pattern.compile("</");
				Matcher attributeTagEnd = tagPatternEnd.matcher(strTag);
						
				boolean isTagStart = false;
				boolean isTagEnd = false;
				
					for(String tagElement: bufResult) {
						
						String buf[];
						attributeTagStart = tagPatternStart.matcher(tagElement);
						attributeTagEnd = tagPatternEnd.matcher(tagElement);
						
						isTagStart = attributeTagStart.find();
						isTagEnd = attributeTagEnd.find();
						
						buf = tagPatternStart.split(tagElement);
						if(isTagEnd) {
							if(buf.length > 1) {
								if(!(buf[0] == "" || buf[1] == "") ){
									stack.getLastElement().setContent(buf[0]);;
								}
							}
							if(stack.getSize() == 1) {
								rootElement = stack.getLastElement();
								stack.pop();
								return rootElement;
							}
							stack.pop();
						}
						else if(isTagStart) {
							
							
							pattern = Pattern.compile("\s+|=\"|\"");
							String[] strAtr = pattern.split(buf[1]);
							if(strAtr.length != 1) {
								stack.push(strAtr[0]);
								List<Attribute> attr = new ArrayList<Attribute>();
								for(int i=1;i<strAtr.length;i+=3) {
									attr.add(new Attribute(strAtr[i],strAtr[i+1]));
								}
								stack.getLastElement().setAttributes(attr);
							}
							else stack.push(buf[1]);
				
						}
					}
			}
			
		return rootElement;
	}
}
