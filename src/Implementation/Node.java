package Implementation;

import Inetrfaces.NodeInt;

/**
 * Created by abdll on 10/15/2017.
 */
public class Node implements NodeInt {
    private int ID;  //stores Id of student
    private String Name; //only first name spaces are not allowed
    private double MidTerm;  //score out of 60
    private double Final;//score out of 40
    private Node Next;  //reference to next pointer
    private Node Prev;  //reference to previous pointer

    public Node() {
    }

    public Node(int ID, String name, double aFinal, double midTerm) {
        this.ID = ID;
        Name = name;
        MidTerm = midTerm;
        Final = aFinal;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        Name = name;
    }

    @Override
    public double getMidTerm() {
        return MidTerm;
    }

    @Override
    public void setMidTerm(double midTerm) {
        MidTerm = midTerm;
    }

    @Override
    public double getFinal() {
        return Final;
    }

    @Override
    public void setFinal(double aFinal) {
        Final = aFinal;
    }

    @Override
    public Node getNext() {
        return Next;
    }

    public void setNext(NodeInt next) {
        Next = (Node) next;
    }

    @Override
    public Node getPrev() {
        return Prev;
    }

    public void setPrev(NodeInt prev) {
        this.Prev = (Node) prev;
    }
}
