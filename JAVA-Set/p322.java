import java.util.Scanner;
public class p322 {
    String a_name, a_curp;
    float a_initMoney, a_months, a_inteRate, a_deposit, a_withdraw, a_inveMoney;
    int a_hour1, a_hour2, a_hour3, a_hour4, a_minutes1, a_minutes2, a_minutes3, a_minutes4, a_seconds1, a_seconds2, a_seconds3, a_seconds4;
    Scanner v_keyboard=new Scanner(System.in);
    public static void main(String[] args){
        finaData finance=new finaData();
        persData person=new persData();
        p322 data =new p322();
        data.m_getData();
        data.m_moneMovements();
        System.out.println("HOMOCLAVE de "+ data.a_name+" es "+person.m_getHomoclave(data.a_name));
        System.out.println(data.a_name+" Nacio "+person.m_getdateofBirth(data.a_curp));
        System.out.println("Diferencia: "+finance.m_timeDifference(data.a_hour1, data.a_minutes1, data.a_seconds1, data.a_hour2, data.a_minutes2, data.a_seconds2));
        System.out.println("Diferencia: "+finance.m_timeDifference(data.a_hour3, data.a_minutes3, data.a_seconds3, data.a_hour4, data.a_minutes4, data.a_seconds4));
        System.out.println(data.a_name+" tu dinero al final seria "+finance.m_finaInvestment(data.a_inveMoney, data.a_months, data.a_inteRate));
        System.out.println(data.a_name+" saldo "+data.m_moneMovements()+" movimientos 2");
    }
    public void m_getData(){
        a_name=v_keyboard.nextLine();
        a_curp=v_keyboard.nextLine();
        a_initMoney=v_keyboard.nextFloat();
        a_hour1=v_keyboard.nextInt();
        a_minutes1=v_keyboard.nextInt();
        a_seconds1=v_keyboard.nextInt();
        a_hour2=v_keyboard.nextInt();
        a_minutes2=v_keyboard.nextInt();
        a_seconds2=v_keyboard.nextInt();
        a_hour3=v_keyboard.nextInt();
        a_minutes3=v_keyboard.nextInt();
        a_seconds3=v_keyboard.nextInt();
        a_hour4=v_keyboard.nextInt();
        a_minutes4=v_keyboard.nextInt();
        a_seconds4=v_keyboard.nextInt();
        a_inveMoney=v_keyboard.nextFloat();
        a_months=v_keyboard.nextFloat();
        a_inteRate=v_keyboard.nextFloat();
        a_deposit=v_keyboard.nextFloat();
        a_withdraw=v_keyboard.nextFloat();
    }
    float m_moneMovements(){
        float v_finaMoney;
        return v_finaMoney=(a_initMoney+a_deposit)-a_withdraw;

    }
}
class finaData{
    double m_finaInvestment(float p_money, float p_months, float p_inteRate){
        double v_investment;
        v_investment=Math.floor(((p_money*p_inteRate*(p_months/12))+p_money)*10000)/10000;
        return v_investment;
    }
    String m_timeDifference(int p_hour1, int p_minutes1, int p_seconds1, int p_hour2, int p_minutes2, int p_seconds2){
        int v_seconds1, v_seconds2, v_difference, v_difeHour, v_difeMinutes, v_difeSeconds;
        String v_result;
        v_seconds1=(p_hour1*3600)+(p_minutes1*60)+p_seconds1;
        v_seconds2=(p_hour2*3600)+(p_minutes2*60)+p_seconds2;
        v_difference=Math.abs(v_seconds1-v_seconds2);
        v_difeHour=v_difference/3600;
        v_difeMinutes=(v_difference-(v_difeHour*3600))/60;
        v_difeSeconds=v_difference-((v_difeHour*3600)+(v_difeMinutes*60));
        v_result=v_difeHour+":"+v_difeMinutes+":"+v_difeSeconds;
        return v_result;
    }
}
class persData{
    String m_getHomoclave(String p_name){
        char v_homoChar1, v_homoChar2, v_homoChar3, v_homoChar4;
        String v_homoclave;
        v_homoChar1=p_name.charAt(4);
        v_homoChar2=p_name.charAt(6);
        v_homoChar3=p_name.charAt(0);
        v_homoChar4=p_name.charAt(11);
        v_homoclave=String.valueOf(v_homoChar1)+String.valueOf(v_homoChar2)+String.valueOf(v_homoChar3)+String.valueOf(v_homoChar4);
        return v_homoclave;
    }
    String m_getdateofBirth(String p_curp){
        char v_curpChar1, v_curpChar2, v_curpChar3, v_curpChar4, v_curpChar5, v_curpChar6;
        String v_dateofBirth;
        v_curpChar1=p_curp.charAt(4);
        v_curpChar2=p_curp.charAt(5);
        v_curpChar3=p_curp.charAt(6);
        v_curpChar4=p_curp.charAt(7);
        v_curpChar5=p_curp.charAt(8);
        v_curpChar6=p_curp.charAt(9);
        v_dateofBirth=String.valueOf(v_curpChar1)+String.valueOf(v_curpChar2)+"-"+String.valueOf(v_curpChar3)+String.valueOf(v_curpChar4)+"-"+String.valueOf(v_curpChar5)+String.valueOf(v_curpChar6);
        return v_dateofBirth;
    }
}
