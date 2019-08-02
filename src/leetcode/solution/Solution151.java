package leetcode.solution;

import java.util.Arrays;

/**
 * 151. 翻转字符串里的单词
 */
public class Solution151 {
    public  String reverseWords(String s) {
        if (s==null||s.length() == 0) {
            return s;
        }
        char[] charArr = clear(s.toCharArray());
        if(charArr==null){
            return "";
        }
        int i = 0, j = 0;
        while ( j <= charArr.length ) {
            if(j==charArr.length||charArr[j]==' '){
                reverse(charArr, i, j-1);
                i = j + 1;
            }
            j++;
        }
        reverse(charArr,0,charArr.length-1);
        return new String(charArr);
    }
    public  char[]  clear(char[]  charArray) {
        int t = 0;
        for (int i = 0; i <charArray.length ; i++) {
            if(charArray[i] == ' '){
                if (t > 0 && charArray[t-1] != ' ') {
                    charArray[t++] = charArray[i];
                }
            }else{
                charArray[t++] = charArray[i];
            }
        }
        if (t == 0) {
            return null;
        }else{
            if (charArray[t - 1]==' ') {
                return Arrays.copyOfRange(charArray, 0, t-1);
            }else {
                return Arrays.copyOfRange(charArray, 0, t);
            }
        }
    }
    public  void reverse(char[] arr,int i,int j) {
        while (i < j) {
            char tmp= arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
