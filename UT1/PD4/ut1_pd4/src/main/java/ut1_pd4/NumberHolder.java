package ut1_pd4;
/*1) El siguiente código crea un array y una string. 
String[] students = new String[10];
String studentName = "Peter Parker";
students[0] = studentName;
studentName = null;
...

¿Cuántas referencias a estos objetos
existen luego de que el código se ha ejecutado?

Hay 3 referencias, son students, students[0] y studentsName

 ¿Es alguno de los objetos candidato a
ser eliminado por el garbage collector?

No, porque la funcion del Garbage Collector es eliminar los objetos
    que ya no son accesibles o no se utilizan, en este caso todos los 
    objetos siguen referenciados.


2) Cómo hace un programa para destruir un objeto que ha creado?
En Java no se puede borrar directamente un objeto, para esto usamos el
Garbage Collector, lo que debemos hacer es marcar un objeto como inaccesible 
(debes asegurarte de que no hay ninguna referencia al objeto en el código y 
establecer cualquier variable que apunte al objeto en "null") y de esa manera 
puede ser borrado de manera automatica por el GC.


 */



public class NumberHolder {
    public int anInt;
    public float aFloat;

    public static void main(String[] args) {
        NumberHolder numberHolder = new NumberHolder();
        numberHolder.anInt = 2;
        numberHolder.aFloat = 4.44F;

        System.out.println(numberHolder.anInt);
        System.out.println(numberHolder.aFloat);
    }
}
