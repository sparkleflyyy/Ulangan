/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.Tampilan;

/**
 *
 * @author basith
 */
public interface controllerInput {
    public void Simpan(Tampilan IM) throws SQLException;
    public void Hapus(Tampilan IM) throws SQLException;
    public void Batal(Tampilan IM) throws SQLException;
    public void Ubah(Tampilan IM) throws SQLException;
    public void Baru(Tampilan IM) throws SQLException;
    public void Tampil(Tampilan IM) throws SQLException;
    public void kliktabel(Tampilan IM) throws SQLException;
    
}
