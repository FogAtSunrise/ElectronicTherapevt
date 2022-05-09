//сущность, содержит или вопрос или конечный результат или сообщение об ошибке
public class Message {
    public Boolean IsQuestion; //указывает, вопрос или ответ
    public Integer number; //номер вопроса, если 0 - ошибка
    public String text; //текст вопроса или диагноза
    //адреса последующих вопросов, если это вопрос
    public Integer ansYes;
    public Integer ansNo;

    Message(Integer num, String str, Integer yes, Integer no)
    {
        number=num;
        text = str;
        ansYes = yes;
        ansNo = no;
    }

    Message(Integer num, String str)
    {
        number=num;
        text = str;
    }
}
