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

    @Test
    void TestGetMessageById1() {
        Therapist therapist = new Therapist();
        Message quest = therapist.getMessageById(1);
        assertEquals(quest.text, "Вас беспокоят головные боли?");
    }

    @Test
    void TestGetMessageById2() {
        Therapist therapist = new Therapist();
        Message quest = therapist.getMessageById(2);
        assertEquals(quest.text, "Вас беспокоят боли в груди?");
        quest = therapist.getMessageById(3);
        assertEquals(quest.text, "Вас беспокоит нарушение аппетита?");
        quest = therapist.getMessageById(15);
        assertEquals(quest.text, "РЕЗУЛЬТАТ: Ищи проблему в эндокринной системе");
    }
}
