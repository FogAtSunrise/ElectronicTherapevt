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

    @Test
    void TestGetMessageAfterAns() {
        Therapist therapist = new Therapist();
        Message quest = therapist.getMessageById(2);
        assertEquals(quest.text, "Вас беспокоят боли в груди?");
        int number = quest.number;

        quest = therapist.getMessageByAnswer(number, "yes");
        assertEquals(quest.text, "Возникало ли у вас нарушение ритма сердцебиения(перебои)?");

        quest = therapist.getMessageByAnswer(number, "no");
        assertEquals(quest.text, "Вас беспокоит нарушение аппетита?");
    }

    @Test
    void TestGetMessagesAfterAns1() {
        Therapist therapist = new Therapist();
        Message quest = therapist.getMessageById(1);
        assertEquals(quest.text, "Вас беспокоят головные боли?");

        quest = therapist.getMessageByAnswer(quest.number, "no");
        assertEquals(quest.text, "Вас беспокоят боли в груди?");

        quest = therapist.getMessageByAnswer(quest.number, "no");
        assertEquals(quest.text, "Вас беспокоит нарушение аппетита?");

        quest = therapist.getMessageByAnswer(quest.number, "no");
        assertEquals(quest.text, "РЕКОМЕНДАЦИИ:Все ваши проблемы в голове, поспите и покушайте нормально");
    }

    @Test
    void TestGetMessagesAfterAns2() {
        Therapist therapist = new Therapist();
        Message quest = therapist.getMessageById(1);
        assertEquals(quest.text, "Вас беспокоят головные боли?");

        quest = therapist.getMessageByAnswer(quest.number, "yes");
        assertEquals(quest.text, "Бывали ли у вас обмороки или судороги?");

        quest = therapist.getMessageByAnswer(quest.number, "no");
        assertEquals(quest.text, "Бывают ли у вас жажда и сухость во рту?");

        quest = therapist.getMessageByAnswer(quest.number, "no");
        assertEquals(quest.text, "РЕЗУЛЬТАТ: Ищи проблему в эндокринной системе");
    }

    @Test
    void TestGetStartQuest() {
        Therapist therapist = new Therapist();
        Message quest1 = therapist.getMessageById(1);
        Message quest2 = therapist.getStartMessage();
        assertEquals(quest1.text, quest2.text);
    }
}
