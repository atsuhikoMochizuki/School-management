package fr.mochizuki;

import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;

import fr.mochizuki.entity.Student;
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student (1,"Sayien","sangoku.sayien@gmail.com","kamé-house");

        System.out.println(student.ToString());


    }
}
