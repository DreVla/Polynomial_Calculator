/**
vlad
Mar 19, 2018

*/

package tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.Monom;
import model.Polinom;

public class PolinomTest {
	ArrayList<Monom> mon1 = new ArrayList<Monom>();
	ArrayList<Monom> mon2 = new ArrayList<Monom>();
	ArrayList<Monom> monRez = new ArrayList<Monom>();
	int grad1,grad2;
	Polinom pol1;
	Polinom pol2;
	Polinom polRez;
	
	@Test 
	public void testAddition() {
		mon1.add(new Monom(0, 3));
		mon1.add(new Monom(1, (float) 6.31));
		mon1.add(new Monom(2, 23));
		mon1.add(new Monom(3, (float) 0.4));
		mon2.add(new Monom(0, (float) 4.2));
		mon2.add(new Monom(1, 41));
		mon2.add(new Monom(2, 0));
		pol1 = new Polinom(3, mon1);
		pol2 = new Polinom(2, mon2);
		Polinom sum = pol1.adunare(pol2);
		monRez.add(new Monom(0, (float) 7.2));
		monRez.add(new Monom(1, (float) 47.31));
		monRez.add(new Monom(2, (float) 23));
		monRez.add(new Monom(3, (float) 0.4));
		polRez = new Polinom(3, monRez);
		assertEquals(sum.toString(),polRez.toString());
	}
	
	@Test 
	public void testSubtraction() {
		mon1.add(new Monom(0, 21));
		mon1.add(new Monom(1, 4));
		mon1.add(new Monom(2, 23));
		mon1.add(new Monom(3, 8));
		mon2.add(new Monom(0, 3));
		mon2.add(new Monom(1, 5));
		mon2.add(new Monom(2, 2));
		pol1 = new Polinom(3, mon1);
		pol2 = new Polinom(2, mon2);
		Polinom sub = pol1.scadere(pol2);
		monRez.add(new Monom(0, 18));
		monRez.add(new Monom(1, -1));
		monRez.add(new Monom(2, 21));
		monRez.add(new Monom(3, 8));
		polRez = new Polinom(3, monRez);
		assertEquals(sub.toString(),polRez.toString());
	}
	
	@Test 
	public void testMul() {
		mon1.add(new Monom(0, 5));
		mon1.add(new Monom(1, 1));
		mon1.add(new Monom(2, 2));
		mon2.add(new Monom(0, 2));
		mon2.add(new Monom(1, 3));
		pol1 = new Polinom(3, mon1);
		pol2 = new Polinom(2, mon2);
		Polinom mul = pol1.inmultire(pol2);
		monRez.add(new Monom(0, 10));
		monRez.add(new Monom(1, 17));
		monRez.add(new Monom(2, 7));
		monRez.add(new Monom(3, 6));
		polRez = new Polinom(5, monRez);
		assertEquals(mul.toString(),polRez.toString());
	}
	
	@Test 
	public void testIntegrate() {
		mon1.add(new Monom(0, 3));
		mon1.add(new Monom(1, 4));
		mon1.add(new Monom(2, 21));
		mon1.add(new Monom(3, 4));
		pol1 = new Polinom(3, mon1);
		Polinom integ = pol1.integrare();
		monRez.add(new Monom(0, (float) 0));
		monRez.add(new Monom(1, (float) 3));
		monRez.add(new Monom(2, (float) 2));
		monRez.add(new Monom(3, (float) 7));
		monRez.add(new Monom(4, (float) 1));
		polRez = new Polinom(4, monRez);
		assertEquals(integ.toString(),polRez.toString());
	}
	
	@Test 
	public void testDerivate() {
		mon1.add(new Monom(0, 3));
		mon1.add(new Monom(1, (float) 6.31));
		mon1.add(new Monom(2, 23));
		mon1.add(new Monom(3, (float) 0.4));
		pol1 = new Polinom(3, mon1);
		Polinom deriv = pol1.derivare();
		monRez.add(new Monom(0, (float) 6.31));
		monRez.add(new Monom(1, (float) 46));
		monRez.add(new Monom(2, (float) 1.2));
		polRez = new Polinom(2, monRez);
		assertEquals(deriv.toString(),polRez.toString());
	}
	
	
}
