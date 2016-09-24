

public class GumballMachine implements IGumballMachine{
 
	State soldOutState;
	State noEnoughCoinState;
	State hasEnoughCoinState;
	State soldState;
 
	State state = soldOutState;
	int count = 0; //
	int coin = 0;
	int gumballInSlot = 0;
 
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noEnoughCoinState = new NoEnoughCoinState(this);
		hasEnoughCoinState = new HasEnoughCoinState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noEnoughCoinState;
		} 
	}
 
	public void insertCoin(int c) {
		state.insertCoin(c);
	}
	
	public void insertQuarter() {
		state.insertCoin(25);
	}
	
	public void insertDime() {
		state.insertCoin(10);
	}
	
	public void insertNickel() {
		state.insertCoin(5);
	}
	
 
	public void ejectCoin() {
		state.ejectCoin();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}
 
	int getCount() {
		return count;
	}
 
	public int getCoin() { return coin;}
	
	public void setCoin(int c) { coin = c;}
	
	public void addGumballInSlot() { gumballInSlot++;}
	
	public int getGumballInSlot() { return gumballInSlot;}
	
	
	void refill(int count) {
		this.count = count;
		state = noEnoughCoinState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoEnoughCoinState() {
        return noEnoughCoinState;
    }

    public State getHasEnoughCoinState() {
        return hasEnoughCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
	
	public boolean isGumballInSlot( ) { //check gumball in slot
		if(gumballInSlot > 0){
			System.out.println("Have gumball in slot.");
			return true; 
		} 
		else{
			System.out.println("No gumball in slot.");
			return false; 
		}
	}
	
	public void takeGumballFromSlot( ) { // take gumball from slot 
		if(isGumballInSlot()){
			System.out.println("Take all " + getGumballInSlot() + " gumball in the slot"); 
			gumballInSlot = 0;
		}
		else System.out.println("Sorry, there is no gumball in slot"); 
	}


}
