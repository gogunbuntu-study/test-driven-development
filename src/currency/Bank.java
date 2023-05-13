package currency;

import java.util.Hashtable;

public class Bank {
	
	private Hashtable<Pair, Integer> rates = new Hashtable<>();

	void addRate(String from, String to, int rate) {
		rates.put(new Pair(from, to), Integer.valueOf(rate));
	}
	
	public Money reduce(Expression source, String to) {
		return source.reduce(this, to);
	}

	public int rate(String from, String to) {
		if(from.equals(to)) return 1;
		Integer rate = (Integer) rates.get(new Pair(from, to));
		return rate.intValue();
	}

	private class Pair {
		private String from;
		private String to;
		
		Pair(String from, String to) {
			this.from = from;
			this.to = to;
		}
		
		@Override
		public boolean equals(Object object) {
			Pair pair = (Pair) object;
			return this.from.equals(pair.from) && this.to.equals(pair.to); 
		}
		
		@Override
		public int hashCode() {
			return 0;
		}
	}
}