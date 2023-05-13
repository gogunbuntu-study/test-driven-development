package currency;

import java.util.Objects;

class Money implements Expression {
	protected int amount;
	protected String currency;
	
	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}

	@Override
	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount 
				&& currency().equals(money.currency());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.amount);
	}

	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}
	
	protected String currency() {
		return currency;
	}

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	@Override
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
	
}