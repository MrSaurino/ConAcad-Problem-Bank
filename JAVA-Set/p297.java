import java.util.Scanner;
public class p297 {
    public static void main(String[] args) throws Exception {
        numbDivisor Result=new numbDivisor();
        Result.m_prinResult();
    }
}
class numbDivisor{
    int a_number1, a_number2, a_number3;
    float a_division1, a_division2, a_division3, a_division4, a_division5, a_division6;
    public void m_enteData(){
        Scanner v_keyboard=new Scanner(System.in);
        a_number1 =v_keyboard.nextInt();
        a_number2 =v_keyboard.nextInt();
        a_number3 =v_keyboard.nextInt();
    }
    private void m_divisions(){
        m_divifirsNumber();
        m_divisecoNumber();
        m_divithirNumber();
    }
    private void m_divifirsNumber(){
        a_division1 = (float) a_number1 / (float) a_number2;
        a_division2 = (float) a_number1 / (float) a_number3;
    }
    private void m_divisecoNumber(){
        a_division3 = (float) a_number2 / (float) a_number1;
        a_division4 = (float) a_number2 / (float) a_number3;
    }
    private void m_divithirNumber(){
        a_division5 = (float) a_number3 / (float) a_number1;
        a_division6 = (float) a_number3 / (float) a_number2;
    }
    public void m_prinResult(){
        m_enteData();
        m_divisions();
        System.out.println(Math.floor(a_division1 *100d)/100d);
        System.out.println(Math.floor(a_division2 *100d)/100d);
        System.out.println(Math.floor(a_division3 *100d)/100d);
        System.out.println(Math.floor(a_division4 *100d)/100d);
        System.out.println(Math.floor(a_division5 *100d)/100d);
        System.out.println(Math.floor(a_division6 *100d)/100d);

    }
}