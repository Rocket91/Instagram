package com.applicatech.instagram;

import android.app.AlertDialog;



import com.parse.ParseException;

import com.parse.ParseUser;



import static com.parse.ParseException.INVALID_SESSION_TOKEN;



public class ParseErrorHandler {

    public static void handleParseError(ParseException e){

        switch (e.getCode()){

            case INVALID_SESSION_TOKEN: handleInvalidSessionToken();

                break;

        }

    }



    private static void handleInvalidSessionToken(){

        ParseUser.logOut();

    }

}