package nl.bioinf.scwi.speciesbrowser.servlet;
import nl.bioinf.scwi.speciesbrowser.config.WebConfig;
import nl.bioinf.scwi.speciesbrowser.model.Species;
import nl.bioinf.scwi.speciesbrowser.model.SpeciesReader;
import org.thymeleaf.context.WebContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SpeciesBrowserServlet", urlPatterns = "/speciesbrowser", loadOnStartup = 1)

public class SpeciesBrowserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Initializing Thymeleaf template engine");
        final ServletContext servletContext = this.getServletContext();
        WebConfig.createTemplateEngine(servletContext);
    }

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        WebConfig.configureResponse(response);
    WebContext ctx = new WebContext(
            request,
            response,
            request.getServletContext(),
            request.getLocale());


        WebConfig.createTemplateEngine(
    getServletContext()).process("speciesbrowser",ctx, response.getWriter());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        WebConfig.configureResponse(response);
        WebContext ctx = new WebContext(
                request,
                response,
                request.getServletContext(),
                request.getLocale());

        List<Species> species = SpeciesReader.speciesDataReader();
        System.out.println(species);
        ctx.setVariable("species", species);

        WebConfig.createTemplateEngine(getServletContext()).
                process("speciesbrowser", ctx, response.getWriter());
    }
}