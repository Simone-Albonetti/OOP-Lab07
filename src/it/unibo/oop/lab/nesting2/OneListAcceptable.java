package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {
	
	private List<T> listToCheck;
		
	public OneListAcceptable (List<T> list) {
		this.listToCheck = list;
		}

	@Override
	public Acceptor<T> acceptor() {
		return new OneListAcceptor<T>();
	}
	
	private class OneListAcceptor<T> implements Acceptor<T>{
				
		//private final List<T> listAcceptor =  new ArrayList(listToCheck);
		private final Iterator<T> it = (Iterator<T>) listToCheck.iterator();
				
		@Override
		public void accept(T newElement) throws ElementNotAcceptedException {
			if (this.it.hasNext()) {
				if (!(this.it.next().equals(newElement))){
					throw new ElementNotAcceptedException(newElement);
				}	
			} else {
				this.end();
				throw new ElementNotAcceptedException(newElement);
			}
					
		}

		@Override
		public void end() throws EndNotAcceptedException {
			if(this.it.hasNext()) {
				throw new EndNotAcceptedException();
			} 
			
		}
	}
}

