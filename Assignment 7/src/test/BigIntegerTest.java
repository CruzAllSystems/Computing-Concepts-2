package test;
import static org.junit.Assert.*;
import org.junit.Test;
import biginteger.BigIntegerEngine; 
import biginteger.BigIntegerEngineImpl;

public class BigIntegerTest 
{

	@Test
	public void operandTests() {
		BigIntegerEngine engine = new BigIntegerEngineImpl();
		String out = engine.toString();
		assertTrue(out.equals("0\n0\n0\n0\n"));
		for(int i=0; i<BigIntegerEngine.MAX_OPERANDS; i++)
		{
			assertEquals("0", engine.getOperand(i+1));
		}
		assertTrue(engine.setOperand(1, "1"));
		assertTrue(engine.setOperand(2, "2"));
		assertTrue(engine.setOperand(3, "3"));
		assertTrue(engine.setOperand(4, "4"));
		assertTrue(engine.toString().equals("1\n2\n3\n4\n"));
		System.out.println("SUCCESS, first sets work and so does default constructor");
		assertEquals(engine.getOperand(1), "1");
		assertEquals(engine.getOperand(2), "2");
		assertEquals(engine.getOperand(3), "3");
		assertEquals(engine.getOperand(4), "4");
		assertEquals(engine.getOperand(0), "");
		assertEquals(engine.getOperand(5), "");
		System.out.println("SUCCESS, getOperand working");
		assertTrue(engine.setOperand(1,"1234567890123456789"));
		assertEquals(engine.getOperand(1), "1234567890123456789");
		assertTrue(engine.setOperand(1, "0"));
		assertEquals(engine.getOperand(1), "0");
		assertEquals(engine.getOperand(-1), "");
		assertFalse(engine.setOperand(5, "5"));
		assertFalse(engine.setOperand(1, "-1"));
		assertFalse(engine.setOperand(1, ""));
		assertFalse(engine.setOperand(5, ";;3320234=2-20-30-04$$$$$"));
		assertFalse(engine.setOperand(-2, "1"));
		assertFalse(engine.setOperand(-1, "1"));
		assertFalse(engine.setOperand(BigIntegerEngine.MAX_OPERANDS+1, ""));
		engine.clearOperands();
		assertEquals(engine.getOperand(1),"0");
		assertEquals(engine.getOperand(2),"0");
		assertEquals(engine.getOperand(3),"0");
		assertEquals(engine.getOperand(4),"0");
		System.out.println("SUCCESS, clearOperands working.");
		System.out.println("SUCCESS,  all operand tests pass.");
	}
	@Test
	public void getSum1Tests()
	{
		BigIntegerEngine engine = new BigIntegerEngineImpl();
		String answer = engine.getSum();
		assertEquals(answer, "0");
		engine.setOperand(1,"1");
		answer = engine.getSum();
		assertEquals(answer,"1");
		engine.setOperand(1, "9");
		answer = engine.getSum();
		assertEquals(answer,"9");
		engine.setOperand(1, "999");  
		answer = engine.getSum();
		assertEquals(answer,"999");
		engine.clearOperands();
		answer = engine.getSum();
		assertEquals(answer, "0");
		engine.setOperand(4,  "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000");
		answer = engine.getSum();
		assertEquals(answer, "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000");
		System.out.println("SUCCESS, getSum1Tests() pass.");
		
	}
	@Test
	public void getSum2Tests()
	{
		BigIntegerEngine engine = new BigIntegerEngineImpl();
		String answer="";
		engine.setOperand(3, "19");
		engine.setOperand(4, "0");
		answer = engine.getSum();
		assertEquals(answer, "19");
		engine.clearOperands();
		answer = engine.getSum();
		assertEquals(answer, "0");
		engine.setOperand(1, "1");
		answer = engine.getSum();
		assertEquals(answer,"1");
		engine.setOperand(2, "9");
		answer = engine.getSum();
		assertEquals(answer,"10");
		engine.setOperand(2, "999");  
		answer = engine.getSum();
		assertEquals(answer,"1000");
		engine.setOperand(1,"0");
		engine.setOperand(2, "0");
		engine.setOperand(3, "1");
		engine.setOperand(4, "2");
		answer = engine.getSum();
		assertEquals(answer, "3");
		engine.setOperand(3,"333");
		answer = engine.getSum();
		assertEquals(answer, "335");
		engine.setOperand(4, "111");
		answer = engine.getSum();
		assertEquals(answer, "444");
		engine.setOperand(3, "8");
		engine.setOperand(4, "1111");
		answer = engine.getSum();
		assertEquals(answer, "1119");
		engine.setOperand(3, "0");
		engine.setOperand(4, "19");
		answer = engine.getSum();
		assertEquals(answer, "19");
		engine.setOperand(3, "19");
		engine.setOperand(4, "0");
		answer = engine.getSum();
		assertEquals(answer, "19");
		engine.clearOperands();
		engine.setOperand(2, "3");
		engine.setOperand(3, "7");
		answer = engine.getSum();
		assertEquals(answer, "10");
		engine.clearOperands();
		engine.setOperand(2, "3333333333333333333333333333333333333333");
		engine.setOperand(3, "7888888888888888888888888888888888888888");
		answer = engine.getSum();
		assertEquals(answer, "11222222222222222222222222222222222222221");	
		engine.clearOperands();
		engine.setOperand(1, "3333333333333333333333333333333333333333");
		engine.setOperand(4, "7888888888888888888888888888888888888888");
		answer = engine.getSum();
		assertEquals(answer, "11222222222222222222222222222222222222221");	
		System.out.println("SUCCESS, getSum2Tests pass.");
	}
	@Test
	public void getSumMultipleTests()
	{
		BigIntegerEngine engine = new BigIntegerEngineImpl();
		String answer="";
		answer = engine.getSum();
		assertEquals(answer, "0");
		for(int i=0; i< BigIntegerEngine.MAX_OPERANDS; i++)
		{
			engine.setOperand(i+1, "5");
		}
		answer = engine.getSum();
		assertEquals(answer, "20");
		engine.setOperand(1, "1000000000000000");
		answer = engine.getSum();
		assertEquals(answer, "1000000000000015");
		engine.clearOperands();
		engine.setOperand( BigIntegerEngine.MAX_OPERANDS, "10000000000");
		answer = engine.getSum();
		assertEquals(answer, "10000000000");
		engine.setOperand(1,"9");
		engine.setOperand(2, "99");
		engine.setOperand(3, "999");
		engine.setOperand(4, "9999");
		answer = engine.getSum();
		assertEquals(answer, "11106");
		engine.setOperand(1, "1");
		engine.setOperand(2, "10");
		engine.setOperand(3, "100");
		engine.setOperand(4, "1000");
		answer = engine.getSum();
		assertEquals(answer, "1111");
		engine.clearOperands();
		answer = engine.getSum();
		assertEquals(answer, "0");
		engine.setOperand(1, "888");
		engine.setOperand(4, "9");
		answer = engine.getSum();
		assertEquals(answer, "897");
		engine.setOperand(3, "111");
		answer = engine.getSum();
		assertEquals(answer, "1008");
		engine.setOperand(2, "999");
		answer = engine.getSum();
		assertEquals(answer, "2007");
		engine.setOperand(2, "3333333333333333333333333333333333333333");
		engine.setOperand(3, "7888888888888888888888888888888888888888");
		engine.setOperand(1, "3333333333333333333333333333333333333333");
		engine.setOperand(4, "7888888888888888888888888888888888888888");
		answer=engine.getSum();
		assertEquals(answer, "22444444444444444444444444444444444444442");
		System.out.println("SUCCESS, add MultipleTests pass.");
	}

}
