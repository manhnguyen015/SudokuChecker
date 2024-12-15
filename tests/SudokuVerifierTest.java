import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
	//  correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
	//  incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

SudokuVerifier v = new SudokuVerifier();
	
	@Test
	public void testcorrectSudoku() {
		int a = v.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("correct string", a, 0);
		
	}
	
	@Test
	public void testtooShortString() {
		int a = v.verify("41736982563215894795872431682543716979158643234691275828964357157329168416487529");
		assertEquals("too short String", a, -1);
		
	}
	
	@Test
	public void testtooLongString() {
		int a = v.verify("4173698256321589479587243168254371697915864323469127582896435715732916841648752931");
		assertEquals("too long String", a, -1);
		
	}
	
	@Test
	public void testnotDigit() {
		int a = v.verify("4173698256321589479587243168254371#9791586432346912758289643571573291684164875293");
		assertEquals("String contains other than digits", a, 1);
		
	}
	
	@Test
	public void testzeroDigit() {
		int a = v.verify("017369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("String contains zero", a, -1);
		
	}
	
	@Test
	public void testincorrectSubgrid() {
		int a = v.verify("447369825632158947958724316825437169791586432346912758289643571573291684164875293");
		assertEquals("incorrect subgrid", a, -2);
		
	}
	
	@Test
	public void testincorrectRow() {
		int a = v.verify("417469825632158947958723316825437169791586432346912758289643571573291684164875293");
		assertEquals("incorrect row", a, -3);
		
	}
	
	@Test
	public void testincorrectColumn() {
		int a = v.verify("417369825632158947958724316425837169791546832386912754289643571573291684164875293");
		assertEquals("incorrect column", a, -4);
		
	}
}
