import java.util.Scanner;
import static java.lang.Math.abs;
public class  p151 {
    public static void main(String[] args) throws Exception {
        barcodeVerificator Object=new barcodeVerificator();
        Object.m_showResults();
    }
}
class barcodeVerificator{
    String a_barcode, a_group1, a_group2;
    int a_lenght, a_rest, a_rest2, a_rest3, a_digit1, a_digit2, a_product, a_substraction, a_median, a_halfLenght;
    int a_parSum1, a_parSum2, a_mascara;
    Scanner v_keyboard=new Scanner(System.in);
    public void m_getCodes(){
        a_barcode=v_keyboard.nextLine();
    }
    private Integer m_getLength(){
        return a_lenght=a_barcode.length();
    }
    private Integer m_checParity(){
        return a_rest=a_lenght%2;
    }
    private Integer m_calcMedian(){
        return a_median=Math.round((float)a_lenght/2);
    }
    private void m_sepaCode(){
        a_halfLenght=a_lenght/2;
        a_group1=a_barcode.substring(0,a_halfLenght);
        a_group2=a_barcode.substring(a_halfLenght,a_lenght);
    }
    private void m_getSum(){
        int v_meter1, v_meter2;
        a_parSum1=0;
        a_parSum2=0;
        for(v_meter1=0;v_meter1<a_halfLenght;v_meter1++)
            a_parSum1+=Character.getNumericValue(a_group1.charAt(v_meter1));

        for(v_meter2=0;v_meter2<a_halfLenght;v_meter2++)
            a_parSum2+=Character.getNumericValue(a_group2.charAt(v_meter2));
    }
    private void m_getDigits(){
        a_digit2=Character.getNumericValue(a_barcode.charAt(a_lenght-1));
        a_digit1=Character.getNumericValue(a_barcode.charAt(0));
    }
    public void m_analBarcode(){
        if(a_rest!=0){
            m_calcMedian();
            m_getDigits();
            a_substraction=Math.abs(a_digit1-a_digit2);
            if(a_substraction==0)
                System.out.println("INCORRECTO IMPAR");
            else{
                a_product=a_digit1*a_digit2;
                a_rest3=a_product%a_substraction;
                a_median=Character.getNumericValue(a_barcode.charAt(a_median-1));
                if(a_rest3==a_median)
                    System.out.println("CORRECTO IMPAR");
                else
                    System.out.println("INCORRECTO IMPAR");
            }
        }
        else{
            m_sepaCode();
            m_getSum();
            a_mascara=a_parSum1&a_parSum2;
            a_rest2=a_mascara%2;
            if(a_parSum1==a_parSum2&&a_rest2==0)
                System.out.println("INCORRECTO PAR");
            else{

                if(a_rest2==0)
                    System.out.println("INCORRECTO PAR");
                else
                    System.out.println("CORRECTO PAR");
            }
        }
    }
    public void m_showResults(){
        do {
            m_getCodes();
            if(a_barcode.equals("0")==false){
                m_getLength();
                m_checParity();
                if(a_lenght>=4)
                    m_analBarcode();
                else{
                    if(a_rest==0)
                        System.out.println("INCORRECTO PAR");
                    else
                        System.out.println("INCORRECTO IMPAR");
                }
            }
        }while(a_barcode.equals("0")==false);
    }
}