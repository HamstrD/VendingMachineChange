package com.smart421.VendingMachine.change;

import java.util.Collection;

import com.smart421.VendingMachine.exceptions.InsufficentChangeException;
import com.smart421.VendingMachine.exceptions.NegativeEntryException;

public interface Change {

	/**
	 * Calculate the optimal amount of change, in coins, that can be made for a submitted amount.
	 * @param pence
	 * @return Collection<Coin>
	 * @throws Exception 
	 */
	public Collection<Coin> getOptimalChangeFor(int pence) throws NegativeEntryException;

	/**
	 * Calculate the optimal amount of change, in coins, that can be made for a submitted 
	 * amount using a limited inventory of coins.
	 * @param pence
	 * @return Collection<Coin>
	 * @throws InsufficentChangeException 
	 * @throws NegativeEntryException 
	 */
	public Collection<Coin> getChangeFor(int pence) throws InsufficentChangeException, NegativeEntryException;

}
