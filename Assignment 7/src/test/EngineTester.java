package test;
import biginteger.*;

public class EngineTester 
{
	public static void main(String args[])
	{
		BigIntegerEngine test = new BigIntegerEngineImpl();
		test.setOperand(1, "500");
		test.setOperand(2, "1");
		test.setOperand(3, "3000");
		test.setOperand(4, "545");
		
		System.out.println(test.getSum());
		
	}

}
