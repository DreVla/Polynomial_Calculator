/**
Dreghici Popa Vlad
Mar 10, 2018
Controller is the link between the model and the view.
The controller must send the input from the user to the model, do the required
actions and after everything is done, return the result back to the view.
Main controller contains the GUI, 2 array lists for monoms and 2 polinoms
All the events are handled through ActionListeners, which is an interface 
that receives action events.
For each button pressed, a certain action is performed. For example when the 
users presses confirm, the coeficients and exponents of the polynoms are read
and saved for future operations.
 */

package controller; //pachetul = colectie de clase si interfete

import java.util.ArrayList; 

import javax.swing.JOptionPane; // pentru folosirea pop-up message

import model.Monom;
import model.Polinom;
import view.PolinomGui;

public class Controller {

	private PolinomGui polinomGui; //declare interfata
	private ArrayList<Monom> monoame1 = new ArrayList<Monom>();
	private ArrayList<Monom> monoame2 = new ArrayList<Monom>();
	private Polinom polinom1;
	private Polinom polinom2;

	public Controller() {
		polinomGui = new PolinomGui(); 
		polinomGui.confirmPress(e->{ 
			if(!polinomGui.getCoef1().equals("") && !polinomGui.getCoef2().equals("")) {
			String[] coeficienti1 = polinomGui.getCoef1().split(","); 
			int grad1 = coeficienti1.length; 
			for(int i = 0 ; i < grad1 ; i++) { 
				monoame1.add(new Monom(i, Float.parseFloat(coeficienti1[i]))); 
			}
			polinom1 = new Polinom(grad1, monoame1); 
			polinomGui.writePolinom1(polinom1.toString()); 
			String coef2 = polinomGui.getCoef2();
			String[] coeficienti2 = coef2.split(",");
			int grad2 = coeficienti2.length;
			for(int i = 0 ; i < grad2 ; i++) {
				monoame2.add(new Monom(i, Float.parseFloat(coeficienti2[i])));
			}
			polinom2 = new Polinom(grad2, monoame2);
			polinomGui.writePolinom2(polinom2.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Insert both polynomials!","Error!", JOptionPane.ERROR_MESSAGE);
			}
		});

		polinomGui.additionPressed(e->{ 
			if(polinomGui.getCoef1().equals("") || polinomGui.getCoef2().equals("")){
				JOptionPane.showMessageDialog(null, "Insert both polynomials!","Error!", JOptionPane.ERROR_MESSAGE);
			}
			Polinom adunare = polinom1.adunare(polinom2); 
			polinomGui.writeResult(adunare.toString());	

		});

		polinomGui.subtractPressed(e->{ 
			if(polinomGui.getCoef1().equals("") || polinomGui.getCoef2().equals("")){
				JOptionPane.showMessageDialog(null, "Insert both polynomials!","Error!", JOptionPane.ERROR_MESSAGE);
			}
			Polinom scadere = polinom1.scadere(polinom2); 
			polinomGui.writeResult(scadere.toString()); 

		});

		polinomGui.multiplyPressed(e->{ 
			if(polinomGui.getCoef1().equals("") || polinomGui.getCoef2().equals("")){
				JOptionPane.showMessageDialog(null, "Insert both polynomials!","Error!", JOptionPane.ERROR_MESSAGE);
			}
			Polinom inmultire = polinom1.inmultire(polinom2);
			polinomGui.writeResult(inmultire.toString());	
		});

		polinomGui.dividePressed(e->{
			if(polinomGui.getCoef1().equals("") || polinomGui.getCoef2().equals("")){
				JOptionPane.showMessageDialog(null, "Insert both polynomials!","Error!", JOptionPane.ERROR_MESSAGE);
			}
			Polinom impartire = polinom1.impartire(polinom2);
			polinomGui.writeResult(impartire.toString());
		});

		polinomGui.derivatePressed(e->{ 
			if(polinom1.getMonoame().size()==0) {
				JOptionPane.showMessageDialog(null, "Insert first polynomial!","Error!", JOptionPane.ERROR_MESSAGE);
			} 
			Polinom derivare = polinom1.derivare(); 
			polinomGui.writeResult(derivare.toString()); 
		});

		polinomGui.integratePressed(e->{ 
			if(polinom1.getMonoame().size()==0) {
				JOptionPane.showMessageDialog(null, "Insert first polynomial","Error!", JOptionPane.ERROR_MESSAGE);
			}
			Polinom integrat = polinom1.integrare(); 
			polinomGui.writeResult(integrat.toString()); 
		});

		polinomGui.resetPressed(e->{ 
			polinom1.getMonoame().clear(); 
			polinom2.getMonoame().clear(); 
			polinomGui.writePolinom1("First polynomial");
			polinomGui.writePolinom2("Second polynomial");
			polinomGui.writeResult("Result");
			polinomGui.resetPolinoame();
		});
	}


}
