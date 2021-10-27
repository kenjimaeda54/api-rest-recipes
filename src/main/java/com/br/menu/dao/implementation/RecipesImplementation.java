package com.br.menu.dao.implementation;

import com.br.menu.Config;
import com.br.menu.dao.RecipesDao;
import com.br.menu.domain.Recipes;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RecipesImplementation implements RecipesDao {
    private Config config = new Config();
    private static List<Recipes> recipes;
    private Connection conn = config.getConnection();

    public RecipesImplementation() throws SQLException {
    }

    @Override
    public List<Recipes> getAllRecipes() {
        String query = "SELECT * FROM RECIPES";
        recipes = null;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (recipes == null) {
                recipes = new ArrayList<Recipes>();
                while (rs.next()) {
                    Recipes recipesEach = new Recipes();
                    recipesEach.setDescription(rs.getString("recipes_description"));
                    recipesEach.setDate(rs.getDate("recipes_date").toString());
                    recipesEach.setHours(rs.getTime("recipes_date").toString());
                    recipesEach.setId(rs.getInt("recipes_id"));
                    recipesEach.setLink(rs.getString("recipes_link"));
                    recipesEach.setTitle(rs.getString("recipes_title"));
                    recipes.add(recipesEach);

                }
                stm.close();
                rs.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    @Override
    public void insertRecipes(Recipes recipes) {
        String query = "INSERT INTO RECIPES(recipes_title,recipes_description,recipes_link) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, recipes.getTitle());
            ps.setString(2, recipes.getDescription());
            ps.setString(3, recipes.getLink());
            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateRecipes(Recipes recipes, int id) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(timestamp.getTime());
        String query = "UPDATE RECIPES SET recipes_title=?,recipes_description=?,recipes_link=?,recipes_date=? WHERE recipes_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, recipes.getTitle());
            ps.setString(2, recipes.getDescription());
            ps.setString(3, recipes.getLink());
            ps.setString(4, date);
            ps.setInt(5, id);
            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recipes> getById(Integer id) {
        String query = "SELECT * FROM RECIPES";
        recipes = null;
        try {
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(query);
            if (recipes == null) {
                recipes = new ArrayList<Recipes>();
                while (rst.next()) {
                    Recipes eachRecipes = new Recipes();
                    if (id.equals(rst.getInt("recipes_id"))) {
                        eachRecipes.setTitle(rst.getString("recipes_title"));
                        eachRecipes.setLink(rst.getString("recipes_link"));
                        eachRecipes.setDescription(rst.getString("recipes_description"));
                        eachRecipes.setDate(rst.getDate("recipes_date").toString());
                        eachRecipes.setHours(rst.getTime("recipes_date").toString());
                        recipes.add(eachRecipes);
                        conn.close();
                        stm.close();
                        rst.close();
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  recipes;
    }


}
