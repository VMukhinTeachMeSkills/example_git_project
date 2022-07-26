package com.tms.courses.vm.lesson17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main
{
    public static final String TXT_FILE_REGEX = ".*\\.txt";
    public static final String DOCUMENT_NUMBER_REGEX = "\\d{4}-[a-zа-я]{3}-\\d{4}-[a-zа-я]{3}-(\\d[a-zа-я]){2}";
    public static final String PHONE_REGEX = "\\+\\(\\d{2}\\)\\d{7}";
    public static final String EMAIL_REGEX = "[A-Z0-9._]+@[A-Z0-9.-]+\\.[A-Z]{2,6}";


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String dirPath = scanner.next();
        if (!scanner.hasNextInt())
        {
            System.out.println("Error: invalid input");
            return;
        }
        Integer n = scanner.nextInt();

        File directory = new File(dirPath);
        if (!directory.isDirectory())
        {
            System.out.println("Error: invalid directory path");
            return;
        }
        List<String> allFilesList = Arrays.asList(directory.list());

        if (allFilesList.isEmpty())
        {
            System.out.println("Error: empty directory");
            return;
        }

        Pattern txtFilePattern = Pattern.compile(TXT_FILE_REGEX);

        List<String> txtFileNames = allFilesList.stream()
                .filter(filename -> txtFilePattern.matcher(filename).matches())
                .collect(Collectors.toList());

        if (txtFileNames.isEmpty())
        {
            System.out.println("Error: no txt files found");
            return;
        }

        Map<String, Document> result = new HashMap<>();

        txtFileNames.stream()
                .limit(n)
                .forEach(filename -> processFile(new File(directory, filename), result));

        System.out.println("Number of documents processed: " + result.size());
        System.out.println(result);
    }

    private static void processFile(File file, Map<String, Document> map)
    {
        Scanner scanner;
        try
        {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file with path " + file.getPath() + " not found");
            return;
        }
        scanner.useDelimiter("\\Z");
        String content = scanner.next();

        Matcher documentMatcher = Pattern.compile(DOCUMENT_NUMBER_REGEX).matcher(content);
        if (documentMatcher.find())
        {
            String docNum = documentMatcher.group();
            Matcher phoneMatcher = Pattern.compile(PHONE_REGEX).matcher(content);
            Matcher emailMatcher = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE).matcher(content);
            Document document = new Document();
            if (phoneMatcher.find())
            {
                document.setPhone(phoneMatcher.group());
            }
            if (emailMatcher.find())
            {
                document.setEmail(emailMatcher.group());
            }
            map.put(docNum, document);
        }
    }
}
