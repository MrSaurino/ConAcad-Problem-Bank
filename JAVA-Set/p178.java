import java.util.Scanner;
public class p178 {
    public static void main(String[] args) {
        depoChecker Object=new depoChecker();
        Object.m_getResults();
    }
}
class depoChecker{
    int a_cases;
    float a_deposit, a_inteRate, a_expeAmount;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){a_cases=a_keyboard.nextInt();}
    public void m_getData(){
        a_deposit=a_keyboard.nextFloat();
        a_inteRate=a_keyboard.nextFloat();
        a_expeAmount=a_keyboard.nextFloat();
    }
    private float m_getinteRate(){
        a_inteRate=(a_inteRate/100)+1;
        return a_inteRate;
    }
    private void m_getMoney(){
        int v_meter1=0;
        while(a_deposit<=a_expeAmount){
            a_deposit=a_deposit*a_inteRate;
            v_meter1++;
        }
        System.out.println(v_meter1);
    }
    public void m_getResults(){
        int v_meter2;
        m_getCases();
        for(v_meter2=0;v_meter2<a_cases;v_meter2++){
            m_getData();
            if(a_deposit<=0)
                System.out.println("-1");
            else if(a_inteRate<1||a_inteRate>100)
                System.out.println("-1");
            else if(a_deposit>=a_expeAmount)
                System.out.println("0");
            else{
                m_getinteRate();
                m_getMoney();
            }
        }
    }
}

