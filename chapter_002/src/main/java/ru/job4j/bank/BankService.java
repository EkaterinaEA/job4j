package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        if (findByPassport(srcPassport) == null || findByPassport(destPassport) == null
                || findByRequisite(srcPassport, srcRequisite).getBalance() < amount) {
            return false;
        } else {
            findByRequisite(srcPassport, srcRequisite).setBalance(findByRequisite(srcPassport, srcRequisite).getBalance() - amount);
            findByRequisite(destPassport, dеstRequisite).setBalance(findByRequisite(destPassport, dеstRequisite).getBalance() + amount);
            return true;
        }
    }
}
