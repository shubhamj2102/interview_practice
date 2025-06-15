package practice.stream;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public void oddEven(){
        // 1. separate odd and even numbers
        var list= List.of(1,2,3,4,5,6,7,8);
        var oddNumbers=list.stream().filter(num-> num%2!=0).collect(Collectors.toList());
        var evenNumbers=list.stream().filter(num->num%2==0).collect(Collectors.toList());
        System.out.println("odd numbers= "+oddNumbers);
        System.out.println("even Numbers="+evenNumbers);

        // method 2

       Map<Boolean, List<Integer>> oddEvenList= list.stream().collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println("odd numbers= "+oddEvenList.get(false));
        System.out.println("even Numbers="+oddEvenList.get(true));
    }

    public void freqOfEachChar(){
        var str="abcabccccffr";
       var result= str.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(ch->ch, Collectors.counting()));
        System.out.println(result);
    }

    public void reverseSort(){
        var list=List.of(1,2,3,4,5,6);
        var reverseList=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("reverse list= "+reverseList);
    }

    public void multipleOf5(){
        var list=List.of(5,34,10,25,250,3,4,6,7);

        var multipleOf5=list.stream().filter(num->num%5==0).collect(Collectors.toList());
        System.out.println("multipleOf5 = "+multipleOf5);
    }

    public void mergeSortedArray(){
        var arr1=new int[]{1,3,5,7,8};
        var arr2=new int[]{2,4,6,9};
       var mergedArray= IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().toArray();
        System.out.println("merged array= "+ Arrays.toString(mergedArray));
    }

    public void mergeSortedList(){
        var list1=List.of(1,3,5,7,9);
        var list2=List.of(2,4,6,8);
        var mergedList= Stream.concat(list1.stream(),list2.stream()).sorted().collect(Collectors.toList());
        System.out.println("merged list= "+mergedList);
    }

    public void threeMaxMinNumbers(){
        var list=List.of(1,2,3,4,5,6,8,9,0,10,14,15);

        //3 max numbers
        var threeMinNum=list.stream().sorted().limit(3).collect(Collectors.toList());
        var threeMaxNum=list.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println("threeMinNum= "+threeMinNum);
        System.out.println("threeMaxNum= "+ threeMaxNum);
    }

    public void sortStringsAccToLength(){
        var stringList=List.of("abcccc","a","ab","abbbbb","abc");

       var sortedStringListAccToLength= stringList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("sortedStringListAccToLength = "+sortedStringListAccToLength);
    }

    public void sumAndAverageOfAList(){
        var list=List.of(3,4,5,6,7);
       var sum= list.stream().mapToInt(num -> num).sum();
       var avg=list.stream().mapToDouble(num->num).average().orElse(0.0);
       var sum2=list.stream().collect(Collectors.summingInt(i->i));
       var avg2=list.stream().collect(Collectors.averagingInt(i->i));
        System.out.println("sum= "+sum+", "+"sum2= "+sum2);
        System.out.println("avg= "+avg+", "+"avg2= "+avg2);
    }

    public void groupByDepartmentWithAvgSal(){
        var employees=List.of(
                new Employee("john",10000.0,"IT"),
                new Employee("paul",20000.0,"IT"),
                new Employee("robin",30000.0,"HR"),
                new Employee("Singh",10000.0,"HR"),
                new Employee("jain",50000.0,"HR"),
                new Employee("vikas",60000.0,"FIN"),
                new Employee("shubham",70000.0,"FIN")
                );
       var mapDepToAvgSal= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(mapDepToAvgSal);
    }

    public void reverseIntArray(){
        var intArr=new int[]{1,2,4,5,6};
        var reversedArr=Arrays.stream(intArr).boxed().sorted(Comparator.reverseOrder()).mapToInt(num->num).toArray();
        System.out.println("reversedArray= "+ Arrays.toString(reversedArr));
    }

    public void isPalindrome(){
        String s1="abcba";
        String s2="abcdef";

       var isPalindrome= IntStream.range(0,(s1.length()/2)-1).allMatch(i->s1.charAt(i)==s1.charAt(s1.length()-i-1));
       var isPalindrome2=IntStream.range(0,(s2.length()/2)-1).allMatch(i->s2.charAt(i)==s2.charAt(s2.length()-i-1));
        System.out.println("abcba is "+(isPalindrome?"palindrome":"not palindrome"));
        System.out.println("abcdef is "+(isPalindrome2?"palindrome":"not palindrome"));
    }

    public void lastEltOfArray(){
        var arr=new int[]{1,2,3,4,5,6};

        var lastElt=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(i->i).findFirst().getAsInt();
        var lastElt2=Arrays.stream(arr).skip(arr.length-1).findFirst().getAsInt();
        System.out.println("last element= "+lastElt);
        System.out.println("last element2= "+lastElt2);
    }

    public void getAge(){
        LocalDate birthDate=LocalDate.of(1994,2,21);
        LocalDate today=LocalDate.now();
        var age=ChronoUnit.YEARS.between(birthDate,today);
        var period= Period.between(birthDate,today);
        System.out.println("age1= "+age);
        System.out.println("age2="+period.getYears()+" years and "+period.getMonths()+" months and "+period.getDays()+" days");
    }

    public void freqOfElts(){
        var list=List.of(1,2,4,4,4,5,5,6,6,6,6,6,6,7,8,8,9);
       var freqMap= list.stream().collect(Collectors.groupingBy(elt->elt,Collectors.counting()));
        System.out.println(freqMap);
    }

    public void stringJoining(){
        var strArr=List.of("prefix", "delimiter","suffix");
       var joinedString= strArr.stream().collect(Collectors.joining());
        System.out.println("Joined= "+joinedString);
    }

    public void getMinMax(){
        var list=List.of(1,-1,2,4,5,5,6,6);
       var max= list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max="+max);
        var min=list.stream().min(Comparator.naturalOrder()).get();
        System.out.println("min= "+min);
    }

    public void isAnagram(){
        String s1="abcccd";
        String s2="cccabd";
      var isAnagram=  s1.chars().mapToObj(ch->String.valueOf((char) ch)).sorted().collect(Collectors.joining()).equals(
              s2.chars().mapToObj(ch->String.valueOf((char) ch)).sorted().collect(Collectors.joining())
      );
        System.out.println(isAnagram?(s1 +" and "+s2 +" are anagram"):(s1 +" and "+s2 +" are not anagram"));
    }

    public void sumOfDigits(){
        int number=1234567;
        var sum=String.valueOf(number).chars().mapToObj(ch -> ch - '0').mapToInt(i -> i).sum();
        var sum2=String.valueOf(number).chars().mapToObj(ch->ch-'0').collect(Collectors.summingInt(i->i));
        System.out.println("sum= "+sum);
        System.out.println("sum2= "+sum2);
        var sum3=Stream.of(String.valueOf(number).split("")).collect(Collectors.summingInt(s->Integer.parseInt(s)));
        System.out.println("sum3="+sum3);
    }

    public void commonElts(){
        var list1=List.of(1,2,3,4,5);
        var list2=List.of(3,4,5,6,7,8);

       var commElts= list1.stream().filter(num->list2.contains(num)).collect(Collectors.toList());
        System.out.println("commElts= "+ commElts);
    }

    public void reverseEachWord(){
        var str="Hello world in java";
       var result= Stream.of(str.split(" ")).map(s->new StringBuilder(s).reverse()).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public void naturalNumbersSum(){
        var sum=IntStream.range(1,11).sum();
        System.out.println("10 Natual number sum= "+sum);
    }

    public void stringStartWithDigit(){
        var list=List.of("asjkhsk","9fkjeds","8kfn","fjiw4o");
        var result=list.stream().filter(str->Character.isDigit(str.charAt(0))).collect(Collectors.toList());
        System.out.println("stringStartWithDigit="+result);
    }

    public void findDuplicate(){
        var list=List.of(1,2,3,3,3,4,4,5,6);
        var set=new HashSet<Integer>();

      var result=  list.stream().filter(elt->list.indexOf(elt)!=list.lastIndexOf(elt)).distinct().collect(Collectors.toList());
      var result2=list.stream().filter(i->!set.add(i)).collect(Collectors.toSet());
        System.out.println("duplicate elements= "+result);
        System.out.println("duplicate elements 2= "+result2);
    }
    public void fibonacciSeries(){
       var result= Stream.iterate(new int[]{0,1},arr->new int[]{arr[1],arr[0]+arr[1]}).map(arr->arr[0]).limit(10).collect(Collectors.toList());
        System.out.println("fibonacci series= "+result);
    }
}
