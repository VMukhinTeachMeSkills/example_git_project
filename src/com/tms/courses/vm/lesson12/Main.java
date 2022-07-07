package com.tms.courses.vm.lesson12;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        File file = new File("/home/user/example/", "test.txt");
        File fileToWrite = new File("/home/user/example/", "outputTest.txt");
        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line1 = reader.readLine();
            reader.close();

            System.out.println(line1);

            FileWriter fileWriter = new FileWriter(fileToWrite);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(line1);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
