import java.util.Scanner;
public class p179 {
    public static void main(String[] args) {
        statOrganizer Object=new statOrganizer();
        Object.m_showResults();
    }
}
class statOrganizer{
    int a_cases, a_statNumbers, a_statues, a_difeEstatues, a_finaStatues;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){a_cases=a_keyboard.nextInt();}
    public void m_getstatNumber(){a_statNumbers=a_keyboard.nextInt();}
    public void m_getStatues(){
        int v_meter1, v_maxiNumber=0, v_minimNumber=0;
        for(v_meter1=0;v_meter1<a_statNumbers;v_meter1++){
            a_statues=a_keyboard.nextInt();
            if(v_maxiNumber!=0&&v_minimNumber!=0){
                if(a_statues>v_maxiNumber)
                    v_maxiNumber=a_statues;
                if(a_statues<v_minimNumber)
                    v_minimNumber=a_statues;}
            else
            {v_minimNumber=a_statues;v_maxiNumber=a_statues;}
        }
        a_difeEstatues=v_maxiNumber-v_minimNumber;
        a_finaStatues=a_difeEstatues-(a_statNumbers-1);
    }
    public void m_showResults(){
        int v_meter2;
        m_getCases();
        for(v_meter2=0;v_meter2<a_cases;v_meter2++){
            m_getstatNumber();
            m_getStatues();
            System.out.println(a_finaStatues);
        }
    }
}