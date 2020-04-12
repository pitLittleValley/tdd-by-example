package guru.springframework;

import java.util.HashMap;

public class Bank {

	private HashMap<Pair, Integer> rateMap = new HashMap<>();

	Money reduce(Expression source, String toCurrency) {

		return source.reduce(this, toCurrency);
	}

	public int rate(String from, String to) {

		int resultRate = 1;
		if (from.equals(to)) {
			return resultRate;
		}

		if (this.rateMap.containsKey(new Pair(from, to))) {
			resultRate = rateMap.get(new Pair(from, to));
		} else {
			resultRate = 0;
		}
		return resultRate;
	}

	public void addRate(String from, String to, int rate) {
		this.rateMap.put(new Pair(from, to), rate);

	}
}
