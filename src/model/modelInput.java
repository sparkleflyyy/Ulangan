/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.controllerInput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.KoneksiDB;
import view.Tampilan;

/**
 *
 * @author basith
 */
public class modelInput implements controllerInput{
    
    
    @Override
    public void Simpan(Tampilan IM) throws SQLException {
       try {
           Connection con = KoneksiDB.getcon();
           String sql = "Insert Into invenn VALUES(?,?,?,?)";
           PreparedStatement prepare = con.prepareStatement(sql);
           prepare.setString(1, IM.txtKode.getText());
           prepare.setString(2, IM.txtNama.getText());
           prepare.setString(3, IM.txtStcock.getText());
           prepare.setString(4, IM.txtTahun.getText());
           prepare.executeUpdate();
           JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
           prepare.close();
           Baru(IM);
       } catch (Exception e) {
           System.out.println(e);
       } finally {
           Tampil(IM);
       }   

    }

    @Override
    public void Hapus(Tampilan IM) throws SQLException {
    try {
            Connection con = KoneksiDB.getcon();
            String sql = "DELETE FROM invenn WHERE ID=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, IM.txtKode.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diHapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(IM);
            Baru(IM);
       }
    }

    @Override
    public void Batal(Tampilan IM) throws SQLException {
       IM.txtKode.setText("");
       IM.txtNama.setText("");
       IM.txtStcock.setText("");
       IM.txtTahun.setText("");

    }

    @Override
    public void Ubah(Tampilan IM) throws SQLException {
     try {
            Connection con = KoneksiDB.getcon();
          String sql = "UPDATE  invenn SET Nama_brg=?, Jml_brg=?,Tahun=? WHERE ID=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(4, IM.txtKode.getText());
            prepare.setString(1, IM.txtNama.getText());
            prepare.setString(2, IM.txtStcock.getText());
            prepare.setString(3, IM.txtTahun.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(IM);
            Baru(IM);
        }    
        
    }

    @Override
    public void Baru(Tampilan IM) throws SQLException {
       IM.txtKode.setText("");
       IM.txtNama.setText("");
       IM.txtStcock.setText("");
       IM.txtTahun.setText("");

    }

    @Override
    public void Tampil(Tampilan IM) throws SQLException {
         IM.tblmodel.getDataVector().removeAllElements();
        IM.tblmodel.fireTableDataChanged();
         try {
           Connection con = KoneksiDB.getcon();
           Statement stt = con.createStatement();
           String sql = "SELECT * FROM invenn ORDER BY ID ASC";         
           ResultSet res = stt.executeQuery(sql);
           while (res.next()){
               Object[] ob = new Object[8];
               ob[0] = res.getString(1);
               ob[1] = res.getString(2);
               ob[2] = res.getString(3);
               ob[3] = res.getString(4);
               IM.tblmodel.addRow(ob);
           } 
       }catch (Exception e) {
              System.out.println(e);
      }
    }

    @Override
    public void kliktabel(Tampilan IM) throws SQLException {
      try {
        int pilih = IM.tbl.getSelectedRow();
        if (pilih == -1) {
            return;
        }
        IM.txtKode.setText(IM.tblmodel.getValueAt (pilih, 0).toString());
        IM.txtNama.setText(IM.tblmodel.getValueAt (pilih, 1).toString());
        IM.txtStcock.setText(IM.tblmodel.getValueAt (pilih, 2).toString());
        IM.txtTahun.setText(IM.tblmodel.getValueAt (pilih, 3).toString());
    } catch (Exception e) {
    }
        //memberi nilai jk pada radio button
            
    }

    
}

