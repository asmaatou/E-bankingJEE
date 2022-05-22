package org.sid.ebankingbackend.exceptions;

public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String messsage) {
        super(messsage);
    }
}
