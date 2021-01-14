package by.jwd.parsexml.entity;

import java.util.List;

import by.jwd.parsexml.behavior.TreeTraversal;
import by.jwd.parsexml.behavior.impl.TreeTraversalImpl;

public class Element {
	private String name;
	private List<Attribute> attributes;
	private List<Element> childElements;
	private String content;
	public static long serialVersionUID = 1L;
	
	public Element() {
		this.name = "";
		this.attributes = null;
		this.childElements = null;
		this.content = null;
	}
	public Element(String name) {
		this.name = name;
		this.attributes = null;
		this.childElements = null;
		this.content = null;
	}	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public List<Element> getChildElements() {
		return childElements;
	}
	
	public void setChildElements(List<Element> childElements) {
		this.childElements = childElements;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((childElements == null) ? 0 : childElements.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (childElements == null) {
			if (other.childElements != null)
				return false;
		} else if (!childElements.equals(other.childElements))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String childNamesToPrint = "";
		for(int i = 0;i < this.childElements.size();i++ ) {
			childNamesToPrint += this.childElements.get(i).getName();
			childNamesToPrint += "\n";
		}
		
		String attributeToPrint = "";
		for(int i =0; i< this.attributes.size();i++) {
			attributeToPrint += this.attributes.get(i).getName() ;
			attributeToPrint += " = ";
			attributeToPrint += this.attributes.get(i).getContent() ;
		}
		String contentToPrint = "";
		if(this.content != null) {
			contentToPrint = this.content;
		}
		return this.getClass().getName() + "@"
				+ "name: " + this.name
				+ ", childElements: " + childNamesToPrint
				+ ", Attributes: " + attributeToPrint
				+ ", content: " + contentToPrint;
	}

	
	public String getElementContent() {
		if(this.content != null) return this.content;
		TreeTraversal treeTraversal = new TreeTraversalImpl();
		String contentRootElement = treeTraversal.getTreeContent(this);
		return contentRootElement;
	}
}


