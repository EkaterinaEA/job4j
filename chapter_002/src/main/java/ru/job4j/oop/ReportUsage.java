package ru.job4j.oop;

public class ReportUsage {

    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport jsonReport = new JSONReport();
        String jsonText = jsonReport.generate("name", "body");
        System.out.println(jsonText);
    }

}
