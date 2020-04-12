package guru.springframework;

public class Money implements Expression {

	protected int amount;
	protected String currency;

	public Money(int amount2, String currency) {
		this.currency = currency;
		this.amount = amount2;
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	protected String currency() {
		return currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Money other = (Money) obj;
		return this.amount == other.amount && this.currency.equals(other.currency);
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

	@Override
	public Expression times(int multiplier) {
		return new Money(amount * multiplier, this.currency);
	}

	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	@Override
	public Money reduce(Bank bank, String to) {

		return new Money(amount / bank.rate(currency, to), to);
	}
}