    import java.util.Scanner;
    public class p2 {
        public static void main(String[] args) {
            sumLarge Object=new sumLarge();
            Object.m_showResults();
        }
    }
    class sumLarge {
        int a_cases, a_length1, a_length2, a_subtraction;
        String a_number1, a_number2;
        Scanner a_keyboard = new Scanner(System.in);

        public void m_getCases() {
            a_cases = a_keyboard.nextInt();
        }

        public void m_getNumbers() {
            a_number1 = a_keyboard.next();
            a_number2 = a_keyboard.next();
        }

        private void m_getLength() {
            a_length1 = a_number1.length();
            a_length2 = a_number2.length();
        }

        private void m_subsLength() {
            a_subtraction = Math.abs(a_length1 - a_length2);
        }

        private void m_getnumbZeros() {
            int v_meter1 = 0;
            if (a_length1>a_length2) {
                while (v_meter1 < a_subtraction) {
                    a_number2 = "0" + a_number2;
                    v_meter1++;
                }
            }
            else{
                while (v_meter1 < a_subtraction) {
                    a_number1 = "0" + a_number1;
                    v_meter1++;
                }
            }
        }
        private void m_getsum(){
            int v_meter2, v_number1=0,v_firsResult;
            String v_totaSuma="";
            for(v_meter2=0;v_meter2<=a_length1-1;v_meter2++){
                v_firsResult=a_number1.charAt(v_meter2)+a_number2.charAt(v_meter2) - 96+v_number1;
                v_number1=v_firsResult/10;
                v_totaSuma+=v_firsResult%10;
            }
            if(v_number1==1)
                v_totaSuma+=1;
            System.out.println(Integer.parseInt(v_totaSuma));
        }
        public void m_showResults(){
            int v_meter3;
            m_getCases();
            for(v_meter3=0;v_meter3<a_cases;v_meter3++){
                m_getNumbers();
                m_getLength();
                m_subsLength();
                m_getnumbZeros();
                m_getsum();
            }
        }
    }