public class Example2 {
    public static void main(String[] args) {
        /*catch можеть поймать Exception или потомков. Если бы бросался Exception,
        а перехватывался RuntimeException - не сработало бы.*/
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("Это RuntimeException на самом деле!!!");
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }
}
