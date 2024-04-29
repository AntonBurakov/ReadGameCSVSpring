package ru.netology.burakov.ReadGameCSVSpring.entity;

public class Game {

    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private float naSales;
    private float euSales;
    private float jpSales;
    private float otherSales;
    private float globalSales;

    public Game(int rank, String name, String platform, int year, String genre, String publisher, float naSales, float euSales, float jpSales, float otherSales, float globalSales) {
        this.rank = rank;
        this.name = name;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.naSales = naSales;
        this.euSales = euSales;
        this.jpSales = jpSales;
        this.otherSales = otherSales;
        this.globalSales = globalSales;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getNaSales() {
        return naSales;
    }

    public void setNaSales(float naSales) {
        this.naSales = naSales;
    }

    public float getEuSales() {
        return euSales;
    }

    public void setEuSales(float euSales) {
        this.euSales = euSales;
    }

    public float getJpSales() {
        return jpSales;
    }

    public void setJpSales(float jpSales) {
        this.jpSales = jpSales;
    }

    public float getOtherSales() {
        return otherSales;
    }

    public void setOtherSales(float otherSales) {
        this.otherSales = otherSales;
    }

    public float getGlobalSales() {
        return globalSales;
    }

    public void setGlobalSales(float globalSales) {
        this.globalSales = globalSales;
    }

    @Override
    public String toString() {
        return "Game{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", platform=" + platform +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", naSales='" + naSales + '\'' +
                ", euSales='" + euSales + '\'' +
                ", jpSales='" + jpSales + '\'' +
                ", otherSales='" + otherSales + '\'' +
                ", globalSales='" + globalSales + '\'' +
                '}';
    }

}
