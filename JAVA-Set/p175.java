import java.util.Scanner;
public class p175 {
    public static void main(String[] args) throws Exception {
        plantGrowth Object=new plantGrowth();
        Object.m_showResults();
    }
}
class plantGrowth{
    int a_cases, a_growth, a_decrease, a_totaGrowth, a_expeGrowth;
    float a_days;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){
        a_cases=a_keyboard.nextInt();
    }
    public void m_getData(){
        a_growth=a_keyboard.nextInt();
        a_decrease=a_keyboard.nextInt();
        a_expeGrowth=a_keyboard.nextInt();
    }
    private Integer m_getGrowth(){
        a_totaGrowth=a_growth-a_decrease;
        return a_totaGrowth;
    }
    private float m_totaDays(){
        int v_meter=a_totaGrowth;
        if(a_totaGrowth>0){
            while(v_meter<=a_expeGrowth){
                v_meter++;
                a_days=(float)Math.ceil((float)a_expeGrowth/(float)a_totaGrowth);
            }
            if(a_totaGrowth>a_expeGrowth)
                a_days=(float)a_totaGrowth/a_expeGrowth;
        }
        else a_days=0;
        return a_days;
    }
    public void m_showResults(){
        m_getCases();
        for(int v_meter2=0;v_meter2<a_cases;v_meter2++){
            m_getData();
            m_getGrowth();
            m_totaDays();
            System.out.println((int)a_days);
        }
    }
}
