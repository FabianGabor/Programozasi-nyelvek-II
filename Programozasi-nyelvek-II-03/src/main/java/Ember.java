public class Ember {
    public String nev;
    public int szuletesiEv;
    public boolean nem;
    public int jovedelem;

    public Ember() {
        this.nev = "Tudo R. Akos";
        this.szuletesiEv = 1987;
        this.nem = true;
        this.jovedelem = 0;
    }

    public Ember(String nev, int szuletesiEv, boolean nem, int jovedelem) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
        this.nem = nem;
        this.jovedelem = jovedelem;
    }

    public Ember(String nev, int szuletesiEv, boolean nem) {
        this.nev = nev;
        this.szuletesiEv = szuletesiEv;
        this.nem = nem;
        this.jovedelem = 0; // nincs atadva parameterkent, de ez lesz az alapertelmezett
    }

    public static void main (String[] args) {

    }
}
