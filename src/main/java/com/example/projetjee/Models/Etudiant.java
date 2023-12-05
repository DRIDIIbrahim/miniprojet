package com.example.projetjee.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Etudiant {
 private int id;
 private String nom;
 private String prenom;
 private String email;
 private String password;

 public void setId(int id) {
  this.id = id;
 }

 public void setNom(String nom) {
  this.nom = nom;
 }

 public void setPrenom(String prenom) {
  this.prenom = prenom;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public int getId() {
  return id;
 }

 public String getNom() {
  return nom;
 }

 public String getPrenom() {
  return prenom;
 }

 public String getEmail() {
  return email;
 }

 public String getPassword() {
  return password;
 }

 public Etudiant(String nom, String prenom, String email, String password) {
  this.nom = nom;
  this.prenom = prenom;
  this.email = email;
  this.password = password;
 }
 public int save(Connection connexion){
  String sql= "INSERT INTO etudiant (nom,prenom,email,password)" +"VALUES (?,?,?,?)";

  int resultat=0;
  try {
   PreparedStatement statement=connexion.prepareStatement(sql);
   statement.setString(1,this.nom);
   statement.setString(2,this.prenom);
   statement.setString(3,this.email);
   statement.setString(4,this.password);
   resultat=statement.executeUpdate();
  }catch (SQLException e){
   throw new RuntimeException(e);
  }
  return resultat;
 }
}

