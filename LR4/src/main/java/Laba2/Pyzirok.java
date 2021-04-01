package Laba2;

class ArrayBubble{
    private long[] a;   //ссылка на массив
    private int elems;  //количество элементов в массиве

    public ArrayBubble(int max){    //конструктор класса
        a = new long[max];          //создание массива размером max
        elems = 0;                  //при создании массив содержит 0 элементов
    }

    public void into(long value){   //метод вставки элемента в массив
        a[elems] = value;           //вставка value в массив a
        elems++;                    //размер массива увеличиваетс¤
    }

    public void printer(){          //метод вывода массива в консоль
        for (int i = 0; i < elems; i++){    //дл¤ каждого элемента в массиве
            System.out.print(a[i] + " ");   //вывести в консоль
            System.out.println("");         //с новой строки
        }
        System.out.println("----Окончание вывода массива----");
    }

    private void toSwap(int first, int second){ //метод мен¤ет местами пару чисел массива
        long dummy = a[first];      //во временную переменную помещаем первый элемент
        a[first] = a[second];       //на место первого ставим второй элемент
        a[second] = dummy;          //вместо второго элемента пишем первый из временной пам¤ти
    }

    public void bubbleSorter(){     
        for (int out = elems - 1; out >= 1; out--){  //внешний цикл
            for (int in = 0; in < out; in++){       //внутренний цикл
                if(a[in] > a[in + 1])               //если порядок элементов нарушен
                    toSwap(in, in + 1);             //вызвать метод, мен¤ющий местами
            }
        }
    }

    public long[] Test(){
        return a;
    }

}

public class Pyzirok {
    public static void main(String[] args) {
        ArrayBubble array = new ArrayBubble(5); //—создаем массив array на 5 элементов

        array.into(163);       //заполняем массив
        array.into(300);
        array.into(184);
        array.into(191);
        array.into(174);

        array.printer();            //выводим элементы до сортировки
        array.bubbleSorter();       //применяем сортировку
        array.printer();            //снова выводим отсортированный йсписок
    }
    
}
