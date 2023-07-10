package com.example.bookorderapp.data.menu;

public class MenuItem {
   private String name;
   private String author;
   private String type;
   private  int pages;
   private double price;


    public MenuItem(String name, String author, String type, int pages, double price) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.pages = pages;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
