/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginscreen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class loginscreen extends Application {
    private AnchorPane pane;
    private Scene scene;
    private Label textLogin;
    private Label textPassword;
    
    private TextField user;
    private PasswordField password;
    
    private Button login;
    private Button logout;
    
    private void initComponents(){
        textLogin = new Label("Usuário");
        textPassword = new Label ("Senha");
        
        textLogin.setFont(new Font(16));
        textPassword.setFont(new Font (16));
        
        user = new TextField();
        user.setPromptText ("Login...");
        
        password = new PasswordField();
        password.setPromptText("Senha...");
        
        login= new Button("Entrar");
        logout = new Button("Esqueceu a senha ?");
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        pane = new AnchorPane();
        scene  = new Scene(pane, 500, 300);
        initComponents();
        
        login.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent arg0){
                if(user.getText().equals("Login") && password.getText().equals("Senha")){
                    JOptionPane.showMessageDialog(null, "Usuário Autenticado","Autenticacao", 
                                                    JOptionPane.INFORMATION_MESSAGE);
                } else {
                     JOptionPane.showMessageDialog(null, "Usuário Não Registrado","Entrar em contato com Support", 
                                                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        logout.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                 System.exit(0);
            } 
        });
        
        pane.getChildren().addAll(textLogin, textPassword, user, password, login, logout);
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #7FFFD4 0%, silver 100%);");
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();
        
        initLayout();
    }

    public static void main(String[] args) {
        launch(args);
    }  
    
    private void initLayout(){
        textLogin.setLayoutX((pane.getWidth() - textLogin.getWidth())/2);
        textLogin.setLayoutY(40);
        
        user.setLayoutX((pane.getWidth() - user.getWidth()) / 2);
        user.setLayoutY(70);
        
        textPassword.setLayoutX((pane.getWidth() - textPassword.getWidth()) /2);
        textPassword.setLayoutY(100);
        
        password.setLayoutX((pane.getWidth() - password.getWidth()) / 2);
        password.setLayoutY(130);
       
        login.setLayoutX((pane.getWidth() - login.getWidth()) / 2);
        login.setLayoutY(200);
        
        logout.setLayoutX((pane.getWidth() - logout.getWidth()) / 2);
        logout.setLayoutY(230);
        
    }
}