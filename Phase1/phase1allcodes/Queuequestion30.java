package phase1allcodes;

import java.util.*;

public class Queuequestion30 
{
public static void main(String[] args)

{
	Queue<String> locationsQueue = new LinkedList<>();
    locationsQueue.add("USA");
	locationsQueue.add("UK");
	locationsQueue.add("LA");
	locationsQueue.add("CUBA");
	locationsQueue.add("CHINA");
    System.out.println("Queue is : " + locationsQueue);
	System.out.println("Head of Queue : " + locationsQueue.peek());
	locationsQueue.remove();
	System.out.println("After removing Head of Queue : " + locationsQueue);
	System.out.println("Size of Queue : " + locationsQueue.size());
}
}
