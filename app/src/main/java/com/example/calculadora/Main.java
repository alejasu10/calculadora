package com.example.calculadora;
import androidx.activity.ComponentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends ComponentActivity{
    //Definimos las variables globales que usaremos
    double num1, num2,res;
    String op,ultimo_numero, vacio = "";
    /**Instanciamos los TextView de forma global.
    Para poder acceder a ellos desde cualquier funcion.*/
    TextView number;
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botones);
        //Inicializamos los TextView.
        number = findViewById(R.id.number);
        result = findViewById(R.id.result);
    }

    /** Definimos la funcion que nos dara el resultado.
    Dependiendo del  op(operador) que se haya elegido.
    Se realizara la operacion correspondiente.*/
    public void resultado(View view) {

        if (!number.getText().toString().isEmpty()) {
            num2 = Double.parseDouble(number.getText().toString());
            number.setText("");
            switch (op) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;

                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        res = num1 / num2;
                    } else {
                        result.setText("Error");
                        return;
                    }
                    break;
                case "√":
                        res = Math.sqrt(num1);
                        break;

                case "%":
                    res = num1 / 100;
                    break;

            }
            //Se muestra el resultado en el TextView result.
                result.setText(String.valueOf(res));
                //se muestra el resultado en el TextView number para poder operar con el.
                number.setText(String.valueOf(res));
        }
        else {
            result.setText("Error");
        }
    }
    //Creamos las funciones de cada boton para poder operar.
    public void borrar(View view){
        num1 = 0;
        num2 = 0;
        number.setText(vacio);// se vacian los TextView
        result.setText(vacio);
    }
    //Hacemos una concadenacion de los numeros con :
    ///number.setText(number.getText() + "numero");
    //el metodo get toma el valor anterior y lo une con el nuevo
    //el metodo setText reemplaza el texto por el valor nuevo
    public void number1 (View view){
        number.setText(number.getText() + "1");
    }
    public void number2 (View view){
        number.setText(number.getText() + "2");
    }
    public void number3 (View view){
        number.setText(number.getText() + "3");
    }

    public void number4 (View view){
        number.setText(number.getText() + "4");
    }

    public void number5 (View view){
        number.setText(number.getText() + "5");
    }

    public void number6 (View view){
        number.setText(number.getText() + "6");
    }

    public void number7 (View view){
        number.setText(number.getText() + "7");
    }

    public void number8 (View view){
        number.setText(number.getText() + "8");
    }

    public void number9 (View view){
        number.setText(number.getText() + "9");
    }
    public void number0 (View view){
        number.setText(number.getText() + "0");
    }
    public void punto (View view){
        number.setText(number.getText() + ".");
    }
    //Creamos una funcion para guardar los numeros en una variable.
    public void guardar (View view){
        num1 = Double.parseDouble(number.getText().toString());
        number.setText("");

    }
    // Creamos los operadores logicos.
    //Despues de ingresar un numero y pulsar un operador.
    //Se guarda en la variable y se procede a ingresar el 2do numero para operar.
    public void signo_mas (View view){
        op = "+";
        guardar(view);

    }
    public void signo_menos (View view){
        //comprobamos que la pantalla esta vacia para ingresar numero negativos
        if (number.getText().toString().isEmpty()){
            number.setText("-");
        }
        else {
            op = "-";
            guardar(view);
        }
    }
    public void signo_por (View view){
        op = "*";
        guardar(view);
    }
    public void signo_dividir (View view){
        op = "/";
        guardar(view);
    }
    public void signo_porcentaje (View view) {
        if (number.getText().toString().isEmpty()) {
            result.setText("Error");
        } else {
            op = "%";
            num1 = Double.parseDouble(number.getText().toString());
            resultado(view);
        }
    }

    public void signo_raiz (View view){
        if (number.getText().toString().isEmpty()) {
            result.setText("Error");
        } else {
            op = "√";
            num1 = Double.parseDouble(number.getText().toString());
            resultado(view);
        }
    }
    public void borrar_ultimo(View view){
        ultimo_numero = number.getText().toString();
        if (!ultimo_numero.isEmpty()) {
            number.setText(ultimo_numero.substring(0, ultimo_numero.length() - 1));
        }
    }

    }


