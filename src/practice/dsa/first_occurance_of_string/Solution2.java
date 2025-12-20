package practice.dsa.first_occurance_of_string;

public class Solution2 {

    private int[] getLps(String pat){
        int n=pat.length();
        int [] lps=new int[n];

        int len=0, i=1;

        while(i<n){
            if(pat.charAt(i)==pat.charAt(len)){
                lps[i]=len+1;
                len++;
                i++;
            }
            else if(len!=0){
                len=lps[len-1];
            }
            else{
                i++;
            }
        }

        return lps;
    }

    public int strStr(String haystack, String needle) {

        int n=haystack.length();
        int m=needle.length();

        int [] lps=getLps(needle);

        int i=0, j=0;

        while(i<n && j<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            } else if (j!=0) {
                j=lps[j-1];
            }
            else{
                i++;
            }

            if(j==m) return i-m;
        }

        return -1;

    }
}
