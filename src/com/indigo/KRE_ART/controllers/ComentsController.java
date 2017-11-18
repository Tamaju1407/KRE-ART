package com.indigo.KRE_ART.controllers;

import com.indigo.KRE_ART.models.Image;
import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Coment;
import com.indigo.KRE_ART.models.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ComentsController", urlPatterns = "/coments")
public class ComentsController extends javax.servlet.http.HttpServlet{
    KreartService service;
    String url;

    public ComentsController() {
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
                List<Coment> coments = service.findAllComents();
                request.setAttribute("coments", coments);
                url = "list.jsp";
            }
            if (action.equals("show")){
                int id = Integer.parseInt(request.getParameter("id"));
                Coment coment = service.findComentById(id);
                request.setAttribute("coment", coment);
                url = "show.jsp";
            }
            if (action.equals("new")){
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
