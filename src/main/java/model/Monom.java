/**
* Dreghici Popa Vlad
* Mar 10, 2018
* Monom class is used to execute operations on
* each element of the polynom
* exp, coef are used for exponent and coefficient
* Methods declared are used for each operation needed
* 
*/

package model;

public class Monom {

	private int exp = 0;
	private float coef = 0;

	public Monom(int exp, float coef) {
		this.coef = coef;
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public float getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}


	public Monom addd(Monom m) {
		return new Monom(this.exp, this.coef + m.getCoef());
	}

	public Monom subtract(Monom m) {
		return new Monom(this.exp, this.coef - m.getCoef());
	}

	public Monom mul(Monom m) {
		return new Monom(this.exp + m.getExp(), this.coef * m.getCoef());
	}

	public Monom div(Monom m) {
		return new Monom(this.exp - m.getExp(), this.coef / m.getCoef());
	}

	public Monom derivate() {
		return new Monom(this.exp - 1, this.coef * this.exp);
	}

	public Monom integrate() {
		if(this.exp == 0) {
			return new Monom(1, this.coef);
		}
		return new Monom(this.exp + 1, this.coef / (this.exp+1));
	}

	public Monom invert() {
		return new Monom(this.exp, this.coef - 2*this.coef);
	}

	@Override
	public String toString() {
		if(this.coef > 0) return "+" + this.coef + "x^" + this.exp;
		else if(this.coef < 0) return this.coef + "x^" + this.exp;
		else return "";
	}

}
