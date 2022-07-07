package com.tms.courses.vm.lesson10;

public class StringUtil
{
    private static final String ABC = "abc";

    //xxxx-yyy-xxxx-yyy-xyxy

    public static void printFirstTwoBlocks(String str)
    {
        System.out.println(str.substring(0, 4));
        System.out.println(str.substring(9, 13));
    }

    public static void printWithSlash(String str)
    {
        String[] words = str.split("-");
        StringBuilder sb = new StringBuilder("Letters:");
        sb.append(words[1].toUpperCase()).append("/");  //xxxx-YYY-xxxx-yyy-xyxy
        sb.append(words[3].toUpperCase()).append("/");  //xxxx-yyy-xxxx-YYY-xyxy

        Character character = words[4].charAt(1);
        sb.append(character.toString().toUpperCase()).append("/"); //xxxx-yyy-xxxx-yyy-xYxy

        Character character1 = words[4].charAt(3);
        sb.append(character1.toString().toUpperCase()).append("/"); //xxxx-yyy-xxxx-yyy-xyxY

        System.out.println(sb);
    }

    public static void checkStringContainsAbs(String str) throws NotContainsABCException
    {
        boolean contains = str.contains(ABC);
        if (contains)
        {
            System.out.println("String " + str + " contains abc");
        }
        else
        {
            NotContainsABCException exception = new NotContainsABCException("String " + str + " not contains abc");
            throw exception;
        }
    }

    public static String findLeastUniqueSymbolsWord(String str)
    {
        String[] words = str.split(" ");

        String minString = words[0];
        int minUnique = findUniqueNumberOfChars(words[0]);
        for(int i = 1; i < words.length; i++)
        {
            int currentUnique = findUniqueNumberOfChars(words[i]);
            if (currentUnique < minUnique)
            {
                minUnique = currentUnique;
                minString = words[i];
            }
        }

        return minString;
    }

    private static int findUniqueNumberOfChars(String word)
    {
        char[] letters = word.toCharArray();
        int counter = 0;
        for (int i = 0; i < letters.length; i++)
        {
            String currentLetter = String.valueOf(letters[i]); // char letters[i] to String
            if (!word.substring(i + 1, word.length()).contains(currentLetter)) // если нету символа, добавляем счетчик
            {
                counter++;
            }
        }

        return counter;
    }

    public static void checkThreeLetters(String str)
    {
        String[] words = str.split("-");
        for (String word: words)
        {
            if (word.length() == 3 && stringContainsOnlyLetters(word))
            {
                word = "***";
            }
            System.out.println(word + "-");
        }
    }

    private static boolean stringContainsOnlyLetters(String str)
    {
        char[] letters = str.toCharArray();
        for (Character letter: letters)
        {
            if (Character.isLetter(letter))
            {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
