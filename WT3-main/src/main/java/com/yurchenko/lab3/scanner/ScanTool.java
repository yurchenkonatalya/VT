package com.labovichl.lab3.scanner;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanTool {
    private  static  final Scanner scanner=new Scanner(System.in);

    private static final String NATURAL_NUMBER_REGEX = "^(([1-9][0-9]*)|([1-9]))$";
    private static final String ADRES_SERVER_REGEX =
            "^(((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?):([1-9]\\d*))$";
    private static final String LOGIN_PASSWORD_REGEX = "^[^:]+:[^:]+$";
    private static final String STUDENT_INFO_REGEX =
            "^(([^:]+:){3}((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d):([^:]+):(\\d{8}):([^:]+))$";
    private static final String GRADE_BOOK_NUMBER_REGEX = "^\\d{8}$";
    private static final String UPDATE_STUDEMT_INFO_REGEX =
            "^((\\d{8}):([^:]+:){3}((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d):([^:]+):(\\d{8}):([^:]+))$";



    public static int scanPositiveNumberInRange(int start,int end){
        String str=scanner.nextLine();
        int result=-1;
        if (isNaturalNunberValid(str)){
            int tempResult=Integer.parseInt(str);
            if(isNumberInRange(tempResult,start,end)){
                result=tempResult;
            }
        }
        return result;
    }

    public static String scanAddressServer(){
        String str=scanner.nextLine();
        String result="-1";
        if (isAdressServerValid(str)){
            result=str;
        }
        return result;
    }

    public static String scanLoginPassword(){
        String str=scanner.nextLine();
        String result="-1";
        if (isLoginPasswordValid(str)){
            result=str;
        }
        return result;
    }

    public static String scanBookNumber(){
        String str=scanner.nextLine();
        String result="-1";
        if (isBookNumberValid(str)){
            result=str;
        }
        return result;
    }

    public static String scanStudentInfo(){
        String str=scanner.nextLine();
        String result="-1";
        if (isStudentInfoValid(str)){
            result=str;
        }
        return result;
    }

    public static String scanUpdateStudentInfo(){
        String str=scanner.nextLine();
        String result="-1";
        if (isUpdateStudentInfoValid(str)){
            result=str;
        }
        return result;
    }

    public static String scanSpeciality(){
        String str=scanner.nextLine();
        String result="-1";
        if (!str.isEmpty()){
            result=str;
        }
        return result;
    }






    private static boolean isNaturalNunberValid(String number){
        Pattern pattern = Pattern.compile(NATURAL_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }
    private static boolean isAdressServerValid(String adressServer){
        Pattern pattern = Pattern.compile(ADRES_SERVER_REGEX);
        Matcher matcher = pattern.matcher(adressServer);
        return matcher.find();
    }
    private static boolean isNumberInRange(int number,int start,int end){
        if(!(number>=start && number<=end)){
            return false;
        }
        return true;
    }

    private static boolean isLoginPasswordValid(String loginPassword){
        Pattern pattern = Pattern.compile(LOGIN_PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(loginPassword);
        return matcher.find();
    }

    private static boolean isStudentInfoValid(String stydentInfo){
        Pattern pattern = Pattern.compile(STUDENT_INFO_REGEX);
        Matcher matcher = pattern.matcher(stydentInfo);
        return matcher.find();
    }
    private static boolean isUpdateStudentInfoValid(String updateStydentInfo){
        Pattern pattern = Pattern.compile(UPDATE_STUDEMT_INFO_REGEX);
        Matcher matcher = pattern.matcher(updateStydentInfo);
        return matcher.find();
    }

    private static boolean isBookNumberValid(String bookNumber){
        Pattern pattern = Pattern.compile(GRADE_BOOK_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(bookNumber);
        return matcher.find();
    }
}
