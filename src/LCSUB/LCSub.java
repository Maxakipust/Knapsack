package LCSUB;

public class LCSub {
    static void LongestCommonSubsequence(String x, String y){
        System.out.print("_\t");
        for(int i = 0; i< y.length(); i++){
            System.out.print(y.charAt(i)+"\t");
        }
        System.out.println();
        for(int i =0; i<x.length(); i++){
            System.out.print(x.charAt(i)+"\t");
            for(int j = 0; j<y.length(); j++){
                String st = LCST(x,y,i,j);
                System.out.print(st.equals("")?"_":st);
                System.out.print("\t");
            }
            System.out.println();
        }
    }


    static String LCST(String x, String y, int i, int j){
        if(i==-1 || j==-1){
            return "";
        }
        if(x.charAt(i) != y.charAt(j)){
            String first = LCST(x, y, i, j-1);
            String second = LCST(x,y,i-1, j);
            if(first.length()>second.length()){
                return first;
            }else{
                return second;
            }
        }else{
            return LCST(x,y,i-1, j-1) + x.charAt(i);
        }

    }

    public static void main(String[] args) {
        LongestCommonSubsequence("cbabac", "abcabba");
    }
}
