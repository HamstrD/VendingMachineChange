package com.smart421.VendingMachine.change;

import java.util.ArrayList;
import java.util.Collection;

public interface ChangeUtil {

	/**
	 * Retrieve current inventory of coins from 'coins-inventory' properties file. 
	 * @return Collection<Coin>
	 */
	public Collection<Coin> getCoinInventory();
	
	/**
	 * Update properties file 'coin-inventory' with new data of the state of inventory.
	 * @param newInventory
	 */
	public void updateCoinInventory(Collection<Coin> newInventory);

	/**
	 * Setup a selection of coins to be used to implement 'OptimalChange' method, unlimited by amount.
	 * @return Collection<Coin>
	 */
	public Collection<Coin> setUpCoins();

	/**
	 * Calculate amount total sum of coins within an amount of change.
	 * @param change
	 * @return int 
	 */
	public int sumOfChange(Collection<Coin> change);

	/**
	 * Arrange coin inventory in descending order of denomination. Using selection method of sorting.
	 * @param inventory
	 */
	public void sortInventory(ArrayList<Coin> inventory);

	

}
