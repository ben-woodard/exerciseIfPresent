public class FindCarmenApplication {

    public static void main(String[] args) {
        FileService fileService = new FileService();

        fileService.findCarmen("InterpolWatchReport-Week1.csv");
        fileService.findCarmen("InterpolWatchReport-Week2.csv");
        fileService.findCarmen("InterpolWatchReport-Week3.csv");
    }
}