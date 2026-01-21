
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();

        List<Book> books = readBooks(file);

    }

    public static List<Book> readBooks(String file) {
        List<Book> books = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            books = stream
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 4)
                    .map(parts -> new Book(
                            parts[0],
                            Integer.valueOf(parts[1]),
                            Integer.valueOf(parts[2]),
                            parts[3]))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return books;
    }

}
