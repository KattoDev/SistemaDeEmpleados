package ComponentMaintainer;

/**
 * @author Kris
 */
public class CM_Messages {

    private String authGaranted = "credenciales correctas";
    private String authFailed = "credenciales incorrectas";
    private String loggedOutPopUp = "¿Desea cerrar la sesión?";
    private String loggedOut = "Se ha cerrado la sesión";

    public String getAuthGaranted() {
        return authGaranted;
    }

    public String getAuthFailed() {
        return authFailed;
    }

    public String getLoggedOutPopUp() {
        return loggedOutPopUp;
    }

    public String getLoggedOut() {
        return loggedOut;
    }
}
