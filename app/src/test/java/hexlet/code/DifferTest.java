package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final String path1 = "src/test/resources/FirstFile.json";
    private final String path2 = "src/test/resources/SecondFile.json";
    private final String path3 = "src/test/resources/FirstFile.yml";
    private final String path4 = "src/test/resources/SecondFile.yml";

    private final Path pathStylish =
            Paths.get("src/test/resources/expected/testSTYLISH").toAbsolutePath().normalize();
    private final Path pathPlain =
            Paths.get("src/test/resources/expected/testPlain").toAbsolutePath().normalize();
    private final Path pathJson =
            Paths.get("src/test/resources/expected/testJSON").toAbsolutePath().normalize();

    public DifferTest() throws IOException {
    }

    @Test
    public void test1() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path1, path2));
    }

    @Test
    public void testStylish1() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path1, path2, "stylish"));
    }

    @Test
    public void testStylish2() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path3, path4, "stylish"));
    }

    @Test
    public void testPlain1() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path1, path2, "plain"));
    }

    @Test
    public void testPlain2() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path3, path4, "plain"));
    }

    @Test
    public void testJson1() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path1, path2, "json"));
    }

    @Test
    public void testJson2() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path3, path4, "json"));
    }
}
