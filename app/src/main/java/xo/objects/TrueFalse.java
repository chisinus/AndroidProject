package xo.objects;

public class TrueFalse {
    public int getQuestionID() {
        return questionID;
    }

    private int questionID;

    public boolean isTrueQuestion() {
        return trueQuestion;
    }

    private boolean trueQuestion;

    public TrueFalse(int id, boolean trueQuestion)
    {
        questionID = id;
        this.trueQuestion = trueQuestion;
    }
}
