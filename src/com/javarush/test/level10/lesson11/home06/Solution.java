package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String firstName;
        String lastName;
        int age;
        boolean sex;
        boolean married;
        boolean dead;

        Human() {}

        Human(String firstName) {
            this.firstName = firstName;
        }

        Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        Human(String firstName, String lastName, int age, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }
        Human(String firstName, String lastName, int age, boolean sex, boolean married) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.married = married;
        }
        Human(String firstName, String lastName, int age, boolean sex, boolean married, boolean dead) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.married = married;
            this.dead = dead;
        }
        Human(int age) {
            this.age = age;
        }
        Human(int age, boolean sex) {
            this.age = age;
            this.sex = sex;
        }

        Human (int age, boolean sex, boolean married) {
            this.age = age;
            this.sex = sex;
            this.married = married;
        }
    }
}
