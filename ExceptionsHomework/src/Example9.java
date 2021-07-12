import java.io.FileNotFoundException;
import java.io.IOException;

public class Example9 {
    public static void main(String[] args) {}
}

/*Компилируется, так как предок пугает IOException и InterruptedException, а потомок пугает только потомком IOException.
* Если потомок разширял исключения, то была бы ошибка компиляции.*/
class Parent {
    public void f() throws IOException, InterruptedException {}
}

class Child extends Parent {
    @Override
    public void f() throws FileNotFoundException {
        System.err.println("Might throw FileNotFoundException");
    }
}
