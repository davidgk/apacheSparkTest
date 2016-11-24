package apacheSparkTest;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        port(getHerokuAssignedPort());
        get("/recursete", (req, res) -> "<h1>Vamos recurso, Ponte a Laburar</h1>");
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
