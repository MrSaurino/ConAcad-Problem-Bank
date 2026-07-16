import java.util.Scanner;
import static java.lang.Math.round;
public class p298 {
    public static void main(String[] args) throws Exception {
        formSolver Result=new formSolver();
        Result.m_enteData();
        Result.m_showResults();
    }
}
class formSolver{
    float a_valuofX, a_valuofY, a_valuofZ, a_valuofT;
    public void m_enteData(){
        Scanner v_keyboard=new Scanner(System.in);
        a_valuofZ =v_keyboard.nextFloat();
        a_valuofY =v_keyboard.nextFloat();
        a_valuofT =v_keyboard.nextFloat();
    }
    private float m_calcSolution(){
        a_valuofX =(float) (Math.sqrt(((Math.pow(a_valuofZ,2)*18)-(Math.pow(a_valuofT,6)* a_valuofY *4F)))/Math.pow(a_valuofT,3));
        return a_valuofX;
    }
    public void m_showResults(){
        m_calcSolution();
        System.out.println(Math.round(m_calcSolution()*1000d)/1000d);
    }

}