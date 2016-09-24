

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

	@Test
	public void test() {
		System.out.println("\n------Test No Coin to crank ---------"); 
		gm1.turnCrank();
		assertEquals(false, gm1.isGumballInSlot());
		gm1.takeGumballFromSlot();
	}
	
	//2.5
	@Test
	public void testNoEnoughCoinCrank()
	{
		System.out.println("\n------Test No Enough Coin to crank ---------"); gm1.insertDime();
		gm1.insertNickel();
		gm1.insertQuarter();
		gm1.turnCrank();
		assertEquals(false, gm1.isGumballInSlot()); gm1.takeGumballFromSlot();
	}
	
	//Test requirement 2.3
	@Test
	public void testEnoughCoinCrank()
	//test if have enough coin, 50 cents in the machine // and turn crank
	{
	System.out.println("\n------Test have Enough Coin to crank ---------"); gm1.insertQuarter();
	gm1.insertNickel();
	gm1.insertDime();
	gm1.insertQuarter();
	gm1.turnCrank();
	assertEquals(true, gm1.isGumballInSlot()); gm1.takeGumballFromSlot();
	assertEquals(false, gm1.isGumballInSlot());
	}
	
	//Test requirement 2.4
	@Test
	public void testEnoughCoinsForTwoCrank() {
	//test have more than 50 cents to crank,
	//and have other enough 50 cents to crank again
	//test if have coin but not enough, 50 cents in the machine // and turn crank
	System.out.println("\n------Test have Enough Coin for two gumball and crank ---------"); gm1.insertQuarter();

	gm1.insertNickel();
	gm1.insertQuarter();
	gm1.turnCrank();
	assertEquals(true, gm1.isGumballInSlot()); gm1.insertQuarter();
	gm1.insertQuarter();
	gm1.insertDime();
	gm1.turnCrank(); gm1.takeGumballFromSlot(); assertEquals(false, gm1.isGumballInSlot());
	}
	
	@Test
	public void testNoEnoughCoinsForTwoCrank() 
	//test have more than 50 cents to crank,
	// but have not other enough 50 cents to crank again
	{
	System.out.println("\n------Test have not Enough Coin for two gumball and crank ---------"); gm1.insertQuarter();
	gm1.insertNickel();
	gm1.insertQuarter();
	gm1.insertNickel();
	gm1.turnCrank();
	assertEquals(true, gm1.isGumballInSlot()); gm1.turnCrank(); gm1.takeGumballFromSlot(); assertEquals(false, gm1.isGumballInSlot());
	}
	@Test
	public void testEjectAllCoins() //test inset coins and eject all coins 
	{
	System.out.println("\n------Test insert Coin and eject all coins ---------"); gm1.insertQuarter();
	gm1.insertNickel();
	gm1.insertDime();
	gm1.insertQuarter();
	gm1.ejectCoin();
	assertEquals(false, gm1.isGumballInSlot()); gm1.takeGumballFromSlot();
	}

	//2.3
	@Test
	public void testEjectCoinsAfterTakeGumball() 
	{
	//test eject left coins after take gumball
	System.out.println("\n------Test insert Coin and eject left coin after take gumball ---------"); gm1.insertNickel();
	gm1.insertQuarter();
	gm1.insertDime();
	gm1.insertQuarter();
	gm1.insertNickel();
	gm1.insertQuarter();
	gm1.turnCrank();
	assertEquals(true, gm1.isGumballInSlot()); gm1.takeGumballFromSlot(); assertEquals(false, gm1.isGumballInSlot()); gm1.ejectCoin();
	} 

}
