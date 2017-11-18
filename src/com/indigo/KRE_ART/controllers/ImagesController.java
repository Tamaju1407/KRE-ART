package com.indigo.KRE_ART.controllers;

import com.indigo.KRE_ART.models.KreartService;
import com.indigo.KRE_ART.models.Image;
import com.indigo.KRE_ART.models.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ImagesController", urlPatterns = "/images")
public class ImagesController {
    KreartService service;
    String url;

    public ImagesController() {
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
                List<Image> images = service.findAllImages();
                request.setAttribute("images", images);
                url = "list.jsp";
            }
            if (action.equals("show")){
                int id = Integer.parseInt(request.getParameter("id"));
                Image image = service.findImageById(id);
                request.setAttribute("image", image);
                url = "show.jsp";
            }
            if (action.equals("new")){
                url = "new.jsp";
            }
            if (action.equals("edit")){
                int id = Integer.parseInt(request.getParameter("id"));
                Image image = service.findImageById(id);
                request.setAttribute("image", image);
                url = "edit.jsp";
            }
        }

        if(method.equals("POST")){
            if(action.equals("create")){
                int id = service.getMaxIdImage() + 1;
                Person person = service.findPersonById(Integer.parseInt(request.getParameter("person")));
                String url = request.getParameter("url");
                int rate = Integer.parseInt(request.getParameter("rate"));
                boolean execute = service.createImage(id,person,url,rate);
                List<Image> images = service.findAllImages();
                request.setAttribute("images", images);
                url = "list.jsp";
            }
            if(action.equals("update")){
                int id = Integer.parseInt(request.getParameter("int"));
                Person person = service.findPersonById(Integer.parseInt(request.getParameter("person")));
                String url = request.getParameter("url");
                int rate = Integer.parseInt(request.getParameter("rate"));
                boolean execute = service.updateImage(id,person,url,rate);
                List<Image> images = service.findAllImages();
                request.setAttribute("images", images);
                url = "list.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}
