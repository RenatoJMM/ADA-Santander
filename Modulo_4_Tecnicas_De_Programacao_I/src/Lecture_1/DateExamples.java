import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateExamples {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();

        System.out.println(hoje);
        System.out.println();

        LocalTime horaAtual = LocalTime.now();
        System.out.println(horaAtual);
        System.out.println();

        LocalDateTime hojeHora = LocalDateTime.now();
        System.out.println(hojeHora);
        System.out.println();

        LocalDate dataPassada = LocalDate.of(2023, Month.SEPTEMBER, 02);
        System.out.println(dataPassada);
        System.out.println();

        LocalDate anoDia = LocalDate.ofYearDay(2023, 50);
        System.out.println(anoDia);
        System.out.println();

        LocalTime testeHora = LocalTime.of(16, 20);
        System.out.println(testeHora);
        System.out.println();

        LocalTime horaSegundo = LocalTime.of(20, 25, 59);
        System.out.println(horaSegundo);
        System.out.println();

        LocalDateTime diaMesAnoHora = LocalDateTime.of(2023, Month.AUGUST, 23, 13, 45, 40);
        System.out.println(diaMesAnoHora);
        System.out.println();

        LocalDateTime testeDnv = LocalDateTime.of(hoje, testeHora);
        System.out.println(testeDnv);
        System.out.println();

        LocalDate dataFutura = LocalDate.of(2023, Month.DECEMBER, 25);
        System.out.println(dataFutura);
        System.out.println();

        System.out.println(dataFutura.isAfter(hoje));
        System.out.println(dataFutura.isBefore(hoje));
        System.out.println(dataFutura.isEqual(hoje));

        System.out.println(MomentosEspeciais.evento1());
        System.out.println(MomentosEspeciais.evento2());
        System.out.println(MomentosEspeciais.evento3());

    }

}