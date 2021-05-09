package com.example.calculatorservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalculatorService {

    public final Pattern DEFAULT_DELIMITERS_REGEX = Pattern.compile("[\\n,]");
    public final Pattern BETWEEN_SQUARE_BRACKETS_REGEX = Pattern.compile("(?<=\\[).+?(?=\\])");
    private Pattern delimiters;

    public int add(String numbers) {
        Scanner scanner = new Scanner(numbers);
        if (numbers.startsWith("//")) {
            String line = scanner.nextLine();
            delimiters = extractDelimiters(line);
        } else {
            delimiters = DEFAULT_DELIMITERS_REGEX;
        }
        scanner.useDelimiter(delimiters);
        List<Integer> integerList = new ArrayList<>();
        while (scanner.hasNext()) {
            String stringElement = scanner.next();
            if (!stringElement.isEmpty()) {
                try {
                    int element = Integer.parseInt(stringElement);
                    integerList.add(element);
                } catch (NumberFormatException e) {
                    throw new InvalidNumbersFormatException();
                }
            }
        }
        handleNegatives(integerList);
        return integerList.stream().mapToInt(x -> x > 1000 ? 0 : x).sum();
    }

    public Pattern extractDelimiters(String line) {
        StringBuilder sb = new StringBuilder("\\n");
        Matcher m = BETWEEN_SQUARE_BRACKETS_REGEX.matcher(line);
        int delimitersCount = 0;
        while (m.find()) {
            sb.append("|");
            sb.append(Pattern.quote(m.group()));
            delimitersCount++;
        }
        if (delimitersCount == 0) {
            sb.append("|,|");
            sb.append(Pattern.quote(line.substring(2)));
        }
        return Pattern.compile(sb.toString());
    }

    public void handleNegatives(List<Integer> numbers) {
        int[] negatives = numbers.stream().filter(x -> x < 0).mapToInt(x -> x).toArray();
        if (negatives.length > 0) {
            throw new NegativesNotAllowedException(negatives);
        }
    }

    public Pattern getDelimiters() {
        return delimiters;
    }
}
