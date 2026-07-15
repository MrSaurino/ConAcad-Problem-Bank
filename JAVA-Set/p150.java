import java.util.Scanner;
public class p150 {
    public static void main(String[] args) {
        sherRide Object=new sherRide();
        Object.m_showResults();
    }
}
class sherRide{
    int a_cases, a_inicKilometers, a_inicTime, a_soilType, a_ages=1;
    int a_ageMeter=0, a_metePersons=0;
    float a_finaKilometers, a_difeHours;
    Scanner a_keyboard = new Scanner(System.in);
    public void m_getCases(){
        a_cases=a_keyboard.nextInt();
    }
    public void m_getData(){
        a_inicKilometers=a_keyboard.nextInt();
        a_inicTime=a_keyboard.nextInt();
        a_soilType=a_keyboard.nextInt();
    }
    public void m_getAges(){
        do{
            a_ages=a_keyboard.nextInt();
            m_counPeople(a_ages);
        }while(a_ages!=0);
    }
    private void m_counPeople(int p_ages){
        if(p_ages!=0) {
            a_metePersons++;
            if (p_ages > 0 && p_ages < 14 || p_ages >= 65||p_ages<0)
                a_ageMeter++;
        }

    }
    private void m_getTime(){
        float v_halfPercentage, v_hours;
        int v_totaTime=0;
        v_hours=a_inicTime/60F;
        v_halfPercentage=(float)a_ageMeter/(float)a_metePersons;
        switch(a_soilType){
            case 1:if(v_halfPercentage>=0.5){
                a_finaKilometers=a_inicKilometers/2F;
                a_difeHours=v_hours-a_finaKilometers;
                v_totaTime=Math.round(a_difeHours*60);
            }
            else{
                a_finaKilometers=a_inicKilometers/3F;
                a_difeHours=v_hours-a_finaKilometers;
                v_totaTime=Math.round(a_difeHours*60);
            }break;

            default: if(v_halfPercentage>0.5){
                a_finaKilometers=a_inicKilometers/0.5F;
                a_difeHours=v_hours-a_finaKilometers;
                v_totaTime=Math.round(a_difeHours*60);
            }
            else{
                a_finaKilometers=a_inicKilometers;
                a_difeHours=v_hours-a_finaKilometers;
                v_totaTime=Math.round(a_difeHours*60);
            }break;
        }
        System.out.println(v_totaTime);
    }
    public void m_showResults(){
        int v_meter2;
        m_getCases();
        for(v_meter2=0;v_meter2<a_cases;v_meter2++){
            m_getData();
            a_ageMeter=0; a_metePersons=0;
            m_getAges();
            m_getTime();
        }
    }
}
