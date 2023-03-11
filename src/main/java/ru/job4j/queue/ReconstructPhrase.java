package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder temp = new StringBuilder();
        int size = evenElements.size() / 2;
        for (int index = 0; index < size; index++) {
                temp.append(evenElements.poll());
                evenElements.poll();
        }
        return temp.toString();
    }

    private String getDescendingElements() {
        StringBuilder temp = new StringBuilder();
        int size = descendingElements.size();
        for (int index = 0; index < size; index++) {
            temp.append(descendingElements.pollLast());
        }
        return temp.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
