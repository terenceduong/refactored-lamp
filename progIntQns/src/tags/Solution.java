package tags;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Tag aTag = new Tag("html");
		aTag.addAttribute("class", "brown");
		aTag.addAttribute("class", "green");
		aTag.addAttribute("alt", "v1");
		aTag.addAttribute("alt", "v1");
		Tag bTag = new Tag("div");
		bTag.addAttribute("class", "brown");
		aTag.addTag(bTag);
		Tag cTag = new Tag("p");
		cTag.addAttribute("alt", "brown");
		aTag.addTag(cTag);
		Tag dTag = new Tag("span");
		dTag.addAttribute("class", "orange");
		bTag.addTag(dTag);
		System.out.println(aTag.toString());
//		System.out.println();
//		System.out.println(aTag.getClass("brown"));
//		System.out.println();
//		System.out.println(aTag.tags);
	}
}

class Tag {
	String name;
	HashMap<String, ArrayList<String>> attributes = new HashMap<String, ArrayList<String>>();
	ArrayList<Tag> tags = new ArrayList<Tag>();
	
	Tag(String name) { 
		this.name = name;
	}
	
	public void addTag(Tag newTag) {
		if (!tags.contains(newTag)) {
			tags.add(newTag);
		}
	}
	
	public ArrayList<Tag> getClass(String searchValue) {
		ArrayList<Tag> out = new ArrayList<Tag>();
		ArrayList<Tag> frontier = new ArrayList<Tag>();
		frontier.add(this);
		while(frontier.size() != 0) {
			Tag thisTag = frontier.remove(0);
			if (thisTag.attributes.containsKey("class")) {
				if (thisTag.attributes.get("class").contains(searchValue)) {
					out.add(thisTag);
				}
			}
			
			for (int i = 0; i < thisTag.tags.size(); i++) {
				frontier.add(thisTag.tags.get(i));
			}
		}
		return out;
	}
	
//	public ArrayList<Tag> getClassRec(String searchValue, ArrayList<Tag> out, ArrayList<Tag> frontier) {
//		while(frontier.size() != 0) {
//			Tag thisTag = frontier.remove(0);
//			if (thisTag.attributes.containsKey("class")) {
//				if (thisTag.attributes.get("class").contains(searchValue))
//					out.add(this);
//			}
//			
//			for (int i = 0; i < thisTag.tags.size(); i++) {
//				frontier.add(thisTag.tags.get(i));
//			}
//		}
//		
//		return out;
//	}
	
	public void addAttribute(String attributeName, String attributeValue) {
		ArrayList<String> attrValueList = null;
		
		// attribute list contains this new attribute name
		if (attributes.containsKey(attributeName)) {
			if (!attributes.get(attributeName).contains(attributeValue)) {
				attrValueList = attributes.remove(attributeName);
				attrValueList.add(attributeValue);
				attributes.put(attributeName, attrValueList);
			}
		} else {
			ArrayList<String> newValues = new ArrayList<String>();
			newValues.add(attributeValue);
			attributes.put(attributeName, newValues);
		}
	}
	
	public String printChildren(Tag thisTag, String tabs) {
		StringBuilder sb = new StringBuilder();
		sb.append(tabs + "<" + thisTag.name);
		
		for (String attr : thisTag.attributes.keySet()) {
			sb.append(" " + attr + "=\"");
			String space = "";
			for (int i = 0; i < thisTag.attributes.get(attr).size(); i++) {
				sb.append(space + thisTag.attributes.get(attr).get(i));
				space = " ";
			}
			sb.append("\"");
		}
		sb.append(">\n");
		
		for (int i = 0; i < thisTag.tags.size(); i++) {
			sb.append(printChildren(thisTag.tags.get(i), tabs + "\t"));
		}
		
		sb.append(String.format("%s</%s>%n", tabs, thisTag.name));
		return sb.toString();
		
	}
	
	@Override
	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("<" + name);
//		
//		for (String attr : attributes.keySet()) {
//			sb.append(" " + attr + "=\"");
//			String space = "";
//			for (int i = 0; i < attributes.get(attr).size(); i++) {
//				sb.append(space + attributes.get(attr).get(i));
//				space = " ";
//			}
//			sb.append("\"");
//		}
//		sb.append(">\n");
//		
//		sb.append(printChildren(this));
//		
//		sb.append(String.format("</%s>", name));
//		return sb.toString();
		return printChildren(this, "");
	}
	
	
	
}
