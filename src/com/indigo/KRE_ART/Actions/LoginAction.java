package com.indigo.KRE_ART.Actions;

import com.indigo.KRE_ART.models.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "LoginAction", urlPatterns = "/login")
public class LoginAction extends javax.servlet.http.HttpServlet{
    KreartService service;
    String url;

    public LoginAction() {
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
        if(method.equals("POST")) {
            String error = "";
            if(action.equals("verify")){
                Person person = service.findPersonByEmail(request.getParameter("email"));
                if(person != null){
                    if(person.getPassword().equals(request.getParameter("password"))){
                        PersonAll personAll = service.createPersonAll(person);
                        List<Image> images = service.findAllImagesByPerson(person);
                        request.setAttribute("personall", personAll);
                        request.setAttribute("images", images);
                        url = "perfil.jsp";
                    }
                    else{
                        error = "Contraseña Incorrecta";
                        request.setAttribute("error", error);
                        request.setAttribute("status","hidden");
                        request.setAttribute("person", person);
                        url = "login.jsp";
                    }
                }
                else{
                    error = "Error Person Null";
                    request.setAttribute("error", error);
                    request.setAttribute("status","hidden");
                    request.setAttribute("person", person);
                    url = "login.jsp";
                }
            }
        }
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
            if (action.equals("searchtalent")){
                String category = request.getParameter("category");
                List<Talent> talents = service.findAllTalentsByCategory(category);
                List<Person> persons = null;
                int n = 0;
                while (n == talents.size()){
                    persons.add(talents.get(n).getPerson());
                    n++;
                }
                request.setAttribute("persons", persons);
                url = "busqueda.jsp";
            }
            if (action.equals("searchheadhunter")){
                String category = request.getParameter("category");
                List<Headhunter> headhunters = service.findAllHeadHuntersByCategory(category);
                List<Person> persons = null;
                int n = 0;
                while (n == headhunters.size()){
                    persons.add(headhunters.get(n).getPerson());
                    n++;
                }
                request.setAttribute("persons", persons);
                url = "busqueda.jsp";
            }
            if (action.equals("search")){
                List<Person> persons = service.findAllPersons();
                int n = 0;
                List<PersonAll> personalls = new ArrayList<>();
                while(n != persons.size()) {
                    personalls.add(service.createPersonAll(persons.get(n)));
                    n = n + 1;
                }
                request.setAttribute("personalls", personalls);
                url = "busqueda.jsp";
            }
            if (action.equals("searchemail")){
                String email = request.getParameter("email");
                Person person = service.findPersonByEmail(email);
                request.setAttribute("person",person);
                url = "busqueda.jsp";
            }
            if (action.equals("rate")){
                List<Image> images = service.findImagesByRate();
                request.setAttribute("images", images);
                url = "inicio.jsp";
            }
            if (action.equals("coments")){
                int id = Integer.parseInt(request.getParameter("id"));
                List<Coment> coments = service.findAllComentsByPerson(service.findPersonById(id));
                request.setAttribute("coments", coments);
                url = "imagen.jsp";
            }
            if (action.equals("imgs")){
                int id = Integer.parseInt(request.getParameter("id"));
                Image image = service.findImageById(id);
                List<Coment> coments = service.findAllComentsByImage(image);
                request.setAttribute("image", image);
                request.setAttribute("coments", coments);
                url = "img.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
