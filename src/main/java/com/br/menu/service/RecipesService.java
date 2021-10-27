package com.br.menu.service;

import com.br.menu.dao.implementation.RecipesImplementation;
import com.br.menu.domain.Recipes;

import java.sql.SQLException;
import java.util.List;

public class RecipesService {
    RecipesImplementation recipesDao = new RecipesImplementation();


    public RecipesService() throws SQLException {
    }

    public List<Recipes>  getAllRecipes() {
        return recipesDao.getAllRecipes();
    }

    public   void insertRecipes(Recipes recipes) {
        recipesDao.insertRecipes(recipes);
    }

    public  void updateRecipes(Recipes recipes,int id){
        recipesDao.updateRecipes(recipes,id);
    }

    public  List<Recipes> getRecipesById(Integer id){
        return recipesDao.getById(id);
    }

}
