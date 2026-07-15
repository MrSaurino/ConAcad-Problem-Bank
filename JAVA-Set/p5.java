import java.util.Scanner;
public class p5 {
    public static void main(String[] args) throws Exception {
        rpm Object=new rpm();
        Object.m_showResults();
    }
}
class rpm{
    int a_inicRPM, a_gearAmount, a_gearTeeth1,a_gearTeeth2;
    float a_division, a_finaRPM;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getRPM(){
        a_inicRPM=a_keyboard.nextInt();
    }
    public void m_getgearNumber(){
        a_gearAmount=a_keyboard.nextInt();
        a_gearTeeth1=a_keyboard.nextInt();
    }
    private void m_getgearTeeth(){
        int v_meter;
        for(v_meter=1;v_meter<a_gearAmount;v_meter++){
            a_gearTeeth2=a_keyboard.nextInt();
        }
    }
    private void m_getfinaRPM(){
        a_division=(float)a_gearTeeth1/(float)a_gearTeeth2;
        a_finaRPM=a_division*a_inicRPM;
    }
    public void m_showResults(){
        do {
            m_getRPM();
            if(a_inicRPM!=-1){
                m_getgearNumber();
                m_getgearTeeth();
                m_getfinaRPM();
                System.out.println((int)a_finaRPM);
            }
        }while(a_inicRPM!=-1);
    }
}
