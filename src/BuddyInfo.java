
public class BuddyInfo {
    private String name;
    private String number;
    private String address;

    public String getName() {
        return this.name;
    }

    public BuddyInfo() {
        this("", "", "");
    }

    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BuddyInfo buddy = new BuddyInfo("Homr", "4555 kendly way", "613");
        System.out.println("Hello " + buddy.getName());
    }
}
