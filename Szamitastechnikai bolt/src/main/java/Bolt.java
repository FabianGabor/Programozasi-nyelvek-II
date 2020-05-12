import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedMap;

public class Bolt implements BoltInterface{
	SortedMap<int, Hardware> arukeszlet;
	int forgotoke;

	public Bolt() {
	}

	public Bolt(int forgotoke) {
		this.forgotoke = forgotoke;
	}

	public Bolt(SortedMap<int, Hardware> arukeszlet, int forgotoke) {
		this.arukeszlet = arukeszlet;
		this.forgotoke = forgotoke;
	}

	public SortedMap<int, Hardware> getArukeszlet() {
		return arukeszlet;
	}

	public void setArukeszlet(SortedMap<int, Hardware> arukeszlet) {
		this.arukeszlet = arukeszlet;
	}

	public int getForgotoke() {
		return forgotoke;
	}

	public void setForgotoke(int forgotoke) {
		this.forgotoke = forgotoke;
	}

	@Override
	public SortedMap<int, Hardware> feltolt(String allomanynev) {
		SortedMap<int, Hardware> arukeszlet;

		try (BufferedReader reader = new BufferedReader(new FileReader(allomanynev))) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean vesz(Hardware ezt) {
		return false;
	}

	@Override
	public boolean elad(int ezt) {
		return false;
	}

	@Override
	public Hardware kerescikkszam(int ezt) {
		return null;
	}

	@Override
	public int keresmegnevezes(String ezt) {
		return 0;
	}
}
