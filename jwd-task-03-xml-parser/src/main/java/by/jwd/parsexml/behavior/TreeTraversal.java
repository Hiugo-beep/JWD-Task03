package by.jwd.parsexml.behavior;

import by.jwd.parsexml.behavior.TreeTraversal;
import by.jwd.parsexml.entity.Element;

public interface TreeTraversal  implements TreeTraversal {
	private String treeContent = "";
	private int counter = 1;
	
	@Override
	public String getTreeContent(Element ob) {
		setTreeContent(ob);
		return treeContent;
	}
	
	private void setTreeContent(Element ob) 
	{
		if (ob!= null) {		  
			if(ob.getContent() == "") {
				for(Element child: ob.getChildElements())
				{
					setTreeContent(child);
				}
				counter++;
				treeContent += "\n";
			}else 
				treeContent += counter+") " + ob.getContent()+"\n";
		}
	}
}
