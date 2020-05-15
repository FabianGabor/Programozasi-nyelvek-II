import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static BufferedReader in;
    private final List<MenuItem> itemList;
    private final MenuItem exitItem;
    private String title;

    public Menu() {
        this.itemList = new ArrayList<MenuItem>();

        Menu.in = new BufferedReader(new InputStreamReader(System.in));
        //this.setTitle("Menu");

        this.exitItem = new MenuItem("Kilépés"); // A root menu will exit from the program

        this.exitItem.setExitItem(true); // Let the MenuItem know that it is the exit item for this menu
    }

    public void addItem(MenuItem item) { this.itemList.add(item); }

    public void execute() {
        MenuItem item = null;
        do {
            this.print();
            item = this.getUserInput();
            item.invoke();
        }
        while(!item.isExitItem());
    }

    private int getExitIndex() { return this.itemList.size() + 1; }

    private MenuItem getUserInput() {
        MenuItem item = null;
        String input = null;

        try {
            input = Menu.in.readLine();
            int option = Integer.parseInt(input); // Throws NumberFormatException for non-numberic input

            if (option < 1 || option > this.getExitIndex())
                throw new NumberFormatException(); // Taking advantage of above to catch out-of-range numbers

            if (option == this.getExitIndex()) {
                item = exitItem;
                Menu.in.close();
            }
            else item = itemList.get(option - 1); // -1 as itemList(0) -> item 1 in printed menu
        }
        catch (NumberFormatException ex) {
            System.out.println("\nHiba: '" + input + "' nem lehetséges választás!");
            item = new MenuItem(null); // Return a dummy menu item which ensures it cannot be invoked
        }
        catch (IOException ex) { ex.printStackTrace(); }
        finally { return item; }
    }

    private void print() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");

        for (int i = 0; i < this.itemList.size(); i++)
            sb.append("\n" + (i + 1) + ". " + this.itemList.get(i).getLabel());

        sb.append("\n" + getExitIndex() + ". " + exitItem.getLabel());
        sb.append("\n");

        System.out.print(sb.toString());
    }

    public void setTitle(String title) { this.title = title; }

    public String toString() {
        return "menu=[" + this.title + "]  items=" + this.itemList.toString();
    }
}
