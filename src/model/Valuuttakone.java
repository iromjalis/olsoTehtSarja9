package model;

public class Valuuttakone implements IValuuttakone{
//	public Object [][]valuutat={{"Euroopan euro", 1.0},{ "Ruotsin kruunu", 9.4780},{ "Norjan kruunu",
//	8.9018},{ "Yhdysvaltain dollari", 1.0629}};
	
	private ArrayList<Valuutta> valuutat = new ArrayList<>();
	private ValuuttaAccessObject valuutta = new ValuuttaAccessObject();
	
	public Valuuttakone() {
		Valuutta[] valuuttaArr = valuutta.readValuutat();
		for (Valuutta v : valuuttaArr) {
			valuutat.add(v);
		}
	}
	@Override
	public String[] getVaihtoehdot() {
		String[] valuuttataulu = new String[valuutat.size()];
		for (int i = 0; i < valuutat.size(); i++) {
			valuuttataulu[i] = valuutat.get(i).getNimi();
		}
		return valuuttataulu;
	}

	@Override
	public double muunna(int mistäIndeksi, int mihinIndeksi, double määrä) {
		double tulos = määrä/(valuutat.get(mistäIndeksi).getVaihtokurssi());
		
		tulos *= valuutat.get(mihinIndeksi).getVaihtokurssi();
		
		return tulos;
	}
	
}