package com.vc.hard;

class IntegerToEnglishWords {
    private String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        else return helper(num);
    }

    private String helper(int num) {
        String str = "";
        if(num < 10) str = belowTen[num % 10];
        else if(num < 20) str = belowTwenty[num % 10] ;
        else if(num < 100) str = belowHundred[num / 10] +" "+helper(num % 10);
        else if(num < 1000) str = helper(num / 100) +" Hundred "+helper(num % 100);
        else if(num < 1_000_000) str = helper(num / 1000) +" Thousand "+helper(num % 1000);
        else if(num < 1_000_000_000) str = helper(num / 1_000_000) +" Million "+helper(num % 1_000_000);
        else str = helper(num / 1_000_000_000) +" Billion "+helper(num % 1_000_000_000);
        return str.trim();
    }
}