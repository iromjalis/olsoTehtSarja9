package model;

/**
 * @author Irina Romjalis
 */

public interface IValuuttakone {
	public abstract String[] getVaihtoehdot();
	public abstract double muunna(int mistäIndeksi, int mihinIndeksi, double määrä);
}
