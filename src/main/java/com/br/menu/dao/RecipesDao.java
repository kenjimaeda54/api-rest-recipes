package com.br.menu.dao;

import com.br.menu.domain.Recipes;

import java.util.List;

public interface  RecipesDao {
    List<Recipes>  getAllRecipes();
    void   insertRecipes(Recipes recipes);
    void   updateRecipes(Recipes recipes,int id);
    List<Recipes>  getById(Integer id);
    void   deleteRecipes(int id);

}
