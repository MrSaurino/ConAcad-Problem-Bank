import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.round;
public class p180 {
    public static void main(String[] args) throws Exception {
        formEquality Object=new formEquality();
        Object.m_enteData();
        Object.m_squaNumbers();
        Object.m_compFormula1();

        Object.m_enteData();
        Object.m_squaNumbers();
        Object.m_compFormula1();

        Object.m_enteData();
        Object.m_squaNumbers();
        Object.m_compFormula1();

        Object.m_enteData();
        Object.m_squaNumbers();
        Object.m_compFormula1();
    }
}
class formEquality{
    float a_valuofA1, a_valuofB1, a_valuofC1;
    float a_squavaluofA1, a_squavaluofB1, a_squavaluofC1;
    Scanner v_keyboard=new Scanner(System.in);
    public void m_enteData(){
        a_valuofA1=v_keyboard.nextFloat();
        a_valuofB1=v_keyboard.nextFloat();
        a_valuofC1=v_keyboard.nextFloat();
    }
    public void m_squaNumbers(){
        m_squaA();
        m_squaB();
        m_squaC();
    }
    private float m_squaA(){
        return a_squavaluofA1=(float) Math.round(Math.pow(a_valuofA1,2)*100f)/100f;
    }
    private float m_squaB(){
        return a_squavaluofB1=(float) Math.round(Math.pow(a_valuofB1,2)*100f)/100f;
    }
    private float m_squaC(){
        return a_squavaluofC1=(float) Math.round(Math.pow(a_valuofC1,2)*100f)/100f;
    }
    public void m_compFormula1(){
        m_squaNumbers();
        if(m_squaA()+m_squaB()==m_squaC())
            System.out.println("CUMPLE");
        else
            System.out.println("NO CUMPLE");
    }
}