/**
Dreghici Popa Vlad
Mar 10, 2018
Polinom class for operations and initializations
 */

package model;

import java.util.ArrayList;

public class Polinom {

	private int grad;
	private ArrayList<Monom> monoame = new ArrayList<Monom>();

	public Polinom(int grad,ArrayList<Monom> monoame) {
		this.grad = grad;
		this.monoame = monoame;
	}

	public int getGrad() {
		return grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}

	public ArrayList<Monom> getMonoame() {
		return monoame;
	}

	public void setMonoame(ArrayList<Monom> monoame) {
		this.monoame = monoame;
	}
	
	/**	toString used to print polynomials
	 * use a string builder to build our string
	 * append concatenates each string
	 */
	@Override
	public String toString() {
		StringBuilder polinomBuilder = new StringBuilder(); 
		for(Monom m : this.monoame) {
			polinomBuilder.append(m.toString());
		}
		String polinom = polinomBuilder.toString();
		return polinom;
	}
	
	/** Addition made on 2 branches
	 * 1. first grade > second grade
	 * create new ArrayList which takes monoms of first one
	 * Add coefficients when exponents equal
	 * 2.first grade < second grade
	 * create new ArrayList which takes monoms of second polynomial
	 * Add coefficients when exponents equal
	 */
	public Polinom adunare(Polinom p) { 
		if(this.grad >= p.getGrad()) {
			ArrayList<Monom> sumaMonoame = new ArrayList<Monom>(this.monoame);
			for(Monom m1 : sumaMonoame) { 
				for(Monom m2 : p.getMonoame()) {
					if(m1.getExp() == m2.getExp()) {
						sumaMonoame.set(m1.getExp(), m1.addd(m2)); 
					}
				}
			}
			return new Polinom(this.grad, sumaMonoame);
		} else { 
			ArrayList<Monom> sumaMonoame = new ArrayList<Monom>(p.getMonoame());
			for(Monom m1 : sumaMonoame) {
				for(Monom m2 : this.monoame) {
					if(m1.getExp() == m2.getExp()) {
						sumaMonoame.set(m1.getExp(), m1.addd(m2));
					}
				}
			}
			return  new Polinom(p.getGrad(), sumaMonoame);
		}
	}
	
	/* Similar to addition, subtraction executed on 2 branches
	 * 1. grad1 > grad2
	 * new ArrayList with monoms from first polynomial
	 * subtract at equal exponent
	 * 2 . grad1 < grad2
	 * new ArrayList with monoms from second polynomial
	 * subtract at equal exponent
	 * at the end, invert the remaining coefficients from second polynomial
	 */
	public Polinom scadere(Polinom p) {
		if(this.grad >= p.getGrad()) {
			ArrayList<Monom> difMonoame = new ArrayList<Monom>(this.monoame); 
			for(Monom m1 : difMonoame) {
				for(Monom m2 : p.getMonoame()) { 
					if(m1.getExp() == m2.getExp()) { 
						difMonoame.set(m1.getExp(), m1.subtract(m2));
					}	
				}
			}
			return new Polinom(this.grad,difMonoame);
		} else {
			ArrayList<Monom> difMonoame = new ArrayList<Monom>();
			for(Monom m1 : this.monoame) {
				for(Monom m2 : p.getMonoame()) {
					if(m1.getExp() == m2.getExp()) {
						difMonoame.add(m1.subtract(m2));
					}
				}
			} 
			for(Monom m : p.getMonoame()) {
				if(m.getExp() >= this.grad) {
					difMonoame.add(m.invert()); 
				}
			}
			return new Polinom(p.getGrad(),difMonoame);
		}
	}
	
	/* Multiply
	 * new ArrayList filled with 0's
	 * traverse the two polynomials
	 * set each element to be equal to him + the sum of 
	 * same exponent elements
	 */
	public Polinom inmultire(Polinom p) { 
		ArrayList<Monom> mulMonoame = new ArrayList<Monom>(); 
		for(int i = 0 ; i < this.grad + p.getGrad() - 1 ; i++) {
			mulMonoame.add(new Monom(i, 0 )); 
		}
		for(int i = 0 ; i < this.grad ; i++) {
			for(int j = 0 ; j < p.getGrad() ; j++) {
				mulMonoame.set(i+j, mulMonoame.get(i+j).addd(this.monoame.get(i).mul(p.getMonoame().get(j))));
			}
		}
		return new Polinom(this.grad + p.getGrad(), mulMonoame);
	}	
	
	public Polinom impartire(Polinom p) {
		ArrayList<Monom> cat = new ArrayList<Monom>();
		ArrayList<Monom> rest = new ArrayList<Monom>();
		int exp2 = p.getGrad();
		while(this.grad > p.getGrad()) {
			Monom monomel = this.getMonoame().get(0).div(p.getMonoame().get(0));
			cat.add(monomel);
			Polinom aux = new Polinom(1, cat);
			aux = aux.inmultire(p);
			Polinom thes = this.scadere(aux);
			exp2--;
		}
		return new Polinom(this.grad, cat);
	}
	
	/* Derivate operation
	 * Use derivate method from Monom class
	 */
	public Polinom derivare() {
		ArrayList<Monom> monoameDerivate = new ArrayList<Monom>();
		for(Monom m : this.monoame) {
			if(m.getExp()!=0) {
				monoameDerivate.add(m.derivate());
			}
		}
		return new Polinom(this.grad, monoameDerivate);
	}
	
	/* Integrate operation
	 * Use integrate method from Monom class
	 */
	public Polinom integrare() {
		ArrayList<Monom> monoameIntegrate = new ArrayList<Monom>();
		for(Monom m : this.monoame) {
			monoameIntegrate.add(m.integrate()); 
		}
		return new Polinom(this.grad, monoameIntegrate);
	}
}
