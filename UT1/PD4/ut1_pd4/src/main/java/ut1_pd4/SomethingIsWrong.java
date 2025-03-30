package ut1_pd4;

//1) Indica qué es lo que está mal en el siguiente programa:
/* public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect; // Lo que esta mal es como se inicia la instancia, falta el new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
} */
//2) Repara el error, ejecuta el programa y verifica que la salida es correcta.


class Rectangle {
    public int width;
    public int height;

    int area() {
        int area = this.width * this.height;
        return area;
    }
}

public class SomethingIsWrong {

    public static void main(String[] args) {
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
}

// Salida = myRect's area is 2000