package com.smart421.VendingMachine.change;

public class Coin{

	private int denomination;
	private int noOfCoins;

	public Coin() {
	};

	public Coin(int denomination) {
		this.denomination = denomination;
	}

	public Coin(int denomination, int amount) {
		this.denomination = denomination;
		this.noOfCoins = amount;
	}

	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	public int getNoOfCoins() {
		return noOfCoins;
	}

	public void setNoOfCoins(int noOfCoins) {
		this.noOfCoins = noOfCoins;
	}

	public int sumOfCoins() {
		return noOfCoins * denomination;
	}

	public String toString() {

		if (denomination == 100)
			return "£1 x " + noOfCoins;
		else
			return denomination + "p x " + noOfCoins;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coin) {
			Coin temp = (Coin) obj;
			if (temp.getDenomination() == this.denomination)
				return true;
		}
		return super.equals(obj);
	}

}
