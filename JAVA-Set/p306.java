import java.util.Scanner;
public class p306 {
    public static void main(String[] args) throws Exception {
        tickPurchase Object=new tickPurchase();
        Object.m_enteData();
        Object.m_convtoNumber();
        Object.m_buyTicket();
        Object.a_keyboard.nextLine();
        Object.m_enteData();
        Object.m_convtoNumber();
        Object.m_buyTicket();
        Object.a_keyboard.nextLine();
        Object.m_enteData();
        Object.m_convtoNumber();
        Object.m_buyTicket();
        Object.a_keyboard.nextLine();
        Object.m_enteData();
        Object.m_convtoNumber();
        Object.m_buyTicket();
    }
}
class tickPurchase{
    String a_name1, a_flig1;
    String a_striHour1, a_striPrice1;
    int a_hour1, a_pric1;
    Scanner a_keyboard =new Scanner(System.in);
    void m_enteData(){
        a_name1= a_keyboard.nextLine();
        a_flig1= a_keyboard.next();
        a_striHour1= a_keyboard.next();
        a_striPrice1= a_keyboard.next();

    }
    void m_convtoNumber(){
        a_hour1=Integer.parseInt(a_striHour1);
        a_pric1=Integer.parseInt(a_striPrice1);
    }
    void m_buyTicket(){
        if(a_flig1.equals("SI"))
            if(a_hour1<=6)
                System.out.println(a_name1+" COMPRA");
            else if(a_pric1<10000)
                System.out.println(a_name1+" COMPRA");
            else
                System.out.println(a_name1+" NO COMPRA");
        else
        if(a_hour1<24)
            System.out.println(a_name1+" COMPRA");
        else
            System.out.println(a_name1+" NO COMPRA");
    }
}