import java.util.*;

/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
        Stack<T> s2=(Stack<T>) s.clone();
        Stack<T> s3=new Stack<>();
        while(!s2.isEmpty())
            s3.push(s2.pop());
        return s3;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    {
        if(s1.size()!=s2.size())
            return false;
        Stack<T> s1c=(Stack<T>) s1.clone();
        Stack<T> s2c=(Stack<T>) s2.clone();
        while(!s1c.isEmpty())
            if(!s1c.pop().equals(s2c.pop()))
                return false;
        return true;
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
        String[] semboller=splitToTokens(girdi);
        Stack<Integer> s=new Stack<>();
        int d1,d2;
        for(String sembol:semboller){
            switch(sembol) {
                case "+":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d2+d1);
                break;
                case "-":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d2-d1);
                break;
                case "*":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d2*d1);
                break;
                case "/":
                    d1=s.pop();
                    d2=s.pop();
                    s.push(d2/d1);
                break;
                default:
                    s.push(Integer.parseInt(sembol));
                break;
            }
        }
        return s.pop();
    }

    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    public static String infixToPostfix(String girdi){
        //Metodun gövdesini yazınız
        return null;
    }

    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
}
