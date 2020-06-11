package com.vc.web.util;

public class UrlUtil {
    public static String slug(String str) {
        return str.toLowerCase()
           .trim()
           .replaceAll(" ", "-")                       //replace spaces with -
           .replaceAll("&", "and")                     //replace & with and
           .replaceAll("[^\\p{L}\\p{Nd}-]+", "")       //replace non-word characters
           .replaceAll("[-]+", "-")                    //collapse multiple dashes
           .replaceAll("^-+", "")                      //trim starting dash
           .replaceAll("-+$", "");                     //trim ending dash
    }

    public static String unSlug(String str) {
        String[] arr = str.trim().replaceAll("-", " ").split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}
