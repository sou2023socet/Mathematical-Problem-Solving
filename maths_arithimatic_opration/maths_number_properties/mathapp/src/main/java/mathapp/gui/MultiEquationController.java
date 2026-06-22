package mathapp.gui;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import mathapp.equations.EquationGenerator;
import mathapp.equations.MultipleEquationHandler;
import mathapp.equations.api.EquationSolver;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultiEquationController {

    // Screens
    @FXML private VBox welcomeScreen;
    @FXML private VBox guideScreen;
    @FXML private VBox aboutScreen;
    @FXML private VBox calculatorScreen;

    // Calculator Elements
    @FXML private TextArea equationsArea;
    @FXML private TextField variablesField;
    @FXML private TextArea outputArea;

    private MultipleEquationHandler multiHandler;
    private VBox currentScreen;

    @FXML
    public void initialize() {
        // Initialize Engine
        EquationSolver coreSolver = new EquationSolver();
        EquationGenerator generator = new EquationGenerator(coreSolver);
        this.multiHandler = new MultipleEquationHandler(generator, coreSolver);

        // Setup UI State
        currentScreen = welcomeScreen;
        guideScreen.setVisible(false);
        aboutScreen.setVisible(false);
        calculatorScreen.setVisible(false);
    }

    // --- NAVIGATION LOGIC WITH ANIMATION ---
    
    @FXML void navToWelcome(ActionEvent event) { switchScreen(welcomeScreen); }
    @FXML void navToGuide(ActionEvent event) { switchScreen(guideScreen); }
    @FXML void navToAbout(ActionEvent event) { switchScreen(aboutScreen); }
    @FXML void navToCalculator(ActionEvent event) { switchScreen(calculatorScreen); }

    private void switchScreen(VBox newScreen) {
        if (currentScreen == newScreen) return;

        // Fade out current screen
        FadeTransition fadeOut = new FadeTransition(Duration.millis(150), currentScreen);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> {
            currentScreen.setVisible(false);
            
            // Fade in new screen
            newScreen.setOpacity(0.0);
            newScreen.setVisible(true);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(200), newScreen);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
            
            currentScreen = newScreen;
        });
        fadeOut.play();
    }

    // --- CALCULATOR LOGIC ---

    @FXML
    void handleSolve(ActionEvent event) {
        String eqText = equationsArea.getText().trim();
        String varText = variablesField.getText().trim();

        if (eqText.isEmpty() || varText.isEmpty() || !varText.contains("=?")) {
            outputArea.setText("❌ Error: Missing equations or target variable (=?).");
            return;
        }

        List<String> equationsList = Arrays.stream(eqText.split("\\r?\\n"))
                                           .filter(line -> !line.trim().isEmpty())
                                           .collect(Collectors.toList());

        try {
            Map<String, Double> finalState = multiHandler.solveSystem(equationsList, varText);
            
            StringBuilder sb = new StringBuilder("✅ Success! Resolved Variables:\n\n");
            for (Map.Entry<String, Double> entry : finalState.entrySet()) {
                sb.append(" • ").append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");
            }
            outputArea.setText(sb.toString());
        } catch (Exception e) {
            outputArea.setText("❌ System Logic Error. Check syntax and variable names.");
        }
    }

    @FXML
    void handleTestCase(ActionEvent event) {
        equationsArea.setText("distance = speed * time\nacceleration = speed / time");
        variablesField.setText("distance=100 time=5 acceleration=?");
        outputArea.setText("Test case loaded. Press 'Solve'.");
    }

    @FXML
    void handleClear(ActionEvent event) {
        equationsArea.clear();
        variablesField.clear();
        outputArea.clear();
    }
}