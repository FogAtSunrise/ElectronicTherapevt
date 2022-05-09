import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TherapistTest {
    @Test
    void ClassTherapistCreationTest() {
        Therapist therapist = new Therapist();
        assertNotNull(therapist);
    }

    @Test
    void TestCountQuestion() {
        Therapist therapist = new Therapist();
        List<Message> data = therapist.getData();
        assertEquals(data.size(), 15);
    }
}
