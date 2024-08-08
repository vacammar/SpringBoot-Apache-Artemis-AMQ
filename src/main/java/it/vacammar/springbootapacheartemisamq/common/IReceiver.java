package it.vacammar.springbootapacheartemisamq.common;

public interface IReceiver<D> {

    void receive(D message);
}
