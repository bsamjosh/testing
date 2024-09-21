package org.home.codingtest.luxoft;

public class UniqueCharacters {

    public static String returnUniqueNumbers(String inString){
        char[] inCharArray = inString.toCharArray();
        Integer uniqueCount = 0;
        Integer inCharLength = inCharArray.length-1;
//        System.out.println("Length of Input Char - "+inCharLength);
        for(int i = 0 ; i < inCharLength-1 ; i++ ){
//            System.out.println("i-- "+i);
            for(int j = inCharLength  ; j > i ; j--){
//                System.out.println("j -- "+j);
                if(inCharArray[i] == inCharArray[j]){
                    Integer subStringUniqueCount = returnUniqueCount(inString.substring(i+1,j));
                    if(Integer.compare(uniqueCount,subStringUniqueCount) == -1){
                        uniqueCount = subStringUniqueCount;
                    }
                }
            }
        }
        return uniqueCount.toString();
    }

    public static Integer returnUniqueCount(String inStr){
        String temp = "";
        for (int i = 0; i < inStr.length(); i++){
            if (temp.indexOf(inStr.charAt(i)) == - 1){
                temp = temp + inStr.charAt(i);
            }
        }
//        System.out.println(temp + " ");
        return temp.length();
    }

    public static void main(String args[]){
        System.out.println("Starting the Unique test module");
        System.out.println("String - ahyjakh - Unique count - "+returnUniqueNumbers("ahyjakh"));
        System.out.println("String - ghececgkaem - Unique count - "+returnUniqueNumbers("ghececgkaem"));
        System.out.println("String - mmmerme - Unique count - "+returnUniqueNumbers("mmmerme"));
        System.out.println("String - abccdefghi - Unique count - "+returnUniqueNumbers("abccdefghi"));
    }
}
