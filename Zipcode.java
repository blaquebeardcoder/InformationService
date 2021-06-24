public class Zipcode extends ServiceCommunicator{
    public Zipcode(String serviceURL, String zipcode) {
        super(serviceURL + zipcode);
    }
    public Zipcode() {}

    //test code
    public static void main(String[] args) {
        Zipcode zip = new Zipcode("http://api.zippopotam.us/us/", "10452");
        System.out.println(zip.get());
    }
}

