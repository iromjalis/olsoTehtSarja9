
public class Main {
	public static void main(String[] args) {
		view.ValuuttakoneenGUI.main(args);
		Valuutta v = new Valuutta("EUR", 1.01);
		v.getNimi();
		v.getVaihtokurssi();
	}
}
