import java.util.Scanner;
public class p319 {
    public static void main(String[] args) throws Exception {
        knowName Object=new knowName();
        Object.m_enteData();
        Object.m_prinResult();

        Object.m_enteData();
        Object.m_prinResult();

        Object.m_enteData();
        Object.m_prinResult();
    }
}
class knowName{
    String a_name1="", a_name2="", a_name3="";
    int a_age1=0;
    Scanner v_keyboard=new Scanner(System.in);
    public void m_enteData(){
        a_name1 =v_keyboard.next();
        a_name2 =v_keyboard.next();
        a_name3 =v_keyboard.next();
        a_age1 =v_keyboard.nextInt();
    }
    private Integer m_obtaAge1(){
        int a_resu1;
        a_resu1 = a_age1 -5;
        return a_resu1;
    }
    public void m_prinResult(){
        m_obtaAge1();
        System.out.println("SOY "+ a_name3 +" "+"Y TENGO "+ m_obtaAge1());
    }
}

