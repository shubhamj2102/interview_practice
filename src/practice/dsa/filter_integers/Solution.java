package practice.dsa.filter_integers;

import java.util.List;

public class Solution {

    public List<String> validIntegers(List<String> input){

      return input.stream().filter(str->!str.isEmpty()).filter(str->str.charAt(0)=='-'  ?
               str.length()>1 && str.substring(1).chars().allMatch(Character::isDigit):
              str.chars().allMatch(Character::isDigit) ).toList();

    }
}
