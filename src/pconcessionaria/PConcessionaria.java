/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pconcessionaria;
import br.com.info.dal.ConexaoBD;
import br.com.info.telas.Cliente;
import br.com.info.telas.Tela1;
import br.com.info.telas.Veiculos;
import java.sql.*;

/**
 *
 * @author andde
 */
public class PConcessionaria {

    /**1'8
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conexao=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        
        conexao=ConexaoBD.conector();
     
      new Tela1().setVisible(true);
        
    }
    
}
