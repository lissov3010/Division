import java.util.ArrayList;
import java.util.List;
/*2 динамических массива случайных чисел от 0 до 100
производим деление каждого значения 1 на соответствуещий индекс 2 массива
при результате меньше 1 выбросить Exception
 */
public class DivisionNumArray {
    public static void main(String[] args) {
        double result = 0;
        List<Double> list1 = new ArrayList<>();//c писок на основе массива
        for (int i = 0; i < 10; i++)//Цыкл со счетчиком
            list1.add(((Math.random() * 100)));//список возвращает boolean c плавающей точкой

        List<Double> list2 = new ArrayList<>();
        for (int j = 0; j < 10; j++)
            list2.add(((Math.random() * 100)));

        System.out.println("Первый массив случайных чисел:");
        for (Double x: list1)
            System.out.printf("%.2f\t",x);//табуляция перевод строки

        System.out.println("\nВторой массив случайных чисел:");
        for (Double y:list2)
            System.out.printf("%.2f\t",y);

        System.out.println("\n");//это символ escape для строк который заменяется новым объектом

        for (int k = 0; k < list1.size(); k++){
            try{//определяет блок кода в котором может произойти исключение
                if (list2.get(k) == 0)//возвращает элемент расположенный в указанной позиции
                throw new ArithmeticException();

                result = list1.get(k) / list2.get(k);

                if (result < 1)
                    throw new DivisionExc(list1.get(k),list2.get(k));
                System.out.printf("Результат деления %.2f на %.2f равен %.2f\n",list1.get(k),list2.get(k),result);


            }catch (DivisionExc divisionExc) {//определяет участок кода который отвечает за обработку кода
                System.out.println(divisionExc);

            }catch (ArithmeticException e) {
                System.out.println("Попытка деления на ноль");
            }
        }
    }
}

class DivisionExc extends Exception {
    double firsNum;
    double secondNum;

    public DivisionExc(double firsNum,double secondNum) {
        this.firsNum = firsNum;
        this.secondNum = secondNum;
    }

    @Override
    public String toString() {
        return "Результат деления" + String.format("%.2f",firsNum) +
                "на" + String.format("%.2f",secondNum) +
                "меньше 1";
    }
}
