import java.util.Scanner;
public class p304 {
    public static void main(String[] args) throws Exception {
        ponderations Object=new ponderations();
        Object.m_enteData();
        Object.m_getMean();
        Object.m_getfinaGrade1();
        Object.a_keyboard.nextLine();
        Object.m_enteData();
        Object.m_getMean();
        Object.m_getfinaGrade1();
        Object.a_keyboard.nextLine();
        Object.m_enteData();
        Object.m_getMean();
        Object.m_getfinaGrade1();
    }
}
class ponderations{
    String a_name1,a_activity1, a_activity2, a_activity3;
    int a_grade1, a_grade2, a_grade3;
    float a_mean1,a_finaGrade1;
    Scanner a_keyboard =new Scanner(System.in);
    void m_enteData(){
        a_name1= a_keyboard.nextLine();
        a_grade1= a_keyboard.nextInt();
        a_grade2= a_keyboard.nextInt();
        a_grade3= a_keyboard.nextInt();
        a_activity1= a_keyboard.next();
        a_activity2= a_keyboard.next();
        a_activity3= a_keyboard.next();
    }
    void m_getMean(){
        a_mean1=(float)(a_grade1+a_grade2+a_grade3)/3;
    }
    void m_getfinaGrade1(){
        if(a_activity1.equals("SI")||a_activity1.equals("sI")||a_activity1.equals("Si")||a_activity1.equals("si"))
            if(a_activity2.equals("SI")||a_activity2.equals("sI")||a_activity2.equals("Si")||a_activity2.equals("si"))
                if(a_activity3.equals("SI")||a_activity3.equals("sI")||a_activity3.equals("Si")||a_activity3.equals("si"))
                {a_finaGrade1=(float)(a_mean1*0.3) + (float) a_mean1;
                    if(a_finaGrade1>100)
                        System.out.println(a_name1+" "+ 100);
                    else
                        System.out.println(a_name1+" "+ (int)a_finaGrade1);}
                else
                {a_finaGrade1=(float)(a_mean1*0.2)+ (float) a_mean1;
                    if(a_finaGrade1>100)
                        System.out.println(a_name1+" "+ 100);
                    else
                        System.out.println(a_name1+" "+(int)a_finaGrade1);}
            else if(a_activity3.equals("SI")||a_activity3.equals("sI")||a_activity3.equals("Si")||a_activity3.equals("si"))
            {a_finaGrade1=(float)(a_mean1*0.2)+ (float) a_mean1;
                if(a_finaGrade1>100)
                    System.out.println(a_name1+" "+ 100);
                else
                    System.out.println(a_name1+" "+(int)a_finaGrade1);}
            else
            {a_finaGrade1=(int)(a_mean1*0.05)+ (int) a_mean1;
                if(a_finaGrade1>100)
                    System.out.println(a_name1+" "+ 100);
                else
                    System.out.println(a_name1+" "+a_finaGrade1);}

        else if(a_activity2.equals("SI")||a_activity2.equals("sI")||a_activity2.equals("Si")||a_activity2.equals("si"))
            if(a_activity3.equals("SI")||a_activity3.equals("sI")||a_activity3.equals("Si")||a_activity3.equals("si"))
            {a_finaGrade1=(float)(a_mean1*0.2)+ (float) a_mean1;
                if(a_finaGrade1>100)
                    System.out.println(a_name1+" "+ 100);
                else
                    System.out.println(a_name1+" "+(int)a_finaGrade1);}
            else
            {a_finaGrade1=(float)(a_mean1*0.1)+ (float) a_mean1;
                if(a_finaGrade1>100)
                    System.out.println(a_name1+" "+ 100);
                else
                    System.out.println(a_name1+" "+(int)a_finaGrade1);}
        else if(a_activity3.equals("SI")||a_activity3.equals("sI")||a_activity3.equals("Si")||a_activity3.equals("si"))
        {a_finaGrade1=(float)(a_mean1*0.1)+ (float) a_mean1;
            if(a_finaGrade1>100)
                System.out.println(a_name1+" "+ 100);
            else
                System.out.println(a_name1+" "+(int)a_finaGrade1);}
        else
            System.out.println(a_mean1);

    }
}