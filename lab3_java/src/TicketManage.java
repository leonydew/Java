package main.java.lab3;


public class TicketManage {
    public void buyTicket(Session session, int row, int col) {
        try {
            if (session.isSeatAvailable(row, col)) {
                session.bookSeat(row, col);
                System.out.println("Билет успешно куплен!");
            } else {
                throw new Exception("Место уже занято!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
