package OOPs;

public class DynamicQueueClient {

	public static void main(String[] args) {
		try{
			Queue qu;
			qu=new DynamicQueue(5);
			for(int i=0;i<5;i++){
				qu.enqueue(5-i);
				displayquackInfo(qu);
			}
			System.out.println("Point 1");
			qu.enqueue(100);
			displayquackInfo(qu);
			System.out.println("Point 2");
			while(!qu.isEmpty()){
//				System.out.println(qu.front());
				System.out.println(qu.dequeue());
				displayquackInfo(qu);
			}
			System.out.println("Point 3");
			qu.dequeue();
			System.out.println("Point 4");
		}
		catch(Exception ex){
			System.out.println(ex);
			System.out.println("still Running");
		}
		
	}
	public static void displayquackInfo(Queue qu){
		System.out.println("Size = "+qu.size());
		System.out.println("Empty = "+qu.isEmpty());
		qu.display();
	}

	}


