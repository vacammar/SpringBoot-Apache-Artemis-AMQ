package it.vacammar.springbootapacheartemisamq.common;

public interface ISender<D> {

    void send(D message);
}
