package co.zw.engineer.covidscreening.model;

public class Question {
    private Long id;
    private String question;
    private Boolean answer;

    public Question(Long id, String question, Boolean answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }



}
