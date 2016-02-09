package com.smart421.VendingMachine;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.smart421.VendingMachine.change.Change;
import com.smart421.VendingMachine.change.ChangeImpl;
import com.smart421.VendingMachine.change.ChangeUtil;
import com.smart421.VendingMachine.change.ChangeUtilImpl;
import com.smart421.VendingMachine.change.Coin;
import com.smart421.VendingMachine.exceptions.InsufficentChangeException;
import com.smart421.VendingMachine.exceptions.NegativeEntryException;

public class ChangeTests {
	
	static Change changeImpl;
	static ChangeUtil changeUtil;
	private ArrayList<Coin>availableCoins;
	
	@BeforeClass
	public static void setUp(){
		changeImpl=new ChangeImpl();
		changeUtil=new ChangeUtilImpl();
	}
	
	@Before	
	public void setUpCoins(){
		
		availableCoins = new ArrayList<Coin>();
		availableCoins.add(new Coin(100, 10));
		availableCoins.add(new Coin(50, 10));
		availableCoins.add(new Coin(20, 10));
		availableCoins.add(new Coin(10, 10));
		availableCoins.add(new Coin(5, 10));
		availableCoins.add(new Coin(2, 10));
		availableCoins.add(new Coin(1, 10));
		
		changeUtil.updateCoinInventory(availableCoins);
	}
	
	@Test
	public void readInventory(){
		ArrayList<Coin>inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		
		for(Coin coin:inventory)
			System.out.println(coin.toString());
		
		assertTrue(inventory!=null);
	}
	
	@Test
	public void changeInventory(){
		
		changeUtil.updateCoinInventory(availableCoins);
		
		ArrayList<Coin>testInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		
		boolean flag=true;
		
		for(Coin coin:availableCoins){
			Coin test=testInventory.get(testInventory.indexOf(coin));
			
			if(test.getNoOfCoins()!=coin.getNoOfCoins()){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void returnZeroChange() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(0);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	
	
	@Test 
	public void returnSinglePound() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(100);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0&&coin.getDenomination()!=100){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void returnSingleFiftyPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(50);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0&&coin.getDenomination()!=50){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void returnSingleTwentyPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(20);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0&&coin.getDenomination()!=20){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void returnSingleTenPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(10);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0&&coin.getDenomination()!=10){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void returnSingleFivePence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(5);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0&&coin.getDenomination()!=5){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void returnSingleTwoPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(2);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0&&coin.getDenomination()!=2){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void returnSinglePence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(1);
		boolean flag=true;
		for(Coin coin:change){
			if(coin.getNoOfCoins()>0&&coin.getDenomination()!=1){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test
	
	public void rejectNegativeNumbers() throws InsufficentChangeException{
		try {
			ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(-1);
		} catch (NegativeEntryException e) {
			
		}
	}
	
	@Test 
	public void reduceInventorySinglePence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> prevInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(1);
		ArrayList<Coin> inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		boolean flag=true;
		for(Coin coin:change){
			int prevNoOfCoins=inventory.get(inventory.indexOf(coin)).getNoOfCoins();
			int noOfCoins=prevInventory.get(prevInventory.indexOf(coin)).getNoOfCoins();
			if (coin.getDenomination()==1&&prevNoOfCoins==noOfCoins){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void reduceInventoryTwoPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> prevInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(2);
		ArrayList<Coin> inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		boolean flag=true;
		for(Coin coin:change){
			int prevNoOfCoins=inventory.get(inventory.indexOf(coin)).getNoOfCoins();
			int noOfCoins=prevInventory.get(prevInventory.indexOf(coin)).getNoOfCoins();
			if (coin.getDenomination()==2&&prevNoOfCoins==noOfCoins){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void reduceInventoryFivePence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> prevInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(5);
		ArrayList<Coin> inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		boolean flag=true;
		for(Coin coin:change){
			int prevNoOfCoins=inventory.get(inventory.indexOf(coin)).getNoOfCoins();
			int noOfCoins=prevInventory.get(prevInventory.indexOf(coin)).getNoOfCoins();
			if (coin.getDenomination()==5&&prevNoOfCoins==noOfCoins){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void reduceInventoryTenPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> prevInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(10);
		ArrayList<Coin> inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		boolean flag=true;
		for(Coin coin:change){
			int prevNoOfCoins=inventory.get(inventory.indexOf(coin)).getNoOfCoins();
			int noOfCoins=prevInventory.get(prevInventory.indexOf(coin)).getNoOfCoins();
			if (coin.getDenomination()==10&&prevNoOfCoins==noOfCoins){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void reduceInventoryTwentyPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> prevInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(20);
		ArrayList<Coin> inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		boolean flag=true;
		for(Coin coin:change){
			int prevNoOfCoins=inventory.get(inventory.indexOf(coin)).getNoOfCoins();
			int noOfCoins=prevInventory.get(prevInventory.indexOf(coin)).getNoOfCoins();
			if (coin.getDenomination()==20&&prevNoOfCoins==noOfCoins){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void reduceInventoryFiftyPence() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> prevInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(50);
		ArrayList<Coin> inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		boolean flag=true;
		for(Coin coin:change){
			int prevNoOfCoins=inventory.get(inventory.indexOf(coin)).getNoOfCoins();
			int noOfCoins=prevInventory.get(prevInventory.indexOf(coin)).getNoOfCoins();
			if (coin.getDenomination()==50&&prevNoOfCoins==noOfCoins){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test 
	public void reduceInventorySinglePound() throws InsufficentChangeException, NegativeEntryException{
		ArrayList<Coin> prevInventory=(ArrayList<Coin>) changeUtil.getCoinInventory();		
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getChangeFor(100);
		ArrayList<Coin> inventory=(ArrayList<Coin>) changeUtil.getCoinInventory();
		boolean flag=true;
		for(Coin coin:change){
			int prevNoOfCoins=inventory.get(inventory.indexOf(coin)).getNoOfCoins();
			int noOfCoins=prevInventory.get(prevInventory.indexOf(coin)).getNoOfCoins();
			if (coin.getDenomination()==100&&prevNoOfCoins==noOfCoins){
				flag=false;
				break;
			}
		}
		
		assertTrue(flag);
	}
	
	@Test
	public void insufficientChangeWarning() throws  NegativeEntryException{
		ArrayList<Coin> change;
		try {
			change = (ArrayList<Coin>) changeImpl.getChangeFor(10000);
		} catch (InsufficentChangeException e) {
			
		}		
	}
	
	

}
