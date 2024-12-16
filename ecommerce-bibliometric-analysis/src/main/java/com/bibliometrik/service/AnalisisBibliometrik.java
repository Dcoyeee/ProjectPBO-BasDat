package com.bibliometrik.service;

import com.bibliometrik.database.KoneksiDatabase;
import com.bibliometrik.model.PublikasiEcommerce;
import com.bibliometrik.model.TransaksiPenjualan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnalisisBibliometrik {
    public List<PublikasiEcommerce> getPublikasiList() {
        List<PublikasiEcommerce> publikasiList = new ArrayList<>();
        
        try (Connection conn = KoneksiDatabase.getConnection()) {
            String query = "SELECT * FROM publikasi_ecommerce";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                PublikasiEcommerce publikasi = new PublikasiEcommerce();
                publikasi.setId(resultSet.getInt("id"));
                publikasi.setJudul(resultSet.getString("judul"));
                publikasi.setPenulis(resultSet.getString("penulis"));
                publikasi.setTerbitTanggal(resultSet.getString("terbit_tanggal"));
                publikasi.setHarga(resultSet.getDouble("harga"));
                publikasi.setStok(resultSet.getInt("stok"));
                publikasiList.add(publikasi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return publikasiList;
    }
    
    public List<TransaksiPenjualan> getTransaksiList() {
        List<TransaksiPenjualan> transaksiList = new ArrayList<>();
        
        try (Connection conn = KoneksiDatabase.getConnection()) {
            String query = "SELECT * FROM transaksi_penjualan";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                TransaksiPenjualan transaksi = new TransaksiPenjualan();
                transaksi.setId(resultSet.getInt("id"));
                transaksi.setIdPublikasi(resultSet.getInt("id_publikasi"));
                transaksi.setJumlahBeli(resultSet.getInt("jumlah_beli"));
                transaksi.setTotalHarga(resultSet.getDouble("total_harga"));
                transaksi.setTanggalTransaksi(resultSet.getString("tanggal_transaksi"));
                transaksi.setIdPembeli(resultSet.getInt("id_pembeli"));
                transaksiList.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return transaksiList;
    }
    
    public double hitungTotalPenjualan(List<TransaksiPenjualan> transaksiList) {
        double totalPenjualan = 0;
        for (TransaksiPenjualan transaksi : transaksiList) {
            totalPenjualan += transaksi.getTotalHarga();
        }
        return totalPenjualan;
    }
    
    public double hitungRataRataHargaPublikasi(List<PublikasiEcommerce> publikasiList) {
        double totalHarga = 0;
        for (PublikasiEcommerce publikasi : publikasiList) {
            totalHarga += publikasi.getHarga();
        }
        return totalHarga / publikasiList.size();
    }
    
    public int getPublikasiTerlaris(List<TransaksiPenjualan> transaksiList) {
        int publikasiTerlaris = 0;
        int maksimalJumlahBeli = 0;
        
        for (TransaksiPenjualan transaksi : transaksiList) {
            if (transaksi.getJumlahBeli() > maksimalJumlahBeli) {
                maksimalJumlahBeli = transaksi.getJumlahBeli();
                publikasiTerlaris = transaksi.getIdPublikasi();
            }
        }
        
        return publikasiTerlaris;
        public List<PublikasiEcommerce> getPublikasiList() {
            List<PublikasiEcommerce> publikasiList = new ArrayList<>();
            try (Connection conn = KoneksiDatabase.getConnection()) {
                String query = "SELECT * FROM publikasi_ecommerce";
                PreparedStatement statement = conn.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                // Proses hasil query dan tambahkan ke publikasiList
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return publikasiList;
        }
    }
}