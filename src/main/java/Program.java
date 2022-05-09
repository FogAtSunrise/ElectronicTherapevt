import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Therapist therapist = new Therapist();
        Message mes = therapist.getStartMessage();
        do{
            System.out.println(mes.text);
            String ans = console.nextLine();
            mes = therapist.getMessageByAnswer(mes.number, ans);
        } while(mes.number!=0);
    }
}
