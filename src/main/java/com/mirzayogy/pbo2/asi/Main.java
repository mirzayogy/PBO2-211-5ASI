package com.mirzayogy.pbo2.asi;

import com.mirzayogy.pbo2.asi.frame.LoginFrame;
import com.mirzayogy.pbo2.asi.model.JenisBarang;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        LoginFrame l = new LoginFrame();
//        l.setVisible(true);
        JenisBarang jenisBarang = new JenisBarang();
        
//        jenisBarang.setNamajenisbarang("Buku 5A SI");
//        if(jenisBarang.create()){
//            System.out.println("Simpan Berhasil");
//        } else {
//            System.out.println("GAGAL");
//        }

//        jenisBarang.setId(5);
//        jenisBarang.setNamajenisbarang("Modul PBO 2 5A SI");
//        if(jenisBarang.update()){
//          System.out.println("Ubah data Berhasil");
//        } else {
//            System.out.println("GAGAL");
//        }
        
//        jenisBarang.setId(7);
//        if(jenisBarang.delete()){
//          System.out.println("Hapus data Berhasil");
//        } else {
//            System.out.println("GAGAL");
//        }
        
//        ArrayList<JenisBarang> list = jenisBarang.read();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getId());
//
//            System.out.println(list.get(i).getNamajenisbarang());
//        }

//        ArrayList<JenisBarang> list = jenisBarang.search("Pakaian");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getNamajenisbarang());
//        }

          jenisBarang.setId(2);
          if(jenisBarang.find()){
              System.out.println(jenisBarang.getId());
              System.out.println(jenisBarang.getNamajenisbarang());
          } else {
            System.out.println("Data tidak ditemukan");
          }
    }
}
