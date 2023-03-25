public class Valuutta {

	public String nimi;
	public double vaihtokurssi;
	
	private Valuutta(String n, double v) {
		this.nimi = n;
		this.vaihtokurssi = v;
	}
	public String getNimi() {
//		System.out.println(nimi);
		return nimi;}
	public double getVaihtokurssi() {
//		System.out.println(vaihtokurssi);
		return vaihtokurssi;}
	public void setVaihtokurssi(double vaihtokurssi) {
		this.vaihtokurssi = vaihtokurssi;
//		this.getVaihtokurssi();
		}
}
