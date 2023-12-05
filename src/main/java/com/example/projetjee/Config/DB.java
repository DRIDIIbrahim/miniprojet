package com.example.etudiant.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class DB {
    //url de connexion a la base de donnes
    private static  final String URL="jdbc:mysql://localhost:3306/projetJEE";
    //nom d'utilisateur
    private static  final String USER="root";
    private static  final String PASSWORD="";
    //methode de connexion a la base de donnees
    //return objet de type Connection

    public static Connection connexionDB(){
        Connection connexion =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connexion=DriverManager.getConnection(DB.URL, DB.USER, DB.PASSWORD);
        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return connexion;
    }

}
