package com.prodemy.coffeeshop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="menu")
public class Menu {

    @Id
    @Column(name="menu_id")
    private String menuId;
    
    @Column(name="menu_nama")
    private String menuNama;
    
    @Column(name="menu_tipe")
    private String menuTipe;
    
    @Column(name="menu_deskripsi")
    private String menuDeskripsi;
    
    @Column(name="menu_harga")
    private String menuHarga;

    @Column(name="menu_gambar")
    private String menuGambar;

}