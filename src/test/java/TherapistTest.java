import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TherapistTest {
    @Test
    void ClassTherapistCreationTest() {
        Therapist therapist = new Therapist();
        assertNotNull(therapist);
    }
}
