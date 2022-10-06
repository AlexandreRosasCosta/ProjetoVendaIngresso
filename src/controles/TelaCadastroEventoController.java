/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controles;

import java.sql.Connection;
import conexao.ConexaoDb;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import projeto.Evento;

/**
 * FXML Controller class
 *
 * @author Alexandre
 */
public class TelaCadastroEventoController implements Initializable {

    @FXML
    private TextField Busca_Campo;
    @FXML
    private Button Botao_Pesquisa_Evento;
    @FXML
    private Label Campo_Aviso;
    @FXML
    private TableView<Evento> Tabela_View;
    @FXML
    private javafx.scene.control.TableColumn<Evento, Integer> IDEvento;
    @FXML
    private javafx.scene.control.TableColumn<Evento, String> nome;
    @FXML
    private javafx.scene.control.TableColumn<Evento, Date> dataHoraInicio;
    @FXML
    private javafx.scene.control.TableColumn<Evento, Date> dataHoraTermino;
    @FXML
    private javafx.scene.control.TableColumn<Evento, Integer> numVagas;
    @FXML
    private javafx.scene.control.TableColumn<Evento, Double> valorIngresso;
    @FXML
    private javafx.scene.control.TableColumn<Evento, Integer> QtdAssentosEvento;
    
    ObservableList<Evento> oblist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String sqlCons = "select * from evento";
        try {
            Connection con = ConexaoDb.conectarBanco();
            ResultSet rs = con.createStatement().executeQuery(sqlCons);
            while (rs.next()) {                
                oblist.add(new Evento(rs.getString("nome"), rs.getString("imagemCartaz"), 
                        rs.getDate("dataHoraInicio"), rs.getDate("dataHoraTermino"), 
                        rs.getInt("numVagas"),rs.getDouble("valorIngresso"), rs.getInt("colunas"),
                        rs.getInt("fileiras")));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TelaCadastroEventoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        IDEvento.setCellValueFactory(new PropertyValueFactory<>("IDEvento"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dataHoraInicio.setCellValueFactory(new PropertyValueFactory<>("dataHoraInicio"));
        dataHoraTermino.setCellValueFactory(new PropertyValueFactory<>("dataHoraTermino"));
        numVagas.setCellValueFactory(new PropertyValueFactory<>("numVagas"));
        valorIngresso.setCellValueFactory(new PropertyValueFactory<>("valorIngresso"));
        QtdAssentosEvento.setCellValueFactory(new PropertyValueFactory<>("QtdAssentosEvento"));
        
        Tabela_View.setItems(oblist);
    }    

    @FXML
    private void pesquisarEvento(ActionEvent event) {
        if(!Busca_Campo.getText().equals("")){
            Campo_Aviso.setText(Busca_Campo.getText());
        }else{
            Campo_Aviso.setText("Informe o campo de busca!");
        }
    }
    
}
