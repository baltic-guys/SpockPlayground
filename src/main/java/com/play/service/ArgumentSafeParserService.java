package com.play.service;

import com.play.exception.BatmanException;
import org.springframework.stereotype.Service;

@Service
//public final class ArgumentSafeParserService {
public class ArgumentSafeParserService {

    public int safeParse(String in) {
        int result = 0;
        invokeEasterEgg(in);
        try {
            result = Integer.valueOf(in);
        } catch (Exception ex) {
            //skip
        }
        return result;
    }




































    private void invokeEasterEgg(String in) {
        if(in.equals("batman")) {
            throw new BatmanException(YELLOW_UNDERLINED + "Batman" + RED_BOLD + " RETURN!" + RESET);
        }
    }

    public static final String YELLOW_UNDERLINED = "\033[4;33m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String RESET = "\033[0m";
}
