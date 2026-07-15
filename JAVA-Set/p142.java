import java.util.Scanner;
public class p142 {
    public static void main(String[] args) throws Exception {
        isbnChecker Object=new isbnChecker();
        Object.m_showResults();
    }
}
class isbnChecker{
    int a_digit1, a_digit2, a_digit3, a_digit4, a_digit5, a_digit6, a_digit7, a_digit8, a_digit9, a_digit10;
    int a_cases, a_sum, a_residue, a_length;
    String a_isbn;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){
        a_cases=a_keyboard.nextInt();
        a_keyboard.nextLine();
    }
    public void m_getISBN(){
        a_isbn=a_keyboard.nextLine();
        a_length=a_isbn.length();
    }
    public void m_veriISBN(){
        if(a_length==13){
            if (a_isbn.contains(" "))
                a_isbn = a_isbn.replace(" ", "");
            else
                a_isbn = a_isbn.replace("-", "");
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
    }
    private void m_multISBN(){
        a_digit1=a_digit1*1;
        a_digit2=a_digit2*2;
        a_digit3=a_digit3*3;
        a_digit4=a_digit4*4;
        a_digit5=a_digit5*5;
        a_digit6=a_digit6*6;
        a_digit7=a_digit7*7;
        a_digit8=a_digit8*8;
        a_digit9=a_digit9*9;

    }
    private Integer m_sumResults(){
        a_sum=a_digit1+a_digit2+a_digit3+a_digit4+a_digit5+a_digit6+a_digit7+a_digit8+a_digit9;
        return a_sum;
    }
    private Integer m_diviResult(){
        return a_residue=a_sum%11;
    }
    public void m_veriNumber(){
        if(a_residue==a_digit10)
            System.out.println("CORRECTO");
        else
            System.out.println("INCORRECTO");
    }
    public void m_analISBN(){
        m_multISBN();
        m_sumResults();
        m_diviResult();
    }
    public void m_showResults(){
        int v_meter;
        m_getCases();
        for(v_meter=0;v_meter<a_cases&&a_cases<=10;v_meter++){
            m_getISBN();
            if(a_isbn.contains(" ")||a_isbn.contains("-")||a_length==10){
                if(a_isbn.contains(" ")&a_isbn.contains("-"))
                    System.out.println("INCORRECTO");
                else{
                    m_veriISBN();
                    m_convNumbers();
                    m_analISBN();
                    m_veriNumber();}}
            else
                System.out.println("INCORRECTO");

        }
    }
}