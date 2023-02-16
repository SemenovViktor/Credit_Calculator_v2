/**
 * Credit calculator v4
 */

public class Consumer {
    private double sum; //тело кредита
    private double monthPaid; //ежемесячный платеж
    private double percentRate; //процентная ставка
    private double overPaid; // размер переплаты
    private double sumFromFirstOverPaid; // сумма с которой начисляются проценты

    public double getOverPaid() {
        if (isAbleToPay(this.sumFromFirstOverPaid, this.monthPaid, this.percentRate)) {

            while (sumFromFirstOverPaid > 0) {
                overPaid = overPaid + (sumFromFirstOverPaid * (percentRate * 0.01));
                sumFromFirstOverPaid =
                        sumFromFirstOverPaid + (sumFromFirstOverPaid * (percentRate * 0.01)) - (monthPaid * 12.);
            }
        }
        return overPaid;
    }
    public void fillClientData(String[] clientData){
            this.sum = Double.parseDouble(clientData[0]);
            this.monthPaid = Double.parseDouble(clientData[1]);
            this.percentRate = Double.parseDouble(clientData[2]);
            if (clientData[3].equals("human")) {
                this.sumFromFirstOverPaid = sum;
            }
            else if (clientData[3].equals("business")) {
                this.sumFromFirstOverPaid = (sum - (monthPaid * 12));
            }
    }

    public static boolean isAbleToPay(double sumFromFirstOverPaid, double monthPaid, double percentRate)
            throws IllegalArgumentException {
        if (sumFromFirstOverPaid <= 0) {
            throw new IllegalArgumentException("Сумма кредита должна быть больше нуля.");

        }
        else if (monthPaid <= 0) {
            throw new IllegalArgumentException("Ежемесячный платеж должен быть больше нуля.");
        }
        else if (sumFromFirstOverPaid * (percentRate / 100.) >= (monthPaid * 12.)){
            throw new IllegalArgumentException("Ежемесячный платеж за год не может быть меньше или равен сумме, " +
                    "с которой начисляются проценты - кредит невозможно погасить.");
        }

        return (sumFromFirstOverPaid > 0 && monthPaid > 0
                && (sumFromFirstOverPaid * (percentRate / 100.) <= (monthPaid * 12.)));
    }
}