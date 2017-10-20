package Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Heap.Heap;

public class HCoder {

	HashMap<Character,String> encoder;
	HashMap<String,Character> decoder;
	
	private class Node implements Comparable<Node> 
	{
		Character data;
		int cost;
		Node left;
		Node right;
		
		Node(Character data,int cost)
		{
			this.data=data;
			this.cost=cost;
			this.left=null;
			this.right=null;
		}
		
		Node(Node left,Node right)
		{
			this.data=data;
			this.cost=left.cost + right.cost;
			this.left=left;
			this.right=right;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.cost-o.cost;
		}

	}

  public HCoder(String feeder)
	{
		HashMap<Character,Integer> freqmap = new HashMap<>();
		
		for(int i=0;i<feeder.length();i++)
		{
			if(freqmap.containsKey(feeder.charAt(i)))
			{
				freqmap.put(feeder.charAt(i), freqmap.get(feeder.charAt(i))+1);
			}
			else{
				freqmap.put(feeder.charAt(i), 1);
			}
		}
		
		Heap<Node> minHeap = new Heap<Node>(true);
		
		Set<Map.Entry<Character, Integer>> entries = freqmap.entrySet();
		
		for(Map.Entry<Character, Integer> entry: entries )
		{
			Node bt = new Node(entry.getKey(),entry.getValue());
			minHeap.add(bt);
		}
		
		while(minHeap.size()!=1)
		{
			Node one = minHeap.remove();
			Node two = minHeap.remove();
			
			minHeap.add(new Node(one,two));
		}
		
		Node ft = minHeap.remove();
		encoder = new HashMap<>();
		decoder = new HashMap<>();
		this.initEncoderDecoder(ft, "");
		
		
	}
	
	private void initEncoderDecoder(Node node,String osf)
	{
		if(node==null)
		{
			return;
		}
		
		if(node.left==null && node.right==null )
		{
			this.encoder.put(node.data,osf );
			this.decoder.put(osf, node.data);
			
		}
		
		this.initEncoderDecoder(node.left, osf + "0");
		this.initEncoderDecoder(node.right,osf + "1");
	}

	public String encoder(String source)
	{
		String str="";
		
		for(int i=0;i<source.length();i++)
		{
			String code = this.encoder.get(source.charAt(i));
			str +=code;
		}
		
		return str;
	}

	public String Decoder(String Codedstring)
	{
		String str="";
		String key="";
		
		for(int i=0;i<Codedstring.length();i++)
		{
			key +=Codedstring.charAt(i);
			
			if(this.decoder.containsKey(key))
			{
				str +=this.decoder.get(key);
				key="";
			}
			
		}
		
		return str;
	}
}
