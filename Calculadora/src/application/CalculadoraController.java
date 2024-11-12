package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

public class CalculadoraController {
    @FXML
    private Button boton1;
    @FXML
    private Button boton2;
    @FXML
    private Button boton3;
    @FXML
    private Button boton4;
    @FXML
    private Button boton5;
    @FXML
    private Button boton6;
    @FXML
    private Button boton7;
    @FXML
    private Button boton8;
    @FXML
    private Button boton9;
    @FXML
    private Button boton0;
    @FXML
    private Button botonSumar;
    @FXML
    private Button botonRestar;
    @FXML
    private Button botonMultiplicar;
    @FXML
    private Button botonDividir;
    @FXML
    private Button botonResultado;
    @FXML
    private TextField textFieldResultado;

    private Scene scene;

    OperacionWrapper operacionWrapper = new OperacionWrapper();
    ValoresWrapper valoresWrapper = new ValoresWrapper();

    @FXML
    public void initialize() {
        obtenerValores();
        calcular();
    }

    public class OperacionWrapper {
        String operacion = "";  // Variable mutable para almacenar el valor de la operación
    }

    public class ValoresWrapper {
        String valor1 = "";
        String valor2 = "";
    }

    @FXML
    public void calcular() {
        botonSumar.setOnAction(event -> {
            operacionWrapper.operacion = "+";
            actualizarValor("+");
        });

        botonRestar.setOnAction(event -> {
            operacionWrapper.operacion = "-";
            actualizarValor("-");
        });

        botonMultiplicar.setOnAction(event -> {
            operacionWrapper.operacion = "X";
            actualizarValor("X");
        });

        botonDividir.setOnAction(event -> {
            operacionWrapper.operacion = "/";
            actualizarValor("/");
        });

        botonResultado.setOnAction(event -> {
            int valor1 = Integer.parseInt(valoresWrapper.valor1);
            int valor2 = Integer.parseInt(valoresWrapper.valor2);
            int resultado = 0;
            switch (operacionWrapper.operacion) {
                case "+":
                    resultado = valor1 + valor2;
                    break;
                case "-":
                    resultado = valor1 - valor2;
                    break;
                case "/":
                    resultado = valor1 / valor2;
                    break;
                case "X":
                    resultado = valor1 * valor2;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + operacionWrapper.operacion);
            }
            textFieldResultado.setText(Integer.toString(resultado));
        });
    }

    @FXML
    public void obtenerValores() {
        // Asignamos la acción a cada botón numérico
        boton1.setOnAction(event -> actualizarValor("1"));
        boton2.setOnAction(event -> actualizarValor("2"));
        boton3.setOnAction(event -> actualizarValor("3"));
        boton4.setOnAction(event -> actualizarValor("4"));
        boton5.setOnAction(event -> actualizarValor("5"));
        boton6.setOnAction(event -> actualizarValor("6"));
        boton7.setOnAction(event -> actualizarValor("7"));
        boton8.setOnAction(event -> actualizarValor("8"));
        boton9.setOnAction(event -> actualizarValor("9"));
        boton0.setOnAction(event -> actualizarValor("0"));
    }

    public void actualizarValor(String valor) {
        if (operacionWrapper.operacion.isEmpty()) {
            valoresWrapper.valor1 += valor; // Actualiza el primer valor
        }else if("+".equals(valor) || "-".equals(valor)|| "/".equals(valor)|| "X".equals(valor)) {	
        	
        }else {
            valoresWrapper.valor2 += valor; // Actualiza el segundo valor
        }
        System.out.println("Valor 1: "+valoresWrapper.valor1);
        System.out.println("Valor 2: "+valoresWrapper.valor2);
        textFieldResultado.setText(textFieldResultado.getText()+valor);
    }

    // Método para asignar los listeners de teclado
    public void asignarKeyListeners(Scene scene) {
        // Asegúrate de que la escena no sea nula antes de agregar el listener
        if (scene != null) {
            scene.setOnKeyPressed(event -> {
                switch (event.getCode()) {
	                case DIGIT1, NUMPAD1:
	                    actualizarValor("1");
	                    break;
	                case DIGIT2, NUMPAD2:
	                    actualizarValor("2");
	                    break;
	                case DIGIT3, NUMPAD3:
	                    actualizarValor("3");
	                    break;
	                case DIGIT4, NUMPAD4:
	                    actualizarValor("4");
	                    break;
	                case DIGIT5,NUMPAD5:
	                    actualizarValor("5");
	                    break;
	                case DIGIT6,NUMPAD6:
	                    actualizarValor("6");
	                    break;
	                case DIGIT7,NUMPAD7:
	                    actualizarValor("7");
	                    break;
	                case DIGIT8,NUMPAD8:
	                    actualizarValor("8");
	                    break;
	                case DIGIT9,NUMPAD9:
	                    actualizarValor("9");
	                    break;
	                case DIGIT0,NUMPAD0:
	                    actualizarValor("0");
	                    break;
	                case PLUS:
	                	operacionWrapper.operacion = "+";
	                    actualizarValor("+");
	                    break;
	                case MINUS:
	                	operacionWrapper.operacion = "-";
	                    actualizarValor("-");
	                    break;
	                case ASTERISK:
	                	operacionWrapper.operacion = "X";
	                    actualizarValor("X");
	                    break;
	                case SLASH:
	                	operacionWrapper.operacion = "/";
	                    actualizarValor("/");
	                    break;
	                case ENTER:
	                    botonResultado.fire();
	                    break;
	                default:
	                    break;
                }
            });
        }
    }
}
