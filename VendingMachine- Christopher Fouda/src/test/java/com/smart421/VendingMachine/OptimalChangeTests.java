package com.smart421.VendingMachine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.smart421.VendingMachine.change.Change;
import com.smart421.VendingMachine.change.ChangeImpl;
import com.smart421.VendingMachine.change.Coin;
import com.smart421.VendingMachine.exceptions.NegativeEntryException;

public class OptimalChangeTests {
	static Change changeImpl;
	
	@BeforeClass
	public static void setUp(){
		changeImpl=new ChangeImpl();
	}
	
	@Test
	public void returnZeroChange() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(0);
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
	public void returnSinglePound() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(100);
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
	public void returnSingleFiftyPence() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(50);
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
	public void returnSingleTwentyPence() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(20);
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
	public void returnSingleTenPence() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(10);
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
	public void returnSingleFivePence() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(5);
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
	public void returnSingleTwoPence() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(2);
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
	public void returnSinglePence() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(1);
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
	
	public void rejectNegativeNumbers(){
		ArrayList<Coin> change;
		try {
			change = (ArrayList<Coin>) changeImpl.getOptimalChangeFor(-1);
		} catch (NegativeEntryException e) {
			// TODO Auto-generated catch block
		}
	}

}
