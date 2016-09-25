

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GumballMachineTestDrive1 {

	private GumballMachine gm1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception { gm1 = new GumballMachine(5); 
	}
	
	@After
	public void tearDown() throws Exception {
	}

	
	@Test //test1
	public void testNoCoinCrank() {
		System.out.println("====No coin inserted, and crank====");
		gm1.turnCrank();
		assertEquals(false, gm1.isGumballInSlot());
		gm1.takeGumballFromSlot();
	}
	
	
	@Test //test2
	public void testNoEnoughCoinCrank()
	{
		System.out.println("====insert 0.40, and crank====");
		gm1.insertDime();
		//System.out.println(gm1.getCoin());
		gm1.insertNickel();
		//System.out.println(gm1.getCoin());
		gm1.insertQuarter();
		//System.out.println(gm1.getCoin());
		gm1.turnCrank();
		//System.out.println(gm1.getCoin());
		assertEquals(40, gm1.getCoin()); 
		//gm1.takeGumballFromSlot();
	}
	
	@Test //test3
	public void testOneDollarCrank()
	{
		System.out.println("====1.00, and crank====");
		gm1.insertQuarter();
		//System.out.println(gm1.getCoin());
		gm1.insertQuarter();
		//System.out.println(gm1.getCoin());
		gm1.insertQuarter();
		//System.out.println(gm1.getCoin());
		gm1.insertQuarter();
		gm1.turnCrank();
		gm1.turnCrank();
		//System.out.println(gm1.getCoin());
		//assertEquals(1, gm1.getGumballInSlot()); 
		//gm1.takeGumballFromSlot();
		assertEquals(1, gm1.getGumballInSlot());
	}
	
	@Test //test4
	public void test50centCrankand50centCrank()
	{
		System.out.println("====0.5, then crank, and do it again====");
		gm1.insertQuarter();
		//System.out.println(gm1.getCoin());
		gm1.insertQuarter();
		gm1.turnCrank();
		//System.out.println(gm1.getCoin());
		gm1.insertQuarter();
		//System.out.println(gm1.getCoin());
		gm1.insertQuarter();
		gm1.turnCrank();
		assertEquals(true, gm1.isGumballInSlot()); 
		//System.out.println(gm1.getCoin());
		//assertEquals(1, gm1.getGumballInSlot()); 
		gm1.takeGumballFromSlot();
		assertEquals(false, gm1.isGumballInSlot());
	}
	
	@Test //test5
	public void testEjectCoin() //test inset coins and eject all coins 
	{
		System.out.println("====0.5, then eject coins===="); 
		gm1.insertQuarter();
		gm1.insertNickel();
		gm1.insertDime();
		gm1.insertDime();
		gm1.ejectCoin();
		assertEquals(false, gm1.isGumballInSlot()); 
		assertEquals(0, gm1.getCoin());
	}
	
}
