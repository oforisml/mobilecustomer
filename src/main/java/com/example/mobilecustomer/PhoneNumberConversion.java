package com.example.mobilecustomer;

public class PhoneNumberConversion {
    public static String formatPhone(String phoneNumber, String formattingPattern, String countryCode){
        if(phoneNumber == null)
            return null;
        if (formattingPattern == null)
            return phoneNumber;
        if(countryCode == null)
            return phoneNumber;

        int numberPatternn = "#".charAt(0);
        String formattedPhone = "";
        String normalizedNumber ;
        boolean hasCountryCode = false;

        //calculating pattern length without spaces, etc
        int patternLength = formattingPattern.replaceAll(" ", "").length();

        //normalizing the number
        normalizedNumber = phoneNumber.replaceAll("[^]")

        }
    }
}
