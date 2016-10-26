package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("ch1", true, 82);
        Human child2 = new Human("ch2", true, 82);
        Human child3 = new Human("ch3", true, 82);
        Human father = new Human("dad", true, 82, child1, child2,child3);
        Human mother = new Human("mom", false, 82, child1, child2,child3);
        Human grandFather1 = new Human("ded1", true, 82, father);
        Human grandFather2 = new Human("ded2", true, 82, mother);
        Human grandMother1 = new Human("ba1", false, 82, father);
        Human grandMother2 = new Human("ba2", false, 82, mother);
        System.out.println(grandMother2);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandFather1);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child3);
        System.out.println(child2);
        System.out.println(child1);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human(String name, boolean sex, int age, Human... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            ArrayList<Human> childrenCopy = new ArrayList<>();
            for (Human child : children)
            {
                childrenCopy.add(child);
            }
            this.children = childrenCopy;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
