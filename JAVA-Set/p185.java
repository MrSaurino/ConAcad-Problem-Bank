import java.util.Scanner;
import static java.lang.Math.round;
public class p185{
    public static void main(String[] args) throws Exception {
        fertCalculator Result=new fertCalculator();
        Result.m_showResult();
    }
}
class fertCalculator{
    float a_width, a_height, a_area, a_cornKilos, a_liters, a_fertKilos;
    public void m_enteData(){
        Scanner v_keyboard=new Scanner(System.in);
        a_width =v_keyboard.nextFloat();
        a_height =v_keyboard.nextFloat();
    }
    private void m_makeCalculations(){
        m_calcArea();
        m_calcKilos();
        m_calcLiters();
        m_calcFertilizer();
    }
    private float m_calcArea(){
        return a_area = a_width * a_height;
    }
    private float m_calcKilos(){
        return a_cornKilos =(a_area *(2/3F))/1.8F;
    }
    private float m_calcLiters(){
        return a_liters =(a_cornKilos *3F)/1.5F;
    }
    private float m_calcFertilizer(){
        return a_fertKilos =(a_liters *0.750F)/2.5F;
    }
    public void m_showResult(){
        m_enteData();
        m_makeCalculations();
        System.out.println(Math.round(m_calcFertilizer()*100d)/100d);
    }
}