package controller;

import model.IValuuttakone;
import view.ValuuttakoneenGUI;

public class ValuuttakoneenOhjain implements IValuuttakoneenOhjain{
	Valuuttakone valuuttakone;
	ValuuttakoneenGUI gui;
	
    public ValuuttakoneenOhjain(ValuuttakoneenGUI gui) {
    	this.gui = gui;
    }
    @Override
	public String[] getValuutat() {
		String[] valuutat = valuuttakone.getVaihtoehdot();
		return valuutat;
	}
    @Override
	public void muunnos() {
		int lahtoIndeksi = gui.getLähtöIndeksi();
		int kohdeIndeksi = gui.getKohdeIndeksi();
		double maara = gui.getMäärä();
		double muunnettu = valuuttakone.muunna(lahtoIndeksi, kohdeIndeksi, maara);
		
		gui.setTulos(muunnettu);
	}
}