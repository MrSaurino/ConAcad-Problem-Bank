import java.util.Scanner;
import static java.lang.Math.abs;
public class p181{
    public static void main(String[] args) throws Exception {
        numChain Object=new numChain();
        Object.m_ShowResults();
    }

}
class numChain{
    String a_Chain1, a_Chain2, a_Chain3, a_Chain4, a_ChaiResult1, a_ChaiResult2, a_ChaiResult3;
    int a_Number1, a_Number2, a_Number3, a_Number4, a_Result1, a_Result2, a_Result3;
    public void m_EnteData(){
        Scanner v_keyboard=new Scanner(System.in);
        a_Chain1=v_keyboard.next();
        a_Chain2=v_keyboard.next();
        a_Chain3=v_keyboard.next();
        a_Chain4=v_keyboard.next();
    }
    private void m_ConvData1(){
        a_Number1=Integer.parseInt(a_Chain1);
        a_Number2=Integer.parseInt(a_Chain2);
        a_Number3=Integer.parseInt(a_Chain3);
        a_Number4=Integer.parseInt(a_Chain4);
    }
    private void m_GetSubtractions(){
        m_CalcSubtraction1();
        m_CalcSubtraction2();
        m_CalcSubtraction3();
    }
    private void m_CalcSubtraction1(){
        a_Result1=a_Number1 - a_Number2;
        Math.abs(a_Result1);
    }
    private void m_CalcSubtraction2(){
        a_Result2=a_Number2 - a_Number3;
        Math.abs(a_Result2);
    }
    private void m_CalcSubtraction3(){
        a_Result3=a_Number3 - a_Number4;
        Math.abs(a_Result3);
    }
    private void m_ConvData2(){
        a_ChaiResult1 = Integer.toString(Math.abs(a_Result1));
        a_ChaiResult2 = Integer.toString(Math.abs(a_Result2));
        a_ChaiResult3 = Integer.toString(Math.abs(a_Result3));
    }
    public void m_ShowResults(){
        m_EnteData();
        m_ConvData1();
        m_GetSubtractions();
        m_ConvData2();
        System.out.println(a_ChaiResult1+" "+a_ChaiResult2+" "+a_ChaiResult3);

    }
}