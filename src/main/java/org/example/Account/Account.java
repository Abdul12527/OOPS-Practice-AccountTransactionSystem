package org.example.Account;

import java.util.ArrayList;

public class Account {
    private int id;
    ArrayList<Transition> transitions=new ArrayList<Transition>();
    public Account(int id){
        this.id=id;
    }

    public void senMoney(Account to,double Amount){
        if(to==null||Amount<=0)return;
        Transition t1=new Transition(to,this,StandardOperations.SEND,Amount);
        transitions.add(t1);
        to.ReciveMoney(this, Amount);
    }

    public void ReciveMoney(Account from,double Amount){
        if(from==null||Amount<=0)return;
        Transition t1=new Transition(this,from,StandardOperations.RECEIVE,Amount);
        transitions.add(t1);
    }
    public void widraw(double Amount){
        if(Amount<=0)return;
        Transition t1=new Transition(this,this,StandardOperations.WITHDRAW,Amount);
        transitions.add(t1);
    }

    public ArrayList<Transition> transitionHistory(){
        return transitions;
    }

    @Override
    public String toString() {
        return "Account ID"+this.id;
    }

    private class Transition{
        Account to,from;
        StandardOperations op;
        double amount;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public Transition(Account to, Account from, StandardOperations op, double amount) {
            this.to = to;
            this.from = from;
            this.op = op;
            this.amount=amount;
        }

        public Account getTo() {
            return to;
        }

        public void setTo(Account to) {
            this.to = to;
        }

        public Account getFrom() {
            return from;
        }

        public void setFrom(Account from) {
            this.from = from;
        }

        public StandardOperations getOp() {
            return op;
        }

        public void setOp(StandardOperations op) {
            this.op = op;
        }

        @Override
        public String toString() {
            return "Transaction:["+this.from+","+this.to+","+this.amount+","+this.op+"]";
        }
    }
}
