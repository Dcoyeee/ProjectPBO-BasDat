package com.bibliometrik.service;

import com.bibliometrik.database.KoneksiDatabase;
import com.bibliometrik.model.PublikasiEcommerce;
import com.bibliometrik.model.TransaksiPenjualan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PengolahanData {
    public void tambahPublikasi(PublikasiEcommerce publikasi) {
        try (Connection conn = KoneksiDatabase.getConnection()) {
            String query = "INSERT INTO publikasi_ecommerce (judul, penulis, terbit_tanggal, harga, stok) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, publikasi.getJudul());
            statement.setString(2, publikasi.getPenulis());
            statement.setString(3, publikasi.getTerbitTanggal());
            statement.setDouble(4, publikasi.getHarga());
            statement.setInt(5, publikasi.getStok());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void tambahTransaksi(TransaksiPenjualan transaksi) {
        try (Connection conn = KoneksiDatabase.getConnection()) {
            String query = "INSERT INTO transaksi_penjualan (id_publikasi, jumlah_beli, total_harga, tanggal_transaksi, id_pembeli) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, transaksi.getIdPublikasi());
            statement.setInt(2, transaksi.getJumlahBeli());
            statement.setDouble(3, transaksi.getTotalHarga());
            statement.setString(4, transaksi.getTanggalTransaksi());
            statement.setInt(5, transaksi.getIdPembeli());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}