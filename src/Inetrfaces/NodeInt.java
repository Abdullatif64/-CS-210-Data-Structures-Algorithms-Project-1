package Inetrfaces;

/**
 * Created by abdll on 10/15/2017.
 */
public interface NodeInt {
    int getID();
    void setID(int id);
    String getName();
    void setName(String name);
    double getMidTerm();
    void setMidTerm(double midterm);
    double getFinal();
    void setFinal(double Final);
    NodeInt getNext();
    void setNext(NodeInt n);
    NodeInt getPrev();
    void setPrev(NodeInt n);
}
