package com.smart421.VendingMachine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.smart421.VendingMachine.change.Change;
import com.smart421.VendingMachine.change.ChangeImpl;
import com.smart421.VendingMachine.change.ChangeUtil;
import com.smart421.VendingMachine.change.ChangeUtilImpl;
import com.smart421.VendingMachine.change.Coin;
import com.smart421.VendingMachine.exceptions.InsufficentChangeException;
import com.smart421.VendingMachine.exceptions.NegativeEntryException;

public class ChangeSampleTests {
	
	static Change changeImpl;
	static ChangeUtil changeUtil;
	ArrayList<Coin>availableCoins=new ArrayList<Coin>();
	
	@BeforeClass
	public static void setUp(){
		changeImpl=new ChangeImpl();
		changeUtil=new ChangeUtilImpl();
	}
	
	@Before
	public  void setUpCoins(){
		
		availableCoins = new ArrayList<Coin>();
		availableCoins.add(new Coin(100, 100));
		availableCoins.add(new Coin(50, 100));
		availableCoins.add(new Coin(20, 100));
		availableCoins.add(new Coin(10, 100));
		availableCoins.add(new Coin(5, 100));
		availableCoins.add(new Coin(2, 100));
		availableCoins.add(new Coin(1, 100));
		
		changeUtil.updateCoinInventory(availableCoins);
	}
	
	@Test
	public void smallSampleTest() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin>result=(ArrayList<Coin>) changeImpl.getChangeFor(26);
		int sum=changeUtil.sumOfChange(result);
		
		assertTrue(sum==26);
	}
	
	@Test
	public void largeSampleTest() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin>result=(ArrayList<Coin>) changeImpl.getChangeFor(2687);
		int sum=changeUtil.sumOfChange(result);
		
		assertTrue(sum==2687);
	}

	
	
	public void InsufficientChangeSampleTest(){
		
		availableCoins=new ArrayList<Coin>();
		availableCoins.add(new Coin(100,0));
		availableCoins.add(new Coin(50,0));
		availableCoins.add(new Coin(20,0));
		availableCoins.add(new Coin(10,0));
		availableCoins.add(new Coin(5,0));
		availableCoins.add(new Coin(2,0));
		availableCoins.add(new Coin(1,0));
		
		changeUtil.updateCoinInventory(availableCoins);
		
		try {
			ArrayList<Coin>result=(ArrayList<Coin>) changeImpl.getChangeFor(2687);
			fail();
		
		} catch (NegativeEntryException e) {
			fail();
		} catch (InsufficentChangeException e) {
			
		}
	}
	
	
	
	

}
