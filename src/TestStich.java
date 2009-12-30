
public class TestStich {

	int x = 0;
	
	
	
	public TestStich(int x)
	{
		this.x = x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void dump(boolean b){}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestStich s = new TestStich(4);
		s.dump(false);
	}

}
