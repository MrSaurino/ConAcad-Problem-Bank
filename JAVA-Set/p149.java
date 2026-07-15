import java.util.Scanner;
public class p149 {
    public static void main(String[] args) throws Exception {
        isbnChecker Object=new isbnChecker();
        Object.m_showResults();
    }
}
class isbnChecker{
    int a_digit1, a_digit2, a_digit3, a_digit4, a_digit5, a_digit6, a_digit7, a_digit8, a_digit9, a_digit10, a_digit11, a_digit12, a_digit13;
    int a_cases, a_sum, a_residue, a_dc, a_length;
    String a_isbn;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){
        a_cases=a_keyboard.nextInt();
        a_keyboard.nextLine();
    }
    public void m_getISBN(){
        a_isbn=a_keyboard.nextLine();

    }
    public void m_veriISBN(){
        a_length=a_isbn.length();
        if(a_length==17){
            if(a_isbn.contains(" "))
                a_isbn=a_isbn.replace(" ","");
            else
                a_isbn=a_isbn.replace("-","");
        }
    }
    public void m_convNumbers(){
        a_digit1=Character.getNumericValue(a_isbn.charAt(0));
        a_digit2=Character.getNumericValue(a_isbn.charAt(1));
        a_digit3=Character.getNumericValue(a_isbn.charAt(2));
        a_digit4=Character.getNumericValue(a_isbn.charAt(3));
        a_digit5=Character.getNumericValue(a_isbn.charAt(4));
        a_digit6=Character.getNumericValue(a_isbn.charAt(5));
        a_digit7=Character.getNumericValue(a_isbn.charAt(6));
        a_digit8=Character.getNumericValue(a_isbn.charAt(7));
        a_digit9=Character.getNumericValue(a_isbn.charAt(8));
        a_digit10=Character.getNumericValue(a_isbn.charAt(9));
        a_digit11=Character.getNumericValue(a_isbn.charAt(10));
        a_digit12=Character.getNumericValue(a_isbn.charAt(11));
        a_digit13=Character.getNumericValue(a_isbn.charAt(12));
    }
    private void m_multISBN(){
        a_digit1=a_digit1*1;
        a_digit2=a_digit2*3;
        a_digit3=a_digit3*1;
        a_digit4=a_digit4*3;
        a_digit5=a_digit5*1;
        a_digit6=a_digit6*3;
        a_digit7=a_digit7*1;
        a_digit8=a_digit8*3;
        a_digit9=a_digit9*1;
        a_digit10=a_digit10*3;
        a_digit11=a_digit11*1;
        a_digit12=a_digit12*3;
    }
    private Integer m_sumResults(){
        a_sum=a_digit1+a_digit2+a_digit3+a_digit4+a_digit5+a_digit6+a_digit7+a_digit8+a_digit9+a_digit10+a_digit11+a_digit12;
        return a_sum;
    }
    private Integer m_diviResult(){
        return a_residue=a_sum%10;
    }
    private void m_getDC(){
        a_dc=(a_residue==0)?0:10-a_residue;
    }
    public void m_veriDC(){
        if(a_dc==a_digit13)
            System.out.println("CORRECTO");
        else
            System.out.println("INCORRECTO");
    }
    public void m_analISBN(){
        m_multISBN();
        m_sumResults();
        m_diviResult();
        m_getDC();
    }
    public void m_showResults(){
        int v_meter;
        m_getCases();
        for(v_meter=0;v_meter<a_cases&&a_cases<=10;v_meter++){
            m_getISBN();
            m_veriISBN();
            m_convNumbers();
            m_analISBN();
            m_veriDC();
        }
    }
}