import java.util.Scanner;
public class p173 {
    public static void main(String[] args) throws Exception {
        area Object=new area();
        Object.m_showResults();
    }
}
class area{
    int a_numofCases, a_case1;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getData(){
        a_case1=a_keyboard.nextInt();
    }
    public void m_getCases(){
        a_numofCases=a_keyboard.nextInt();
    }
    int m_getArea(int p_case1){
        int v_meter1=0, v_meter2=1;
        int v_result=0;
        while(v_meter1<p_case1){
            v_result=(4*v_meter1)+v_meter2;
            v_meter2=v_result;
            v_meter1++;
        }
        return v_result;
    }
    public void m_showResults(){
        int v_finaResult=0,v_meter3=0;
        m_getCases();
        while(v_meter3<a_numofCases){
            m_getData();
            v_finaResult=m_getArea(a_case1);
            System.out.println(v_finaResult);
            v_meter3++;
        }
    }
}