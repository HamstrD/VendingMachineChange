package com.smart421.VendingMachine.change;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Properties;

public class ChangeUtilImpl implements ChangeUtil {

	@Override
	public int sumOfChange(Collection<Coin> change) {
		int sum = 0;
		for (Coin coin : change) {
			sum += coin.sumOfCoins();
		}
		return sum;
	}

	@Override
	public Collection<Coin> getCoinInventory() {
		InputStream in = null;
		Properties prop = new Properties();
		ArrayList<Coin> inventory = new ArrayList<Coin>();
		
		try {
			in = new FileInputStream("coin-inventory.properties");
			prop.load(in);

			Enumeration<?> denominationsProp = prop.propertyNames();
			
			//Convert extracted properties to Coin objects.
			while (denominationsProp.hasMoreElements()) {
				int denom = Integer.parseInt("" + denominationsProp.nextElement());
				Coin coin = new Coin(denom, Integer.parseInt(prop.getProperty("" + denom)));
				inventory.add(coin);
			}
			
			//Sort list from highest denomination to lowest.
			sortInventory(inventory);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return inventory;
	}

	@Override
	public void updateCoinInventory(Collection<Coin> newInventory) {
		Properties prop = new Properties();
		OutputStream out;
		try {
			out = new FileOutputStream("coin-inventory.properties");

			for (Coin coin : newInventory) {
				prop.setProperty("" + coin.getDenomination(), "" + coin.getNoOfCoins());
			}

			prop.store(out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sortInventory(ArrayList<Coin> inventory) {

		for (int i = 0; i < inventory.size() - 1; i++) {
			
			int index = i;
			
			for (int j = i + 1; j < inventory.size(); j++)
				if (inventory.get(j).getDenomination() > inventory.get(index).getDenomination())
					index = j;

			Coin largerCoin = inventory.get(index);
			inventory.set(index, inventory.get(i));
			inventory.set(i, largerCoin);
		}

	}

	@Override
	public Collection<Coin> setUpCoins() {
		ArrayList<Coin> availableCoins;

		availableCoins = new ArrayList<Coin>();
		availableCoins.add(new Coin(100, 10));
		availableCoins.add(new Coin(50, 10));
		availableCoins.add(new Coin(20, 10));
		availableCoins.add(new Coin(10, 10));
		availableCoins.add(new Coin(5, 10));
		availableCoins.add(new Coin(2, 10));
		availableCoins.add(new Coin(1, 10));

		return availableCoins;
	}

}
