package Inetrfaces;

/**
 * Created by abdll on 10/15/2017.
 */
public interface SRAListInt {
    void add(NodeInt N);
    NodeInt search(int id);
    void remove(NodeInt N);
    double MedianMidTerm();
    double MedianFinal();
    double AverageTotal();
    int ComputeAboveAvg();
    int ComputeBelowAvg();
}
