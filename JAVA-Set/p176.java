import java.util.Scanner;
public class p176 {
    public static void main(String[] args) {
        digiGrade Object=new digiGrade();
        Object.m_showResults();
    }
}
class digiGrade{
    int a_cases, a_number;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){a_cases=a_keyboard.nextInt();}
    public void m_getNumbers(){a_number=a_keyboard.nextInt();}
    private void m_getGrade(){
        int v_length, v_meter, v_sum=0, v_meter2=0, v_control=1, v_control2=0;
        String v_striNumber, v_number;
        v_striNumber=String.valueOf(a_number);
        v_length=v_striNumber.length();
        do{
            v_sum=0;
            if(v_control==0){
                v_striNumber=String.valueOf(v_control2);
                v_length=v_striNumber.length();
            }

            for(v_meter=0;v_meter<v_length;v_meter++){
                v_number=String.valueOf(v_striNumber.charAt(v_meter));
                v_sum+=Integer.valueOf(v_number);
            }
            v_meter2++;
            v_control2=v_sum;
            v_control=0;
        }while(v_sum>9);
        System.out.println(v_meter2);
    }
    public void m_showResults(){
        int v_meter3;
        m_getCases();
        for(v_meter3=0;v_meter3<a_cases;v_meter3++){
            m_getNumbers();
            m_getGrade();
        }
    }
}