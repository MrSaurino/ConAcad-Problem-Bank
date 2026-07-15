import java.util.Scanner;
public class p172 {
    public static void main(String[] args) {
        paliChecker Objeto=new paliChecker();
        System.out.println("Gay si no compila");
    }
}
class paliChecker{
    int a_cases;
    String a_palindrome, a_invePalindrome;
    Scanner a_keyboard=new Scanner(System.in);
    public void m_getCases(){
        a_cases=a_keyboard.nextInt();
        a_keyboard.nextLine();
    }
    public void m_getPalindrome(){
        a_palindrome=a_keyboard.nextLine();
    }
    String m_revePalindrome(){
        a_invePalindrome=a_palindrome;
        return a_invePalindrome;
    }
}
