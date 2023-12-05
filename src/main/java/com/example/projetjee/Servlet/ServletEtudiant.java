package com.example.projetjee.Servlet;

import com.example.projetjee.Models.Etudiant;
import jakarta.servlet.annotation.WebServlet;

import javax.lang.model.element.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name="ServletEtudiant",value = "/")
public class ServletEtudiant extends HttpServlet {
    private Connection connexion;
    //attribut qui represent les requetes
    private Statement statement;


    public void init() {
        this.connexion= com.example.etudiant.configs.DB.connexionDB();
        try {
            this.statement=this.connexion.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String nom=request.getParameter("lastname");
String prenom=request.getParameter("name");
String email=request.getParameter("email");
String password=request.getParameter("password");
        PrintWriter out =response.getWriter();
if( nom != null && !nom.equals("")
        &&prenom != null && !prenom.equals("")
        && email != null && !email.equals("")
        && password != null && !password.equals("")){
    Etudiant e = new Etudiant(nom,prenom,email,password);
    int r = e.save(this.connexion);
    if (r ==1){
        out.println("success");
    }else{
        out.println("failed");
    }
        }
    }
}
