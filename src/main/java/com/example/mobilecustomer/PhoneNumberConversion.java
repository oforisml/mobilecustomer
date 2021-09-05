package com.example.mobilecustomer;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.Locale;

public class PhoneNumberConversion {
    public static String formatPhone( String msisdn) {
        char[] S;
        String s = msisdn;



        String  formatted;
        if(s.charAt(0)=='0') {
            S=s.toCharArray();
            S[0]='9';
            s = String.valueOf(S);

            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumber = null;
            try {
                phoneNumber = phoneUtil.parse(s, Locale.US.getCountry());
            } catch (NumberParseException e) {
                e.printStackTrace();
            }
            String newString = phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
            S = newString.toCharArray();
            S[1]='0';
            formatted = String.valueOf(S);


        }

        else {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumber = null;
            try {
                phoneNumber = phoneUtil.parse(s, Locale.US.getCountry());
            } catch (NumberParseException e) {
                e.printStackTrace();
            }
            formatted = phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        }
        return formatted;

    }
}


