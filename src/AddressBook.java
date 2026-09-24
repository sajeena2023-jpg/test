
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<BuddyInfo> bud = new ArrayList();

    public AddressBook() {
    }













    public void addBuddy(BuddyInfo buddy) {
        this.bud.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        this.bud.remove(buddy);
    }

    public static void main(String[] args) {
        System.out.println("addddd book");
        AddressBook book = new AddressBook();
        BuddyInfo person1 = new BuddyInfo("sajeescdscdsna", "jksdnkdnksndks way", "202");
        book.addBuddy(person1);
        book.removeBuddy(person1);
    }
    //gdh6ft86tf
}
