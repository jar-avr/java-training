public class Example8 {
    /*Пугаем Throwable, тогда нормально компилируется. Если бы пугали Exception, то была бы ошибка компиляции, так как
    * throws пугает ссылкой, а не обьектом, на который эта ссылка указывает. Throws не может пугать ссылкой предка.*/
    public static void main(String[] args) throws Throwable {
        try {
            Throwable t = new Exception();
            throw t;
        } catch (Exception e) {
            System.out.println("Перехвачено!");
        }
    }
}
