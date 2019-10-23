package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exception.divisionparzero;
import tp.*;

public class operationteste {
	@Test
	public void test() throws divisionparzero 
	{
		operation  op1 = operation.plus;
		
		double somme= op1.evaluation(3, 3);
		
		assertTrue("addition",somme==6);
		
	}
	@Test
	public void test1 () throws divisionparzero {
		operation op1= operation.moins;
		 double resultat= op1.evaluation(2,6);
		 assertTrue("soustraction",resultat==4);
	}
	@Test
	public void test2 () throws divisionparzero {
		operation op1= operation.div;
		double resultat= op1.evaluation(4, 2);
		assertTrue("division",resultat==2);
	}
	@Test
	public void test3 () throws divisionparzero {
		operation op1= operation.multi;
		double resultat= op1.evaluation(3, 2);
		assertTrue("multiplications",resultat==6);
	}
	
	
	
	
	

}
