package edu.hw3.StockMarket;

public interface StockMarket {
    record Stock(double cost, String name) {}
    void add(Stock st);
    void remove(Stock st);
    Stock mostValuableStock();
}
