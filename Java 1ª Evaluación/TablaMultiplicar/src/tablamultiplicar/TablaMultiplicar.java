package tablamultiplicar;

/**
 *
 * @author David
 */
public class TablaMultiplicar {

    public static void main(String[] args) {
        for (int numero1 = 1; numero1 != 10; numero1++) {
            
            for (int numero2 = 0; numero2 != 11; numero2++) {
                System.out.println(numero1 + " x " + numero2 + " = " + numero1 * numero2);
            }System.out.println("");
        }
    }

}
