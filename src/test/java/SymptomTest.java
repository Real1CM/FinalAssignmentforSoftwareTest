import org.example.Detail;
import org.example.Symptom;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SymptomTest {
    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11"
    })
    void selectSymptomTest(int inputValue) {
        Boolean functionFlag = new Symptom().selectSymptom(inputValue);
        Detail mockedDetail = mock(Detail.class);
        when(mockedDetail.symptom(1)).thenReturn(1);
        when(mockedDetail.TemperatureTop(38.0f)).thenReturn(38.0f);

        String detailChosen = "1";
        ByteArrayInputStream strIn = new ByteArrayInputStream(detailChosen.getBytes());
        System.setIn(strIn);
        int a;
        try {
            while ((a = System.in.read()) != -1) {
                System.out.print((char) a);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        assertEquals(true, functionFlag);
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "4",
            "3",
            "5",
            "14",
    })
    void contactHistoryTest(int a) {
        assertEquals(a <= 4, new Symptom().contactHistory(a) == 0);
    }
}
