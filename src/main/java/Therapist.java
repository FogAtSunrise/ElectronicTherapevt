import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Therapist {
    List<Message> questions = new ArrayList<Message>();

    public List<Message> getData(){return questions;}

    Therapist(){ readDate();}


    public Message getMessageById(int id)
    {
        if (questions==null) {
            return new Message(0, "Error! Отсутствие данных" );
        }
        else
        {
            Message b = questions.stream().filter(x-> x.number==id).findFirst().get();
            return b;
        }
    }

    public Message getStartMessage()
    {System.out.println("Добро пожаловать в систему \"ЭДЕКТРОННЫЙ ТЕРАПЕВТ\"" +
            "\nВаму будет задан ряд вопросов," +
            "\n ваша задача отвечать \"yes\" или \"no\".\n\nПОЕХАЛИ\n\n");
        return questions.get(0);
    }


    public Message getMessageByAnswer(int id, String ans)
    {
        Message mes = getMessageById(id);
            return getMessageById(ans.equals("yes")? mes.ansYes: mes.ansNo);
    }


    private void readDate()
    {
        Message mes;

        try {
            File file = new File("src/main/resources/data");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] words = line.split("#");

                if(words.length==4)
                { mes = new Message(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]));
                    mes.IsQuestion = true;
                    questions.add(mes);
                }
                else
                if(words.length==2)
                { mes = new Message(Integer.parseInt(words[0]), words[1]);
                    mes.IsQuestion = false;
                    questions.add(mes);
                }
                else
                    throw new NullPointerException("Errror! Ошибка данных в документе");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
