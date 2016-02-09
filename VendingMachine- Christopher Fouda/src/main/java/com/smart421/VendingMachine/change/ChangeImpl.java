package com.smart421.VendingMachine.change;

import java.util.ArrayList;
import java.util.Collection;

import com.smart421.VendingMachine.exceptions.InsufficentChangeException;
import com.smart421.VendingMachine.exceptions.NegativeEntryException;

public class ChangeImpl implements Change {

	ChangeUtil util = new ChangeUtilImpl();
	ArrayList<Coin> availCoins = (ArrayList<Coin>) util.setUpCoins();

	@Override
	public Collection<Coin> getOptimalChangeFor(int pence) throws NegativeEntryException,NumberFormatException {
		try {
			//Validation that negative numbers will not be submitted.
			if (pence < 0)
				throw new NegativeEntryException();

			ArrayList<Coin> change = new ArrayList<Coin>();

			for (Coin coin : availCoins) {
				int temp = pence;
				int noOfCoins = 0;
				int denom = coin.getDenomination();
				
				//Reduce the amount of change by current denomination to the maximum.
				while (temp > 0) {
					temp -= denom;
					noOfCoins++;
					
					if (temp < 0) {
						temp += denom;
						noOfCoins--;
						break;
					}
				}
				
				pence -= (denom * noOfCoins);
				change.add(new Coin(denom, noOfCoins));
			}
			return change;
		} catch (NegativeEntryException e) {
			System.out.println("Can not accept negative numbers");
			throw e;
		} catch (NumberFormatException e) {
			System.out.println("Can not accept negative numbers");
			throw e;
		}
	}

	@Override
	public Collection<Coin> getChangeFor(int pence) throws InsufficentChangeException, NegativeEntryException,NumberFormatException {
		try {
			//Validation that negative numbers will not be submitted.
			if (pence < 0)
				throw new NegativeEntryException();

			availCoins = (ArrayList<Coin>) util.getCoinInventory();
			ArrayList<Coin> change = new ArrayList<Coin>();

			for (Coin coin : availCoins) {
				int temp = pence;
				int noOfCoins = 0;
				int availNoOfCoins = coin.getNoOfCoins();
				int denom = coin.getDenomination();
				
				//Reduce the amount of change by current denomination to the maximum.
				while (temp > 0) {
					temp -= denom;
					noOfCoins++;
					availNoOfCoins--;
					//Testing also that there is enough coins in the Inventory.
					if (temp < 0 || availNoOfCoins < 0) {
						temp += denom;
						noOfCoins--;
						break;
					}
				}
				
				pence -= (denom * noOfCoins);
				coin.setNoOfCoins(availCoins.get(availCoins.indexOf(coin)).getNoOfCoins() - noOfCoins);
				change.add(new Coin(denom, noOfCoins));
			}

			//Give exception if not enough change in inventory, otherwise save changes to inventory
			//and return change.
			if (pence > 0)
				throw new InsufficentChangeException();
			else {
				util.updateCoinInventory(availCoins);
				return change;
			}
		} catch (InsufficentChangeException e) {
			System.out.println("Insufficient Change Available");
			throw e;
		} catch (NegativeEntryException e) {

			System.out.println("Can not accept negative numbers");
			throw e;
		} catch (NumberFormatException e) {
			System.out.println("Can not accept negative numbers");
			throw e;
		}
	}

}
