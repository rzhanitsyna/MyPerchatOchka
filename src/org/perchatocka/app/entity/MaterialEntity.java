package org.perchatocka.app.entity;

import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Data
public class MaterialEntity {
    private int ID;
    private String Title;
    private int CountInPack;
    private String Unit;
    private double CountInStock;
    private double MinCount;
    private String Description;
    private double Cost;
    private String Image;
    private String MaterialType;

    private javax.swing.ImageIcon ImageIcon;

    public MaterialEntity(int ID, String title, int countInPack, String unit, double countInStock, double minCount, String description, double cost, String image, String materialType) {
        this.ID = ID;
        this.Title = title;
        this.CountInPack = countInPack;
        this.Unit = unit;
        this.CountInStock = countInStock;
        this.MinCount = minCount;
        this.Description = description;
        this.Cost = cost;
        this.Image = image;
        this.MaterialType = materialType;

        try {
            this.ImageIcon = new ImageIcon(ImageIO.read(MaterialEntity.class.getClassLoader().getResource(Image)).getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
