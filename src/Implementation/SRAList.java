package Implementation;

import Inetrfaces.NodeInt;
import Inetrfaces.SRAListInt;

/**
 * Created by abdll on 10/15/2017.
 */
public class SRAList implements SRAListInt {
    private Node Head; //stores Reference to Head of the list
    private Node Tail; //stores Reference to Tail of the list
    private int size; //current size


    public SRAList() {
    }

    public Node getHead() {
        return Head;
    }

    public void setHead(Node head) {
        Head = head;
    }

    public Node getTail() {
        return Tail;
    }

    public void setTail(Node tail) {
        Tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void add(NodeInt N) {
        if (Head == null) {
            Head = (Node) N;
            Tail = (Node) N;
        } else {
            N.setPrev(Tail);
            Tail.setNext(N);
            Tail = (Node) N;

        }
        size++;
    }


    @Override
    public NodeInt search(int id) {
        Node temp = Head;
        if (temp == null)
            return null;
        while (temp.getNext() != null) {
            if (temp.getID() == id) {
                return temp;
            }
            temp = temp.getNext();

        }
        return temp;
    }

    @Override
    public void remove(NodeInt N) {
        Node temp = null;
        if (N != null)
            temp = (Node) search(N.getID());
        if (size == 1) {
            Head = null;
            Tail = null;
        } else {
            if (temp == Head) {
                temp.getNext().setPrev(null);
                Head = temp.getNext();
            } else if (temp == Tail) {
                temp.getPrev().setNext(null);
                Tail = temp.getPrev();
            } else {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
            }
        }
        size--;//find if it is a problem
    }

    @Override
    public double MedianMidTerm() {
        Node temp = Head, p = temp;
        double medianm;
        if (size == 0) {
            return 0;
        } else {
            if (size == 1) {
                medianm = Head.getMidTerm();

            } else if (size == 2) {
                medianm = (Head.getMidTerm() + Tail.getMidTerm()) / 2;
            } else {
                for (int i = 0; i < size; i++) {
                    temp = Head;
                    p = temp;
                    while (temp.getNext() != null) {
                        p = temp.getNext();
                        if (temp == Head) {
                            if (temp.getMidTerm() > p.getMidTerm()) {
                                temp.setNext(p.getNext());
                                p.getNext().setPrev(temp);
                                p.setNext(temp);
                                temp.setPrev(p);
                                p.setPrev(null);
                                Head = p;
                            }
                        } else if (p == Tail) {
                            if (temp.getMidTerm() > p.getMidTerm()) {
                                p.setPrev(temp.getPrev());
                                temp.getPrev().setNext(p);
                                p.setNext(temp);
                                temp.setPrev(p);
                                temp.setNext(null);
                                Tail = temp;


                            }
                        } else {
                            if (temp.getMidTerm() > p.getMidTerm()) {
                                temp.setNext(p.getNext());
                                p.getNext().setPrev(temp);
                                temp.getPrev().setNext(p);
                                p.setPrev(temp.getPrev());
                                p.setNext(temp);
                                temp.setPrev(p);
                            }


                        }
                        if (temp.getNext() != null)
                            temp = temp.getNext();
                    }

                }
                temp = Head;


                for (int i = 0; i < (size / 2); i++) {
                    temp = temp.getNext();
                }
                if (size % 2 == 0) {
                    medianm = (temp.getMidTerm() + temp.getPrev().getMidTerm()) / 2;
                } else {


                    medianm = temp.getMidTerm();

                }

            }
            return medianm;
        }
    }

    @Override
    public double MedianFinal() {
        Node temp = Head, p = temp;
        double medianf;
        if (size == 1) {
            medianf = Head.getFinal();

        } else if (size == 2) {
            medianf = (Head.getFinal() + Tail.getFinal()) / 2;
        } else {
            for (int i = 0; i < size; i++) {
                temp = Head;
                p = temp;
                while (temp.getNext() != null) {
                    p = temp.getNext();
                    if (temp == Head) {
                        if (temp.getFinal() > p.getFinal()) {
                            temp.setNext(p.getNext());
                            p.getNext().setPrev(temp);
                            p.setNext(temp);
                            temp.setPrev(p);
                            p.setPrev(null);
                            Head = p;
                        }
                    } else if (p == Tail) {
                        if (temp.getFinal() > p.getFinal()) {
                            p.setPrev(temp.getPrev());
                            temp.getPrev().setNext(p);
                            p.setNext(temp);
                            temp.setPrev(p);
                            temp.setNext(null);
                            Tail = temp;
                        }
                    } else {
                        if (temp.getFinal() > p.getFinal()) {
                            temp.setNext(p.getNext());
                            p.getNext().setPrev(temp);
                            temp.getPrev().setNext(p);
                            p.setPrev(temp.getPrev());
                            p.setNext(temp);
                            temp.setPrev(p);
                        }

                    }
                    if (temp.getNext() != null)
                        temp = temp.getNext();

                }
            }
            temp = Head;


            for (int i = 0; i < (size / 2); i++) {
                temp = temp.getNext();
            }
            if (size % 2 == 0) {
                medianf = (temp.getFinal() + temp.getPrev().getFinal()) / 2;
            } else {


                medianf = temp.getFinal();

            }

        }
        return medianf;

    }


    @Override
    public double AverageTotal() {
        double total = 0;
        double average;
        Node temp = Head;
        while (temp != null) {
            total = total + (temp.getMidTerm() + temp.getFinal());
            temp = temp.getNext();
        }
        average = total / size;

        return average;
    }

    @Override
    public int ComputeAboveAvg() {
        int above = 0;
        Node temp = Head;
        while (temp != null) {
            if ((temp.getMidTerm() + temp.getFinal()) > AverageTotal())
                above++;
            temp = temp.getNext();
        }

        return above;
    }

    @Override
    public int ComputeBelowAvg() {
        int below = 0;
        Node temp = Head;
        while (temp != null) {
            if ((temp.getMidTerm() + temp.getFinal()) < AverageTotal())
                below++;
            temp = temp.getNext();
        }

        return below;
    }

    public String toString() {
        Node tmp = Head;
        String print = "";
        for (int i = 0; i < size; i++) {
            print += "[" + tmp.getID() + " " + tmp.getName() + " " + tmp.getMidTerm() + " " + tmp.getFinal() + "] --> ";
            tmp = tmp.getNext();
        }
        return print;
    }
}
