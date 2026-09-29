//edited on github
import java.util.ArrayList;

public class AddressBook {


    public AddressBook(ArrayList<BuddyInfo> bud) {
        this.bud = bud;
    }

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
        BuddyInfo person1 = new BuddyInfo("sajeena", "jksdnkdnksndks way", "202");
        book.addBuddy(person1);
        book.removeBuddy(person1);
    }
    //https://github.com/sajeena2023-jpg/test.git
}

//how are you today and this is me using the branch setting
