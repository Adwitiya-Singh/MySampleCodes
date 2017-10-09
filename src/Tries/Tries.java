package Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tries {

	private class Node
	{
		Character data;
		boolean isTerminal;
		HashMap<Character,Node> children;
		
		Node(Character data,boolean isTerminal)
		{
			this.data=data;
			this.isTerminal=isTerminal;
			this.children=new HashMap<>();
		}
		
	}

	Node root;
	int numWords;
	
	Tries()
	{
		this.root=new Node('\0',false);
		this.numWords=0;
	}
	
	public int numWords()
	{
		return this.numWords;
	}
	
	public boolean isEmpty()
	{
		return this.numWords==0;
	}
	
	public void addWords(String word)
	{
		this.addWords(root, word);
	}
	
	private void addWords(Node parent,String word)
	{
		if(word.length()==0)
		{
			if(parent.isTerminal)
			{
				
			}else{
				parent.isTerminal=true;
				this.numWords++;
			}
			
			return;
		}
		
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(ch);
		
		if(child==null)
		{
			child = new Node(ch,false);
			parent.children.put(ch,child);
		}
		
		this.addWords(child, ros);
	}

	public void DisplayAsWords()
	{
		this.DisplayAsWords(this.root,"");
	}
	
	private void DisplayAsWords(Node node,String osf)
	{
		if(node.isTerminal)
		{
			String ToPrint = (osf + node.data).substring(1);
			System.out.println(ToPrint);
		}
		
		Set<Map.Entry<Character,Node>> children = node.children.entrySet();
		
		for(Map.Entry<Character,Node> child : children)
		{
			this.DisplayAsWords(child.getValue(),osf + node.data );
		}
	}

	public void remove(String word)
	{
		this.remove(root, word);
	}
	
	private void remove(Node parent,String word)
	{
		if(word.length()==0)
		{
			if(parent.isTerminal)
			{
				parent.isTerminal=false;
				this.numWords--;
			}else
			{
				
			}
			
			return;
		}
		
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(ch);
		
		if(child==null)
		{
			return;
		}
		
		this.remove(child, ros);
		
		if(!child.isTerminal && child.children.size()==0)
		{
		    parent.children.remove(ch);
		}
	}

	public boolean searchWord(String word)
	{
		return this.searchWord(root, word);
	}
	
	private boolean searchWord(Node parent,String word)
	{
		if(word.length()==0)
		{
			if(parent.isTerminal)
			{
				return true;
			}
			else{
				return false;
			}
		}
		
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(ch);
		
		if(child == null)
		{
			return false;
		}
		
	  return this.searchWord(child,ros);
	}

	public void DisplayAsTree()
	{
		this.DisplayAsTree(root);
	}
	
	private void DisplayAsTree(Node node)
	{
		String str ="";
		
		str += node.data + " => ";
	
		Set<Map.Entry<Character,Node>> children = node.children.entrySet();
		
		for(Map.Entry<Character,Node> child:children)
		{
			str += child.getKey() + " ,";
		}
		
		str += " END";
		
		for(Map.Entry<Character,Node> child:children)
		{
			this.DisplayAsTree(child.getValue());
		}
	}
}
