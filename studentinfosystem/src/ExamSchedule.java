public class ExamSchedule {
    class Node {
        String exam;
        Node next;
        Node previous;

        public Node(String exam) {
            this.exam = exam;
            this.next = null;
            this.previous = null;
        }
    }

    Node head;
    Node tail;
    Node current; // To keep track of the current position

    public ExamSchedule() {
        head = null;
        tail = null;
        current = null;
    }

    public void addExam(String exam) {
        Node newNode = new Node(exam);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = head; // Initialize current when adding first exam
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void printSchedule() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.exam);
            temp = temp.next;
        }
    }

    public void printScheduleReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.exam);
            temp = temp.previous;
        }
    }

    public void resetCurrent() {
        current = head;
    }

    public String nextExam() {
        if (current == null) {
            resetCurrent();
            if (current == null) {
                return "No exams scheduled.";
            }
        }
        String exam = current.exam;
        current = current.next;
        return exam;
    }

    public String previousExam() {
        if (current == null) {
            current = tail;
            if (current == null) {
                return "No exams scheduled.";
            }
            return current.exam;
        }
        
        if (current.previous == null) {
            return "No previous exams available.";
        }
        
        current = current.previous;
        return current.exam;
    }

    // Added methods to match test expectations
    public void viewNextExam() {
        System.out.println(nextExam());
    }

    public void viewPreviousExam() {
        System.out.println(previousExam());
    }
}