import java.util.Scanner;
public class p324 {
    public static void main(String[] args) throws Exception {
        ASCIIValues Object=new ASCIIValues();
        Object.m_showResults();
    }
}
class ASCIIValues{
    int a_cases, a_value1, a_asciValue;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){
        a_cases=a_keyboard.nextByte();
        a_keyboard.nextLine();
    }
    public void m_getasciivalues(){
        a_asciValue=a_keyboard.next().charAt(0);
        a_value1=a_keyboard.nextInt();
    }
    String m_analASCII(){
        int v_meter1, v_meter2;
        String v_number;
        if(a_value1>0){
            for(v_meter1=0;v_meter1<a_value1;v_meter1++){
                v_number=Character.toString(a_asciValue+v_meter1);
                System.out.print(v_number);
            }
        }
        else{
            for(v_meter2=0;v_meter2>=a_value1;v_meter2--){
                v_number=Character.toString(a_asciValue+v_meter2);
                System.out.print(v_number);
            }
        }
        return v_number="";
    }
    public void m_showResults(){
        int v_meter3;
        m_getCases();
        for(v_meter3=0;v_meter3<a_cases;v_meter3++){
            m_getasciivalues();
            System.out.println(m_analASCII());
        }
    }
}
