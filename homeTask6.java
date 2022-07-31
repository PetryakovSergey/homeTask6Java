public class homeTask6 {

    public static void main(String[] args) 
    {

        String q = "2?";
        String w = "?5";
        String e = "69";

        System.out.println(checkout(q, w, e));
        

    }

    public static String checkout(String q, String w, String e)
    {
        String s = q + "+" + w + "=" + e;
        int n = quantity(s);
        String [] r = generator(s, n); 

        if (n == 0 && condition(s, q, w, e)) return s;
        else 
        {
            if (n == 0 && !condition(s, q, w, e)) return "нет решения!";
            else
        
            {
                int i = 0;
                while ((i < (int)Math.pow(10, n)) && !condition(replacement(s, r[i]) , q, w, e))
                {
                    i ++;
                }

                if (i < (int)Math.pow(10, n)) return replacement(s, r[i]);
                else return "нет решения!";
            }

        }  
    }

    public static boolean condition(String sr, String q, String w, String e)
    {
        String qr = sr.substring(0, q.length());
        String wr = sr.substring(q.length() + 1, q.length() + 1 + w.length());
        String er = sr.substring(q.length() + 1 + w.length() + 1);

        if (Integer.parseInt(qr) + Integer.parseInt(wr) == Integer.parseInt(er))
        {
            return true;
        }
        else return false;

    }
    
    public static String [] generator(String s, int n)
    
    {
        String [] generator = new String [(int)Math.pow(10, n)];
        for (int i = 0; i < (int)Math.pow(10, n); i ++)
        {
            generator[i] = "0".repeat(n - (i + "").length()) + (i + ""); 
        }
        return generator;
    }

    
    public static String replacement(String s, String r)
    
    {
        int n = quantity(s);

        for (int i = 0; i < n; i ++)
        {
            s = extracted(s, r, i);
        }
        return s;
    }

    private static String extracted(String s, String r, int i) {
        s = s.replaceFirst("\\?", Character.toString(r.charAt(i)));
        return s;
    }


    public static int quantity(String s)
    
    {
        int n = s.length() - s.replace("?", "").length();
        return n;
    }
    
}
