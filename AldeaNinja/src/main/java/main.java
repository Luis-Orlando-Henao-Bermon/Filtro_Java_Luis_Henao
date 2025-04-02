import Controlador.*;

public class main {
    public static void main(String[] args) {
        try {
            ControladorTotal.Iniciar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
