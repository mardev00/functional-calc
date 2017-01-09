package com.mardev.calculator.service;

import java.util.Iterator;


public class Stack<T> implements Iterable<T> {
private Node first;
int N;

public void push(T T)
{
   Node oldfirst = first;
   Node n = new Node();
   n.T = T;
   n.next = oldfirst;
   first = n;
   N++;   

}

public T peek()
{
	if(first == null)
		return null;
	else
		return first.T;
			
}


public T  pop()
{
   T T = first.T;
   first = first.next;
   N--;
   return T;
}


public boolean isEmpty() 
{
   return first == null;

}

public int size()
{
   return N;
}

private class Node
{
   private T T;
   private Node next;

}



   public Iterator<T> iterator() {
      return new ListIterator();
   }

private class ListIterator implements Iterator<T>
   {  
      private Node current = first;
      public boolean hasNext() 
      {
         return current.next != null;
      }

      public void remove() { }

      public T next() 
      {
         T T = current.T;
         current = current.next;
         return T;

      }

   }


}
