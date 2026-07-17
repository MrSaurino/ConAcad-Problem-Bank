import java.util.Scanner;
public class p302 {
    public static void main(String[] args) throws Exception {
        obtaName Object=new obtaName();
        Object.m_EnteData();
        Object.m_FullNames();
    }
}
class obtaName{
    String a_Name1, a_Name2, a_LastName1, a_LastName2, a_LastName3, a_LastName4;
    public void m_EnteData(){
        Scanner v_keyboard=new Scanner(System.in);
        a_Name2=v_keyboard.nextLine();
        a_LastName2=v_keyboard.nextLine();
        a_LastName1=v_keyboard.nextLine();
        a_LastName4=v_keyboard.nextLine();
        a_LastName3=v_keyboard.nextLine();
        a_Name1=v_keyboard.nextLine();
    }
    private String m_NameOrder1(){
        String v_CompName1;
        v_CompName1 = a_Name1 +" "+ a_LastName1+ " " + a_LastName2;
        return v_CompName1;
    }
    private String m_NameOrder2(){
        String v_CompName2;
        v_CompName2 = a_Name2 +" "+ a_LastName3 +" "+ a_LastName4;
        return v_CompName2;
    }
    void m_FullNames(){
        m_NameOrder1();
        m_NameOrder2();
        System.out.println(m_NameOrder1());
        System.out.println(m_NameOrder2());
    }
}
