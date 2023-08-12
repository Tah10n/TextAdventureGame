package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/game")
public class TextAdventureServlet extends HttpServlet {
    private TextAdventureGame game;

    @Override
    public void init() {
        game = new TextAdventureGame();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        if (game.isGameEnded()) {
            game = new TextAdventureGame();
        }

        String action = request.getParameter("input");
        String description;
        Location location = game.getCurrentScene().getLocation();
        if (action == null) {
            description = "Выберите действие, " + request.getSession().getAttribute("playerName");
        } else {
            Scene newScene = game.changeScene(action);
            description = newScene.getDescription();
            location = newScene.getLocation();
        }

        request.setAttribute("location", location.getTitle());
        request.setAttribute("description", description);
        request.setAttribute("game", game);

        try {
            request.getRequestDispatcher("/game.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setGame(TextAdventureGame game) {
        this.game = game;
    }
}
