package com.indigo.KRE_ART.Actions;

import com.indigo.KRE_ART.models.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "FillAction", urlPatterns = "/fill")
public class FillAction {
    KreartService service;
    String url;

    public FillAction() {
        super();
        service = new KreartService();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");

        if(method.equals("GET")){
            if (action.equals("profile")){
                int id = Integer.parseInt(request.getParameter("id"));
                Person person = service.findPersonById(id);
                PersonAll personAll = service.createPersonAll(person);
                List<Image> images = service.findAllImagesByPerson(person);
                request.setAttribute("personall", personAll);
                request.setAttribute("images", images);
                url = "perfil.jsp";
            }
            if (action.equals("searchcategory")){
                String category = request.getParameter("category");
                List<Person> persons = service.findAllPersonsByCategory(category);
                request.setAttribute("persons", persons);
                url = "busqueda.jsp";
            }
            if (action.equals("searchemail")){
                url = "new.jsp";
            }
            if (action.equals("edit")){
                int id = Integer.parseInt(request.getParameter("id"));
                Coment coment = service.findComentById(id);
                request.setAttribute("coment", coment);
                url = "edit.jsp";
            }
        }

        if(method.equals("POST")){
            if(action.equals("create")){
                int id = service.getMaxIdComent() + 1;
                Person personsend = service.findPersonById(Integer.parseInt(request.getParameter("personsend")));
                Image image = service.findImageById(Integer.parseInt(request.getParameter("image")));
                String message = request.getParameter("message");
                int rate = 0;
                boolean execute = service.createComent(id,personsend,image,message,rate);
                List<Coment> coments = service.findAllComents();
                request.setAttribute("coments", coments);
                url = "list.jsp";
            }
            if(action.equals("update")){
                int id = Integer.parseInt(request.getParameter("int"));
                Person personsend = service.findPersonById(Integer.parseInt(request.getParameter("personsend")));
                Image image = service.findImageById(Integer.parseInt(request.getParameter("image")));
                String message = request.getParameter("message");
                int rate = 0;
                boolean execute = service.updateComent(id,personsend,image,message,rate);
                List<Coment> coments = service.findAllComents();
                request.setAttribute("coments", coments);
                url = "list.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
