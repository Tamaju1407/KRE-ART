package com.indigo.KRE_ART.controllers;

import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "PersonsController", urlPatterns = "/persons")
public class PersonsController extends javax.servlet.http.HttpServlet {
    KreartService service;
    String url;

    public PersonsController() {
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
            if (action.equals("index")){
                List<Person> persons = service.findAllPersons();
                request.setAttribute("persons", persons);
                url = "listPersons.jsp";
            }
            if (action.equals("show")){
                int id = Integer.parseInt(request.getParameter("id"));
                Person person = service.findPersonById(id);
                request.setAttribute("person", person);
                url = "show.jsp";
            }
            if (action.equals("new")){
                url = "new.jsp";
            }
            if (action.equals("edit")){
                int id = Integer.parseInt(request.getParameter("id"));
                Person person = service.findPersonById(id);
                request.setAttribute("person", person);
                url = "edit.jsp";
            }
        }

        if(method.equals("POST")){
            if(action.equals("create")){
                int id = service.getMaxIdPerson() + 1;
                String name = request.getParameter("name");
                int dni = Integer.parseInt(request.getParameter("dni"));
                int cellphone = Integer.parseInt(request.getParameter("cellphone"));
                String location = request.getParameter("district") + ", " + request.getParameter("address");
                String email = request.getParameter("email");
                String profile = request.getParameter("profile");
                String description = request.getParameter("description");
                int rate = 0;
                int type = 0;
                if(request.getParameter("type") == "talent"){ type = 1;}
                else { type = 2;}
                boolean execute = service.createPerson(id,name,dni,cellphone,location,email,profile,description,rate,type);
                List<Person> persons = service.findAllPersons();
                request.setAttribute("persons", persons);
                url = "list.jsp";
            }
            if(action.equals("update")){
                int id = Integer.parseInt(request.getParameter("int"));
                String name = request.getParameter("name");
                int dni = Integer.parseInt(request.getParameter("dni"));
                int cellphone = Integer.parseInt(request.getParameter("cellphone"));
                String location = request.getParameter("district") + ", " + request.getParameter("address");
                String email = request.getParameter("email");
                String profile = request.getParameter("profile");
                String description = request.getParameter("description");
                int rate = 0;
                int type = 0;
                if(request.getParameter("type") == "talent"){ type = 1;}
                else { type = 2;}
                boolean execute = service.updatePerson(id,name,dni,cellphone,location,email,profile,description,rate,type);
                List<Person> persons = service.findAllPersons();
                request.setAttribute("persons", persons);
                url = "list.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
