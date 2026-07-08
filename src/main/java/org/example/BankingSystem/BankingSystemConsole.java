package org.example.BankingSystem;

import org.example.BankingSystem.IDFC.IDFCAccountFactory;
import org.example.BankingSystem.IDFC.IDFCBank;
import org.example.BankingSystem.SBI.SBIAccountFactory;
import org.example.BankingSystem.SBI.SBIBank;
import org.example.BankingSystem.interfaces.Account;
import org.example.BankingSystem.interfaces.AccountFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystemConsole {
    private final ATM atm = new ATM();
    private final Map<String, AccountFactory> accountFactories = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Integer> accountSequenceByBank = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public BankingSystemConsole() {
        atm.registerBank("SBI", new SBIBank());
        atm.registerBank("IDFC", new IDFCBank());
        accountFactories.put("SBI", new SBIAccountFactory());
        accountFactories.put("IDFC", new IDFCAccountFactory());
    }

    public void start() {
        System.out.println("Welcome to the Banking System");
        boolean running = true;
        while (running) {
            printMenu();
            switch (readLine("Choose an option: ")) {
                case "1" -> openAccount();
                case "2" -> deposit();
                case "3" -> withdraw();
                case "4" -> checkBalance();
                case "5" -> closeAccount();
                case "6" -> running = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }
        System.out.println("Thank you for banking with us!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Open Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Close Account");
        System.out.println("6. Exit");
    }

    private void openAccount() {
        String bankCode = readBankCode();
        if (bankCode == null) return;

        String userId = readLine("Enter user ID: ");
        User user = users.get(userId);
        if (user == null) {
            String userName = readLine("New user detected. Enter your name: ");
            user = new User(userId, userName);
            users.put(userId, user);
        } else {
            System.out.println("Welcome back, " + user.userName + "!");
        }

        String password = readLine("Set a password for this account: ");
        Double initialBalance = readAmount("Enter initial deposit amount: ");
        if (initialBalance == null) return;

        String accountId = generateAccountId(bankCode);
        AccountFactory factory = accountFactories.get(bankCode);
        Account account = factory.createAccount(accountId, userId, password, initialBalance);
        System.out.println(atm.addAccount(bankCode, account));
        System.out.println("Your new account ID is " + accountId + " - keep it safe.");
    }

    private void deposit() {
        String bankCode = readBankCode();
        if (bankCode == null) return;
        String accountId = readLine("Enter account ID: ");
        String password = readLine("Enter password: ");
        Double amount = readAmount("Enter amount to deposit: ");
        if (amount == null) return;
        System.out.println(atm.deposit(bankCode, accountId, password, amount));
    }

    private void withdraw() {
        String bankCode = readBankCode();
        if (bankCode == null) return;
        String accountId = readLine("Enter account ID: ");
        String password = readLine("Enter password: ");
        Double amount = readAmount("Enter amount to withdraw: ");
        if (amount == null) return;
        System.out.println(atm.withdraw(bankCode, accountId, password, amount));
    }

    private void checkBalance() {
        String bankCode = readBankCode();
        if (bankCode == null) return;
        String accountId = readLine("Enter account ID: ");
        String password = readLine("Enter password: ");
        System.out.println(atm.checkBalance(bankCode, accountId, password));
    }

    private void closeAccount() {
        String bankCode = readBankCode();
        if (bankCode == null) return;
        String accountId = readLine("Enter account ID: ");
        System.out.println(atm.deleteAccount(bankCode, accountId));
    }

    private String readBankCode() {
        String bankCode = readLine("Enter bank code (" + String.join("/", atm.supportedBanks()) + "): ").toUpperCase();
        if (!accountFactories.containsKey(bankCode)) {
            System.out.println("Unsupported bank: " + bankCode);
            return null;
        }
        return bankCode;
    }

    private Double readAmount(String prompt) {
        try {
            double amount = Double.parseDouble(readLine(prompt));
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return null;
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
            return null;
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private String generateAccountId(String bankCode) {
        int sequence = accountSequenceByBank.merge(bankCode, 1, Integer::sum);
        return bankCode + "-" + (1000 + sequence);
    }

    public static void main(String[] args) {
        new BankingSystemConsole().start();
    }
}
