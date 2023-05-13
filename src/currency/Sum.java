package currency;

public class Sum implements Expression {
	Money augend;
	Money addend;

	public Sum(Money augend, Money addend) {
		this.augend = augend;
		this.addend = addend;
	}
	
	public Money reduce(Bank bank, String to) {
//		int amount = this.augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount;
		int amount = this.augend.amount + this.addend.amount;

		return new Money(amount, to);
	}
	
//	@Override
//	public Expression plus(Money addend) {
//		return new Sum(this, addend);
//	}
//	
//	public Expression times(int multiplier) {
//		return new Sum(augend.times(multiplier), addend.times(multiplier));
//	}
}
