package nure.four.labOne;

/**
 * Создать списочный массив Book (полями должно быть ФИО автора, названию книги, издательство,
 * год, количество страниц). Получить поток элементов списочного массива,
 * определить  максимальное  (метод  max() ) и
 * минимальное(метод min()) значение количества страниц,
 * отсортировать (метод sorted()) книги в потоке  в порядке убывания количества страниц.
 * Произвести вывод на экран  данных о четных значениях  годов издания и о нечетных количествах страниц,
 *  больших, значения, введенного  с клавиатуры
 */


import java.util.stream.*;
import java.util.*;
import java.util.ArrayList;

/**
 * @author Daryna
 *Лабораторная работа 1 - Потоки данных и Лямбда-выражения Даниленко КИ-15-4
 */
public class Bookshop {

    /**
     * @param args

     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Создание списочного массива типа Book
        ArrayList<Book> MyList=new ArrayList<Book>();
        MyList.add(new Book("Illya", "Math", "Kyiv", 1997, 557));
        MyList.add(new Book("Valya", "Phylosophy", "Kharkiv", 1996, 200));
        MyList.add(new Book("Anna", "Thesis", "Kyiv", 2001, 150));
        MyList.add(new Book("Ann", "Databases", "Kyiv", 2002, 151));
        MyList.add(new Book("Ekkel", "Thinking in Java", "SpB", 1998, 153));
        MyList.add(new Book("Mergov", "Jsp theory", "SpB", 2007, 150));
        MyList.add(new Book("Everyone", "Wiki", "Kyiv", 2018, 1155));

        Stream<Book> Berr=MyList.stream();
        System.out.println("В начале список по страницам: ");
        Berr.forEach((a)->System.out.println("Автор:"+a.getFio()+" Название:"+a.getTitle()+" Страниц:"+a.getPages()+" Год:"+a.getYear()));
        System.out.println();
        // получаем поток
        Stream<Book> MyStr=MyList.stream();

        // Получение максимального и минимального значения, вызываяметоды min(),
        // max(), isPresent(), и get().
        Optional<Book> minVal = MyStr.min(Comparator.comparing(Book::getPages));
        if (minVal.isPresent()) System.out.println("Минимальное значение страниц: " +
                minVal.get().getPages());

        MyStr=MyList.stream();
        Optional<Book> maxVal = MyStr.max(Comparator.comparing(Book::getPages));
        if (maxVal.isPresent()) System.out.println("Максимальное значение страниц: " +
                maxVal.get().getPages());


        MyStr=MyList.stream().sorted(Comparator.comparing(Book::getPages).reversed());
        System.out.print("Отсортировано по убыванию количества страниц: ");
        MyStr.forEach((a)->System.out.print(a.getPages()+" "));
        System.out.println();

        System.out.println("Введите число:");
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        MyStr=MyList.stream().filter((a)->(a.getYear()%2)==0).filter((n)->(n.getPages()%2)==1).filter((a)-> num<a.getPages());
        System.out.println("Отфильтрованы по четным годам и нечетным страницам относительно введенного числа: ");
        MyStr.forEach((a)->System.out.println(a.getTitle()+" "+a.getYear()+" "+a.getPages()+" "));
        System.out.println();

          }

}

