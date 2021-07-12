public class Example6 {
    /*Предупреждаем о Exception. Можно также Throw, так как это предок. Наследник не подходит, будет ошибка компиляции.*/
    public static void main(String[] args) throws Exception { //
        throw new Exception(); // кидаем Exception
    }
}
