package com.indigo.KRE_ART.controllers;

import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Talent;
import com.indigo.KRE_ART.models.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "TalentsController", urlPatterns = "/talents")
public class TalentsController extends javax.servlet.http.HttpServlet{
    KreartService service;
    String url;

    public TalentsController() {
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
                List<Talent> talents = service.findAllTalents();
                request.setAttribute("talents", talents);
                url = "list.jsp";
            }
            if (action.equals("show")){
                int id = Integer.parseInt(request.getParameter("id"));
                Talent talent = service.findTalentById(id);
                request.setAttribute("talent", talent);
                url = "show.jsp";
            }
            if (action.equals("new")){
                url = "new.jsp";
            }
            if (action.equals("edit")){
                int id = Integer.parseInt(request.getParameter("id"));
                Talent talent = service.findTalentById(id);
                request.setAttribute("talent", talent);
                url = "edit.jsp";
            }
        }

        if(method.equals("POST")){
            if(action.equals("create")){
                int id = Integer.parseInt("1" + request.getParameter("person"));
                Person person = service.findPersonById(Integer.parseInt(request.getParameter("person")));
                String category = request.getParameter("category");
                boolean execute = service.createTalent(id,person,category);
                List<Talent> talents = service.findAllTalents();
                request.setAttribute("talents", talents);
                url = "list.jsp";
            }
            if(action.equals("update")){
                int id = Integer.parseInt(request.getParameter("int"));
                Person person = service.findPersonById(Integer.parseInt(request.getParameter("person")));
                String category = request.getParameter("category");
                boolean execute = service.updateTalent(id,person,category);
                List<Talent> talents = service.findAllTalents();
                request.setAttribute("talents", talents);
                url = "list.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
