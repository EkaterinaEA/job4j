package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
      //  char[] leftChar = left.toCharArray();
      //  char[] rightChar = right.toCharArray();
        int lenth = Math.min(left.length(), right.length());
        for (int i = 0; i < lenth; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (left.length() != right.length() && result == 0) {
            if (left.length() < right.length()) {
                result = -1;
            } else result = 1;
        }
        return result;
    }


// иван < иванов т.к. символы и, в , а ,н
// равны,а его длина меньше,  но иван > андрей, потому что а<и
//т.е. в первую очередь мы сравниваем символы. если у меньшего слова
// символы совпадают с большим, то решает длина


}