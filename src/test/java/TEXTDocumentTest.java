import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TEXTDocumentTest {

    TEXTDocumentType textDocumentType = new TEXTDocumentType();
    String itemGreatThan100Char = "azazazeazazeazeeazezerzerzerzeazeaezazeaezaezaezazeazeaeaezaeaezazeaezaezaeaezazeaeazeazeazeaezaeaezaeaeaez";
    String itemLessThan100Char = "zaeazezae";

    @Test
    public void shouldFailWhenDocumentTextPhrasesExceed100Character() {
        try {
            textDocumentType.documentTextPhrasesExceed100Character(itemGreatThan100Char);
            fail();
        } catch (ExceedLineNumberException exception) {
            assertEquals(exception.getMessage(), String.format("Exceed %o Number of line", Constants.EXCEEDNUMBER));
        }
    }

    @Test
    public void shouldPassWhenDocumentTextPhrasesLessThan100Character() {
        textDocumentType.documentTextPhrasesExceed100Character(itemLessThan100Char);
    }

    @Test
    public void testGoodFile(){
        boolean isRegularFile = Files.isRegularFile(Paths.get("test-input.txt"));
        assertTrue(isRegularFile);
    }


}
