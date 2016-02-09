package com.smart421.VendingMachine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.smart421.VendingMachine.change.Change;
import com.smart421.VendingMachine.change.ChangeImpl;
import com.smart421.VendingMachine.change.ChangeUtil;
import com.smart421.VendingMachine.change.ChangeUtilImpl;
import com.smart421.VendingMachine.change.Coin;

public class OptimalChangeSampleTests {
	

	
	static Change changeImpl;
	static ChangeUtil changeUtil;
	
	@BeforeClass
	public static void setUp(){
		changeImpl=new ChangeImpl();
		changeUtil=new ChangeUtilImpl();
	}
	
	@Test
	public void noOfCoinsTest() throws Exception{
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(150);
		
		assertTrue(change.get(0).getNoOfCoins()==1&&change.get(1).getNoOfCoins()==1);
		assertTrue(changeUtil.sumOfChange(change)==150);
	}
	
	@Test
	public void sumOfCoinsTest() throws Exception{
		int pence=150;
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(pence);
		
		assertTrue(changeUtil.sumOfChange(change)==pence);
	}
	
	@Test
	public void largeNumberTest() throws Exception{
		int pence=999999999;
		
		ArrayList<Coin> change=(ArrayList<Coin>) changeImpl.getOptimalChangeFor(pence);
		
		assertTrue(changeUtil.sumOfChange(change)==pence);
	}

}
