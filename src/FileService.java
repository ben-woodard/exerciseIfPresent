import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileService {


    public List<SuspectLocation> readFile(String filename) {
        SuspectLocation suspect;
        List<SuspectLocation> suspectList = new ArrayList<>();
        String[] suspectInfo = new String[2];
        String line;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            line = fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                suspectInfo = line.split(",");
                suspect = new SuspectLocation(suspectInfo[0], suspectInfo[1]);
                suspectList.add(suspect);
            }
        } catch (Exception e) {
            System.out.println("There was an exception while reading the file");
            throw new RuntimeException(e);
        }
        return suspectList;
    }

    public void findCarmen(String fileName) {
        FileService fileService = new FileService();
        List<SuspectLocation> suspectList = fileService.readFile(fileName);

        Optional<SuspectLocation> suspect = suspectList.stream()
                                                       .filter(name -> (name.getName()).equals("CARMEN SANDIEGO"))
                                                       .findAny();
        suspect.ifPresent(sus -> System.out.println(sus.getName() + " is in... " + sus.getCountry()));
    }
}
