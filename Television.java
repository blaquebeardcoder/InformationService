public class Television extends ServiceCommunicator{
    public Television(String serviceURL, String show) {
        super(serviceURL + show);
    }
    //test code
    public static void main(String[] args) {
        Television show = new Television("http://api.tvmaze.com/singlesearch/shows?q=", "White Collar");
        System.out.println(show.get());
    }
}
